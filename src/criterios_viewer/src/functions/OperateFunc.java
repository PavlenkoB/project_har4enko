package src.functions;

import Classes.*;
import org.apache.log4j.Logger;
import src.controllers.SubController;

import java.util.*;

/**
 * Created by AlxEx on 16.12.2015.
 */
public class OperateFunc {
    private static OperateFunc instance = new OperateFunc();
    private static Logger logger = Logger.getLogger(OperateFunc.getInstance().getClass());

    public static OperateFunc getInstance() {
        return instance;
    }

    private OperateFunc() {
    }

    private List<Task> tasks = new ArrayList<>();          //  Массив заданий
    private List<Session> sessions = new ArrayList<>();    //  Массив сессий
    private Task taskChoice;
    private Architecture architectureChoiceType;         //  Тип выбраной архитектуры
    private List<ArchitectureCriterionMark> architectureCriterionMarkList = new ArrayList<>();
    private Map<Criterion, Double> criterionDoubleMark = new HashMap<>();
    private Map<Architecture, Double> architectureComplexMap = new HashMap<>();

    public double getMarkByArchitectureCriterion(Architecture architecture, Criterion criterion) {
        calculateMarksOfArchitectures();
        for (ArchitectureCriterionMark architectureCriterionMark : architectureCriterionMarkList) {
            if (architectureCriterionMark.isIt(architecture, criterion)) {
                return architectureCriterionMark.getMark();
            }
        }
        return 0;
    }

    public Double getComplexMarkByArchitecture(Architecture architecture) {
        return architectureComplexMap.containsKey(architecture) ? architectureComplexMap.get(architecture) : 0d;
    }

    private double sumOfMarksArchBySessionArchitecture(Session session, Architecture architecture) {
        double returnValue = 0d;
        for (Mark mark : session.getMarks()) {
            if (mark.getNumArch0().equals(architecture.getIdDone())) {
                returnValue += mark.getMark();
            } else if (mark.getNumArch1().equals(architecture.getIdDone())) {
                returnValue += (1d / mark.getMark());
            }
        }
        return returnValue;
    }

    private double totalMark(double sumByOne, double sumOfAll) {
        return sumByOne / sumOfAll;
    }

    private double sumOfAllMarksBySession(Session session) {
        double returnValue = 0d;
        for (Mark mark : session.getMarks()) {
            if (mark.getNumArch1() != mark.getNumArch0()) {
                returnValue += mark.getMark() + (1d / mark.getMark());
            } else {
                returnValue += mark.getMark();
            }
        }
        return returnValue;
    }

    /**
     * W_i=(∑_(j=1)^n▒a_ij )⁄(∑_(i=1)^n▒∑_(j=1)^n▒〖aij〗_ )
     */
    private void calculateMarksOfArchitectures() {
        List<ArchitectureCriterionMark> archCritMarksFull = new LinkedList<>();
        List<Session> sessionListByTask = sessions;
        architectureCriterionMarkList.clear();

        for (Session session : sessionListByTask) {
            double sumOfMark = sumOfAllMarksBySession(session);
            for (Architecture arch : taskChoice.getArchitectures()) {
                archCritMarksFull.add(new ArchitectureCriterionMark(arch, session.getCriterion(),
                        totalMark(sumOfMarksArchBySessionArchitecture(session, arch), sumOfMark)));
            }
        }

        double markValue = 0d;
        int sessionCount = 0;
        for (Criterion criterion : Criterion.values()) {
            for (Architecture architecture : taskChoice.getArchitectures()) {
                for (ArchitectureCriterionMark criterionMark : archCritMarksFull) {
                    if (criterionMark.isIt(architecture, criterion)) {
                        markValue += criterionMark.getMark();
                        sessionCount++;
                    }
                }
                markValue = sessionCount > 0 ? markValue / sessionCount : 0d;
                architectureCriterionMarkList.add(new ArchitectureCriterionMark(architecture, criterion, markValue));
                markValue = 0d;
                sessionCount = 0;
            }
        }
        //normalizationArchitectureCriterionMark();
    }

    private double sumAllCriterionMarks(List<CriterionMark> criterionList) {
        double sum = 0d;
        for (CriterionMark criterionMark : criterionList) {
            if (!criterionMark.getCriterion1().equals(criterionMark.getCriterion2())) {
                sum += (1d / criterionMark.getMark()) + criterionMark.getMark();
            } else {
                sum += criterionMark.getMark();
            }
        }
        return sum;
    }

    private double sumByCriterion(List<CriterionMark> criterionMarkList, Criterion criterion) {
        double sum = 0d;
        for (CriterionMark criterionMark : criterionMarkList) {
            if (criterionMark.getCriterion1().equals(criterion)) {
                sum += criterionMark.getMark();
            } else if (criterionMark.getCriterion2().equals(criterion)) {
                sum += 1d / criterionMark.getMark();
            }
        }
        return sum;
    }

    private void calculateMarksOfCriterions() {
        criterionDoubleMark.clear();
        List<CriterionMark> criterionMarkList = SubController.criterionMarksListFromTextFieldsMatrixList();
        double sumOfAll = sumAllCriterionMarks(criterionMarkList);
        for (Criterion criterion : Criterion.values()) {
            double totalMark = sumByCriterion(criterionMarkList, criterion);
            totalMark = totalMark(totalMark, sumOfAll);
            criterionDoubleMark.put(criterion, totalMark);
            totalMark = 0d;
        }
    }

    public void calculateComplexMarks() {
        calculateMarksOfCriterions();
        architectureComplexMap.clear();
        for (Architecture architecture : taskChoice.getArchitectures()) {
            double complexMark = 0d;
            for (ArchitectureCriterionMark architectureMark : architectureCriterionMarkList) {
                if (architectureMark.getArchitecture().equals(architecture)) {
                    complexMark += criterionDoubleMark.get(architectureMark.getCriterion()) * architectureMark.getMark();
                }
            }
            architectureComplexMap.put(architecture, complexMark);
        }
        //normalizationComplexArchMark();
    }

    private void normalizationArchitectureCriterionMark() {
        double maxValue = 0d;
        for (Criterion criterion : Criterion.values()) {
            for (ArchitectureCriterionMark architectureCriterionMark : architectureCriterionMarkList) {
                if (architectureCriterionMark.getCriterion().equals(criterion)) {
                    maxValue = architectureCriterionMark.getMark() > maxValue ? architectureCriterionMark.getMark() : maxValue;
                }
            }
            double index = 10d / maxValue;
            for (ArchitectureCriterionMark architectureCriterionMark : architectureCriterionMarkList) {
                if (architectureCriterionMark.getCriterion().equals(criterion)) {
                    architectureCriterionMark.normalization(index);
                }
            }
        }
    }

    private void normalizationComplexArchMark() {
        double maxValue = 0d;
        Map<Architecture, Double> architectureDoubleMap = new HashMap<>();
        for (Architecture architecture : architectureComplexMap.keySet()) {
            maxValue = architectureComplexMap.get(architecture) > maxValue ? architectureComplexMap.get(architecture) : maxValue;
        }
        double index = 10d / maxValue;
        for (Architecture architecture : architectureComplexMap.keySet()) {
            architectureDoubleMap.put(architecture, architectureComplexMap.get(architecture) * index);
        }
        architectureComplexMap = architectureDoubleMap;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public Task getTaskChoice() {
        return taskChoice;
    }

    public List<ArchitectureCriterionMark> getArchitectureCriterionMarkList() {
        return architectureCriterionMarkList;
    }

    public void setTaskChoice(Task taskChoice) {
        this.taskChoice = taskChoice;
    }

    public Architecture getArchitectureChoiceType() {
        return architectureChoiceType;
    }

    public void setArchitectureChoiceType(Architecture architectureChoiceType) {
        this.architectureChoiceType = architectureChoiceType;
    }

    public void setTaskList(List<Task> taskList) {
        this.tasks = taskList;
    }

    public void setSessionsList(List<Session> sessionList) {
        this.sessions = sessionList;
    }
}
