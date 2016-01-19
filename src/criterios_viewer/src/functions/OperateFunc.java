package src.functions;

import Classes.Architecture;
import Classes.Criterion;
import Classes.Session;
import Classes.Task;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private List<ArchitectureCriterionMark> architectureCriterionMarkList;
    private Map<Architecture, Integer> architecttureComplexMap = new HashMap<>();

    public int getMarkByArchitectureCriterion(Architecture architecture, Criterion criterion) {
        for (ArchitectureCriterionMark architectureCriterionMark : architectureCriterionMarkList) {
            if (architectureCriterionMark.isIt(architecture, criterion)) {
                return architectureCriterionMark.getMark();
            }
        }
        return 0;
    }

    public Integer getComplexMarkByArchitecture(Architecture architecture) {
        return architecttureComplexMap.containsKey(architecture) ? architecttureComplexMap.get(architecture) : 0;
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
