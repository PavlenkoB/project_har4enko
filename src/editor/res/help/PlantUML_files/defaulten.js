(function () {
    var _UDS_CONST_LOCALE = 'en';
    var _UDS_CONST_SHORT_DATE_PATTERN = 'MDY';
    var _UDS_MSG_SEARCHER_IMAGE = ('Image');
    var _UDS_MSG_SEARCHER_WEB = ('Web');
    var _UDS_MSG_SEARCHER_BLOG = ('Blog');
    var _UDS_MSG_SEARCHER_VIDEO = ('Video');
    var _UDS_MSG_SEARCHER_LOCAL = ('Local');
    var _UDS_MSG_SEARCHCONTROL_SAVE = ('save');
    var _UDS_MSG_SEARCHCONTROL_KEEP = ('keep');
    var _UDS_MSG_SEARCHCONTROL_INCLUDE = ('include');
    var _UDS_MSG_SEARCHCONTROL_COPY = ('copy');
    var _UDS_MSG_SEARCHCONTROL_CLOSE = ('close');
    var _UDS_MSG_SEARCHCONTROL_SPONSORED_LINKS = ('Sponsored Links');
    var _UDS_MSG_SEARCHCONTROL_SEE_MORE = ('see more...');
    var _UDS_MSG_SEARCHCONTROL_WATERMARK = ('clipped from Google');
    var _UDS_MSG_SEARCHER_CONFIG_SET_LOCATION = ('Search location');
    var _UDS_MSG_SEARCHER_CONFIG_DISABLE_ADDRESS_LOOKUP = ('Disable address lookup');
    var _UDS_MSG_SEARCHER_NEWS = ('News');

    function _UDS_MSG_MINUTES_AGO(AGE_MINUTES_AGO) {
        return ('' + AGE_MINUTES_AGO + ' minutes ago');
    }

    var _UDS_MSG_ONE_HOUR_AGO = ('1 hour ago');

    function _UDS_MSG_HOURS_AGO(AGE_HOURS_AGO) {
        return ('' + AGE_HOURS_AGO + ' hours ago');
    }

    function _UDS_MSG_NEWS_ALL_N_RELATED(NUMBER) {
        return ('all ' + NUMBER + ' related');
    }

    var _UDS_MSG_NEWS_RELATED = ('Related Articles');
    var _UDS_MSG_BRANDING_STRING = ('powered by Google');
    var _UDS_MSG_SORT_BY_DATE = ('Sort by date');
    var _UDS_MSG_MONTH_ABBR_JAN = ('Jan');
    var _UDS_MSG_MONTH_ABBR_FEB = ('Feb');
    var _UDS_MSG_MONTH_ABBR_MAR = ('Mar');
    var _UDS_MSG_MONTH_ABBR_APR = ('Apr');
    var _UDS_MSG_MONTH_ABBR_MAY = ('May');
    var _UDS_MSG_MONTH_ABBR_JUN = ('Jun');
    var _UDS_MSG_MONTH_ABBR_JUL = ('Jul');
    var _UDS_MSG_MONTH_ABBR_AUG = ('Aug');
    var _UDS_MSG_MONTH_ABBR_SEP = ('Sep');
    var _UDS_MSG_MONTH_ABBR_OCT = ('Oct');
    var _UDS_MSG_MONTH_ABBR_NOV = ('Nov');
    var _UDS_MSG_MONTH_ABBR_DEC = ('Dec');
    var _UDS_MSG_DIRECTIONS = ('directions');
    var _UDS_MSG_CLEAR_RESULTS = ('clear results');
    var _UDS_MSG_SHOW_ONE_RESULT = ('show one result');
    var _UDS_MSG_SHOW_MORE_RESULTS = ('show more results');
    var _UDS_MSG_SHOW_ALL_RESULTS = ('show all results');
    var _UDS_MSG_SETTINGS = ('settings');
    var _UDS_MSG_SEARCH = ('search');
    var _UDS_MSG_SEARCH_UC = ('Search');
    var _UDS_MSG_POWERED_BY = ('powered by');

    function _UDS_MSG_LOCAL_ATTRIBUTION(LOCAL_RESULTS_PROVIDER) {
        return ('Business listings provided by ' + LOCAL_RESULTS_PROVIDER + '');
    }

    var _UDS_MSG_SEARCHER_BOOK = ('Book');

    function _UDS_MSG_FOUND_ON_PAGE(FOUND_ON_PAGE) {
        return ('Page ' + FOUND_ON_PAGE + '');
    }

    function _UDS_MSG_TOTAL_PAGE_COUNT(PAGE_COUNT) {
        return ('' + PAGE_COUNT + ' pages');
    }

    var _UDS_MSG_SEARCHER_BY = ('by');
    var _UDS_MSG_SEARCHER_CODE = ('Code');
    var _UDS_MSG_UNKNOWN_LICENSE = ('Unknown License');
    var _UDS_MSG_SEARCHER_GSA = ('Search Appliance');
    var _UDS_MSG_SEARCHCONTROL_MORERESULTS = ('More results');
    var _UDS_MSG_SEARCHCONTROL_PREVIOUS = ('Previous');
    var _UDS_MSG_SEARCHCONTROL_NEXT = ('Next');
    var _UDS_MSG_GET_DIRECTIONS = ('Get directions');
    var _UDS_MSG_GET_DIRECTIONS_TO_HERE = ('To here');
    var _UDS_MSG_GET_DIRECTIONS_FROM_HERE = ('From here');
    var _UDS_MSG_CLEAR_RESULTS_UC = ('Clear results');
    var _UDS_MSG_SEARCH_THE_MAP = ('search the map');
    var _UDS_MSG_SCROLL_THROUGH_RESULTS = ('scroll through results');
    var _UDS_MSG_EDIT_TAGS = ('edit tags');
    var _UDS_MSG_TAG_THIS_SEARCH = ('tag this search');
    var _UDS_MSG_SEARCH_STRING = ('search string');
    var _UDS_MSG_OPTIONAL_LABEL = ('optional label');
    var _UDS_MSG_DELETE = ('delete');
    var _UDS_MSG_DELETED = ('deleted');
    var _UDS_MSG_CANCEL = ('cancel');
    var _UDS_MSG_UPLOAD_YOUR_VIDEOS = ('upload your own video');
    var _UDS_MSG_IM_DONE_WATCHING = ('i\047m done watching this');
    var _UDS_MSG_CLOSE_VIDEO_PLAYER = ('close video player');
    var _UDS_MSG_NO_RESULTS = ('No Results');
    var _UDS_MSG_LINKEDCSE_ERROR_RESULTS = ('This Custom Search Engine is loading. Try again in a few seconds.');
    var _UDS_MSG_COUPONS = ('Coupons');
    var _UDS_MSG_BACK = ('back');
    var _UDS_MSG_SUBSCRIBE = ('Subscribe');
    var _UDS_MSG_SEARCHER_PATENT = ('Patent');
    var _UDS_MSG_USPAT = ('US Pat.');
    var _UDS_MSG_USPAT_APP = ('US Pat. App');
    var _UDS_MSG_PATENT_FILED = ('Filed');
    var _UDS_MSG_ADS_BY_GOOGLE = ('Ads by Google');
    var _UDS_MSG_SET_DEFAULT_LOCATION = ('Set default location');
    var _UDS_MSG_NEWSCAT_TOPSTORIES = ('Top Stories');
    var _UDS_MSG_NEWSCAT_WORLD = ('World');
    var _UDS_MSG_NEWSCAT_NATION = ('Nation');
    var _UDS_MSG_NEWSCAT_BUSINESS = ('Business');
    var _UDS_MSG_NEWSCAT_SCITECH = ('Sci/Tech');
    var _UDS_MSG_NEWSCAT_ENTERTAINMENT = ('Entertainment');
    var _UDS_MSG_NEWSCAT_HEALTH = ('Health');
    var _UDS_MSG_NEWSCAT_SPORTS = ('Sports');
    var _UDS_MSG_NEWSCAT_POLITICS = ('Politics');
    var _UDS_MSG_SEARCH_RESULTS = ('Search results');
    var _UDS_MSG_DID_YOU_MEAN = ('Did you mean:');
    var _UDS_MSG_CUSTOM_SEARCH = ('Custom Search');
    var _UDS_MSG_LABELED = ('Labeled');
    var _UDS_MSG_LOADING = ('Loading...');
    var _UDS_MSG_ALL_RESULTS_SHORT = ('All');
    var _UDS_MSG_ALL_RESULTS_LONG = ('All results');
    var _UDS_MSG_REFINE_RESULTS = ('Refine results:');

    function _UDS_MSG_REVIEWS(REVIEW_COUNT) {
        return ('' + REVIEW_COUNT + ' reviews');
    }

    function _UDS_MSG_CALORIES(CALORIES) {
        return ('' + CALORIES + ' cal');
    }

    function _UDS_MSG_PRICE_RANGE(RANGE) {
        return ('Price range: ' + RANGE + '.');
    }

    function _UDS_MSG_PRICE(PRICE) {
        return ('Price: ' + PRICE + '.');
    }

    function _UDS_MSG_AVAILABILITY(AVAILABILITY) {
        return ('Availability: ' + AVAILABILITY + '.');
    }

    function _UDS_MSG_TELEPHONE(TELEPHONE) {
        return ('Tel: ' + TELEPHONE + '');
    }

    function _UDS_MSG_RESULT_INFO(NUMBER_OF_RESULTS, SEARCH_TIME) {
        return ('About ' + NUMBER_OF_RESULTS + ' results (' + SEARCH_TIME + ' seconds)');
    }

    var _UDS_MSG_FILE_FORMAT = ('File Format:');
    var _UDS_MSG_SHOWING_RESULTS_FOR = ('Showing results for');
    var _UDS_MSG_SEARCH_INSTEAD_FOR = ('Search instead for');

    function _UDS_MSG_FILTERED_RESULTS(NUM) {
        return ('In order to show you the most relevant results, we have omitted some entries very similar to the ' + NUM + ' already displayed. If you like, you can ' + '<a>repeat the search with the omitted results included' + '</a>.');
    }

    var _UDS_MSG_ORDER_BY = ('Sort by:');
    var _UDS_MSG_ORDER_BY_RELEVANCE = ('Relevance');
    var _UDS_MSG_ORDER_BY_DATE = ('Date');
    var _UDS_MSG_ORDER_BY_GET_LINK = ('Share this page:');
    var _UDS_MSG_ADD_LABEL = ('Add Label');
    var _UDS_MSG_NO_REFINEMENT =
        ('Refinements should be present before adding label');
    var _UDS_MSG_LABEL_PAGE = ('This particular page');
    var _UDS_MSG_LABEL_SITE = ('Entire site');
    var _UDS_MSG_LABEL_PREFIX = ('Specific page prefix');
    var _UDS_MSG_INVALID_URL_PREFIX = ('Invalid url prefix');
    var _UDS_MSG_ERROR_ADDING_LABEL = ('Error adding label.');
    var _UDS_MSG_SAVING = ('Saving...');
    var _UDS_MSG_ADD_LABEL_SAVE = ('Save');
    var _UDS_MSG_ADD_LABEL_CANCEL = ('Cancel');

    var c = encodeURIComponent, da = google_exportSymbol, ea = _UDS_CONST_SHORT_DATE_PATTERN, h = document, fa = isNaN, na = Math, oa = Array, pa = navigator, qa = parseInt, ra = parseFloat, sa = String, ta = _UDS_CONST_LOCALE, ua = decodeURIComponent;

    function va(a, b) {
        return a.onload = b
    }

    function wa(a, b) {
        return a.width = b
    }

    function ya(a, b) {
        return a.padding = b
    }

    function za(a, b) {
        return a.cancelBubble = b
    }

    function Aa(a, b) {
        return a.checked = b
    }

    function Da(a, b) {
        return a.total = b
    }

    function Ea(a, b) {
        return a.href = b
    }

    function Fa(a, b) {
        return a.display = b
    }

    function Ia(a, b) {
        return a.height = b
    }

    function Ja(a, b) {
        return a.root = b
    }

    function Ma(a, b) {
        return a.onreadystatechange = b
    }

    function Na(a, b) {
        return a.input = b
    }

    function Oa(a, b) {
        return a.innerHTML = b
    }

    function Qa(a, b) {
        return a.value = b
    }

    function Ra(a, b) {
        return a.left = b
    }

    function Ua(a, b) {
        return a.type = b
    }

    function Va(a, b) {
        return a.name = b
    }

    function Xa(a, b) {
        return a.zIndex = b
    }

    function Ya(a, b) {
        return a.visibility = b
    }

    function Za(a, b) {
        return a.textContent = b
    }

    function ab(a, b) {
        return a.title = b
    }

    function m(a, b) {
        return a.className = b
    }

    function bb(a, b) {
        return a.disabled = b
    }

    function cb(a, b) {
        return a.target = b
    }

    function fb(a, b) {
        return a.onclick = b
    }

    var p = "appendChild", hb = "getBoundingClientRect", ib = "pushState", kb = "clearTimeout", lb = "width", r = "replace", mb = "floor", nb = "content", sb = "offsetWidth", tb = "concat", ub = "charAt", wb = "createTextNode", xb = "insertBefore", yb = "match", Ab = "focus", t = "createElement", Bb = "keyCode", Cb = "firstChild", Db = "select", Eb = "setAttribute", Fb = "cloneNode", Gb = "clear", Hb = "childNodes", Ib = "refresh", Jb = "attachEvent", Mb = "nextSibling", Nb = "getTime", Ob = "register", Pb = "getElementsByTagName", Qb = "host", Rb = "substr", Sb = "cursor", Tb = "checked", Xb = "setTimeout",
        Yb = "split", Zb = "stopPropagation", $b = "userAgent", ac = "buffer", bc = "location", cc = "count", dc = "hasOwnProperty", ec = "getComputedStyle", u = "style", fc = "hostname", gc = "close", hc = "hasChildNodes", v = "search", ic = "state", jc = "isEnabled", kc = "random", lc = "protocol", B = "addRule", mc = "href", nc = "console", oc = "apply", pc = "tagName", qc = "reset", rc = "removeAttribute", sc = "label", tc = "display", uc = "height", vc = "root", wc = "offsetHeight", C = "push", xc = "page", yc = "open", zc = "test", Ac = "replaceChild", Bc = "input", Cc = "styleSheet", Dc = "submit", Ic = "text",
        Jc = "round", Kc = "nodeType", Lc = "getElementById", Mc = "innerHTML", Nc = "srcElement", Oc = "RENDERER", Pc = "value", Qc = "indexOf", Rc = "insertRow", Sc = "getElementsByClassName", Tc = "setRequestHeader", Uc = "readyState", Vc = "addEventListener", Wc = "type", Xc = "defaultView", Yc = "ServiceBase", Zc = "name", $c = "insertCell", ad = "parse", F = "length", bd = "title", G = "prototype", cd = "className", dd = "clientWidth", ed = "Version", fd = "document", gd = "body", hd = "history", id = "removeChild", jd = "target", kd = "call", ld = "anchor", md = "getAttribute", nd = "charCodeAt",
        od = "sort", pd = "loader", qd = "currentStyle", rd = "substring", sd = "themes", td = "shiftKey", H = "element", ud = "parentNode", vd = "CurrentLocale", wd = "splice", xd = "join", yd = "toLowerCase", zd = "event", I;
    var Ad = this, Bd = function (a, b, d) {
        a = a[Yb](".");
        d = d || Ad;
        a[0]in d || !d.execScript || d.execScript("var " + a[0]);
        for (var e; a[F] && (e = a.shift());)a[F] || void 0 === b ? d = d[e] ? d[e] : d[e] = {} : d[e] = b
    };
    var Jd = function (a, b) {
        if (b)a = a[r](Cd, "&amp;")[r](Dd, "&lt;")[r](Ed, "&gt;")[r](Fd, "&quot;")[r](Gd, "&#39;")[r](Hd, "&#0;"); else {
            if (!Id[zc](a))return a;
            -1 != a[Qc]("&") && (a = a[r](Cd, "&amp;"));
            -1 != a[Qc]("<") && (a = a[r](Dd, "&lt;"));
            -1 != a[Qc](">") && (a = a[r](Ed, "&gt;"));
            -1 != a[Qc]('"') && (a = a[r](Fd, "&quot;"));
            -1 != a[Qc]("'") && (a = a[r](Gd, "&#39;"));
            -1 != a[Qc]("\x00") && (a = a[r](Hd, "&#0;"))
        }
        return a
    }, Cd = /&/g, Dd = /</g, Ed = />/g, Fd = /"/g, Gd = /'/g, Hd = /\x00/g, Id = /[\x00&<>"']/;
    var Kd = /<[^>]*>|&[^;]+;/g, Ld = function (a, b) {
            return b ? a[r](Kd, "") : a
        }, Md = RegExp("[A-Za-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02b8\u0300-\u0590\u0800-\u1fff\u200e\u2c00-\ufb1c\ufe00-\ufe6f\ufefd-\uffff]"), Nd = RegExp("^[^A-Za-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02b8\u0300-\u0590\u0800-\u1fff\u200e\u2c00-\ufb1c\ufe00-\ufe6f\ufefd-\uffff]*[\u0591-\u07ff\u200f\ufb1d-\ufdff\ufe70-\ufefc]"), Od = /^http:\/\/.*/, Pd = RegExp("[A-Za-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02b8\u0300-\u0590\u0800-\u1fff\u200e\u2c00-\ufb1c\ufe00-\ufe6f\ufefd-\uffff][^\u0591-\u07ff\u200f\ufb1d-\ufdff\ufe70-\ufefc]*$"),
        Qd = RegExp("[\u0591-\u07ff\u200f\ufb1d-\ufdff\ufe70-\ufefc][^A-Za-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02b8\u0300-\u0590\u0800-\u1fff\u200e\u2c00-\ufb1c\ufe00-\ufe6f\ufefd-\uffff]*$"), Rd = /\s+/, Sd = /\d/;
    var Td = function (a, b) {
        this.Pd = "number" == typeof a ? 0 < a ? 1 : 0 > a ? -1 : null : null == a ? null : a ? -1 : 1;
        this.Jx = !!b
    };
    I = Td[G];
    I.rm = function (a, b) {
        for (var d = 0, e = 0, g = !1, f = Ld(a, b)[Yb](Rd), k = 0; k < f[F]; k++) {
            var l = f[k];
            Nd[zc](Ld(l, void 0)) ? (d++, e++) : Od[zc](l) ? g = !0 : Md[zc](Ld(l, void 0)) ? e++ : Sd[zc](l) && (g = !0)
        }
        return 0 == e ? g ? 1 : 0 : .4 < d / e ? -1 : 1
    };
    I.Mx = function (a, b) {
        return 0 > a * b
    };
    I.br = function (a, b, d, e) {
        return e && (this.Mx(b, this.Pd) || 1 == this.Pd && Qd[zc](Ld(a, d)) || -1 == this.Pd && Pd[zc](Ld(a, d))) ? 1 == this.Pd ? "\u200e" : "\u200f" : ""
    };
    I.Sq = function (a, b) {
        return this.jr(this.rm(a, b))
    };
    I.jr = function (a) {
        return-1 == (0 == a ? this.Pd : a) ? "rtl" : "ltr"
    };
    I.Uq = function (a, b, d) {
        return this.Iy(null, a, b, d)
    };
    I.Iy = function (a, b, d, e) {
        null == a && (a = this.rm(b, d));
        return this.Px(a, b, d, e)
    };
    I.Px = function (a, b, d, e) {
        e = e || void 0 == e;
        d || (b = Jd(b));
        d = [];
        var g = 0 != a && a != this.Pd;
        if (this.Jx || g)d[C]("<span"), g && d[C](-1 == a ? ' dir="rtl"' : ' dir="ltr"'), d[C](">" + b + "</span>"); else d[C](b);
        d[C](this.br(b, a, !0, e));
        return d[xd]("")
    };
    I.Tq = function (a, b) {
        return this.sy(null, a, b)
    };
    I.sy = function (a, b, d) {
        null == a && (a = this.rm(b, d));
        return this.br(b, a, d, !0)
    };
    I.Jy = function () {
        return-1 == this.Pd ? "right" : "left"
    };
    I.jy = function () {
        return-1 == this.Pd ? "left" : "right"
    };
    var Ud, Vd, Wd, Xd, Yd, Zd, be, ce, de, ee, fe, ge, he, ie, je, ke, le, me, ne, oe, pe, qe, re, se, te, ue, ve, we, xe, ye, ze, Ae, Be, Ce, De, Ee, Fe, Ge, He, Ie, Je, Ke, Le, Me, Ne, Oe, Pe, Qe, Re, Se, Te, Ue, Xe, Ye, Ze, $e, af, bf, cf, df, ef, ff, gf, hf, jf, kf, lf, mf, nf, of, pf = /^[6-9]$/, qf = {Zv: 0, Tp: 1, Yv: 2, pj: 3}, uf = {EMPTY: 0, zt: 1, wo: 2}, vf = {qt: 1, rt: 2, dB: 3, pt: 4, st: 5, uB: 6, LA: 7, fg: 8}, wf = {DONT_CARE: 1, ot: 2, no: 3}, xf = {Sp: 0, $v: 1, pj: 2}, yf = [23, 24], M = {Fu: 0, wA: 114, Ad: 115, Yg: 116, tb: 117, Xg: 494, Ua: 118, Ie: 119, zd: 374, Dd: 120, xd: 121, wi: 122, ic: 123, Te: 124, yi: 125, Nu: 230, lB: 553, Ec: 126,
        ef: 127, Ob: 128, Bo: 343, $f: 129, vA: 231, Ce: 130, Au: 131, zA: 237, IA: 570, gB: 132, Cu: 134, tu: 189, uu: 246, iB: 264, hB: 256, Bi: 133, At: 184, Pg: 419, vB: 503, wB: 578, xB: 579, yB: 505, BB: 516, zB: 509, AB: 512, Me: 173, XA: 568, YA: 569, In: 135, yk: 136, zk: 137, Mn: 138, Qf: 139, Bu: 140, Jn: 141, Kn: 142, Ln: 240, Du: 143, Eu: 144, Ni: 347, Fl: 191, fj: 150, Sf: 145, tq: 146, Sg: 147, CB: 148, sB: 245, Xo: 155, gh: 149, fi: 154, ui: 311, ge: 153, RENDERER: 152, Yc: 156, cf: 151, vl: 158, Ao: 294, il: 157, Se: 160, $A: 328, DB: 580, Gd: 159}, zf = {Yo: 161, Zo: 162};
    var Af = function (a) {
        return{tj: function () {
            return a.tj()
        }, Lb: function () {
            return a.Lb()
        }, Gb: function () {
            return a.Gb()
        }}
    };
    (function () {
        function a(a) {
            for (var b = [], g = 0, f; f = a[g++];)b[C](f.api || {a: f.mh, b: f.rb, c: f.he, d: f.L, e: f.of, f: f.pq, g: f.nq, i: f.ii, j: f.Ba, k: f.Pi, l: f.mq});
            return b
        }

        function b(a) {
            for (var b = [], g = 0, f; f = a[g++];)f = f.api || f, b[C]({api: f, mh: f.a, rb: f.b, he: f.c, L: f.d, of: f.e, pq: f.f, nq: f.g, ii: f.i, Ba: f.j, Pi: f.k, mq: f.l});
            return b
        }

        Ud = function (a) {
            var b = {};
            if (a)for (var g = 0; g < a[F]; ++g)b[a[g]] = !0;
            return b
        };
        Vd = function (b) {
            var e = a(b.Gb());
            return b.api || {a: b.Lb, b: function () {
                return e
            }, c: b.tj}
        };
        Wd = function (a) {
            a = a.api || a;
            var e = b(a.b());
            return{api: a, Lb: a.a, Gb: function () {
                return e
            }, tj: a.c}
        };
        Xd = function (a) {
            return a ? (a = a[yd](), "zh-tw" == a || "zh-cn" == a || "ja" == a || "ko" == a) : !1
        };
        Yd = function () {
            return(new Date)[Nb]()
        };
        Zd = function (a) {
            return"string" == typeof a
        };
        be = function (a) {
            return"number" == typeof a
        }
    })();
    var Bf = function () {
        return{Uf: function () {
            return{rk: "hp", sk: "hp", Go: "google.com", su: "", He: "en", qn: "", Os: "", Cs: "", Uo: 0, gt: "", tk: "", Mo: !1, ru: "", ql: "", pl: 0, Jz: null, No: !1, Cz: !1, pi: !1, Yf: Ud([19, 5, 0]), nz: !1, Ls: !0, mz: 10, ft: !0, Qn: !0, kz: !1, Ms: !1, Ou: !1, Vm: !1, tz: !1, bu: !1, fz: !0, Fz: "en", Lj: !0, Er: !1, Pr: 500, Tj: !1, Li: !0, xo: !0, As: !1, Tn: "", uz: "//www.google.com/textinputassistant", vz: "", xz: 7, oz: !1, pz: !1, Or: !1, Es: !0, Fs: !1, Wm: !1, Ir: !1, Hr: !1, bi: 1, Gr: !0, Oj: !1, fk: !1, ks: !1, ps: 10, Ck: !1, iz: 0, qz: !1, qs: !0, Fr: !1, Zg: h[gd], Bs: !0, Un: null,
                Le: {}, lz: {}, yz: 0, ls: !1, Ns: !0, ce: !1, Ez: null, zs: !1, wu: null, vo: null, wt: !1, Gs: !0, js: !1, Iz: 1, gz: 1, spellcheck: !1, os: !1, Is: "Search", Ak: "I'm  Feeling Lucky", Js: "", Hs: "Learn more", Bz: "Remove", zz: "This search was removed from your Web History", rz: "", jz: "Did you mean:", wz: "", Dz: "", Gz: "Search by voice", en: !1, ms: null, dn: 0, ns: 0, gk: "", Xn: "", sz: !1, Tg: "absolute", Ds: !1, vt: !1, hn: null, gn: !0, Hz: 0, gf: [0, 0, 0], Pn: null, Xm: null, ut: [0], Wn: 0, Az: 1, Uj: "", pn: "", on: "", $k: null, cl: "", bl: "", hz: 1, kk: {}, ss: !0}
        }}
    };
    var Cf = /<\/?(?:b|em)>/gi, Df = {eu: 8, fg: 9, Ho: 13, Ri: 27, tB: 32, cu: 37, zo: 38, du: 39, yo: 40, fu: 46, fB: 190};
    var Ef = function () {
        function a(a, b, d) {
            f[a] = d;
            n[a] = [b]
        }

        function b(a, b, e) {
            var f = l[a];
            f ? f != d && (l[a] = d) : l[a] = e;
            (f = n[a]) ? f[C](b) : n[a] = [b];
            k[b] = e
        }

        var d = ce, e = 0, g = {}, f = {}, k = {}, l = {}, n = {}, q = 1E4;
        return{iA: function () {
            return e++
        }, hA: function () {
            return q++
        }, er: a, jA: function (b, d) {
            var e = q++;
            a(b, e, d);
            return e
        }, register: b, kA: function (a, d) {
            var e = q++;
            b(a, e, d);
            return e
        }, vu: function () {
            return n
        }, Uf: function (a, b) {
            var e = g[a];
            return e ? e : (e = f[a]) ? g[a] = e() : b ? (e = k[b]) ? e() : null : (e = l[a]) && e != d ? e() : null
        }}
    }();
    var Ff = function (a, b, d, e, g, f) {
        function k() {
            if (A) {
                for (var a = 0, b; b = K[a++];)b.Db && b.Db();
                A = !1
            }
        }

        function l(a) {
            for (var b in a) {
                var d = b, e = a[d];
                if (e != x.Yo)if (y[d]) {
                    for (var f = z[d] || [], g = 0, k = void 0; g < e[F]; ++g)(k = n(d, e[g])) && f[C](k);
                    z[d] = f
                } else(e = n(d, e)) && (N[d] = e)
            }
        }

        function n(a, b) {
            var d;
            if (b && b instanceof Object)d = b; else if (d = D.Uf(a, b), !d)return null;
            if (d.cg) {
                var e = d.cg();
                if (e)for (var f = 0, g, k, n; g = e[f++];) {
                    n = !1;
                    k = g.L();
                    if (y[k]) {
                        if (n = J[k]) {
                            n[C](g);
                            continue
                        }
                        n = !0
                    }
                    J[k] = n ? [g] : g
                }
            }
            L[C]([d, a]);
            K[C](d);
            return d
        }

        function q(a) {
            for (var b =
                M.Fu, d = 0, e; e = L[d++];)e[0] == a && (b = e[1]);
            return b
        }

        function s(a, b) {
            var d = de(a.L(), w), e = de(b.L(), w);
            return 0 > d ? 1 : 0 > e ? -1 : d - e
        }

        var x = zf, y = Ud([M.Gd, M.Xo, M.gh, M.ge, M.fi, M.ui, M[Oc], M.Yc, M.wi, M.cf, M.vl, M.Ao, M.Se]), E = [M.Sf, M.tb, M.Ua, M.Ie, M.zd, M.Ec, M.Ad, M.Yg, M.Dd, M.Sg, M.xd, M.Bi, M.ic, M.Te, M.yi, M.ef, M.Ob, M.Bo, M.$f], w = [M.ef, M.gh, M.Cu, M.ic, M.xd, M.Ec, M.Ua, M.Ad, M.Ob, M.Se, M.Me, M.Ie, M.Yg, M[Oc], M.ge, M.$f, M.Dd, M.zd, M.Te, M.vl, M.Xo, M.Au, M.Ce, M.Sg, M.Jn, M.Kn, M.zk, M.Ln, M.Du, M.Mn, M.Eu, M.Qf, M.Bu, M.In, M.yk], N = {}, z = {}, J = {}, L = [],
            K = [], A = !1, D = Ef, Y = {ea: function (a) {
                k();
                for (var b = 0, d; d = K[b++];)d.ea && d.ea(a);
                A = !0
            }, Db: k, nn: function () {
                return A
            }, get: function (a, b) {
                var d = N[a];
                if (d)return d.W ? d.W(q(b)) : {}
            }, Cb: function (a, b) {
                var d = z[a];
                if (d) {
                    for (var e = [], f = q(b), g = 0, k; k = d[g++];)e[C](k.W ? k.W(f) : {});
                    return e
                }
                return[]
            }, Ae: function () {
                return a
            }, Th: function () {
                return g
            }, Lo: function (a, b) {
                var d = z[M.Gd];
                if (d)for (var e = 0, f; f = d[e++];)if (f.X() == a)return f.W ? f.W(q(b)) : {};
                return null
            }};
        (function () {
            if (f.ss) {
                var g = D.vu(), k, q, w, z;
                for (z in g) {
                    var L = z;
                    k = g[L];
                    q = y[L];
                    if (w = b[L]) {
                        if (w != x.Yo && q && w[F]) {
                            q = b;
                            w = w.slice(0);
                            for (var aa = [], xa = {}, la = 0, Ba = void 0, ja = void 0; ja = w[la++];)ja instanceof Object && (Ba = ja.X(), xa[Ba] || (aa[C](ja), xa[Ba] = 1), w[wd](--la, 1));
                            la = Ud(w);
                            la[x.Zo] && (la = Ud(w[tb](k)), delete la[x.Zo]);
                            for (Ba in la)xa[Ba] || aa[C](qa(Ba, 10));
                            q[L] = aa
                        }
                    } else b[L] = q ? k : k[0]
                }
            }
            l(b);
            for (g = 0; z = E[g++];)b[z] || (q = n(z, void 0)) && (N[z] = q);
            l(J);
            K[od](s);
            for (g = 0; z = K[g++];)z.jb && z.jb(d, e);
            a.ol(e, d.Yh());
            e.Gu();
            for (g = 0; z = K[g++];)z.ia && z.ia(Y);
            for (g = 0; z = K[g++];)z.ub && z.ub(f);
            for (g =
                     0; z = K[g++];)z.ea && z.ea(f);
            A = !0
        })();
        return Y
    };
    var Gf = function (a, b, d) {
        function e() {
            return a
        }

        function g() {
            return w
        }

        function f() {
            return N
        }

        function k() {
            return b
        }

        function l() {
            return d || ""
        }

        function n(a, b) {
            y(a, b)
        }

        function q(a, b) {
            y(a, b, !0)
        }

        function s() {
            A || (D = Y = !0)
        }

        function x() {
            T = !0
        }

        function y(a, b, d) {
            A || (D = !0, z[a] = b, d && (J[a] = b))
        }

        var E = ge(), w, N, z = {}, J = {}, L, K, A = !1, D = !1, Y = !1, ba = !1, T = !1, ka = {wb: function () {
            return E
        }, Po: function () {
            var a = qa(E, 36);
            return fa(a) ? -1 : a
        }, Lb: e, lp: g, me: f, Of: k, Ba: function () {
            return z
        }, np: function () {
            return L
        }, gj: l, tl: function () {
            return K
        },
            Ym: function () {
                return{Lb: e, lp: g, me: f, Of: k, gj: l, setParameter: n, Wi: q, Uw: s, Tw: x}
            }, setParameter: n, Wi: q, Uw: s, Tw: x, nu: function () {
                return Y
            }, mu: function () {
                D = ba = !0
            }, Ks: function (e, f, g) {
                return!D && a == e && b.xw(f) && d == g
            }, Ro: function () {
                return ba
            }, op: function () {
                return T
            }, lu: function () {
                A || (K = Yd(), "cp"in J || q("cp", b.ei()), y("gs_id", E), L = ee(J) + ":" + a, D = A = !0)
            }};
        w = a[yd]();
        N = fe(w);
        return ka
    };
    var If = function (a, b, d, e, g, f) {
        function k() {
            return!!b && !!b[0]
        }

        var l, n = !0, q, s = {hd: function () {
            return a
        }, Lb: function () {
            return a.Lb()
        }, Mj: function () {
            return k() ? b[0] : null
        }, Gb: function () {
            return b
        }, vd: k, Ba: function () {
            return d
        }, ml: function () {
            return e
        }, cj: function () {
            return g
        }, Ev: function () {
            return f
        }, L: function () {
            return n
        }, Eo: function () {
            q || (q = Af(s));
            return q
        }, tj: function () {
            return l
        }};
        b ? b[F] && 33 == b[0].L() && (g = n = !1) : b = [];
        d ? l = d.Hw("t") : d = Hf;
        return s
    };
    var Jf = function (a, b, d, e, g, f) {
        function k(a) {
            if (g)for (var b = 0, d; d = a[b++];)if (-1 != de(d, g))return!0;
            return!1
        }

        var l = !1, n = {mh: function () {
            return a
        }, rb: function () {
            return b
        }, he: function () {
            return d
        }, L: function () {
            return e
        }, Pi: function () {
            return f.qb("za")
        }, mq: function () {
            return f.qb("zb")
        }, of: function () {
            return g || []
        }, pq: function (a) {
            return!!g && k([a])
        }, nq: k, Ba: function () {
            return f
        }, ii: function () {
            return l
        }};
        switch (e) {
            case 0:
            case 32:
            case 38:
            case 39:
            case 400:
            case 407:
            case 35:
            case 33:
            case 41:
            case 34:
            case 44:
            case 45:
            case 40:
            case 46:
            case 56:
            case 30:
                l = !0
        }
        f || (f = Hf);
        return n
    };
    (function () {
        var a = /\s/g, b = /\u3000/g, d = /^\s/, e = /\s+/, g = /\s+/g, f = /^\s+|\s+$/g, k = /^\s+$/, l = /<[^>]*>/g, n = /&nbsp;/g, q = /&#x3000;/g, s = [/&/g, /&amp;/g, /</g, /&lt;/g, />/g, /&gt;/g, /"/g, /&quot;/g, /'/g, /&#39;/g, /{/g, /&#123;/g], x = h[Pb]("head")[0], y = 0;
        ie = function (a, b) {
            void 0 === b && (b = a);
            var d = function () {
                return b
            };
            return{ei: d, jo: function () {
                return a
            }, Kw: d, eA: function () {
                return a < b
            }, xw: function (d) {
                return d && a == d.jo() && b == d.Kw()
            }}
        };
        he = function (a, b, d, e) {
            if (null == b || "" === b) {
                if (!e)return;
                b = ""
            }
            d[C](a + "=" + c(sa(b)))
        };
        ee = function (a) {
            var b =
                [], d;
            for (d in a)he(d, a[d], b);
            return b[xd]("&")
        };
        je = function (a) {
            return!!a && !k[zc](a)
        };
        ke = function (a) {
            for (var b = s[F], d = 0; d < b; d += 2)a = a[r](s[d], s[d + 1].source);
            return a
        };
        le = function (a) {
            for (var b = s[F], d = 0; d < b; d += 2)a = a[r](s[d + 1], s[d].source);
            a = a[r](n, " ");
            return a[r](q, "\u3000")
        };
        me = function (a) {
            return a[r](Cf, "")
        };
        ne = function (a) {
            return a[r](l, "")
        };
        oe = function (d) {
            return d && (-1 < d[Qc](" ") || e[zc](d)) ? (d = d[r](b, "&#x3000;"), d[r](a, "&nbsp;")) : d
        };
        fe = function (a, b) {
            return a && (-1 < a[Qc](" ") || e[zc](a)) ? (a = a[r](g, " "),
                a[r](b ? f : d, "")) : a
        };
        pe = function (a, b, d) {
            d && (a = a[yd](), b = b[yd]());
            return b[F] <= a[F] && a[rd](0, b[F]) == b
        };
        qe = function (a, b) {
            return a || b ? !!a && !!b && a[yd]() == b[yd]() : !0
        };
        re = function (a) {
            window[kb](a)
        };
        ce = function () {
        };
        se = function () {
            return x
        };
        ge = function () {
            return(y++).toString(36)
        };
        te = function (a) {
            return pf[zc](a)
        };
        ue = function (a, b) {
            return Jf(a.mh(), a.rb(), b, a.L(), a.of(), a.Ba())
        };
        de = function (a, b) {
            if (b[Qc])return b[Qc](a);
            for (var d = 0, e = b[F]; d < e; ++d)if (b[d] === a)return d;
            return-1
        };
        ve = function (a, b) {
            return a.mb() - b.mb()
        };
        we = function (a, b) {
            return b.mb() - a.mb()
        };
        xe = function (a) {
            var b = {}, d;
            for (d in a)b[d] = a[d];
            return b
        };
        ye = function (a, b, d) {
            b in a || (a[b] = [162]);
            a[b][C](d)
        }
    })();
    var Kf = function (a) {
        return{contains: function (b) {
            return b in a
        }, dw: function (b) {
            return!!a[b]
        }, Do: function (b) {
            return a[b] || 0
        }, qb: function (b) {
            return a[b] || ""
        }, Hw: function (b) {
            return a[b] || null
        }}
    }, Hf = Kf({});
    (function () {
        function a(a, b, d) {
            a = h[t](a);
            b && m(a, b);
            d && (a.id = d);
            return a
        }

        function b(b) {
            return a("div", b)
        }

        function d(a, b) {
            var d = a[Pb]("input");
            if (d)for (var e = 0, f; f = d[e++];)if (f[Zc] == b && "submit" != f[Wc][yd]())return f;
            return null
        }

        function e(a) {
            a && (a.preventDefault && a.preventDefault(), a.returnValue = !1);
            return!1
        }

        function g(a) {
            return a ? a.ownerDocument || a[fd] : window[fd]
        }

        function f(a) {
            return a ? (a = g(a), a[Xc] || a.parentWindow) : window
        }

        var k = void 0 != h.documentElement[u].opacity, l = {rtl: "right", ltr: "left"};
        Ee = function (a, b) {
            try {
                if (a.setSelectionRange)a.setSelectionRange(b, b); else if (a.createTextRange) {
                    var d = a.createTextRange();
                    d.collapse(!0);
                    d.moveStart("character", b);
                    d[Db]()
                }
            } catch (e) {
            }
        };
        Fe = function (a) {
            try {
                var b, d;
                if ("selectionStart"in a)b = a.selectionStart, d = a.selectionEnd; else {
                    var e = a.createTextRange(), f = g(a).selection.createRange();
                    e.inRange(f) && (e.setEndPoint("EndToStart", f), b = e[Ic][F], e.setEndPoint("EndToEnd", f), d = e[Ic][F])
                }
                if (void 0 !== b)return ie(b, d)
            } catch (k) {
            }
            return null
        };
        Ge = function (a, b) {
            for (var d = 0, e = 0; a &&
                (!b || a != b);) {
                d += a.offsetTop;
                e += a.offsetLeft;
                try {
                    a = a.offsetParent
                } catch (f) {
                    a = null
                }
            }
            return{Hl: d, pe: e}
        };
        He = function (a) {
            try {
                return g(a).activeElement == a
            } catch (b) {
            }
            return!1
        };
        Ie = function (a) {
            return 38 == a || 40 == a
        };
        Be = a;
        Je = function () {
            var b = a("table");
            b.cellPadding = b.cellSpacing = 0;
            wa(b[u], "100%");
            return b
        };
        Ke = b;
        Le = function (a, d) {
            var e = b(a), f = e[u];
            f.background = "transparent";
            f.color = "#000";
            ya(f, 0);
            f.position = "absolute";
            d && Xa(f, d);
            f.whiteSpace = "pre";
            return e
        };
        Me = function (a, b) {
            a[Mc] != b && (b && (ze ? b = oe(b) : Ae && (b = '<pre style="font:inherit;margin:0">' +
                b + "</pre>")), Oa(a, b))
        };
        Ne = function (a, b, d) {
            var e = a[u];
            "INPUT" != a.nodeName && (d += 1);
            Ra(e, e.right = "");
            e[b] = d + "px"
        };
        Oe = function (a) {
            return"rtl" == a ? "right" : "left"
        };
        Pe = function (a, b) {
            a.dir != b && (a.dir = b, a[u].textAlign = l[b])
        };
        Qe = function (b, e, f) {
            if (d(b, e))return null;
            var g = a("input");
            Ua(g, "hidden");
            Va(g, e);
            f && Qa(g, f);
            return b[p](g)
        };
        Re = d;
        Se = function (a) {
            var b = h.createEvent("KeyboardEvent");
            b.initKeyEvent && (b.initKeyEvent("keypress", !0, !0, null, !1, !1, !0, !1, 27, 0), a.dispatchEvent(b))
        };
        Te = e;
        Ue = function (a) {
            if (a = a ||
                window[zd])a[Zb] && a[Zb](), za(a, a.cancel = !0);
            return e(a)
        };
        Xe = function (a, b) {
            b[ud][xb](a, b[Mb])
        };
        Ye = function (a) {
            a = a[$c](-1);
            var b = Be("a");
            Ea(b, "#ifl");
            m(b, "gssb_j gss_ifl");
            a[p](b);
            return b
        };
        Ze = function (a, b) {
            var d = f(a);
            return(d = d[ec] ? d[ec](a, "") : a[qd]) ? d[b] : null
        };
        $e = function (a) {
            var b = a || window;
            a = b[fd];
            var d = b.innerWidth, b = b.innerHeight;
            if (!d) {
                var e = a.documentElement;
                e && (d = e[dd], b = e.clientHeight);
                d || (d = a[gd][dd], b = a[gd].clientHeight)
            }
            return{So: d, Qo: b}
        };
        af = function (a) {
            return(a || window)[fd].documentElement[dd]
        };
        bf = function (a) {
            a = a[u];
            a.border = "none";
            ya(a, Ce || De ? "0 1px" : "0");
            a.margin = "0";
            Ia(a, "auto");
            wa(a, "100%")
        };
        cf = function (a) {
            return(k ? "opacity" : "filter") + ":" + (k ? a + "" : (ze ? "progid:DXImageTransform.Microsoft.Alpha(" : "alpha(") + "opacity=" + na[mb](100 * a) + ")") + ";"
        };
        df = function (a) {
            var b = {};
            if (a)for (var d = 0, e; e = a[d++];)b[e.nh()] = e;
            return b
        };
        ef = g;
        ff = f;
        gf = function (a) {
            Ce && (a.tabIndex = 0)
        }
    })();
    Ef.er(M.Fl, 192, function () {
        function a(a) {
            Zd(a) && (a = e(a));
            var b = "";
            if (a) {
                for (var d = a[F], f = 0, g = 0, k = 0; d--;)for (g <<= 8, g |= a[k++], f += 8; 6 <= f;)var l = g >> f - 6 & 63, b = b + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_"[ub](l), f = f - 6;
                f && (l = g << 8 >> f + 8 - 6 & 63, b += "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_"[ub](l))
            }
            return b
        }

        function b(a) {
            var b = [];
            if (a)for (var d = 0, e = 0, f = 0; f < a[F]; ++f) {
                var g = a[nd](f);
                if (32 > g || 127 < g || !n[g - 32])return[];
                d <<= 6;
                d |= n[g - 32] - 1;
                e += 6;
                8 <= e && (b[C](d >> e - 8 & 255), e -=
                    8)
            }
            return b
        }

        function d(a, b) {
            var d = {};
            d.sb = oa(4);
            d.buffer = oa(4);
            d.Gw = oa(4);
            ya(d, oa(64));
            d.padding[0] = 128;
            for (var q = 1; 64 > q; ++q)d.padding[q] = 0;
            g(d);
            var q = oa(64), n;
            64 < b[F] ? (g(d), k(d, b), n = l(d)) : n = b;
            for (var s = 0; s < n[F]; ++s)q[s] = n[s] ^ 92;
            for (s = n[F]; 64 > s; ++s)q[s] = 92;
            g(d);
            for (s = 0; 64 > s; ++s)d[ac][s] = q[s] ^ 106;
            f(d, d[ac]);
            Da(d, 64);
            k(d, e(a));
            n = l(d);
            g(d);
            f(d, q);
            Da(d, 64);
            k(d, n);
            return l(d)
        }

        function e(a) {
            for (var b = [], d = 0, e = 0; e < a[F]; ++e) {
                var f = a[nd](e);
                128 > f ? b[d++] = f : (2048 > f ? b[d++] = f >> 6 | 192 : (b[d++] = f >> 12 | 224, b[d++] = f >>
                    6 & 63 | 128), b[d++] = f & 63 | 128)
            }
            return b
        }

        function g(a) {
            a.sb[0] = 1732584193;
            a.sb[1] = 4023233417;
            a.sb[2] = 2562383102;
            a.sb[3] = 271733878;
            a.uj = Da(a, 0)
        }

        function f(a, b) {
            for (var d = a.Gw, e = 0; 64 > e; e += 4)d[e / 4] = b[e] | b[e + 1] << 8 | b[e + 2] << 16 | b[e + 3] << 24;
            for (var f = a.sb[0], e = a.sb[1], g = a.sb[2], k = a.sb[3], l, n, A, D = 0; 64 > D; ++D)16 > D ? (l = k ^ e & (g ^ k), n = D) : 32 > D ? (l = g ^ k & (e ^ g), n = 5 * D + 1 & 15) : 48 > D ? (l = e ^ g ^ k, n = 3 * D + 5 & 15) : (l = g ^ (e | ~k), n = 7 * D & 15), A = k, k = g, g = e, f = f + l + s[D] + d[n] & 4294967295, l = q[D], e = e + ((f << l | f >>> 32 - l) & 4294967295) & 4294967295, f = A;
            a.sb[0] = a.sb[0] +
                f & 4294967295;
            a.sb[1] = a.sb[1] + e & 4294967295;
            a.sb[2] = a.sb[2] + g & 4294967295;
            a.sb[3] = a.sb[3] + k & 4294967295
        }

        function k(a, b, d) {
            d || (d = b[F]);
            Da(a, a.total + d);
            for (var e = 0; e < d; ++e)a[ac][a.uj++] = b[e], 64 == a.uj && (f(a, a[ac]), a.uj = 0)
        }

        function l(a) {
            var b = oa(16), d = 8 * a.total, e = a.uj;
            k(a, a.padding, 56 > e ? 56 - e : 64 - (e - 56));
            for (var g = 56; 64 > g; ++g)a[ac][g] = d & 255, d >>>= 8;
            f(a, a[ac]);
            for (g = e = 0; 4 > g; ++g)for (d = 0; 32 > d; d += 8)b[e++] = a.sb[g] >> d & 255;
            return b
        }

        var n = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 63, 0, 0, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 0, 0, 0, 0, 0, 0, 0,
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 0, 0, 0, 0, 64, 0, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 0, 0, 0, 0, 0], q = [7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21], s = [3614090360, 3905402710, 606105819, 3250441966, 4118548399, 1200080426, 2821735955, 4249261313, 1770035416, 2336552879, 4294925233, 2304563134, 1804603682, 4254626195,
            2792965006, 1236535329, 4129170786, 3225465664, 643717713, 3921069994, 3593408605, 38016083, 3634488961, 3889429448, 568446438, 3275163606, 4107603335, 1163531501, 2850285829, 4243563512, 1735328473, 2368359562, 4294588738, 2272392833, 1839030562, 4259657740, 2763975236, 1272893353, 4139469664, 3200236656, 681279174, 3936430074, 3572445317, 76029189, 3654602809, 3873151461, 530742520, 3299628645, 4096336452, 1126891415, 2878612391, 4237533241, 1700485571, 2399980690, 4293915773, 2240044497, 1873313359, 4264355552, 2734768916, 1309151649, 4149444226,
            3174756917, 718787259, 3951481745];
        return{L: function () {
            return M.Fl
        }, X: function () {
            return 192
        }, W: function () {
            return{Zu: a, Yu: b, $u: d}
        }}
    });
    Ef.er(M.fj, 95, function () {
        function a(a, d) {
            d = ke(me(d));
            a = ke(fe(a, !0));
            if (pe(d, a))return a + "<b>" + d[Rb](a[F]) + "</b>";
            for (var e = "", g = [], f = d[F] - 1, k = 0, l = -1, n; n = d[ub](k); ++k)" " == n || "\t" == n ? e[F] && (g[C]({sq: e, Gh: l, Fh: k + 1}), e = "", l = -1) : (e += n, -1 == l ? l = k : k == f && g[C]({sq: e, Gh: l, Fh: k + 1}));
            e = a[Yb](/\s+/);
            k = {};
            for (f = 0; l = e[f++];)k[l] = 1;
            n = -1;
            for (var e = [], q = g[F] - 1, f = 0; l = g[f]; ++f)k[l.sq] ? (l = -1 == n, f == q ? e[C]({Gh: l ? f : n, Fh: f}) : l && (n = f)) : -1 < n && (e[C]({Gh: n, Fh: f - 1}), n = -1);
            if (!e[F])return"<b>" + d + "</b>";
            f = "";
            for (k = l = 0; n = e[k]; ++k)(q =
                g[n.Gh].Gh) && (f += "<b>" + d[rd](l, q - 1) + "</b> "), l = g[n.Fh].Fh, f += d[rd](q, l);
            l < d[F] && (f += "<b>" + d[rd](l) + "</b> ");
            return f
        }

        return{L: function () {
            return M.fj
        }, X: function () {
            return 95
        }, W: function () {
            return{bold: a}
        }}
    });
    Ef[Ob](M.tq, 12, function () {
        function a(a) {
            a = b(a, x, d);
            a = b(a, y, e);
            return b(a, w, g)
        }

        function b(a, b, d) {
            for (var e, f = "", g = 0; null != (e = b.exec(a));)g < e.index && (f += a[rd](g, e.index)), f += d(e[0]), g = b.lastIndex;
            if (!f)return a;
            g < a[F] && (f += a[rd](g));
            return f
        }

        function d(a) {
            return sa.fromCharCode(a[nd](0) - 65248)
        }

        function e(a) {
            var b = a[nd](0);
            return 1 == a[F] ? k[ub](b - 65377) : 65438 == a[nd](1) ? l[ub](b - 65395) : n[ub](b - 65418)
        }

        function g(a) {
            var b = a[nd](0);
            return 12443 == a[nd](1) ? q[ub](b - 12454) : s[ub](b - 12495)
        }

        function f(a) {
            return eval('"\\u30' +
                a[Yb](",")[xd]("\\u30") + '"')
        }

        var k = f("02,0C,0D,01,FB,F2,A1,A3,A5,A7,A9,E3,E5,E7,C3,FC,A2,A4,A6,A8,AA,AB,AD,AF,B1,B3,B5,B7,B9,BB,BD,BF,C1,C4,C6,C8,CA,CB,CC,CD,CE,CF,D2,D5,D8,DB,DE,DF,E0,E1,E2,E4,E6,E8,E9,EA,EB,EC,ED,EF,F3,9B,9C"), l = f("F4__,AC,AE,B0,B2,B4,B6,B8,BA,BC,BE,C0,C2,C5,C7,C9_____,D0,D3,D6,D9,DC"), n = f("D1,D4,D7,DA,DD"), q = f("F4____,AC_,AE_,B0_,B2_,B4_,B6_,B8_,BA_,BC_,BE_,C0_,C2__,C5_,C7_,C9______,D0__,D3__,D6__,D9__,DC"), s = f("D1__,D4__,D7__,DA__,DD"), x = /[\uFF01-\uFF5E]/g, y = RegExp("([\uff73\uff76-\uff84\uff8a-\uff8e]\uff9e)|([\uff8a-\uff8e]\uff9f)|([\uff61-\uff9f])",
            "g"), E = "([" + f("A6,AB,AD,AF,B1,B3,B5,B7,B9,BB,BD,BF,C1,C4,C6,C8,CF,D2,D5,D8,DB") + "]\u309b)|([" + f("CF,D2,D5,D8,DB") + "]\u309c)", w = new RegExp(E, "g");
        return{L: function () {
            return M.tq
        }, X: function () {
            return 12
        }, W: function () {
            return{dA: a}
        }}
    });
    var Lf = function (a, b, d, e, g) {
        var f = hf ? "-moz-" : De ? "-ms-" : Ce ? "-o-" : jf ? "-webkit-" : "", k = ".gstl_" + e, l = new RegExp("(\\.(" + g[xd]("|") + ")\\b)"), n = [];
        return{addRule: function (a, e) {
            if (b) {
                if (d) {
                    for (var f = a[Yb](","), g = [], E = 0, w; w = f[E++];)w = l[zc](w) ? w[r](l, k + "$1") : k + " " + w, g[C](w);
                    a = g[xd](",")
                }
                n[C](a, "{", e, "}")
            }
        }, Gu: function () {
            if (b && n[F]) {
                b = !1;
                var d = Be("style");
                d[Eb]("type", "text/css");
                (a || se())[p](d);
                var e = n[xd]("");
                n = null;
                d[Cc] ? d[Cc].cssText = e : d[p](h[wb](e))
            }
        }, prefix: function (a, b) {
            var d = a + (b || "");
            f && (d += b ? a + f + b :
                f + a);
            return d
        }}
    };
    Ef[Ob](M.Sg, 10, function () {
        function a(a) {
            var b = 0;
            a && (k || d(), e(), a in l ? b = l[a] : (Me(k, ke(a)), l[a] = b = k[sb], Me(k, "")));
            return b
        }

        function b() {
            k || d();
            e();
            n || (Me(k, "|"), n = k[wc]);
            return n
        }

        function d() {
            k = Le(g.gk);
            Ya(k[u], "hidden");
            f[p](k)
        }

        function e() {
            var a = Yd();
            if (!s || s + 3E3 < a)s = a, a = Ze(k, "fontSize"), q && a == q || (l = {}, n = null, q = a)
        }

        var g, f, k, l, n, q, s;
        return{jb: function (a) {
            f = a.mo() || h[gd]
        }, ub: function (a) {
            g = a
        }, L: function () {
            return M.Sg
        }, X: function () {
            return 10
        }, W: function () {
            return{Ge: a, Bd: b}
        }}
    });
    var Mf = function (a) {
        var b;
        (function () {
            var d = function () {
            };
            a || (a = {});
            var e = function (b) {
                return a[b] || d
            };
            b = {kl: e("a"), search: e("b"), qf: e("c"), aj: e("d"), $i: e("e"), Ki: e("f"), Qk: e("g"), Rk: e("h"), Mk: e("i"), Gl: e("j"), Mi: e("k"), rl: e("l"), Pk: e("m"), Cq: e("n"), Vk: e("o"), Wk: e("p"), Zi: e("q"), ol: e("r"), Aq: e("s"), Bq: e("t"), Ok: e("u"), Xk: e("w"), Jk: e("x"), Nk: e("y"), Lk: e("z"), Kk: e("aa"), Sk: e("ab"), wl: e("ac")}
        })();
        return{kl: function () {
            return b.kl()
        }, search: function (a, e) {
            b[v](a, e)
        }, qf: function (a) {
            b.qf(a)
        }, aj: function (a) {
            b.aj(a)
        },
            $i: function (a) {
                return b.$i(a)
            }, Ki: function (a) {
                b.Ki(a)
            }, Qk: function (a) {
                b.Qk(a)
            }, Rk: function (a) {
                b.Rk(a)
            }, Mk: function (a) {
                b.Mk(a)
            }, Gl: function (a, e) {
                b.Gl(a, e)
            }, Mi: function (a, e) {
                b.Mi(a, e)
            }, rl: function () {
                b.rl()
            }, Pk: function (a) {
                b.Pk(a)
            }, Cq: function (a) {
                b.Cq(a)
            }, Vk: function () {
                b.Vk()
            }, Wk: function () {
                b.Wk()
            }, Zi: function (a) {
                b.Zi(a)
            }, ol: function (a, e) {
                b.ol(a, e)
            }, Aq: function (a) {
                b.Aq(a)
            }, Bq: function () {
                b.Bq()
            }, Ok: function () {
                b.Ok()
            }, Nk: function () {
                b.Nk()
            }, Xk: function (a) {
                b.Xk(a)
            }, Jk: function () {
                b.Jk()
            }, Lk: function () {
                b.Lk()
            },
            Kk: function () {
                b.Kk()
            }, Sk: function () {
                b.Sk()
            }, wl: function (a, e) {
                return b.wl(a, e)
            }}
    };
    Ef[Ob](M.gh, 6, function () {
        function a(a, b, d, e) {
            var f = a.wb(), k = a.Lb();
            N.Mo || g();
            b = s + x + y + "?" + (E ? E + "&" : "") + (b ? b + "&" : "");
            var n = he;
            a = [];
            n("q", k, a, !0);
            N.No || n("callback", "google.sbox.p" + q, a);
            if (w) {
                for (var k = "", L = 4 + na[mb](32 * na[kc]()), ha = 0, V; ha < L; ++ha)V = .3 > na[kc]() ? 48 + na[mb](10 * na[kc]()) : (.5 < na[kc]() ? 65 : 97) + na[mb](26 * na[kc]()), k += sa.fromCharCode(V);
                n("gs_gbg", k, a)
            }
            n = Be("script");
            n.src = b + a[xd]("&");
            n.charset = "utf-8";
            z[f] = n;
            J = N.Mo ? e : d;
            l[p](n);
            return!0
        }

        function b() {
            return 0
        }

        function d() {
            return 0
        }

        function e(a) {
            var b =
                z[a];
            b && (l[id](b), delete z[a])
        }

        function g() {
            for (var a in z)l[id](z[a]);
            z = {};
            J = null
        }

        function f(a) {
            J && J(a)
        }

        function k(a) {
            a || (a = ce);
            var b = window.google;
            N.No ? b.ac.h = a : b.sbox["p" + q] = a
        }

        var l = se(), n, q, s, x, y, E, w, N, z = {}, J, L = {ia: function (a) {
            n = a.get(M.ef, L);
            q = a.Th().wb()
        }, ea: function (a) {
            N = a;
            0 == a.pl && (a = n.Fv(), s = a[lc], x = a[Qb], y = a.ql, E = a.Gv, w = "https:" == h[bc][lc], k(f), (new Image).src = s + x + "/generate_204")
        }, L: function () {
            return M.gh
        }, X: function () {
            return 6
        }, W: function () {
            return{qu: a, pu: e, li: ce, Ap: b, To: d}
        }, Db: function () {
            k(null);
            g()
        }};
        return L
    });
    Ef[Ob](M.Sf, 1, function () {
        function a(a) {
            if (!l)return!0;
            for (var b = !1, d = !1, f = 0, k; f < a[F]; ++f)if (k = a[ub](f), !e[zc](k) && (g[zc](k) ? d = !0 : b = !0, d && b))return!0;
            return!1
        }

        function b(a, b, d) {
            if (!l)return!0;
            var g = f[zc](d), n = k[zc](b);
            return"ltr" == a ? g || n || e[zc](d) || e[zc](b) : !g || !n
        }

        function d(a) {
            var b = n;
            l && (g[zc](a) ? b = "ltr" : e[zc](a) || (b = "rtl"));
            return b
        }

        var e = RegExp("^[\x00- !-@[-`{-\u00bf\u00d7\u00f7\u02b9-\u02ff\u2000-\u2bff]*$"), g = RegExp("^[\x00- !-@[-`{-\u00bf\u00d7\u00f7\u02b9-\u02ff\u2000-\u2bff]*(?:\\d[\x00- !-@[-`{-\u00bf\u00d7\u00f7\u02b9-\u02ff\u2000-\u2bff]*$|[A-Za-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02b8\u0300-\u0590\u0800-\u1fff\u2c00-\ufb1c\ufdfe-\ufe6f\ufefd-\uffff])"),
            f = RegExp("^[\x00- !-@[-`{-\u00bf\u00d7\u00f7\u02b9-\u02ff\u2000-\u2bff]*(?:\\d|[A-Za-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02b8\u0300-\u0590\u0800-\u1fff\u2c00-\ufb1c\ufdfe-\ufe6f\ufefd-\uffff])"), k = RegExp("(?:\\d|[A-Za-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02b8\u0300-\u0590\u0800-\u1fff\u2c00-\ufb1c\ufdfe-\ufe6f\ufefd-\uffff])[\x00- !-@[-`{-\u00bf\u00d7\u00f7\u02b9-\u02ff\u2000-\u2bff]*$"), l = g[zc]("x"), n;
        return{jb: function (a) {
            n = a.Ke()
        }, L: function () {
            return M.Sf
        }, X: function () {
            return 1
        }, W: function () {
            return{xt: a,
                it: b, ek: d}
        }}
    });
    Ef[Ob](M.tb, 2, function () {
        function a(a, b, d, e, f) {
            var g = s(a);
            g || (g = {}, w[C]({element: a, hw: g}));
            var k = g[b];
            k || (k = g[b] = [], g = a.fw ? window : ff(a), g = q(b, g, k), Zd(b) ? a[Vc] ? a[Vc](b, g, !1) : a["on" + b] = g : a[b] = g);
            k[C]({jw: !!f, Ql: !1, Up: e || 0, mf: d});
            k[od](y);
            d.gw = b
        }

        function b(a, b) {
            var d = s(a);
            if (d && (d = d[b.gw]))for (var e = 0, f; f = d[e++];)if (f.mf == b) {
                f.Ql = !0;
                break
            }
        }

        function d(b, d, e, f) {
            a(N, b, d, e, f)
        }

        function e(a) {
            b(N, a)
        }

        function g(a, b) {
            var d = b || {}, e = N[a];
            e && e(d, d.eg)
        }

        function f(a, b, d) {
            a[Vc] ? a[Vc](b, d, !1) : a[Jb]("on" + b, d)
        }

        function k(a, b, d) {
            a.removeEventListener ? a.removeEventListener(b, d, !1) : a.detachEvent("on" + b, d)
        }

        function l(a) {
            if (E)z || (z = [], f(window, "message", n)), z[C](a), a = window[bc][mc], window.postMessage("sbox.df", /HTTPS?:\/\//i[zc](a) ? a : "*"); else window[Xb](a, 0)
        }

        function n(a) {
            z && a && a.source == window && "sbox.df" == a.data && z[F] && (z.shift()(), z && z[F] && window.postMessage("sbox.df", window[bc][mc]))
        }

        function q(a, b, d) {
            return function (e, f) {
                if (d[F]) {
                    var g;
                    if (!(g = e)) {
                        g = {};
                        var k = b[zd];
                        k && (k[Bb] && (g.keyCode = k[Bb]), g.iw = !0)
                    }
                    g.eg = f || a;
                    for (var k =
                        g, l, n, q = 0, s; s = d[q++];)s.Ql ? n = !0 : l || (s.jw ? x(s, k) : l = s.mf(k));
                    if (n)for (q = 0; s = d[q];)s.Ql ? d[wd](q, 1) : ++q;
                    if (g.Ti)return delete g.Ti, g.iw && (g = b[zd] || g), Ue(g), g.returnValue = !1
                }
            }
        }

        function s(a) {
            for (var b = 0, d; b < w[F]; ++b)if (d = w[b], d[H] == a)return d.hw;
            return null
        }

        function x(a, b) {
            l(function () {
                a.mf(b)
            })
        }

        function y(a, b) {
            return b.Up - a.Up
        }

        var E = window.postMessage && !(De || kf || Ce), w = [], N = {fw: 1}, z;
        return{L: function () {
            return M.tb
        }, X: function () {
            return 2
        }, W: function () {
            return{zb: a, nl: b, Tb: d, Oz: e, xb: g, dg: f, Nz: k, defer: l}
        },
            Db: function () {
                z = null
            }}
    });
    Ef[Ob](M.Xg, 495, function () {
        function a(a) {
            k[a.wb()] = !0
        }

        function b(a) {
            var b = a.hd();
            a = b.wb();
            a in k && (b = b.tl(), b = Yd() - b, n += b, ++l, delete k[a])
        }

        function d() {
            var a = 0, b;
            for (b in k)a++;
            return a
        }

        function e() {
            return l
        }

        function g() {
            return n
        }

        function f() {
            k = {};
            n = l = 0
        }

        var k, l, n;
        return{ea: function () {
            f()
        }, L: function () {
            return M.Xg
        }, X: function () {
            return 495
        }, W: function () {
            return{zu: a, jv: b, Su: d, Tu: e, Uu: g, reset: f}
        }}
    });
    Ef[Ob](M.zd, 375, function () {
        function a(a) {
            g[a] = !0;
            f = a
        }

        function b() {
            var a = [], b;
            for (b in g)a[C](qa(b, 10));
            return a
        }

        function d() {
            return f
        }

        function e() {
            g = {};
            f = null
        }

        var g, f;
        return{ea: function () {
            e()
        }, L: function () {
            return M.zd
        }, X: function () {
            return 375
        }, W: function () {
            return{add: a, dv: b, Xt: d, reset: e}
        }}
    });
    Ef[Ob](M.Dd, 9, function () {
        function a(a) {
            var b = s.Fc(), d;
            d = [];
            d[27] = 25;
            d[0] = e(z.rk);
            d[28] = e(z.sk);
            d[1] = void 0 == a ? "" : a + "";
            d[26] = x.dv()[xd]("j");
            a = "";
            E.fl() ? a = "o" : w.Fe() && (a = w.Rs() + "");
            d[2] = a;
            a = "";
            var k = w.Gb();
            if (k) {
                for (var A, X = 0, ha = 0, V; V = k[ha++];) {
                    var aa = V;
                    V = aa.L() + "";
                    aa = aa.of();
                    aa[F] && (V += "i" + aa[xd]("i"));
                    V != A && (1 < X && (a += "l" + X), a += (A ? "j" : "") + V, X = 0, A = V);
                    ++X
                }
                1 < X && (a += "l" + X)
            }
            d[3] = a;
            d[4] = g(s.gs());
            d[5] = g(s.hs());
            d[6] = J;
            d[7] = Yd() - L;
            d[18] = g(s.is());
            d[8] = q.Ht();
            if (A = q.Bt())d[25] = A.Kt ? "1" + (z.ft ? "a" : "") + (z.Qn ?
                "c" : "") : "", d[10] = A.Jt;
            d[11] = q.Zk();
            d[12] = q.Et();
            if (A = q.Dt())d[9] = A.Mt, d[22] = A.Lt, d[17] = A.Nt;
            d[13] = q.Gt();
            d[14] = q.Ft();
            d[15] = q.It();
            d[16] = q.Ct();
            d[30] = y.Su();
            d[31] = y.Tu();
            d[32] = y.Uu();
            d[19] = e(z.tk);
            A = (A = E.ud()) ? A.Ba().qb("e") ? "1" : "" : "";
            d[20] = A;
            for (A = 0; a = N[A++];)k = a.he(), l[k] && (d[k] = void 0 == d[k] ? e(a.bv()) : "");
            d = d[xd](".")[r](f, "");
            n && K ? (A = b + d, a = n.Yu(K), A = n.$u(A, a), A = A.slice(0, 8), A = n.Zu(A)) : A = "";
            return{oq: b, gs_l: d + "." + A}
        }

        function b() {
            L = Yd();
            ++J;
            s.Cd();
            x[qc]();
            q.Cd();
            for (var a = 0, b; b = N[a++];)b[qc]()
        }

        function d(a) {
            K =
                a
        }

        function e(a) {
            return a ? a[r](k, "-") : ""
        }

        function g(a) {
            return na.max(a - L, 0)
        }

        var f = /\.+$/, k = /\./g, l = Ud(yf), n, q, s, x, y, E, w, N, z, J = -1, L, K, A = {ia: function (a) {
            n = a.get(M.Fl, A);
            q = a.get(M.ic, A);
            s = a.get(M.Ua, A);
            x = a.get(M.zd, A);
            y = a.get(M.Xg, A);
            E = a.get(M.Ec, A);
            w = a.get(M.Ob, A);
            N = a.Cb(M.ui, A);
            df(a.Cb(M[Oc], A))
        }, ub: function (a) {
            K = a.gt
        }, ea: function (a) {
            z = a;
            b()
        }, L: function () {
            return M.Dd
        }, X: function () {
            return 9
        }, W: function () {
            return{Ba: a, reset: b, Ot: d}
        }};
        return A
    });
    Ef[Ob](M.xd, 11, function () {
        function a(a, b) {
            if (E) {
                for (var d = !1, e = 0, g; g = E[e++];)2 == g.Tf(a, b) && (d = !0);
                if (d)return
            }
            if (je(a) || A.ce || n && n.ce())te(b) ? K && !L && (L = Qe(K, "btnI", "1")) : L && (K[id](L), L = null), k(b), J[v](a, b), f(), q.xb(14, {Zh: a})
        }

        function b(a) {
            k();
            J.qf(a);
            f()
        }

        function d(a) {
            k();
            J.aj(a);
            f()
        }

        function e(a) {
            k(1);
            J.Zi(a);
            f()
        }

        function g(a) {
            return J.$i(a)
        }

        function f() {
            s.Nj();
            s.Vt();
            y[qc]();
            N ? N[Gb]() : w[Gb]();
            x.Fc() != x.fb() && x.Qs();
            z && z[Gb]()
        }

        function k(a) {
            l && A.wt && l.ni(a)
        }

        var l, n, q, s, x, y, E, w, N, z, J, L, K, A, D = {jb: function (a) {
            K =
                a.mo()
        }, ia: function (a) {
            l = a.get(M.Ni, D);
            n = a.get(M.Ce, D);
            q = a.get(M.tb, D);
            s = a.get(M.ic, D);
            x = a.get(M.Ua, D);
            y = a.get(M.Dd, D);
            w = a.get(M.Ob, D);
            N = a.get(M.Bo, D);
            z = a.get(M.Qf, D);
            J = a.Ae();
            E = a.Cb(M.Ao, D)
        }, ea: function (a) {
            A = a
        }, L: function () {
            return M.xd
        }, X: function () {
            return 11
        }, W: function () {
            return{search: a, qf: b, aj: d, Zi: e, $i: g}
        }};
        return D
    });
    Ef[Ob](M.Te, 14, function () {
        function a(a) {
            return(a[g.pj] || {}).j
        }

        function b(a) {
            return a[g.Sp]
        }

        function d(a, b) {
            var d = a[g.Sp], s = a[g.$v];
            b || (b = Gf(d, ie(d[F])));
            var N = {}, z = a[g.pj];
            if (z)for (var J in z) {
                var L = z[J];
                J in q && (L = q[J][ad](L));
                N[J] = L
            }
            var z = b, K = !1, A = !1;
            J = !1;
            for (var L = 0, D; D = s[L++];)if (33 == (D[f.Tp] || 0) ? A = !0 : K = !0, A && K) {
                J = !0;
                break
            }
            K = 0;
            A = [];
            for (L = 0; D = s[L++];) {
                var Y = D[f.Tp] || 0;
                if (k[Y] && (!J || 33 != Y)) {
                    var ba;
                    ba = D[f.Zv];
                    n && (ba = l.bold(d[yd](), ne(le(ba))));
                    A[C](Jf(ba, ne(le(ba)), K++, Y, D[f.Yv] || [], e(D)))
                }
            }
            return If(z,
                A, Kf(N), !1, !0, !1)
        }

        function e(a) {
            return(a = a[f.pj]) ? Kf(a) : Hf
        }

        var g = xf, f = qf, k, l, n, q = {}, s = {ia: function (a) {
            l = a.get(M.fj, s);
            if (a = a.Cb(M.vl, s))for (var b = 0, d; d = a[b++];)q[d.Lz()] = d
        }, ea: function (a) {
            k = a.Yf;
            n = a.Ck
        }, L: function () {
            return M.Te
        }, X: function () {
            return 14
        }, W: function () {
            return{ou: a, Mz: b, xk: d}
        }};
        return s
    });
    Ef[Ob](M.yi, 15, function () {
        function a(a) {
            var d = b(a);
            if (d) {
                if (k)for (var g = 0, s; s = k[g++];)a = s.kv(a);
                l.lv(a);
                g = a;
                s = g.hd().Lb();
                var N = g.Gb();
                if (n[jc]())if (N[F]) {
                    var z = !1 == g.L();
                    n.Vj(s, N, z) && f.jv(g)
                } else n[Gb]();
                e.xb(3, {input: s, Ps: N})
            }
            q.Gl(a, d);
            return d
        }

        function b(a) {
            var b = g.fb(), d = l.ud(), b = b[yd](), e = a.Lb()[yd]();
            b == e ? d = !0 : (b = fe(b), a = (e = a.hd()) ? e.me() : fe(a.Lb()[yd]()), d = d ? d.hd().me() : "", d = 0 == b[Qc](a) ? 0 == b[Qc](d) ? a[F] >= d[F] : !0 : !1);
            return d
        }

        function d(a, b) {
            return a.mb() - b.mb()
        }

        var e, g, f, k, l, n, q, s = {ia: function (a) {
            e =
                a.get(M.tb, s);
            g = a.get(M.Ua, s);
            f = a.get(M.Xg, s);
            k = a.Cb(M.wi, s);
            l = a.get(M.Ec, s);
            n = a.get(M.Ob, s);
            q = a.Ae();
            k[od](d)
        }, L: function () {
            return M.yi
        }, X: function () {
            return 15
        }, W: function () {
            return{mf: a, mi: b}
        }};
        return s
    });
    Ef[Ob](M.ic, 13, function () {
        function a(a, b) {
            if (!(!Ka || Pa || ha && ha.Yy())) {
                a.Wi("ds", db.qn);
                a.Wi("pq", ob);
                a.lu();
                var d = !0, e = a.Po();
                e > ca && (ca = e);
                ++O;
                la.zu(a);
                var e = Yd(), f;
                for (f in $a) {
                    var g = $a[f].tl();
                    2500 < e - g && D(f)
                }
                Ga && (f = X.get(a)) && ((d = ga || a.nu()) && db.Ns && a.mu(), ja.mf(f), f.ml() && ++ma, Z = null);
                d && (Z = a, S && !b || A())
            }
        }

        function b() {
            return 10 <= pb || 3 <= V.To() ? !0 : !1
        }

        function d() {
            La = ca
        }

        function e() {
            return ca <= La
        }

        function g() {
            Z = null
        }

        function f() {
            return O
        }

        function k() {
            return{Kt: Ga, Jt: Ga ? X.iu() : 0}
        }

        function l() {
            return Ga ?
                X.Zk() : 0
        }

        function n() {
            return ma
        }

        function q() {
            return{Mt: qb, Lt: eb, Nt: zb}
        }

        function s() {
            return Ub
        }

        function x() {
            return rb
        }

        function y(a) {
            a = Ba.xk(a);
            return ja.mi(a)
        }

        function E() {
            return gb
        }

        function w() {
            for (var a = [], b = 0, d, e = 0; e <= T; ++e)d = jb[e], 0 == d ? b++ : (b = 1 == b ? "0j" : 1 < b ? e + "-" : "", a[C](b + d), b = 0);
            return a[xd]("j")
        }

        function N() {
            Ga && X.gu()
        }

        function z(a) {
            Ga && X.hu(a)
        }

        function J() {
            Ga && X.Cd();
            gb = rb = Ub = zb = eb = qb = ma = pb = O = 0;
            jb = [];
            for (var a = 0; a <= T; ++a)jb[a] = 0
        }

        function L(a) {
            ob = a
        }

        function K(a) {
            return function (b) {
                Y(b, a)
            }
        }

        function A() {
            re(S);
            S = null;
            if (!(2 < V.To()) && Z) {
                var a = [], b = Z.Ba();
                if (b)for (var d in b)he(d, b[d], a);
                R.rl();
                a = V.qu(Z, a[xd]("&"), K(Z), Y);
                Z.Ro() || (++qb, a ? (a = Z, $a[a.wb()] = a, ++pb) : ++eb);
                Z = null;
                a = 100;
                b = (pb - 2) / 2;
                for (d = 1; d++ <= b;)a *= 2;
                a < Ha && (a = Ha);
                S = window[Xb](A, a)
            }
        }

        function D(a) {
            V.pu(a);
            delete $a[a];
            pb && --pb
        }

        function Y(a, b) {
            if (Ka) {
                if (!b) {
                    var d = Ba.ou(a);
                    b = $a[d];
                    if (!b)return
                }
                if (!b.Ro()) {
                    d = Ba.xk(a, b);
                    if (Sa)var e = aa.fb(), d = Sa.$y(d, e);
                    Ga && X.put(d);
                    b.Po() <= La || (++zb, ja.mf(d) || ++Ub, e = b, Ha = d.Ba().Do("d"), e && (D(e.wb()), e = e.tl(), e = Yd() -
                        e, gb += e, rb = na.max(e, rb), ++jb[e > ka ? T : ba[na[mb](e / 100)]]));
                    d && (d = d.Ba().qb("q")) && xa.Ot(d)
                }
            }
        }

        var ba = [0, 1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8], T = ba[ba[F] - 1] + 1, ka = 100 * ba[F] - 1, X, ha, V, aa, xa, la, Ba, ja, Sa, Ca, R, Ka = !1, Z, ca = -1, $a, O, pb, ma, qb, eb, zb, Ub, rb, gb, jb, Ha, S, ga, Pa, La, Ga, db, ob, Ta = {ia: function (a) {
            X = a.get(M.Bi, Ta);
            ha = a.get(M.Ce, Ta);
            a.get(M.tb, Ta);
            aa = a.get(M.Ua, Ta);
            xa = a.get(M.Dd, Ta);
            la = a.get(M.Xg, Ta);
            Ba = a.get(M.Te, Ta);
            ja = a.get(M.yi, Ta);
            Sa = a.get(M.Nu, Ta);
            a.get(M.Ec, Ta);
            Ca = a.get(M.ef, Ta);
            a.get(M.Ob, Ta);
            R = a.Ae()
        },
            ea: function (a) {
                V = Ca.ku();
                db = a;
                Ka = !0;
                $a = {};
                Ha = 0;
                ga = a.Ms;
                Pa = a.pi;
                La = -1;
                Ga = db.Ls && !!X;
                ob = a.Os
            }, L: function () {
                return M.ic
            }, X: function () {
                return 13
            }, W: function () {
                return{Um: a, fl: b, Nj: d, vn: e, Vt: g, Ht: f, Bt: k, Zk: l, Et: n, Dt: q, Gt: s, Ft: x, mi: y, It: E, Ct: w, li: N, Zy: z, Cd: J, wn: L}
            }, Db: function () {
                Ka = !1;
                re(S);
                $a = Z = S = null;
                d()
            }};
        return Ta
    });
    Ef[Ob](M.Ec, 5, function () {
        function a() {
            return g.fl()
        }

        function b(a) {
            f = a
        }

        function d() {
            return f
        }

        function e() {
            f = null
        }

        var g, f, k = {ia: function (a) {
            g = a.get(M.ic, k)
        }, ea: function () {
            f = null
        }, L: function () {
            return M.Ec
        }, X: function () {
            return 5
        }, W: function () {
            return{fl: a, lv: b, ud: d, cA: e}
        }};
        return k
    });
    Ef[Ob](M.ef, 16, function () {
        function a() {
            return g
        }

        function b() {
            return f
        }

        function d() {
            g && g.li()
        }

        var e = {}, g, f, k = {ia: function (a) {
            a = a.Cb(M.gh, k);
            for (var b = 0, d; d = a[b++];)e[d.Ap()] = d
        }, ea: function (a) {
            var b = "https:" == h[bc][lc], d = he, k = [];
            d("client", a.rk, k);
            d("hl", a.He, k);
            d("gl", a.su, k);
            d("sugexp", a.tk, k);
            d("gs_rn", 25, k);
            d("gs_ri", a.sk, k);
            a.Uo && d("authuser", a.Uo, k);
            f = {protocol: "http" + (b ? "s" : "") + "://", host: a.ru || "clients1." + a.Go, ql: a.ql || "/complete/search", Gv: k[F] ? k[xd]("&") : ""};
            g && g.Ap() == a.pl || (g = e[a.pl])
        },
            L: function () {
                return M.ef
            }, X: function () {
                return 16
            }, W: function (e) {
                return{ku: e == M.ic ? a : ce, Fv: b, Kz: d}
            }};
        return k
    });
    Ef[Ob](M.Ad, 7, function () {
        function a(a) {
            n.ti(a)
        }

        function b() {
            return q
        }

        function d(a) {
            if (a in s) {
                if (x) {
                    if (a == x.Bk())return;
                    f();
                    x.On()
                }
                x = s[a];
                n.si(x)
            }
        }

        function e() {
            return q ? n.Bd() : 0
        }

        function g() {
            q || (n.show(k()), q = !0)
        }

        function f() {
            q && (n.Rg(), q = !1)
        }

        function k() {
            var a = xe(l);
            x.Nn(a);
            return a
        }

        var l = {cv: !1, uk: "left", Oo: !0, Re: null, marginWidth: 0}, n, q, s = {}, x, y = {ia: function (a) {
            n = a.get(M.Yg, y);
            if (a = a.Cb(M.fi, y))for (var b = 0, d; d = a[b++];)s[d.Bk()] = d
        }, ea: function () {
            q = !1
        }, L: function () {
            return M.Ad
        }, X: function () {
            return 7
        },
            W: function () {
                return{Lf: b, si: d, Bd: e, show: g, Rg: f, ti: a}
            }, Db: function () {
                f()
            }};
        return y
    });
    Ef[Ob](M.Ua, 3, function () {
        function a() {
            var a = {};
            Ga.xb(13, a);
            !a.cancel && Vb.Lj && Ga.defer(ia.Pj);
            Wb.Nk()
        }

        function b() {
            Ga.xb(12);
            Wb.Ok()
        }

        function d() {
            eb("rtl")
        }

        function e() {
            eb("ltr")
        }

        function g() {
            ia.Lr()
        }

        function f(a) {
            ia.vd() ? ia.Kr() : ia.Ph(a)
        }

        function k() {
            if (0 == Vb.bi)return!1;
            if (4 == Vb.bi)return Wb.Sk(), !1;
            var a = zb();
            if (a)switch (Vb.bi) {
                case 1:
                    if (Ub(a, !0))return ob.add(S.fg), !0;
                    break;
                case 3:
                    return ia.Mf(a)
            }
            return!1
        }

        function l() {
            Vb.Ir ? $a(5) : (ia.Lf() ? ia.Pj() : N(), Y())
        }

        function n(a) {
            Wa && a.jo() == Wa[F] && (Ec &&
                Ec[Gb](), Vb.Hr && $a(2), Wb.Mk(Wa))
        }

        function q(a) {
            Pa && 0 == a.ei() && Pa.tt()
        }

        function s(a, b, d, e) {
            Vb.Fr && !a && ia.Qm(!0);
            Vb.Er && !ia.Lf() && "mousedown" == d && ia.Ph(b);
            var f;
            ae && ae.Ks(a, b, d) ? f = ae : ae = f = Gf(a, b, d);
            var g = b = !1;
            if (a != Wa || "onremovechip" == d)pe(d, "key") ? ob.add(S.qt) : "paste" == d && ob.add(S.rt), b = !0, jb(a), Ga.xb(1, {eg: d, Re: Gc}), Wb.Ki(a), g = Yd(), Ve || (Ve = g), rf = g, je(a) && (e = !0), g = !0;
            a = Ha.DONT_CARE;
            var k = f.Ym(), l = vb.ud();
            if (Kb)for (var n = 0, q; q = Kb[n++];)q = q.Tf(k, l), q > a && (a = q);
            switch (a) {
                case Ha.ot:
                    e = !0;
                    break;
                case Ha.no:
                    e = !1
            }
            e ? (b && ia.Mr(), We && f.setParameter("gs_is", 1), Wb.Pk(We), db.Um(f), ae = null) : g && (ia[Gb](), db.Nj());
            Ga.xb(2, {eg: d})
        }

        function x(a) {
            (We = a) && ob.add(S.pt)
        }

        function y(a) {
            sf != a && ((sf = a) ? Wb.Lk() : Wb.Kk())
        }

        function E(a) {
            rb(a)
        }

        function w() {
            ga[Ab]()
        }

        function N() {
            ga.blur()
        }

        function z() {
            return ga.Rh()
        }

        function J(a, b, d) {
            pe(a, Wa, !0) && (a = Wa + a[Rb](Wa[F]));
            d = d || ie(a[F]);
            s(a, d, "", b);
            rb(a, !0)
        }

        function L(a) {
            J(a, !0);
            tf = Yd();
            ob.add(S.st)
        }

        function K() {
            s(Wa, V(), "onremovechip")
        }

        function A(a) {
            jb(a);
            ga[Ib]();
            Ga.xb(4, {Re: Gc, input: a})
        }

        function D() {
            ga[Db]()
        }

        function Y() {
            Wa != Hc && jb(Hc);
            Ga.xb(5, {input: Hc, Ps: ia.Gb(), Re: Gc});
            ga[Ib]();
            Wb.Rk(Hc)
        }

        function ba() {
            Hc = Wa
        }

        function T() {
            return ga.jn()
        }

        function ka() {
            return Hc
        }

        function X() {
            return Wa
        }

        function ha() {
            return Gc
        }

        function V() {
            return ga.Of()
        }

        function aa() {
            return ga.$j()
        }

        function xa() {
            return ga.Bd()
        }

        function la() {
            return ga.Ge()
        }

        function Ba() {
            return ga.kn()
        }

        function ja() {
            return Ve
        }

        function Sa() {
            return rf
        }

        function Ca() {
            return tf
        }

        function R() {
            return 0 != sg
        }

        function Ka() {
            if ($d) {
                if (Vb.Tj)return!0;
                for (var a = 0, b; b = Fc[a++];)if (b[jc]())return!0
            }
            return!1
        }

        function Z(a) {
            if (a == Wa)return!0;
            var b = Wa[F];
            return a[Rb](0, b) == Wa ? La.it(Gc, Wa, a[Rb](b)) : !1
        }

        function ca() {
            ga.Wj()
        }

        function $a(a) {
            Ta[v](Wa, a)
        }

        function O(a) {
            Wa && (jb(""), ga[Gb](), Ga.xb(1), ia[Gb](), Wb.Ki(Wa));
            a && Wb.Jk()
        }

        function pb() {
            tf = rf = Ve = 0
        }

        function ma(a) {
            ga.oi(a)
        }

        function qb() {
            var a = zb();
            a && Ub(a)
        }

        function eb(a) {
            var b = V().ei();
            Gc == a ? ia.vd() && b == Wa[F] && (ia.Fe() ? Vb.Oj && (a = ia.Ee(), Ta[v](a.rb(), 6)) : Vb.Gr && k()) : Pa && 0 == b && Pa.tt()
        }

        function zb() {
            if (ia.vd()) {
                var a =
                    ia.Fe() ? ia.Ee() : ia.Mj();
                if (a.ii())return a
            }
            return null
        }

        function Ub(a, b) {
            var d = a.rb();
            return qe(Hc, d) ? !1 : (ba(), b ? J(d, !0) : A(d), !0)
        }

        function rb(a, b) {
            Wa = a || "";
            gb();
            ga[Ib]();
            b || (Ga.xb(4, {Re: Gc, input: Wa}), Wb.Qk(Wa))
        }

        function gb() {
            var a = La.ek(Wa);
            a != Gc && (ga.Zj(a), Gc = a)
        }

        function jb(a) {
            Wa = Hc = a || "";
            gb()
        }

        var Ha = wf, S = vf, ga, Pa, La, Ga, db, ob, Ta, Kb, vb, ia, Ec, $d, Fc, Wb, Hc, Wa, Gc, sg, Ve, rf, tf, We, sf, ae, Vb, Lb = {ia: function (a) {
            ga = a.get(M.Ie, Lb);
            Pa = a.get(M.Ce, Lb);
            La = a.get(M.Sf, Lb);
            Ga = a.get(M.tb, Lb);
            db = a.get(M.ic, Lb);
            ob = a.get(M.zd,
                Lb);
            Ta = a.get(M.xd, Lb);
            Kb = a.Cb(M.Yc, Lb);
            vb = a.get(M.Ec, Lb);
            ia = a.get(M.Ob, Lb);
            Ec = a.get(M.Qf, Lb);
            $d = a.get(M.Me, Lb);
            Fc = a.Cb(M.Se, Lb);
            Wb = a.Ae();
            sg = a.Th().Qj()
        }, ub: function (a) {
            Vb = a;
            Kb[od](ve);
            Wa = Hc = ga.Qr() || ""
        }, ea: function (a) {
            Vb = a;
            sf = We = !1;
            gb()
        }, L: function () {
            return M.Ua
        }, X: function () {
            return 3
        }, W: function () {
            return{ln: a, Vr: b, Xr: d, Yr: e, Zr: g, Tr: f, Mf: k, Ur: l, Sr: n, Rr: q, Wr: s, bs: x, mn: y, $h: E, ds: w, nk: N, Vn: z, bn: J, Ly: L, My: K, Uc: A, $m: D, Jr: Y, Qs: ba, jn: T, Fc: ka, fb: X, ek: ha, Of: V, $j: aa, Bd: xa, Ge: la, kn: Ba, gs: ja, hs: Sa, is: Ca, $r: R,
                lk: Ka, Ny: Z, Wj: ca, search: $a, clear: O, Cd: pb, oi: ma, Zm: qb}
        }};
        return Lb
    });
    Ef[Ob](M.Ob, 17, function () {
        function a(a) {
            a.Re = Kb;
            a.marginWidth = Ta;
            var b = vb.Xm;
            b || (b = "rtl" == Kb ? "right" : "left");
            a.uk = b
        }

        function b(a, b, e) {
            var f = !1;
            a = rb && rb.Sy(b);
            Y();
            (Ha = b) && b[F] && (f = b[0].rb(), $a.xt(f) && (f = ma.Fc()), Kb = $a.ek(f), e ? (Pa = Z.zt, f = ca.vs(b, Kb), b = b[0].Ba().qb("a"), b = le(b), Ta = qb.Ge(b)) : (Pa = Z.wo, f = ca.la(ja(), Kb), Ta = 0), a && (ga = rb.Ry(), d(rb.Py())), f ? A() : Y());
            return f
        }

        function d(a) {
            Ka();
            if (S != a) {
                var b = S;
                S = a;
                R(b)
            }
        }

        function e() {
            if (J())if (La) {
                var a = S;
                S == Ha[F] - 1 ? ga = S = null : null == S ? S = 0 : ++S;
                ga = S;
                Ca(a, e)
            } else A()
        }

        function g() {
            if (J())if (La) {
                var a = S;
                Ha && 0 != S ? null == S ? S = Ha[F] - 1 : --S : ga = S = null;
                ga = S;
                Ca(a, g)
            } else A()
        }

        function f(a) {
            var b = a ? 4 : 3;
            if (L())a = N(), ca.ci(a) || ma[v](b), b = ma.Fc(), jb.Mi(b, a); else ma[v](b)
        }

        function k(a) {
            return ca.Mf(a)
        }

        function l(a) {
            ga = S = a;
            a = Ha[a];
            var b = ma.Fc();
            jb.Mi(b, a)
        }

        function n() {
            return La
        }

        function q() {
            return Ga
        }

        function s(a) {
            Ga && !a && Y();
            Ga = a
        }

        function x() {
            return Pa
        }

        function y() {
            return Ha
        }

        function E() {
            return J() ? Ha[0] : null
        }

        function w() {
            return S
        }

        function N() {
            return L() ? Ha[ga] : null
        }

        function z() {
            return ga
        }

        function J() {
            return!(!Ha || !Ha[F])
        }

        function L() {
            return null != ga
        }

        function K() {
            La && !db && (db = window[Xb](Y, vb.Pr))
        }

        function A() {
            La || (O.si(17), O.show(), La = !0, jb.Vk())
        }

        function D() {
            La && (db && (re(db), db = null), O.Rg(), La = !1, jb.Wk())
        }

        function Y() {
            D();
            Ha = null;
            Pa = Z.EMPTY;
            null != S && ca.Ai(S);
            ga = S = null;
            ca[Gb]()
        }

        function ba() {
            pb.Nj();
            D()
        }

        function T() {
            null != S && ca.Ai(S);
            ga = S = null
        }

        function ka() {
            Ka();
            ob = window[Xb](T, 0)
        }

        function X() {
            Ka()
        }

        function ha(a) {
            if (J())A(); else {
                var b = ma.Fc();
                if (b) {
                    a = a || ma.Of();
                    b = Gf(b, a);
                    if (zb) {
                        a =
                            b.Ym();
                        for (var d = Ub.ud(), e = 0, f; f = zb[e++];)f.Tf(a, d)
                    }
                    pb.Um(b)
                }
            }
        }

        function V() {
            return ca.Qa()
        }

        function aa() {
            return ca.gi()
        }

        function xa() {
            La = !1
        }

        function la() {
            ca.bg()
        }

        function Ba() {
            return 17
        }

        function ja() {
            if (J() && Pa == Z.wo) {
                for (var a = [], b = [], d = 0, e; (e = eb[d++]) && !e.so(ma.Fc(), Ha, b););
                (d = b ? b[F] : 0) && (d -= Sa(b, a, 0));
                for (e = 0; e < Ha[F]; ++e)a[C](Ha[e]);
                d && (d -= Sa(b, a, 1));
                vb.Or && a[C](1);
                d && Sa(b, a, 2);
                vb.Wm && a[C](2);
                gb && gb.yt(a);
                return a
            }
            return null
        }

        function Sa(a, b, d) {
            for (var e = 0, f = 0, g; f < a[F]; ++f)(g = a[f]) && g.position ==
                d && (b[C](g), ++e);
            return e
        }

        function Ca(a, b) {
            if (null == S || ca.ff(S))if (R(a), null == S)ma.Jr(); else {
                var d = ca.zi(Ha[S]);
                ma.$h(d);
                jb.Xk(d)
            } else ca.Ai(a), b()
        }

        function R(a) {
            Ka();
            null != a && ca.Ai(a);
            null != S && ca.us(S)
        }

        function Ka() {
            ob && (re(ob), ob = null)
        }

        var Z = uf, ca, $a, O, pb, ma, qb, eb, zb, Ub, rb, gb, jb, Ha, S, ga, Pa, La, Ga, db, ob, Ta, Kb, vb, ia = {ia: function (a) {
            ca = a.get(M.$f, ia);
            $a = a.get(M.Sf, ia);
            O = a.get(M.Ad, ia);
            pb = a.get(M.ic, ia);
            ma = a.get(M.Ua, ia);
            qb = a.get(M.Sg, ia);
            eb = a.Cb(M.ge, ia);
            zb = a.Cb(M.Yc, ia);
            Ub = a.get(M.Ec, ia);
            rb = a.get(M.At,
                ia);
            gb = a.get(M.il, ia);
            jb = a.Ae()
        }, ub: function () {
            zb[od](ve);
            eb[od](we)
        }, ea: function (a) {
            vb = a;
            ga = S = null;
            Pa = Z.EMPTY;
            La = !1;
            Ga = !0;
            Kb = "";
            Ta = 0
        }, L: function () {
            return M.Ob
        }, X: function () {
            return 17
        }, W: function () {
            return{Vj: b, ys: d, Kr: e, Lr: g, ci: f, Mf: k, ts: l, Lf: n, isEnabled: q, Qm: s, Nr: x, Gb: y, Mj: E, Qy: w, Ee: N, Rs: z, vd: J, Fe: L, Mr: K, show: A, Rg: D, clear: Y, Pj: ba, ws: T, xs: ka, Oy: X, Ph: ha}
        }, cg: function () {
            var b = {Nn: a, Qa: V, gi: aa, On: xa, bg: la, Bk: Ba};
            return[
                {jb: ce, ia: ce, ub: ce, ea: ce, L: function () {
                    return M.fi
                }, X: function () {
                    return 17
                }, W: function () {
                    return b
                },
                    cg: ce, Db: ce}
            ]
        }, Db: function () {
            db && (re(db), db = null);
            Ha = null;
            D()
        }};
        return ia
    });
    Ef[Ob](M.Yg, 8, function () {
        function a(a) {
            a != D && (D = a, a = a.Qa(), Y ? a != Y && K[Ac](a, Y) : K[p](a), Y = a)
        }

        function b() {
            A || (A = K ? na.max(K[wc], 0) : 0);
            return A
        }

        function d(a) {
            m(K, a.cv ? "gssb_e gsdd_a" : "gssb_e");
            var b = a.Re || ha;
            N != b && (N = b, Pe(w, b));
            b = a.marginWidth;
            if (L != b) {
                var d = J[u];
                b ? (z[hc]() || z[p](J), wa(d, b + "px"), hf && (d.paddingLeft = "1px")) : (z[hc]() && z[id](J), d.paddingLeft = "");
                L = b
            }
            aa = a.Oo;
            xa = a.uk;
            n(ba, !0);
            n(X, !0);
            x.xb(16);
            g()
        }

        function e() {
            A = 0;
            n(ba, !1);
            n(X, !1);
            var a = ha;
            N != a && (N = a, Pe(w, a));
            x.xb(11)
        }

        function g() {
            A = 0;
            k();
            if (X) {
                var a =
                    y.ut[0], d = X[u];
                "relative" != y.Tg && (d.top = w[u].top, Ra(d, w.offsetLeft + z[sb] + "px"));
                a = b() + a;
                Ia(X[u], na.max(a, 0) + "px");
                l(X, K[sb])
            }
            D && D.bg()
        }

        function f(a) {
            if (T)ka != a && T[Ac](a, ka); else {
                var b = w[Rc](-1);
                Ia(b[u], "0");
                b[$c](-1);
                T = b[$c](-1);
                q.Lf() || (n(K, !1), n(w, !0), g());
                ba = K;
                T[p](a)
            }
            ka = a
        }

        function k() {
            var a, b, d;
            a = (b = D && D.gi()) ? b[sb] : s.Ge();
            (d = V) ? Zd(d) && (d = null) : L || !aa ? (wa(K[u], ""), wa(w[u], "")) : (wa(K[u], "100%"), d = a + y.gf[2], l(w, d));
            if ("relative" != y.Tg) {
                var e = s.$j();
                b && (e.pe = Ge(b).pe);
                b = y.gf;
                var f = b[1];
                b = b[0];
                b =
                    e.Hl + s.Bd() + b;
                "right" == xa ? (d = ff(w), a = af(d) - (e.pe - f + a), d = void 0) : (e = e.pe + f, "center" == xa && d && (e += (a - d) / 2), d = e, a = void 0);
                f = {pe: 0, Hl: 0};
                "absolute" == y.Tg && y.Zg && y.Zg != h[gd] && (f = Ge(y.Zg));
                e = w[u];
                e.top = b - f.Hl + "px";
                Ra(e, e.right = "");
                void 0 != d ? Ra(e, d - f.pe + "px") : e.right = a + f.pe + "px"
            }
            ze && (e.zoom = "normal", e.zoom = 1)
        }

        function l(a, b) {
            be(b) ? 0 < b && wa(a[u], b + "px") : wa(a[u], b)
        }

        function n(a, b) {
            a && Fa(a[u], b ? "" : "none")
        }

        var q, s, x, y, E, w, N, z, J, L, K, A, D, Y, ba, T, ka, X, ha, V, aa = !0, xa, la = {jb: function (a, b) {
            ha = a.Ke();
            b[B](".gssb_c", "border:0;position:absolute;z-index:989");
            b[B](".gssb_e", "border:1px solid #ccc;border-top-color:#d9d9d9;" + b.prefix("box-shadow:0 2px 4px rgba(0,0,0,0.2);") + "cursor:default");
            b[B](".gssb_f", "visibility:hidden;white-space:nowrap");
            b[B](".gssb_k", "border:0;display:block;position:absolute;top:0;z-index:988");
            b[B](".gsdd_a", "border:none!important")
        }, ia: function (a) {
            q = a.get(M.Ad, la);
            s = a.get(M.Ua, la);
            x = a.get(M.tb, la);
            E = a.Th().wb()
        }, ub: function (a) {
            y = a;
            w = Je();
            m(w, "gstl_" + E + " gssb_c");
            n(w, !1);
            ba = w;
            var b = w[Rc](-1);
            z = b[$c](-1);
            m(z, "gssb_f");
            J = Ke();
            K =
                b[$c](-1);
            m(K, "gssb_e");
            wa(K[u], "100%");
            y.vt && (X = Be("iframe", "gstl_" + E + " gssb_k"), n(X, !1), (y.Zg || h[gd])[p](X));
            if (V = y.Pn)be(V) && (V += y.gf[2]), l(w, V);
            k();
            (a.Zg || h[gd])[p](w);
            x.Tb(8, g)
        }, ea: function (a) {
            y = a;
            w[u].position = a.Tg
        }, L: function () {
            return M.Yg
        }, X: function () {
            return 8
        }, W: function () {
            return{si: a, Bd: b, ti: f, show: d, Rg: e, bg: g}
        }};
        return la
    });
    Ef[Ob](M.Ie, 4, function () {
        function a(a, b) {
            zb && (zb = !1, Z.nl(O, X), Z.nl(O, ha));
            b || (b = a);
            O[ud][Ac](a, O);
            b[p](O);
            eb && qb.qs && (De || hf ? Z.defer(function () {
                O[Ab]();
                Ee(O, gb.ei())
            }) : O[Ab]());
            V()
        }

        function b() {
            return Pa
        }

        function d(a) {
            var b = "rtl" == a == ("rtl" == Kb);
            O.dir = a;
            if (La) {
                ca.Zj(a);
                var d = S[ud];
                d[id](La);
                b ? Xe(La, S) : d[xb](La, S)
            }
            Pa && (Pa.dir = a, d = Pa[ud], d[id](Pa), b ? d[xb](Pa, S) : Xe(Pa, S));
            0 != pb && (a = Oe(a), Ne(O, a, 0))
        }

        function e() {
            return gb
        }

        function g() {
            return Ge(ga)
        }

        function f() {
            var a = ga ? ga[wc] : 0;
            ia > a && (a = ia);
            return a
        }

        function k() {
            return Ec ? Ec : ga ? ga[sb] : 0
        }

        function l() {
            var a = O[sb];
            qb.Vm && (a -= O[wc]);
            return a
        }

        function n() {
            return O[Pc]
        }

        function q(a) {
            (qb.en ? O : S || $d || O)[u].background = a || "transparent"
        }

        function s() {
            Ha = !0
        }

        function x() {
            O[Db]();
            ja()
        }

        function y() {
            lf && Qa(O, "");
            Qa(O, R.fb());
            lf && Qa(O, O[Pc]);
            L()
        }

        function E() {
            if (!eb)try {
                O[Ab](), eb = !0, L()
            } catch (a) {
            }
        }

        function w() {
            eb && (O.blur(), eb = !1)
        }

        function N() {
            return eb
        }

        function z() {
            Qa(O, "")
        }

        function J() {
            var b = vb.get("gs_id");
            if (b)Pa = vb.get("gs_ttc"), S = vb.get("gs_tti"), R.lk() &&
                ca && (Ga = ca.Qa(), La = Ga[ud]); else {
                b = Je();
                b.id = vb.wb("gs_id");
                m(b, "gstl_" + ma + " " + (qb.Uj || O[cd]));
                var d = b[Rc](-1), e = b[u], f = O[u];
                wa(e, Ec ? Ec + "px" : f[lb]);
                Ia(e, ia ? ia + "px" : f[uc]);
                ya(e, "0");
                bf(O);
                m(O, qb.gk);
                Ta && (Pa = d[$c](-1), Pa.id = vb.wb("gs_ttc"), Pa[u].whiteSpace = "nowrap");
                S = d[$c](-1);
                S.id = vb.wb("gs_tti");
                m(S, "gsib_a");
                R.lk() && ca && (Ga = ca.Qa(), La = d[$c](-1), m(La, "gsib_b"), La[p](Ga));
                a(b, S)
            }
            mf && jf && (Ia(O[u], "1.25em"), O[u].marginTop = "-0.0625em");
            K(b);
            ga = b
        }

        function L() {
            if (eb) {
                var a = O[Pc][F];
                gb = ie(a);
                Ee(O, a)
            }
        }

        function K(a) {
            Z.zb(a,
                "mouseup", function () {
                    O[Ab]()
                })
        }

        function A() {
            Z.zb(O, "keydown", Y);
            (Ce || qb.js) && Z.zb(O, "keypress", T);
            Z.zb(O, "select", ja, 10);
            var a = !1, b = function (b) {
                Z.zb(O, b, ka, 10, a)
            };
            b("mousedown");
            b("keyup");
            b("keypress");
            a = !0;
            b("mouseup");
            b("keydown");
            b("focus");
            b("blur");
            b("cut");
            b("paste");
            b("input");
            Z.zb(O, "compositionstart", D);
            Z.zb(O, "compositionend", D)
        }

        function D(a) {
            a = a[Wc];
            "compositionstart" == a ? R.mn(!0) : "compositionend" == a && R.mn(!1)
        }

        function Y(a) {
            var b = a[Bb];
            jb = b;
            var d = (jf || hf) && Ie(b) && Ka.vd(), e = b == Ca.Ho, f = b ==
                Ca.Ri;
            db = !1;
            b == Ca.fg && (db = R.Mf());
            e && ((b = Ka.Ee()) && ba(b) ? Ka.ci(a[td]) : Z.defer(function () {
                Ka.ci(a[td])
            }));
            if (d || e || f || db)a.Ti = !0
        }

        function ba(a) {
            return(a = $a[a.L()].Ty) && a()
        }

        function T(a) {
            var b = a[Bb], d = b == Ca.Ri, e = b == Ca.fg && db;
            if (b == Ca.Ho || d || e)a.Ti = !0
        }

        function ka(a) {
            if (!ob) {
                var b = a.eg;
                if (!(b[Qc]("key") || a.ctrlKey || a.altKey || a[td] || a.metaKey))t:if (a = a[Bb], "keypress" != b) {
                    var d = Ie(a), e;
                    if ("keydown" == b) {
                        if (R.bs(229 == a), d)break t
                    } else if (e = a != jb, jb = -1, !d || e)break t;
                    switch (a) {
                        case Ca.Ri:
                            R.Ur();
                            break;
                        case Ca.cu:
                            R.Xr();
                            break;
                        case Ca.du:
                            R.Yr();
                            break;
                        case Ca.zo:
                            R.Zr();
                            break;
                        case Ca.yo:
                            R.Tr(gb);
                            break;
                        case Ca.fu:
                            R.Sr(gb);
                            break;
                        case Ca.eu:
                            R.Rr(gb)
                    }
                }
                ja();
                R.Wr(O[Pc], gb, b)
            }
        }

        function X() {
            eb = !0;
            R.Vr()
        }

        function ha() {
            eb = !1;
            R.ln()
        }

        function V() {
            zb || (zb = !0, Z.zb(O, "focus", X, 99), Z.zb(O, "blur", ha, 99))
        }

        function aa() {
            rb || (rb = window.setInterval(la, qb.ps || 50))
        }

        function xa() {
            rb && (re(rb), rb = null)
        }

        function la() {
            ka({eg: "polling"})
        }

        function Ba() {
            hf && Se(O)
        }

        function ja() {
            if (eb) {
                var a = Fe(O);
                a && (gb = a)
            }
        }

        function Sa() {
            var a;
            Z.dg(window, "pagehide",
                function () {
                    ob = !0;
                    a = O[Pc]
                });
            Z.dg(window, "pageshow", function (b) {
                ob = !1;
                b.persisted && R.Uc(a)
            })
        }

        var Ca = Df, R, Ka, Z, ca, $a, O, pb, ma, qb, eb, zb = !1, Ub, rb, gb = ie(0), jb = -1, Ha = !1, S, ga, Pa, La, Ga, db, ob, Ta, Kb, vb, ia, Ec, $d, Fc = {jb: function (a, b) {
            vb = a;
            O = a.hk();
            Kb = a.Ke();
            a.Yh() || (b[B](".gsib_a", "width:100%;padding:4px 6px 0"), b[B](".gsib_a,.gsib_b", "vertical-align:top"))
        }, ia: function (a) {
            R = a.get(M.Ua, Fc);
            Z = a.get(M.tb, Fc);
            Ka = a.get(M.Ob, Fc);
            ca = a.get(M.Me, Fc);
            $a = df(a.Cb(M[Oc], Fc));
            a = a.Th();
            pb = a.Qj();
            ma = a.wb()
        }, ub: function (a) {
            qb =
                a;
            ia = a.dn;
            Ec = a.ns;
            eb = He(O);
            ja();
            De && Z.zb(O, "beforedeactivate", function (a) {
                Ha && (Ha = !1, a.Ti = !0)
            }, 10);
            hf && Sa();
            ga = O;
            Ta = !!a.Le[M.Ce];
            (R.$r() || R.lk() || Ta || a.ls) && J();
            a.ks && (Z.zb(O, "blur", xa, 10), Z.zb(O, "focus", aa, 10), Ub = !0);
            Z.Tb(8, Ba);
            A();
            V()
        }, ea: function (a) {
            qb = a;
            var b = a.ms;
            b && ($d = vb.Uh(b));
            O[Eb]("autocomplete", "off");
            O[Eb]("spellcheck", a.spellcheck);
            O[u].outline = a.os ? "" : "none";
            Ub && aa()
        }, L: function () {
            return M.Ie
        }, X: function () {
            return 4
        }, W: function () {
            return{Uy: a, jn: b, Zj: d, Of: e, $j: g, Bd: f, Ge: k, kn: l, Qr: n, oi: q,
                Wj: s, select: x, refresh: y, focus: E, blur: w, Rh: N, clear: z}
        }, Db: function () {
            Ub && xa();
            qb.Lj && Z.nl(O, R.ln)
        }};
        return Fc
    });
    Ef[Ob](M.$f, 18, function () {
        function a(a, b) {
            if (!ja)return!1;
            la = b;
            J();
            for (var d = !1, e = 0, f; f = a[e++];)y(f) && (d = !0);
            return d
        }

        function b(a) {
            var b = D[a.L()];
            return b && b.xu ? b.xu(a) : !1
        }

        function d(a) {
            return D[a.L()].ih(null, a, Y)
        }

        function e(a) {
            var b = D[a.L()];
            if (b && b.zi) {
                var d = A.Fc();
                return b.zi(a, d)
            }
            return a.rb()
        }

        function g(a, b) {
            if (!ja)return!1;
            la = b;
            J();
            for (var d = !1, e = 0, f; f = a[e++];)if (1 == f)if (Ca)Sa[p](Ca); else {
                f = w();
                var g = f[u];
                g.textAlign = "center";
                g.whiteSpace = "nowrap";
                f.dir = Ba;
                g = Ke();
                g[u].position = "relative";
                R = Ke();
                m(R, "gssb_g");
                T.Wm && (R[u].paddingBottom = "1px");
                E(T.Is, R, 13);
                T.Es ? E(T.Ak, R, 8) : T.Fs && E(T.Js, R, 14);
                g[p](R);
                f[p](g);
                Ca = f[ud]
            } else if (2 == f)if (Ka)Sa[p](Ka); else f = w(), g = f[u], ya(g, "1px 4px 2px 0"), g.fontSize = "11px", g.textAlign = "right", g = Be("a"), g.id = "gssb_b", Ea(g, "http://www.google.com/support/websearch/bin/answer.py?hl=" + T.He + "&answer=106230"), Oa(g, T.Hs), f[p](g), Ka = f[ud]; else if (3 == f)if (f = V.pop())Sa[p](f); else f = ja[Rc](-1), f.yu = !0, f = f[$c](-1), g = Be("div", "gssb_l"), f[p](g); else y(f) && (d = !0);
            return d
        }

        function f(a) {
            N(a, Z);
            var b = L.Gb();
            b && K.xb(9, {index: a, Wy: b[a], Xy: aa[a]})
        }

        function k(a) {
            N(a, "");
            K.xb(10)
        }

        function l() {
            for (var a, b, d; d = X.pop();)a = d.L(), (b = ka[a]) || (b = ka[a] = []), b[C](d), a = d.Qa(), a[ud][id](a);
            for (; a = Sa[Cb];)a = Sa[id](a), a.yu ? V[C](a) : a != Ca && a != Ka && ha[C](a);
            aa = []
        }

        function n(a) {
            return(a = aa[a]) ? a.ff() : !1
        }

        function q() {
            J()
        }

        function s() {
            return ja
        }

        function x() {
            return T.gn || Ba == la ? xa : null
        }

        function y(a) {
            var b = a.L(), d = D[b];
            if (!d)return!1;
            var e = (b = ka[b]) && b.pop();
            e || (e = d.hh(Y));
            d.la(a, e);
            X[C](e);
            var f =
                e.Qa(), b = w();
            m(b, "gssb_a " + T.Xn);
            b[p](f);
            if (void 0 !== a.he) {
                aa[C](e);
                var e = la, g = a.he();
                T.Gs && (f.onmouseover = function () {
                    L.ys(g)
                }, f.onmouseout = function () {
                    L.xs()
                });
                fb(f, function (b) {
                    A.nk();
                    a.ii() && A.$h(a.rb());
                    L.ws();
                    L.ts(g);
                    b = b || ff(f)[zd];
                    d.Hd(b, a, Y)
                })
            } else e = Ba;
            Pe(b, e);
            return!0
        }

        function E(a, b, d) {
            var e = Be("input");
            Ua(e, "button");
            Qa(e, le(a));
            fb(e, function () {
                Y[v](A.fb(), d)
            });
            var f;
            if (T.Ds) {
                a = "lsb";
                f = Be("span");
                var g = Be("span");
                m(f, "ds");
                m(g, "lsbb");
                f[p](g);
                g[p](e)
            } else a = "gssb_h", f = e;
            m(e, a);
            b[p](f)
        }

        function w() {
            var a =
                ha.pop();
            if (a)return Sa[p](a), a[Cb];
            a = ja[Rc](-1);
            a = a[$c](-1);
            m(a, T.Xn);
            a.onmousedown = z;
            return a
        }

        function N(a, b) {
            var d = aa[a];
            d && d.ff() && m(d.Qa()[ud][ud], b)
        }

        function z(a) {
            a = a || ff(ja)[zd];
            a[Zb] ? a[Zb]() : Ce || De && A.Wj();
            return!1
        }

        function J() {
            if (R) {
                var a = T.Wn ? T.Wn : A.Ge() - 3;
                0 < a && wa(R[u], a + "px")
            }
        }

        var L, K, A, D, Y, ba, T, ka = {}, X = [], ha = [], V = [], aa = [], xa, la, Ba, ja, Sa, Ca, R, Ka, Z, ca = {jb: function (a, b) {
            ba = a;
            Ba = a.Ke();
            b[B](".gssb_a", "padding:0 7px");
            b[B](".gssb_a,.gssb_a td", "white-space:nowrap;overflow:hidden;line-height:22px");
            b[B]("#gssb_b", "font-size:11px;color:#36c;text-decoration:none");
            b[B]("#gssb_b:hover", "font-size:11px;color:#36c;text-decoration:underline");
            b[B](".gssb_g", "text-align:center;padding:8px 0 7px;position:relative");
            b[B](".gssb_h", "font-size:15px;height:28px;margin:0.2em" + (jf ? ";-webkit-appearance:button" : ""));
            b[B](".gssb_i", "background:#eee");
            b[B](".gss_ifl", "visibility:hidden;padding-left:5px");
            b[B](".gssb_i .gss_ifl", "visibility:visible");
            b[B]("a.gssb_j", "font-size:13px;color:#36c;text-decoration:none;line-height:100%");
            b[B]("a.gssb_j:hover", "text-decoration:underline");
            b[B](".gssb_l", "height:1px;background-color:#e5e5e5");
            b[B](".gssb_m", "color:#000;background:#fff")
        }, ia: function (a) {
            L = a.get(M.Ob, ca);
            K = a.get(M.tb, ca);
            A = a.get(M.Ua, ca);
            Y = a.get(M.xd, ca);
            D = df(a.Cb(M[Oc], ca))
        }, ub: function (a) {
            T = a;
            ja = Je();
            a = Be("tbody");
            ja[p](a);
            Sa = ja[Pb]("tbody")[0]
        }, ea: function (a) {
            T = a;
            var b = a.hn;
            b && (xa = ba.Uh(b));
            m(ja, a.pn || "gssb_m");
            Z = a.on || "gssb_i"
        }, L: function () {
            return M.$f
        }, X: function () {
            return 18
        }, W: function () {
            return{vs: a, zi: e, ci: d, Mf: b,
                la: g, us: f, Ai: k, clear: l, ff: n, bg: q, Qa: s, gi: x}
        }};
        return ca
    });
    Ef[Ob](M.Ni, 346, function () {
        function a(a) {
            a = d.Ba(a);
            for (var f in k)f in a || (a[f] = k[f]);
            b(e + ee(a))
        }

        function b(a) {
            var b = new Image, d = f;
            b.onerror = va(b, b.onabort = function () {
                try {
                    delete g[d]
                } catch (a) {
                }
            });
            g[f] = b;
            b.src = a;
            f++
        }

        var d, e, g = [], f = 0, k, l = {ia: function (a) {
            d = a.get(M.Dd, l)
        }, ea: function (a) {
            e = "//" + (a.wu || "www." + a.Go) + "/gen_204?";
            k = a.vo || {}
        }, L: function () {
            return M.Ni
        }, X: function () {
            return 346
        }, W: function () {
            return{ni: a}
        }};
        return l
    });
    Ef[Ob](M.Bi, 21, function () {
        function a(a) {
            l(a);
            var b = a.hd();
            if ((!b || !b.op()) && x)for (b = 0; b < x[F]; ++b)x[b].update(a)
        }

        function b(a) {
            var b = s[a.np()] || null;
            if (b)++y; else if (x && !a.op())for (var d = 0; d < x[F]; ++d)if (b = x[d].get(a)) {
                l(b);
                ++E;
                break
            }
            return b ? If(a, b.Gb(), b.Ba(), b.ml(), b.cj(), b.Ev()) : null
        }

        function d() {
            return y
        }

        function e() {
            return E
        }

        function g() {
            E = y = 0
        }

        function f(a) {
            var b, d, e, f;
            for (f in s)for (b = s[f], b = b.Gb(), e = 0; d = b[e++];)if (d.L() == a) {
                delete s[f];
                break
            }
            n()
        }

        function k() {
            s = {};
            n()
        }

        function l(a) {
            a && a.cj() &&
            (s[a.hd().np()] = a)
        }

        function n() {
            if (x)for (var a = 0; a < x[F]; ++a)x[a][qc]()
        }

        function q(a, b) {
            return b.mb() - a.mb()
        }

        var s = {}, x, y, E, w = {ia: function (a) {
            x = a.Cb(M.cf, w);
            x[od](q)
        }, ea: function () {
            g()
        }, L: function () {
            return M.Bi
        }, X: function () {
            return 21
        }, W: function () {
            return{put: a, get: b, iu: d, Zk: e, Cd: g, hu: f, gu: k}
        }};
        return w
    });
    Ef[Ob](M.Gd, 190, function () {
        function a() {
            s && n.Ml(l)
        }

        function b() {
            s && n.lj(l)
        }

        function d() {
            s && q.Ml(l)
        }

        function e() {
            s && q.lj(l)
        }

        var g, f, k, l, n, q, s = !1, x = {jb: function (a, b) {
            k = a;
            var d = function (a) {
                return"box-shadow:" + a + "-moz-box-shadow:" + a + "-webkit-box-shadow:" + a
            };
            b[B](".gsfe_a", "border:1px solid #b9b9b9;border-top-color:#a0a0a0;" + d("inset 0px 1px 2px rgba(0,0,0,0.1);"));
            b[B](".gsfe_b", "border:1px solid #4d90fe;outline:none;" + d("inset 0px 1px 2px rgba(0,0,0,0.3);"))
        }, ia: function (a) {
            g = a.get(M.tb, x);
            f = a.get(M.Ua,
                x)
        }, ub: function (f) {
            var s = f.$k;
            if (l = s ? k.Uh(s) : null)g.Tb(12, d), g.Tb(13, e), g.zb(l, "mouseover", a), g.zb(l, "mouseout", b), n = Nf(f.cl || "gsfe_a"), q = Nf(f.bl || "gsfe_b")
        }, ea: function () {
            s = !0;
            l && f.Vn() && q.Ml(l)
        }, L: function () {
            return M.Gd
        }, X: function () {
            return 190
        }, Db: function () {
            s = !1;
            l && (n.lj(l), q.lj(l))
        }};
        return x
    });
    var Nf = function (a) {
        var b = new RegExp("(?:^|\\s+)" + a + "(?:$|\\s+)");
        return{Ml: function (d) {
            d && !b[zc](d[cd]) && m(d, d[cd] + (" " + a))
        }, lj: function (a) {
            a && m(a, a[cd][r](b, " "))
        }}
    };
    var Of = function () {
        function a(a) {
            if ("keyup" == a.gj()) {
                var b = Yd();
                if (n) {
                    var d = b - n;
                    e += d;
                    g += d * d
                }
                a = a.Lb()[F];
                a < l && ++f;
                ++k;
                l = a;
                n = b
            }
        }

        function b() {
            return[e, g, k, f]
        }

        function d() {
            n = l = k = f = g = e = 0
        }

        var e, g, f, k, l, n;
        return{L: function () {
            return M.Gd
        }, X: function () {
            return 325
        }, W: function () {
            return{ow: a, sl: b, Cd: d}
        }}
    };
    var Pf = function () {
        function a() {
            return 23
        }

        function b() {
            return f.sl()[xd]("j")[r](e, "j")[r](g, "")
        }

        function d() {
            f.Cd()
        }

        var e = /j0/g, g = /j+$/, f, k = {ia: function (a) {
            f = a.Lo(325, k)
        }, L: function () {
            return M.ui
        }, X: function () {
            return 337
        }, W: function () {
            return{he: a, bv: b, reset: d}
        }};
        return k
    };
    var Qf = function () {
        function a(a) {
            d.ow(a);
            return 1
        }

        function b() {
            return 17
        }

        var d, e = {ia: function (a) {
            d = a.Lo(325, e)
        }, L: function () {
            return M.Yc
        }, X: function () {
            return 331
        }, W: function () {
            return{Tf: a, mb: b}
        }};
        return e
    };
    var Rf = function () {
        function a(a) {
            return E && y == a.Lb() ? If(a, E, Hf, !0, !1, !1) : null
        }

        function b(a) {
            return!!a && 0 <= a[Qc]("**")
        }

        function d() {
            return J
        }

        function e() {
            J = ""
        }

        function g() {
            var a = !w || !q.fb();
            a != N && (N ? z[rc]("x-webkit-speech") : z[Eb]("x-webkit-speech", ""), N = a)
        }

        function f(a, b) {
            b = ke(b);
            a = ke(fe(a, !0));
            for (var d = a[Yb](" "), e = b[Yb](" "), f, g = 0; g < e[F]; ++g)f = e[g], 0 > d[Qc](f) && (e[g] = f.bold());
            return e[xd](" ")[r](l, " ")
        }

        function k(a) {
            a = a && a.Kv ? a.Kv : [];
            var d = na.min(a[F], 3);
            y = a[0].Lv;
            s.add(6);
            if (b(y)) {
                E = [];
                for (var e =
                    0; e < d; ++e) {
                    var g = a[e].Lv;
                    b(g) || E[C](Jf(f(y, g), g, e, 40, null))
                }
            } else E = null, J = y, x[v](y, 15)
        }

        var l = /<\/b> <b>/gi, n, q, s, x, y, E, w, N, z, J = "", L = {jb: function (a) {
            z = a.hk()
        }, ia: function (a) {
            n = a.get(M.tb, L);
            q = a.get(M.Ua, L);
            s = a.get(M.zd, L);
            x = a.get(M.xd, L)
        }, ub: function (a) {
            w = a.bu;
            g();
            z[Eb]("x-webkit-grammar", "builtin:search");
            "" != a.He && z[Eb]("lang", a.He);
            n.dg(z, "webkitspeechchange", k);
            w && (n.Tb(4, g), n.Tb(5, g), n.Tb(1, g))
        }, L: function () {
            return M.Pg
        }, X: function () {
            return 90
        }, W: function () {
            return{Av: e, Bv: d, Hv: a, co: b}
        }};
        return L
    };
    var Tf = function () {
        function a(a) {
            return Sf(g, a)
        }

        function b(a, b) {
            b.la(a.mh(), a.rb(), f)
        }

        function d(a, b, d) {
            d[v](b.rb(), 1)
        }

        function e() {
            return 40
        }

        var g, f, k = {jb: function (a, b) {
            b[B](".gsq_a", "padding:0")
        }, ia: function (a) {
            g = a.get(M.Ua, k)
        }, ea: function (a) {
            f = a.fk ? a.Ak : ""
        }, L: function () {
            return M[Oc]
        }, X: function () {
            return 30
        }, W: function () {
            return{hh: a, la: b, Hd: d, ih: ce, nh: e}
        }};
        return k
    };
    var Sf = function (a, b) {
        var d, e, g, f, k;
        (function () {
            d = Ke();
            m(d, "gsq_a");
            var a = Je();
            d[p](a);
            e = a[Rc](-1);
            a = e[$c](-1);
            wa(a[u], "100%");
            g = Be("span");
            a[p](g)
        })();
        return{Qa: function () {
            return d
        }, L: function () {
            return 40
        }, ff: function () {
            return!0
        }, la: function (d, n, q) {
            Oa(g, d);
            k = n;
            q && !f && (f = Ye(e), fb(f, function (d) {
                a.nk();
                a.$h(k);
                b[v](k, 9);
                return Ue(d)
            }));
            q ? (Oa(f, q + " &raquo;"), Fa(f[u], "")) : f && Fa(f[u], "none")
        }}
    };
    var Uf = function () {
        function a(a) {
            var b = a.gj();
            return d && "input" == b && d.Bv() == a.Lb() ? (d.Av(), 3) : 1
        }

        function b() {
            return 22
        }

        var d, e = {ia: function (a) {
            d = a.get(M.Pg, e)
        }, L: function () {
            return M.Yc
        }, X: function () {
            return 465
        }, W: function () {
            return{Tf: a, mb: b}
        }};
        return e
    };
    var Vf = function () {
        function a() {
            return 1
        }

        function b(a) {
            var b = null;
            d && (b = d.Hv(a));
            return b
        }

        var d, e = {L: function () {
            return M.cf
        }, ia: function (a) {
            d = a.get(M.Pg, e)
        }, X: function () {
            return 100
        }, W: function () {
            return{mb: a, update: ce, get: b, reset: ce}
        }};
        return e
    };
    var Wf = function (a) {
        function b() {
            g.Vn() || g.fb() ? d() : a && !f && (g.oi(a), f = !0)
        }

        function d() {
            if (f || void 0 == f)g.oi("#fff"), f = !1
        }

        var e, g, f, k, l = {jb: function (a) {
            k = a.hk()
        }, ia: function (a) {
            e = a.get(M.tb, l);
            g = a.get(M.Ua, l)
        }, ub: function () {
            e.zb(k, "focus", d);
            e.zb(k, "blur", b);
            e.Tb(4, b);
            e.Tb(5, b)
        }, ea: function () {
            b()
        }, L: function () {
            return M.Gd
        }, X: function () {
            return 166
        }, Db: function () {
            d()
        }};
        return l
    };
    var Xf = function (a) {
        function b(b) {
            var d = e.DONT_CARE;
            if (g) {
                var l = b.gj();
                "focus" == l || "blur" == l || "mousedown" == l ? d = e.no : (b.Wi("partnerid", a), b.setParameter("types", "t"))
            }
            return d
        }

        function d() {
            return 10
        }

        var e = wf, g;
        return{ea: function (a) {
            g = !!a.Le[66]
        }, L: function () {
            return M.Yc
        }, X: function () {
            return 66
        }, W: function () {
            return{Tf: b, mb: d}
        }}
    };
    var Zf = function (a) {
        function b() {
            return Yf(a, g)
        }

        function d(a, b) {
            b.la(a)
        }

        function e() {
            return 505
        }

        var g;
        return{jb: function (a) {
            g = a.Ke()
        }, L: function () {
            return M[Oc]
        }, X: function () {
            return 182
        }, W: function () {
            return{hh: b, la: d, Hd: ce, ih: ce, nh: e}
        }}
    }, Yf = function (a, b) {
        var d, e = {L: function () {
            return 505
        }, Qa: function () {
            return d
        }, la: ce};
        (function () {
            d = Ke();
            var e = d[u];
            e.backgroundImage = "url(" + a + ")";
            e.backgroundRepeat = "no-repeat";
            Ia(e, "18px");
            e.marginBottom = "2px";
            e.backgroundPosition = "bottom " + ("ltr" == b ? "right" : "left")
        })();
        return e
    };
    Ef[Ob](M.ge, 181, function () {
        function a() {
            return 5
        }

        function b(a, b, g) {
            g[C]({L: function () {
                return 505
            }, position: 1})
        }

        return{L: function () {
            return M.ge
        }, X: function () {
            return 181
        }, W: function () {
            return{mb: a, so: b}
        }}
    });
    var ag = function (a, b) {
        function d() {
            E = null;
            s && Oa(s.Qa(), "")
        }

        function e(a, b) {
            var d = J[F];
            switch (a[Bb]) {
                case K.yo:
                    var e = k(b);
                    if (0 > e)break;
                    Te(a);
                    J[(e + 1) % d][Ab]();
                    break;
                case K.zo:
                    e = k(b);
                    if (0 > e)break;
                    Te(a);
                    J[(e - 1 + d) % d][Ab]();
                    break;
                case K.Ri:
                    z = !1;
                    q[Ab]();
                    break;
                case K.fg:
                    if (Te(a), z = !1, a[td])q[Ab](); else q.Jl(), L && L[Ab]()
            }
        }

        function g() {
            window[Xb](function () {
                z && 0 > k(h.activeElement) && (z = !1, q.Rh() || q.Jl())
            }, 10)
        }

        function f() {
            var a = s.Qa();
            if (a[Sc])return a[Sc]("cse-sayt-accessibility");
            for (var a = a[Pb]("a"), b = /\bcse-sayt-accessibility\b/,
                     d = [], e = 0; e < a[F]; e++)b[zc](a[e][cd]) && d[C](a[e]);
            return d
        }

        function k(a) {
            for (var b = 0; b < J[F]; b++)if (J[b] == a)return b;
            return-1
        }

        function l(a, b, d, e) {
            b = null;
            a && (b = a[0], w.put(e ? d + e : d, b));
            d != x || e && e != y || (E = b, n())
        }

        function n() {
            s && E ? Oa(s.Qa(), E) : d();
            b && b()
        }

        var q, s, x, y, E, w, N, z = !1, J, L, K = Df, A = {ia: function (a) {
            q = a
        }, Iv: function (a) {
            s = a;
            n()
        }, pp: function () {
            var b;
            t:{
                if (q) {
                    b = null;
                    if (q.Fe())b = q.Ee(); else if (q.vd()) {
                        var e = q.ud();
                        e && (b = Wd(e).Gb()[0])
                    }
                    if (b) {
                        b = b.rb();
                        break t
                    }
                }
                b = null
            }
            e = N && N.restrictBy ? N.restrictBy : "";
            if (x !=
                b || e != y)if (x = b, y = e, b) {
                var f = w.get(e ? b + e : b);
                f ? b != x || e && e != y || (E = f, n()) : (d(), a(b, l, A))
            } else d()
        }, jl: d, qv: function () {
            var a = f();
            J = [];
            for (var b = 0; b < a[F]; b++) {
                var d = a[b];
                d[Vc] ? (J[C](d), d[Vc]("keydown", function (a) {
                    e(a, a[Nc] ? a[Nc] : this)
                }, !0), d[Vc]("blur", function () {
                    g()
                }, !0)) : d[Jb] && (J[C](d), d[Jb]("onkeydown", function (a) {
                    e(a, a[Nc] ? a[Nc] : this)
                }), d[Jb]("onblur", function () {
                    g()
                }))
            }
            J[F] && (z = !0, window[Xb](function () {
                L = h.activeElement;
                J[0][Ab]()
            }, 10))
        }, ov: function () {
            window[Xb](function () {
                z || q.Jl()
            }, 20)
        }, pv: function (a) {
            N =
                a
        }};
        w = $f(36E5);
        return A
    };
    var cg = function (a) {
        function b() {
            return bg(g)
        }

        function d(b, d) {
            a.Iv(d)
        }

        function e() {
            return 503
        }

        var g, f = {ia: function (a) {
            g = a.get(M.Ob, f)
        }, L: function () {
            return M[Oc]
        }, X: function () {
            return 68
        }, W: function () {
            return{hh: b, la: d, Hd: ce, ih: ce, nh: e}
        }};
        return f
    }, bg = function () {
        var a, b = {L: function () {
            return 503
        }, Qa: function () {
            return a
        }, la: ce};
        a = Ke("cse-sayt-container");
        return b
    };
    Ef[Ob](M.ge, 67, function () {
        function a() {
            return 4
        }

        function b(a, b, g) {
            g[C]({L: function () {
                return 503
            }, position: 1})
        }

        return{L: function () {
            return M.ge
        }, X: function () {
            return 67
        }, W: function () {
            return{mb: a, so: b}
        }}
    });
    var dg = function (a, b) {
        function d() {
            return 2
        }

        function e(d) {
            for (var e = [], k = [], l = d.Gb(), n = !1, q = 0, s; s = l[q++];)34 == s.L() ? k[F] < b && (k[C](s), s.Ba().qb("c") && (n = !0)) : e[F] < a && e[C](ue(s, e[F]));
            for (q = 0; l = k[q++];) {
                s = l.Ba();
                var x = {};
                x.a = s.qb("a");
                x.b = s.qb("b");
                x.c = s.qb("c");
                x.d = s.qb("d");
                x.e = n;
                e[C](Jf("", "", e[F], l.L(), l.of(), Kf(x)))
            }
            return If(d.hd(), e, d.Ba(), d.ml(), d.cj(), !0)
        }

        return{L: function () {
            return M.wi
        }, X: function () {
            return 171
        }, W: function () {
            return{mb: d, kv: e}
        }}
    };
    Ef[Ob](M.cf, 98, function () {
        function a() {
            return 3
        }

        function b(a) {
            if (g) {
                var b = a.hd(), d = a.Gb();
                if (d[F]) {
                    var e = b.me();
                    t:for (var b = Number.MAX_VALUE, l, n = 0; l = d[n++];) {
                        if (!f[l.L()]) {
                            b = -1;
                            break t
                        }
                        l = l.rb();
                        b = na.min(l[F], b)
                    }
                    if (-1 != b) {
                        var q = d[0].rb();
                        if (pe(q, e, !0))for (n = e[F] + 1; n <= b;) {
                            e = null;
                            for (l = 0; q = d[l++];) {
                                q = q.rb();
                                if (n > q[F])return;
                                q = q[Rb](0, n);
                                if (!e)e = q; else if (e != q)return
                            }
                            k[e] = a;
                            ++n
                        }
                    }
                }
            }
        }

        function d(a) {
            if (g) {
                var b = k[a.me()];
                if (b) {
                    var d = a.lp(), e = a.me();
                    b.hd().me();
                    for (var f = b.Ba(), q = n || !f.Do("k"), z = [], J, L, K =
                        b.Gb(), A = 0, D; D = K[A++];)L = D.rb(), J = q ? l.bold(d, L) : ke(L), z[C](Jf(J, L, D.he(), D.L(), D.of(), D.Ba()));
                    delete k[e];
                    return If(a, z, f, !0, b.cj(), !1)
                }
            }
            return null
        }

        function e() {
            k = {}
        }

        var g = !0, f, k = {}, l, n, q = {ia: function (a) {
            l = a.get(M.fj, q)
        }, ub: function () {
            f = Ud([0])
        }, ea: function (a) {
            n = a.Ck;
            g = a.Qn
        }, L: function () {
            return M.cf
        }, X: function () {
            return 98
        }, W: function () {
            return{mb: a, update: b, get: d, reset: e}
        }, Db: function () {
            g = !1
        }};
        return q
    });
    Ef[Ob](M[Oc], 169, function () {
        function a() {
            return eg()
        }

        function b(a, b) {
            var d = a.Ba();
            b.la(d.qb("a"), d.qb("c"), d.qb("d"), d.dw("e"))
        }

        function d(a, b) {
            return b
        }

        function e(a, b, d) {
            a = b.Ba().qb("b");
            (pe(a, "http://") || pe(a, "https://")) && d.qf(a)
        }

        function g(a, b, d) {
            a = b.Ba().qb("b");
            (pe(a, "http://") || pe(a, "https://")) && d.qf(a);
            return!0
        }

        function f() {
            return 34
        }

        return{jb: function (a, b) {
            b[B](".gscsep_a", "display:none")
        }, L: function () {
            return M[Oc]
        }, X: function () {
            return 169
        }, W: function () {
            return{hh: a, la: b, zi: d, Hd: e, ih: g, nh: f}
        }}
    });
    var eg = function () {
        var a, b, d, e, g;
        (function () {
            a = Ke();
            var f = Je();
            m(f, "gsc-completion-promotion-table");
            a[p](f);
            var k = f[Rc](-1), f = function () {
                var a = k[$c](-1);
                a[Eb]("valign", "top");
                return a
            };
            d = f();
            e = Be("img");
            m(e, "gsc-completion-icon");
            b = Ke();
            m(b, "gsc-completion-title");
            g = Ke();
            m(g, "gsc-completion-snippet");
            f = f();
            f[p](b);
            f[p](g)
        })();
        return{Qa: function () {
            return a
        }, L: function () {
            return 34
        }, ff: function () {
            return!0
        }, la: function (a, k, l, n) {
            k && (pe(k, "http://") || pe(k, "https://") || pe(k, "//")) ? (e.src = k, d[hc]() || d[p](e)) :
                d[hc]() && d[id](e);
            m(d, n ? "gsc-completion-icon-cell" : "gscsep_a");
            Oa(b, a);
            Oa(g, l)
        }}
    };
    Ef[Ob](M[Oc], 20, function () {
        function a(a) {
            return fg(g, a)
        }

        function b(a, b) {
            b.la(a.mh(), a.rb(), f)
        }

        function d(a, b, d) {
            d[v](b.rb(), 1)
        }

        function e() {
            return 0
        }

        var g, f, k = {jb: function (a, b) {
            b[B](".gsq_a", "padding:0")
        }, ia: function (a) {
            g = a.get(M.Ua, k)
        }, ea: function (a) {
            f = a.fk ? a.Ak : ""
        }, L: function () {
            return M[Oc]
        }, X: function () {
            return 20
        }, W: function () {
            return{hh: a, la: b, Hd: d, ih: ce, nh: e}
        }};
        return k
    });
    var fg = function (a, b) {
        var d, e, g, f, k;
        (function () {
            d = Ke();
            m(d, "gsq_a");
            var a = Je();
            d[p](a);
            e = a[Rc](-1);
            a = e[$c](-1);
            wa(a[u], "100%");
            g = Be("span");
            a[p](g)
        })();
        return{Qa: function () {
            return d
        }, L: function () {
            return 0
        }, ff: function () {
            return!0
        }, la: function (d, n, q) {
            Oa(g, d);
            k = n;
            q && !f && (f = Ye(e), fb(f, function (d) {
                a.nk();
                a.$h(k);
                b[v](k, 9);
                return Ue(d)
            }));
            q ? (Oa(f, q + " &raquo;"), Fa(f[u], "")) : f && Fa(f[u], "none")
        }}
    };
    Ef[Ob](M.Se, 77, function () {
        function a() {
            return s
        }

        function b() {
            return 77
        }

        function d() {
            return 5
        }

        function e() {
            return E
        }

        function g() {
            return{Qu: !x}
        }

        function f() {
            l[Gb](!0)
        }

        function k() {
            y && ((x = !!l.fb()) && s ? q.Ru(77) : q.Pu(77))
        }

        var l, n, q, s, x, y, E, w, N = {jb: function (a, b) {
            w = a;
            a.Yh() || (b[B](".gscb_a", "display:inline-block;font:27px/13px arial,sans-serif"), b[B](".gsst_a .gscb_a", "color:#a1b9ed;cursor:pointer"), b[B](".gsst_a:hover .gscb_a,.gsst_a:focus .gscb_a", "color:#36c"))
        }, ia: function (a) {
            l = a.get(M.Ua, N);
            n = a.get(M.tb,
                N);
            q = a.get(M.Me, N)
        }, ub: function (a) {
            s = !!a.Li;
            y = a.xo;
            x = !y || !!l.fb();
            E = w.get("gs_cb");
            E || (E = Be("span", "gscb_a"), E.id = w.wb("gs_cb"), Oa(E, "&times;"));
            n.Tb(4, k);
            n.Tb(5, k);
            n.Tb(1, k)
        }, ea: function (a) {
            a.Tj && (s = !!a.Li);
            y = a.xo;
            x = !y || !!l.fb()
        }, L: function () {
            return M.Se
        }, X: function () {
            return 77
        }, W: function () {
            return{isEnabled: a, bp: b, mb: d, Qa: e, $o: g, Hd: f}
        }};
        return N
    });
    Ef[Ob](M.Me, 174, function () {
        function a() {
            return 174
        }

        function b(a) {
            ja != a && (ka.dir = ja = a, f())
        }

        function d() {
            return ka
        }

        function e(a) {
            (a = ha[a]) && a[u] && Fa(a[u], "")
        }

        function g(a) {
            (a = ha[a]) && a[u] && Fa(a[u], "none")
        }

        function f() {
            V && (m(ha[V], "gsst_a"), K.Rg(), V = null)
        }

        function k(a, b) {
            V = a;
            var d = ha[a];
            m(d, "gsst_a gsst_g");
            var e = aa.lastChild;
            e != b && (e == xa ? aa[p](b) : aa[Ac](b, e));
            K.si(174);
            K.show();
            d = d[dd];
            wa(xa[u], d + "px");
            Ra(xa[u], "rtl" == ja ? "0" : aa[dd] - d + "px")
        }

        function l(a, b) {
            V == a ? f() : k(a, b)
        }

        function n(a) {
            a.uk = "rtl" == ja ?
                "left" : "right";
            a.Oo = !1
        }

        function q() {
            return aa
        }

        function s() {
            return T.gn || Ba == ja ? Sa : null
        }

        function x() {
            f()
        }

        function y() {
            return 174
        }

        function E(a, b) {
            return b.mb() - a.mb()
        }

        function w() {
            la != V && f()
        }

        function N() {
            for (var a, b = 0, d; d = Y[b++];)if (d[jc]()) {
                a = !0;
                var e = Be("a", "gsst_a");
                L(e, d);
                e[p](d.Qa());
                ka[p](e)
            }
            Fa(ka[u], a ? "" : "none")
        }

        function z() {
            la = null
        }

        function J() {
            ha = {};
            for (var a = 0, b; b = Y[a++];)if (b[jc]()) {
                var d = b.bp(), e = b.Qa()[ud];
                fb(e, b.Hd);
                e.onmouseover = function () {
                    la = d
                };
                e.onmouseout = z;
                ha[d] = e;
                b.$o && (b = b.$o(),
                    b.Qu && g(d), (b = b.ez) && !ba.wl(e, b) && ab(e, b))
            }
        }

        function L(a, b) {
            Ea(a, "javascript:void(0)");
            gf(a);
            a.onkeydown = function (a) {
                a = a || window[zd];
                var d = a[Bb];
                if (13 == d || 32 == d)b.Hd(a), D.ds(), Ue(a)
            }
        }

        var K, A, D, Y, ba, T, ka, X, ha = {}, V, aa, xa, la, Ba, ja, Sa, Ca, R = {jb: function (a, b) {
            X = a;
            Ba = a.Ke();
            a.Yh() || (b[B](".gsst_a", "display:inline-block"), b[B](".gsst_a", "cursor:pointer;padding:0 4px"), b[B](".gsst_a:hover", "text-decoration:none!important"), b[B](".gsst_b", "font-size:16px;padding:0 2px;position:relative;" + b.prefix("user-select:none;") +
                "white-space:nowrap"), b[B](".gsst_e", cf(.55)), b[B](".gsst_a:hover .gsst_e,.gsst_a:focus .gsst_e", cf(.72)), b[B](".gsst_a:active .gsst_e", cf(1)), b[B](".gsst_f", "background:white;text-align:left"), b[B](".gsst_g", "background-color:white;border:1px solid #ccc;border-top-color:#d9d9d9;" + b.prefix("box-shadow:0 2px 4px rgba(0,0,0,0.2);") + "margin:-1px -3px;padding:0 6px"), b[B](".gsst_h", "background-color:white;height:1px;margin-bottom:-1px;position:relative;top:-1px"))
        }, ia: function (a) {
            K = a.get(M.Ad, R);
            A = a.get(M.tb,
                R);
            D = a.get(M.Ua, R);
            Y = a.Cb(M.Se, R);
            ba = a.Ae()
        }, ub: function (a) {
            Ca = a.Tj;
            Y[od](E);
            ka = X.get("gs_st");
            if (!ka) {
                ka = Ke("gsst_b");
                ka.id = X.wb("gs_st");
                if (a = a.dn)ka[u].lineHeight = a + "px";
                N()
            }
            J()
        }, ea: function (a) {
            T = a;
            (a = a.hn) && (Sa = X.Uh(a));
            if (Ca) {
                a = 0;
                for (var b; b = Y[a++];) {
                    var d = !!ha[b.bp()];
                    if (b[jc]() != d) {
                        for (; ka[hc]();)ka[id](ka.lastChild);
                        N();
                        J();
                        break
                    }
                }
            }
            xa = Ke("gsst_h");
            aa = Ke("gsst_f");
            aa.dir = "ltr";
            aa[p](xa);
            A.Tb(13, w)
        }, L: function () {
            return M.Me
        }, X: a, W: function () {
            return{Zj: b, Qa: d, Ru: e, Pu: g, bz: f, cz: k, dz: l}
        }, cg: function () {
            var b =
            {Nn: n, Qa: q, gi: s, On: x, bg: ce, Bk: y};
            return[
                {jb: ce, ia: ce, ub: ce, ea: ce, L: function () {
                    return M.fi
                }, X: a, W: function () {
                    return b
                }, cg: ce, Db: ce}
            ]
        }};
        return R
    });
    nf = function () {
        var a = window.navigator[$b], b = function (b) {
            return 0 <= a[Qc](b)
        }, d = {};
        window.opera ? d[2] = !0 : b("MSIE") || b("Trident") ? d[0] = !0 : b("WebKit") ? (d[5] = !0, b("Chrome") ? d[3] = !0 : b("Android") ? d[7] = !0 : b("Safari") && (d[4] = !0), b("iPad") && (d[6] = !0)) : b("Gecko") && (d[1] = !0);
        return d
    };
    var $f = function (a) {
        function b(a) {
            delete e[a];
            delete g[a]
        }

        function d(d) {
            if (a) {
                var e = Yd(), l = g[d];
                l && l < e && b(d)
            }
        }

        var e = {}, g = {};
        return{put: function (b, d) {
            e[b] = d;
            if (null != a) {
                var l = Yd() + a;
                g[b] = l
            }
        }, get: function (a) {
            d(a);
            return e[a] || null
        }, contains: function (a) {
            d(a);
            return a in e
        }, remove: b, reset: function () {
            e = {};
            g = {}
        }}
    };
    var gg = function () {
        function a(a) {
            return{api: a, el: a.a, ea: a.b, Db: a.c, Sz: a.d, ev: a.e, Fc: a.f, fb: a.g, vd: a.h, Fe: a.i, sl: a.j, gv: a.k, hv: a.l, Wz: a.m, fv: a.n, li: a.o, Jl: a.p, bn: a.q, Rz: a.r, Pz: a.s, mi: a.t, $m: a.u, focus: a.v, blur: a.w, vn: a.x, ud: a.y, Uc: a.z, Xz: a.aa, Cd: a.ab, search: a.ad, Yz: a.ae, aA: a.af, Ph: a.ag, Ee: a.ah, bA: a.ai, Zm: a.al, nn: a.am, $t: a.an, ce: a.ao, Yt: a.ap, Tz: a.aq, Qj: a.ar, wb: a.as, Qz: a.at, Vj: a.au, $z: a.av, Rh: a.aw, wn: a.ax, ti: a.ay, Zt: a.az, Pi: a.ba, Zz: a.bb, Vz: a.bc, ni: a.bd, Uz: a.be, co: a.bf}
        }

        return{Uf: function (b, d, e, g) {
            try {
                var f =
                    window.google.sbox(b, d, e, g);
                return a(f)
            } catch (k) {
                return null
            }
        }, translate: function (b) {
            return a(b.api || b)
        }}
    };
    Ef[Ob](M.il, 170, function () {
        function a(a) {
            if (1 < a[F] && 34 != a[0].L())for (var d = 1, e; e = a[d]; ++d)if (34 == e.L()) {
                a[wd](d, 0, 3);
                break
            }
        }

        return{L: function () {
            return M.il
        }, X: function () {
            return 170
        }, W: function () {
            return{yt: a}
        }}
    });
    window.google || (window.google = {});
    window.google.sbox = function (a, b, d, e) {
        function g() {
            D.Db()
        }

        function f(a) {
            ha.Uc(a || "")
        }

        function k() {
            return $a
        }

        function l() {
            return ca
        }

        function n() {
            return ha.fb()
        }

        function q() {
            return R.Ee()
        }

        function s() {
            ka.xb(8)
        }

        function x(a) {
            return xa.Ba(a)
        }

        function y() {
            return pb || !!ba && ba.ce()
        }

        function E() {
            return aa.Xt()
        }

        function w(a) {
            a = a.Un || se();
            a = ff(a);
            void 0 == a.nextSearchboxId && (a.nextSearchboxId = 50);
            return a.nextSearchboxId++
        }

        function N() {
            if (a)for (var b = a; b = b[ud];) {
                var d = b.dir;
                if (d)return d
            }
            return"ltr"
        }

        function z(a) {
            a =
                xe(a);
            a.Yf[35] || (a.Cs = "");
            var b = a.Tn;
            b ? a.Tn = b[yd]() : a.As = !1;
            a.Oj && !a.fk && (a.Oj = !1);
            of || (a.Vm = !1);
            return a
        }

        function J(a, b) {
            var d = b.exec(a);
            return d && d[1] ? qa(d[1], 10) || 0 : 0
        }

        function L() {
            var b = ff(a), d = $e(b);
            ka.dg(b, "resize", function () {
                var a = $e(b);
                if (a.So != d.So || a.Qo != d.Qo)d = a, s()
            })
        }

        function K(a) {
            var b = a.Le, d = b[M.In], e = b[M.zk], f = b[M.Ln], g = b[M.Mn], k = b[M.Qf], f = e || g || f;
            b[M.yk] || k || d || f ? (a.Le[M.yk] = !0, a.Le[M.Jn] = !0, f ? (a = Xd(a.He), !e || hf && (mf || a) || De && a ? ($a = 3, b[M.zk] = !1, b[M.Kn] = !1) : $a = 2) : $a = 1) : $a = 0
        }

        var A, D,
            Y, ba, T, ka, X, ha, V, aa, xa, la, Ba, ja, Sa, Ca, R, Ka, Z, ca, $a, O = !1, pb, ma = {a: function (d) {
                if (!O) {
                    d = z(d);
                    ca = null == e ? w(d) : e;
                    var f = ef(a), g = N(), k = !!f[Lc]("gs_id" + ca), l = ["gssb_c", "gssb_k"];
                    d.Uj && l[C](d.Uj);
                    l = Lf(d.Un, d.Bs, d.zs, ca, l);
                    K(d);
                    pb = d.ce;
                    D = Ff(A, d.kk || {}, {Yh: function () {
                        return k
                    }, get: function (a) {
                        return f[Lc](a + ca)
                    }, Uh: function (a) {
                        return f[Lc](a)
                    }, mo: function () {
                        return b
                    }, Ke: function () {
                        return g
                    }, wb: function (a) {
                        return a + ca
                    }, hk: function () {
                        return a
                    }}, l, ma, d);
                    Y = D.get(M.Ni, ma);
                    ba = D.get(M.Ce, ma);
                    T = D.get(M.Ad, ma);
                    ka = D.get(M.tb,
                        ma);
                    X = D.get(M.ic, ma);
                    ha = D.get(M.Ua, ma);
                    V = D.get(M.Ie, ma);
                    aa = D.get(M.zd, ma);
                    xa = D.get(M.Dd, ma);
                    la = D.get(M.tu, ma);
                    Ba = D.get(M.uu, ma);
                    ja = D.get(M.Te, ma);
                    Sa = D.get(M.Pg, ma);
                    Ca = D.get(M.Ec, ma);
                    R = D.get(M.Ob, ma);
                    Ka = D.get(M.Qf, ma);
                    Z = D.get(M.xd, ma);
                    L();
                    O = !0
                }
            }, b: function (a) {
                g();
                a = z(a);
                K(a);
                pb = a.ce;
                D.ea(a)
            }, c: g, d: function () {
                return b
            }, e: function (a, b) {
                return Qe(a, b)
            }, f: function () {
                return ha.Fc()
            }, g: n, h: function () {
                return R.vd()
            }, i: function () {
                return R.Fe()
            }, j: x, k: function (a, b) {
                a || (a = xa.Ba(b));
                return ee(a)
            }, l: function () {
                return R.Lf()
            },
                m: function () {
                    return R.Nr()
                }, n: function (a, b) {
                    ka.dg(a, "click", function (a) {
                        Z[v](n(), b);
                        return Te(a)
                    })
                }, o: function () {
                    X.li()
                }, p: function () {
                    R.Pj()
                }, q: function (a) {
                    ha.bn(a || "")
                }, r: function () {
                    return T.Bd()
                }, s: function () {
                    ha[Gb]()
                }, t: function (a) {
                    return X.mi(a)
                }, u: function () {
                    ha.$m()
                }, v: function () {
                    V[Ab]()
                }, w: function () {
                    V.blur()
                }, x: function () {
                    return X.vn()
                }, y: function () {
                    var a = Ca.ud();
                    return a ? Vd(a.Eo()) : null
                }, z: f, aa: function (a) {
                    a = ja.xk(a);
                    return Vd(a.Eo())
                }, ab: function () {
                    xa[qc]()
                }, ad: function (a, b) {
                    Z[v](a, b)
                }, ae: function () {
                    Ka &&
                    Ka[Ib]()
                }, af: function (a) {
                    R.Qm(a)
                }, ag: function () {
                    R.Ph()
                }, ah: q, ai: s, al: function () {
                    ha.Zm()
                }, am: function () {
                    return D && D.nn()
                }, an: function (a) {
                    ba && ba.$t(a)
                }, ao: y, ap: function () {
                    return y() && ba ? ba.Yt() : ""
                }, aq: function (a, b) {
                    return Re(a, b)
                }, ar: k, as: l, at: function () {
                    Ka && Ka[Gb]()
                }, au: function (a, b) {
                    f(a);
                    R[jc]() && R.Vj(a, b, !1)
                }, av: function (a) {
                    ka.xb(15, {Zh: a})
                }, aw: function () {
                    return V.Rh()
                }, ax: function (a) {
                    X.wn(a)
                }, ay: function (a) {
                    T.ti(a)
                }, az: function (a) {
                    return!!Ba && Ba.Zt(a)
                }, ba: function () {
                    var a, b = Ca.ud();
                    if (b) {
                        var d =
                            b.Mj();
                        d && ((a = d.Pi()) || (a = b.Ba().qb("o")))
                    }
                    return a || ""
                }, bb: function (a, b) {
                    return la ? (la.Vy(a, b), !0) : !1
                }, bc: function (a, b) {
                    switch (a) {
                        case "oq":
                        case "gs_l":
                            return x(b)[a] || null;
                        case "gs_ssp":
                            var d;
                            t:{
                                if ((d = q()) && 46 == d.L() && (d = d.Ba().qb("g")))break t;
                                d = null
                            }
                            return d;
                        default:
                            return null
                    }
                }, bd: function (a) {
                    Y && Y.ni(a)
                }, be: E, bf: function (a) {
                    return 6 == E() && !!Sa && Sa.co(a)
                }, wb: l, Qj: k};
        A = Mf(d);
        (function (a) {
            var b = A.kl(), d = J(a, /Version\/(\d+)/);
            d || (d = J(a, /(?:Android|Chrome|Firefox|Opera|MSIE)[\s\/](\d+)/));
            d || (d =
                J(a, /Trident[^)]*rv:(\d+)/));
            a = d;
            Ae = (De = b[0]) && 8 >= a;
            ze = De && 7 >= a;
            hf = b[1];
            Ce = b[2];
            jf = b[5];
            kf = b[4];
            of = b[3];
            lf = b[7]
        })(window.navigator[$b]);
        mf = /Mac/[zc](pa && (pa.platform || pa.appVersion) || "");
        return ma
    };
    var hg = function () {
        function a(a) {
            var b = !0;
            void 0 != a && (b = a == y.pi, y.pi = a);
            s ? b || s.ea(y) : (s = gg().Uf(z, w, ja), s.el(y), K && K.ia(s))
        }

        function b(a) {
            s.Uc(a)
        }

        function d(a) {
            return a + (0 <= a[Qc]("?") ? "&" : "?") + s.gv()
        }

        function e() {
            aa && aa()
        }

        function g(b, d, e, g) {
            w = b;
            z = d;
            xa = e;
            var n = g.onRenderCallback;
            n && (aa = function () {
                try {
                    n()
                } catch (a) {
                }
            });
            y = f();
            l(y, g);
            k(e, y);
            a();
            g.searchButton && s.fv(g.searchButton, 12)
        }

        function f() {
            var a = x.Uf();
            a.rk = "partner";
            a.sk = "partner";
            a.qn = "cse";
            a.Ou = !0;
            a.vo = {partnerid: xa};
            a.en = !0;
            a.gk = "gsc-input";
            a.pn = "gsc-completion-container";
            a.on = "gsc-completion-selected";
            T && (a.$k = z.id, a.cl = "gsc-input-hover", a.bl = "gsc-input-focus");
            a.gf = [-1, 0, 0];
            a.Ck = !0;
            a.ce = !0;
            a.Li = !1;
            a.spellcheck = !1;
            a.Yf = Ud([0, 34]);
            a.Le[66] = !0;
            return a
        }

        function k(a, b) {
            var d = {}, e = d[M.Gd] = [162];
            if (L || A)d[M[Oc]] = [L ? cg(K) : Zf(A), 162];
            ye(d, M.Yc, Xf(a));
            ye(d, M.Gd, Of());
            ye(d, M.Yc, Qf());
            ye(d, M.ui, Pf());
            D && e[C](Wf(D));
            ye(d, M.wi, dg(Y, ba));
            b.kk = d;
            X && (d = b.kk, d[M.Pg] = Rf(), ye(d, M.Yc, Uf()), ye(d, M.cf, Vf()), ye(d, M[Oc], Tf()))
        }

        function l(a, b) {
            if (ka = !!b.useKennedyLookAndFeel)T &&
            (a.$k = z[ud].id, a.cl = "gsc-input-box-hover", a.bl = "gsc-input-box-focus"), a.gf = [3, -1, 2], a.Li = !0;
            b.interfaceLanguage && (a.He = b.interfaceLanguage);
            b.disableAutoCompletions && (a.pi = !0);
            Y = qa(b.maxSuggestions, 10);
            var d = b.saytSubmit;
            d && (K = ag(d, aa), b.saytExtraParameters && K.pv(b.saytExtraParameters), a.Yf[503] = !0, a.Yf[34] = !1, b.saytKeyboardNavigationEnabled && (a.bi = 4, a.Lj = !1, Ba = !0), L = !0);
            0 <= Y || (Y = d ? 5 : 10);
            ba = qa(b.maxPromotions, 10);
            0 <= ba || (ba = 3);
            a.tk = "gsnos,n=" + (Y + 3);
            (A = b.brandingImageUrl) && (D = b.brandingImageStyle +
                " url(" + A + ")");
            if (d = b.styleOptions) {
                var e = d.xOffset || 0, f = d.yOffset || 0, g = d.widthOffset || 0, k = d.fixedWidth;
                ha = !!d.allowWordWrapping;
                var l = a.gf;
                l[0] += f;
                l[1] += e;
                l[2] += g;
                a.Pn = k;
                a.Xm = d.xAlign;
                d.positionFixed && (a.Tg = "fixed")
            }
            X = !!b.enableSpeech
        }

        function n() {
            s.ni(V)
        }

        var q = {Ov: "oq", Pv: "gs_l"}, s, x, y, E, w, N, z, J, L = !1, K, A, D, Y, ba, T, ka, X, ha = !1, V, aa, xa, la = !1, Ba = !1, ja = {ea: a, el: function (a, b, d, e) {
            g(a, b, d, e);
            if (e.isLoggingWithHiddenFormFields) {
                J = {};
                for (var f in q)a = q[f], J[a] = s.ev(w, a)
            } else la = !0, w && (w[Vc] ? w[Vc]("submit",
                n, !1) : w[Jb] && w[Jb]("onsubmit", n))
        }, Dr: function (a, b, d, e) {
            T = d;
            g(a, b, T.kj() || "", e);
            e.enableAsynchronousLogging && (la = !0)
        }, Hu: function (a, b, d, e) {
            g(null, b, d, e);
            la = !0;
            N = a
        }, Uc: b, fb: function () {
            return s.fb()
        }, a: function () {
            return E
        }, b: function (a, d) {
            a != z[Pc] && (T && window[nc] && window[nc].log && window[nc].log("Programmatically setting input.value? Please consider using prefillQuery() or execute() from google.search.SearchControl instead."), a = z[Pc], b(a));
            if (je(a)) {
                V = d;
                la && (T || N) && n();
                var e = s.sl(V);
                if (J) {
                    var f = q.Ov;
                    J[f] && Qa(J[f], e[f]);
                    f = q.Pv;
                    J[f] && Qa(J[f], e[f])
                }
                T ? (a != s.fb() && s.Uc(a), la ? T[Dc]() : T.Qv(e)) : N ? N(e) : w && (w.fireEvent && h.createEventObject ? (e = h.createEventObject(), w.fireEvent("onsubmit", e) && w[Dc]()) : w.dispatchEvent && h.createEvent ? (e = h.createEvent("HTMLEvents"), e.initEvent("submit", !0, !0), w.dispatchEvent(e) && w[Dc]()) : w.onsubmit && !1 == w.onsubmit() || w[Dc]());
                V = null
            }
        }, c: function (a) {
            window.location = a
        }, d: function (a) {
            window.location = d(a)
        }, e: d, j: function () {
            K && K.pp()
        }, o: e, p: e, r: function (a) {
            if (T)if (ka)a[B](".gssb_a",
                "padding:0 9px"), a[B](".gsib_a", "padding-right:8px;padding-left:8px"), a[B](".gsst_a", "padding-top:3px"); else a[B](".gssb_a", "padding:0 7px"); else a[B](".gssb_a", "padding:0 2px");
            a[B](".gssb_e", "border:0");
            a[B](".gssb_l", "margin:5px 0");
            a[B](".gssb_c .gsc-completion-container", "position:static");
            a[B](".gssb_c", "z-index:5000");
            a[B](".gsc-completion-container table", "background:transparent;font-size:inherit;font-family:inherit");
            a[B](".gssb_c > tbody > tr,.gssb_c > tbody > tr > td,.gssb_d,.gssb_d > tbody > tr,.gssb_d > tbody > tr > td,.gssb_e,.gssb_e > tbody > tr,.gssb_e > tbody > tr > td",
                "padding:0;margin:0;border:0");
            a[B](".gssb_a table,.gssb_a table tr,.gssb_a table tr td", "padding:0;margin:0;border:0");
            L && a[B](".cse-sayt div", "white-space:normal");
            ha && a[B](".gssb_a,.gssb_a td", "white-space:normal")
        }, w: function () {
            K && K.pp()
        }, x: function () {
            T && T.Zc()
        }, y: function () {
            K && Ba && K.ov()
        }, ab: function () {
            K && Ba && s.hv() && K.qv()
        }};
        E = nf();
        x = Bf();
        return ja
    };
    google[v].V = {};
    google[v].V.Tx = "ar" == ta || "iw" == ta || "fa" == ta;
    google[v].V.mr = google[v].V.Tx ? -1 : 1;
    google[v].V.qd = new Td(google[v].V.mr);
    google[v].V.Hi = google[v].V.qd.jr(google[v].V.mr);
    google[v].V.Rq = google[v].V.qd.Jy();
    google[v].V.HA = google[v].V.qd.jy();
    google[v].V.Wd = function (a, b) {
        return google[v].V.qd.Uq(a, !1, b)
    };
    google[v].V.Bf = function (a, b) {
        return google[v].V.qd.Uq(a, !0, b)
    };
    google[v].V.Pw = function (a) {
        return a ? google[v].V.qd.Sq(a, !1) : google[v].V.Hi
    };
    google[v].V.qh = function (a) {
        return a ? google[v].V.qd.Sq(a, !0) : google[v].V.Hi
    };
    google[v].V.Rw = function (a) {
        return a ? google[v].V.qd.Tq(a, !1) : ""
    };
    google[v].V.Qw = function (a) {
        return a ? google[v].V.qd.Tq(a, !0) : ""
    };
    google[v].NoOldNames || (da("UDS_ServiceBase", google[pd][Yc]), da("UDS_ApiKey", google[pd].ApiKey), da("UDS_KeyVerified", google[pd].KeyVerified), da("UDS_LoadFailure", google[pd].LoadFailure), da("UDS_CurrentLocale", ta), da("UDS_ShortDatePattern", ea), da("UDS_Version", google[v][ed]), da("UDS_JSHash", google[v].JSHash));
    var P = {blank: "&nbsp;"};
    P.image = _UDS_MSG_SEARCHER_IMAGE;
    P.web = _UDS_MSG_SEARCHER_WEB;
    P.blog = _UDS_MSG_SEARCHER_BLOG;
    P.video = _UDS_MSG_SEARCHER_VIDEO;
    P.local = _UDS_MSG_SEARCHER_LOCAL;
    P.news = _UDS_MSG_SEARCHER_NEWS;
    P.book = _UDS_MSG_SEARCHER_BOOK;
    P.patent = _UDS_MSG_SEARCHER_PATENT;
    P["ads-by-google"] = _UDS_MSG_ADS_BY_GOOGLE;
    P.save = _UDS_MSG_SEARCHCONTROL_SAVE;
    P.keep = _UDS_MSG_SEARCHCONTROL_KEEP;
    P.include = _UDS_MSG_SEARCHCONTROL_INCLUDE;
    P.copy = _UDS_MSG_SEARCHCONTROL_COPY;
    P.close = _UDS_MSG_SEARCHCONTROL_CLOSE;
    P["sponsored-links"] = _UDS_MSG_SEARCHCONTROL_SPONSORED_LINKS;
    P["see-more"] = _UDS_MSG_SEARCHCONTROL_SEE_MORE;
    P.watermark = _UDS_MSG_SEARCHCONTROL_WATERMARK;
    P["search-location"] = _UDS_MSG_SEARCHER_CONFIG_SET_LOCATION;
    P["disable-address-lookup"] = _UDS_MSG_SEARCHER_CONFIG_DISABLE_ADDRESS_LOOKUP;
    P["sort-by-date"] = _UDS_MSG_SORT_BY_DATE;
    P.pbg = _UDS_MSG_BRANDING_STRING;
    P["n-minutes-ago"] = _UDS_MSG_MINUTES_AGO;
    P["n-hours-ago"] = _UDS_MSG_HOURS_AGO;
    P["one-hour-ago"] = _UDS_MSG_ONE_HOUR_AGO;
    P["all-n-related"] = _UDS_MSG_NEWS_ALL_N_RELATED;
    P["related-articles"] = _UDS_MSG_NEWS_RELATED;
    P["page-count"] = _UDS_MSG_TOTAL_PAGE_COUNT;
    var ig = [];
    ig[0] = _UDS_MSG_MONTH_ABBR_JAN;
    ig[1] = _UDS_MSG_MONTH_ABBR_FEB;
    ig[2] = _UDS_MSG_MONTH_ABBR_MAR;
    ig[3] = _UDS_MSG_MONTH_ABBR_APR;
    ig[4] = _UDS_MSG_MONTH_ABBR_MAY;
    ig[5] = _UDS_MSG_MONTH_ABBR_JUN;
    ig[6] = _UDS_MSG_MONTH_ABBR_JUL;
    ig[7] = _UDS_MSG_MONTH_ABBR_AUG;
    ig[8] = _UDS_MSG_MONTH_ABBR_SEP;
    ig[9] = _UDS_MSG_MONTH_ABBR_OCT;
    ig[10] = _UDS_MSG_MONTH_ABBR_NOV;
    ig[11] = _UDS_MSG_MONTH_ABBR_DEC;
    P["month-abbr"] = ig;
    P.directions = _UDS_MSG_DIRECTIONS;
    P["clear-results"] = _UDS_MSG_CLEAR_RESULTS;
    P["show-one-result"] = _UDS_MSG_SHOW_ONE_RESULT;
    P["show-more-results"] = _UDS_MSG_SHOW_MORE_RESULTS;
    P["show-all-results"] = _UDS_MSG_SHOW_ALL_RESULTS;
    P.settings = _UDS_MSG_SETTINGS;
    P.search = _UDS_MSG_SEARCH;
    P["search-uc"] = _UDS_MSG_SEARCH_UC;
    P["powered-by"] = _UDS_MSG_POWERED_BY;
    P.sa = _UDS_MSG_SEARCHER_GSA;
    P.by = _UDS_MSG_SEARCHER_BY;
    P.code = _UDS_MSG_SEARCHER_CODE;
    P["unknown-license"] = _UDS_MSG_UNKNOWN_LICENSE;
    P["more-results"] = _UDS_MSG_SEARCHCONTROL_MORERESULTS;
    P.previous = _UDS_MSG_SEARCHCONTROL_PREVIOUS;
    P.next = _UDS_MSG_SEARCHCONTROL_NEXT;
    P["get-directions"] = _UDS_MSG_GET_DIRECTIONS;
    P["to-here"] = _UDS_MSG_GET_DIRECTIONS_TO_HERE;
    P["from-here"] = _UDS_MSG_GET_DIRECTIONS_FROM_HERE;
    P["clear-results-uc"] = _UDS_MSG_CLEAR_RESULTS_UC;
    P["search-the-map"] = _UDS_MSG_SEARCH_THE_MAP;
    P["scroll-results"] = _UDS_MSG_SCROLL_THROUGH_RESULTS;
    P["edit-tags"] = _UDS_MSG_EDIT_TAGS;
    P["tag-search"] = _UDS_MSG_TAG_THIS_SEARCH;
    P["search-string"] = _UDS_MSG_SEARCH_STRING;
    P["optional-label"] = _UDS_MSG_OPTIONAL_LABEL;
    P["delete"] = _UDS_MSG_DELETE;
    P.deleted = _UDS_MSG_DELETED;
    P.cancel = _UDS_MSG_CANCEL;
    P["upload-video"] = _UDS_MSG_UPLOAD_YOUR_VIDEOS;
    P["im-done"] = _UDS_MSG_IM_DONE_WATCHING;
    P["close-player"] = _UDS_MSG_CLOSE_VIDEO_PLAYER;
    P["no-results"] = _UDS_MSG_NO_RESULTS;
    P["linked-cse-error-results"] = _UDS_MSG_LINKEDCSE_ERROR_RESULTS;
    P.back = _UDS_MSG_BACK;
    P.subscribe = _UDS_MSG_SUBSCRIBE;
    P["us-pat"] = _UDS_MSG_USPAT;
    P["us-pat-app"] = _UDS_MSG_USPAT_APP;
    P["us-pat-filed"] = _UDS_MSG_PATENT_FILED;
    P.dym = _UDS_MSG_DID_YOU_MEAN;
    P["showing-results-for"] = _UDS_MSG_SHOWING_RESULTS_FOR;
    P["search-instead-for"] = _UDS_MSG_SEARCH_INSTEAD_FOR;
    P["custom-search"] = _UDS_MSG_CUSTOM_SEARCH;
    P.labeled = _UDS_MSG_LABELED;
    P.loading = _UDS_MSG_LOADING;
    P["all-results-short"] = _UDS_MSG_ALL_RESULTS_SHORT;
    P["all-results-long"] = _UDS_MSG_ALL_RESULTS_LONG;
    P["refine-results"] = _UDS_MSG_REFINE_RESULTS;
    P["result-info"] = _UDS_MSG_RESULT_INFO;
    P["file-format"] = _UDS_MSG_FILE_FORMAT;
    P["order-results-by"] = _UDS_MSG_ORDER_BY;
    P["order-by-relevance"] = _UDS_MSG_ORDER_BY_RELEVANCE;
    P["order-by-date"] = _UDS_MSG_ORDER_BY_DATE;
    P["get-link"] = _UDS_MSG_ORDER_BY_GET_LINK;
    P["add-label"] = "Add Label";
    P["no-refinement"] = "Refinements should be present before adding label";
    P["label-page"] = "This particular page";
    P["label-site"] = "Entire site";
    P["label-prefix"] = "Specific page prefix";
    P["invalid-url-prefix"] = "Invalid url prefix";
    P["error-adding-label"] = "Error adding label.";
    P.saving = "Saving...";
    P.Save = "Save";
    P.Cancel = "Cancel";
    function jg(a, b) {
        var d = function () {
        };
        d.prototype = b[G];
        a.prototype = new d;
        a[G].QB = function (b, d, f, k) {
            var l = oa[G][wd][oc](arguments, [1, arguments[F]]);
            return b[oc](a, l)
        }
    }

    var _json_cache_defeater_ = (new Date)[Nb](), _json_request_require_prep = !0;

    function kg(a, b) {
        var d;
        if (d = lg("msie"))d = "msie 6.0"in mg ? mg["msie 6.0"] : mg["msie 6.0"] = -1 != pa.appVersion[yd]()[Qc]("msie 6.0");
        d ? window[Xb](ng(this, og, [a, b]), 0) : og(a, b)
    }

    function pg(a) {
        _json_request_require_prep = !1;
        kg(a, null);
        _json_request_require_prep = !0
    }

    function og(a, b) {
        var d = h[Pb]("head")[0];
        d || (d = h[gd][ud][p](h[t]("head")));
        var e = h[t]("script");
        Ua(e, "text/javascript");
        e.charset = "utf-8";
        var g = _json_request_require_prep ? a + "&key=" + google[pd].ApiKey + "&v=" + b : a;
        if (qg() || lg("safari") || lg("konqueror"))g = g + "&nocache=" + _json_cache_defeater_++;
        e.src = g;
        var f = function () {
            va(e, null);
            e[ud][id](e)
        }, g = function (a) {
            a = a ? a : window[zd];
            a = a[jd] ? a[jd] : a[Nc];
            if ("loaded" == a[Uc] || "complete" == a[Uc])Ma(a, null), f()
        };
        "Gecko" == pa.product ? va(e, f) : Ma(e, g);
        d[p](e)
    }

    function rg(a, b) {
        return function () {
            return b[oc](a, arguments)
        }
    }

    function ng(a, b, d) {
        return function () {
            return b[oc](a, d || [])
        }
    }

    function tg(a) {
        for (; a[Cb];)a[id](a[Cb])
    }

    function ug(a, b) {
        if (a)try {
            tg(a), a[p](b)
        } catch (d) {
        }
        return b
    }

    function Q(a, b) {
        try {
            a[p](b)
        } catch (d) {
        }
        return b
    }

    function vg(a, b) {
        void 0 != a.textContent ? Za(a, b) : a.innerText = b
    }

    function wg(a) {
        return h[wb](a ? a : "")
    }

    function U(a, b) {
        var d = h[t]("div");
        a && Oa(d, a);
        b && m(d, b);
        return d
    }

    function xg(a, b) {
        var d = h[t]("div");
        a && Q(d, wg(a));
        b && m(d, b);
        return d
    }

    function W(a) {
        var b = h[t]("div");
        a && m(b, a);
        return b
    }

    function yg(a, b) {
        var d = h[t]("span");
        a && Q(d, wg(a));
        b && m(d, b);
        return d
    }

    function zg(a, b, d) {
        var e = h[t]("table");
        e[Eb]("cellSpacing", a ? a : 0);
        e[Eb]("cellPadding", b ? b : 0);
        d && m(e, d);
        return e
    }

    function Ag(a, b, d) {
        (a = a[Rc](-1)) || alert(a);
        for (var e = 0; e < b; e++)Bg(a, d);
        return a
    }

    function Bg(a, b) {
        var d = a[$c](-1);
        b && m(d, b);
        return d
    }

    function Cg(a, b, d, e) {
        var g = h[t]("img");
        g.src = a;
        b && wa(g, b);
        d && Ia(g, d);
        e && m(g, e);
        return g
    }

    function Dg(a, b, d, e, g) {
        var f = h[t]("a");
        Ea(f, a);
        b && (e ? Q(f, yg(b, e)) : Q(f, wg(b)));
        d && cb(f, d);
        g && ab(f, g);
        return f
    }

    function Eg(a, b, d, e, g, f) {
        var k = U(null, e), l = h[t]("a");
        Ea(l, a);
        Oa(l, b);
        e && m(l, e);
        d && cb(l, d);
        g && ab(l, g);
        if (f)for (var n in f)l[Eb](n, f[n]);
        k[p](l);
        return k
    }

    function Fg(a, b) {
        var d = h[t]("label");
        b && m(d, b);
        a && Za(d, a);
        return d
    }

    function Gg(a) {
        var b = h[t]("form");
        a && m(b, a);
        return b
    }

    function Hg(a, b) {
        var d = h[t]("input");
        Ua(d, "submit");
        Qa(d, a);
        b && m(d, b);
        return d
    }

    function Ig(a, b, d) {
        var e = h[t]("input");
        Ua(e, "button");
        Qa(e, a);
        b && m(e, b);
        d && fb(e, d);
        return e
    }

    function Jg(a, b, d) {
        var e = h[t]("input");
        e[Eb]("autoComplete", "off");
        Ua(e, "text");
        -1 == a ? $(e, "util-css-expand") : e.size = 0 < a ? a : 10;
        b && $(e, b);
        d && Qa(e, d);
        return e
    }

    function Kg(a, b, d, e) {
        var g = h[t]("input");
        Ua(g, "checkbox");
        Va(g, a);
        Qa(g, b);
        e && m(g, e);
        d && Aa(g, d);
        return g
    }

    function Lg(a, b, d, e) {
        var g = h[t]("input");
        Ua(g, "radio");
        a && Va(g, a);
        b && Qa(g, b);
        e && m(g, e);
        d && Aa(g, d);
        return g
    }

    function Mg(a, b) {
        b ? (a.tabIndex = 0, fb(a, b), a.onkeypress = function (d) {
            d = d || window[zd];
            d[Bb] && 13 == d[Bb] && b[kd](a, d)
        }) : (a.tabIndex = -1, a[rc]("tabIndex"), fb(a, null), a.onkeypress = null)
    }

    function Ng() {
        var a = window[bc][fc];
        return"/cse/labelurl" == window[bc].pathname && -1 !== a[Qc]("google.com", a[F] - 10) ? !0 : !1
    }

    function Og(a, b) {
        if (null == a || null == a[cd])return!1;
        for (var d = a[cd][Yb](" "), e = 0; e < d[F]; e++)if (d[e] == b)return!0;
        return!1
    }

    function $(a, b) {
        Og(a, b) || m(a, a[cd] + (" " + b))
    }

    function Pg(a, b) {
        if (null != a[cd]) {
            for (var d = a[cd][Yb](" "), e = [], g = !1, f = 0; f < d[F]; f++)d[f] != b ? d[f] && e[C](d[f]) : g = !0;
            g && m(a, e[xd](" "))
        }
    }

    var Qg = "", Rg = {cy: {YB: 1, $B: 1, hC: 1, id: 1, iC: 1, "in": 1, jC: 1, lC: 1, mC: 1, nC: 1, oC: 1, xC: 1, IC: 1, MC: 1, NC: 1, QC: 1, RC: 1, TC: 1}, ZB: {RB: 1, TB: 1, UB: 1, VB: 1, WB: 1, XB: 1, cy: 1, aC: 1, "do": 1, bC: 1, cC: 1, dC: 1, eC: 1, fC: 1, gC: 1, kC: 1, pC: 1, qC: 1, rC: 1, sC: 1, tC: 1, uC: 1, vC: 1, wC: 1, zC: 1, AC: 1, BC: 1, CC: 1, DC: 1, EC: 1, FC: 1, GC: 1, HC: 1, JC: 1, KC: 1, LC: 1, OC: 1, PC: 1, SC: 1}, yC: {SB: 1}};

    function lg(a) {
        return a in Sg ? Sg[a] : Sg[a] = -1 != pa[$b][yd]()[Qc](a)
    }

    var Sg = {}, mg = {};

    function qg() {
        return lg("msie")
    }

    var Tg, Ug;
    window.ActiveXObject && (Tg = !0, window.XMLHttpRequest && (Ug = !0));
    function Vg(a) {
        this.qm = a + "branding";
        this.Cj = a + "branding-vertical";
        this.Yq = a + "branding-img-noclear";
        this.Fx = a + "branding-clickable";
        this.text = a + "branding-text";
        this.Gx = a + "branding-text-name"
    }

    function Wg(a, b, d, e, g) {
        var f = new Vg(a);
        a = W(f.qm);
        var k = zg(null, null, f.qm);
        Q(a, k);
        var l = !d;
        l || ($(a, f.Cj), $(k, f.Cj));
        var n = Ag(k, 0), q;
        l ? q = n : (q = n, n = Ag(k, 0));
        var s = "/css/small-logo.png", x = 51, y = 15;
        e && "string" == typeof e && e[yb](/^http:\/\/www\.youtube\.com/) && (s = "/css/youtube-logo-55x24.png", x = 55, y = 24, $(a, f.qm + "-youtube"), l || ($(a, f.Cj + "-youtube"), $(k, f.Cj + "-youtube")));
        q = Bg(q, f[Ic]);
        var l = Bg(n, f.Yq), E = U(P["powered-by"], f[Ic]), s = google[pd][Yc] + s, w = f.Yq;
        Tg && !Ug ? (w = W(w), w[u].filter = 'progid:DXImageTransform.Microsoft.AlphaImageLoader(src="' +
            s + '")', wa(w[u], x + "px"), Ia(w[u], y + "px")) : w = Cg(s, null, null, w);
        y = w;
        Q(q, E);
        e ? (q = "http://www.google.com", "string" == typeof e && (e[yb](/^http:\/\/[a-z]*\.google\.com/) || e[yb](/^http:\/\/www\.youtube\.com/)) && (q = e), e = Dg(q, null, "_BLANK"), m(e, f.Fx), Q(e, y), Q(l, e)) : Q(l, y);
        g && (e = n, d && (e = Ag(k, 0)), d = f[Ic] + " " + f.Gx, f = Bg(e, d), Q(f, xg(g, d)));
        b && (b = "string" == typeof b ? h[Lc](b) : b, tg(b), Q(b, a));
        return a
    }

    var Xg = function (a, b, d) {
        b = b && "*" != b ? b.toUpperCase() : "";
        if (d && a[Sc]) {
            a = a[Sc](d);
            if (b) {
                for (var e = {}, g = 0, f = 0, k; k = a[f]; f++)b == k.nodeName && (e[g++] = k);
                e.length = g;
                return e
            }
            return a
        }
        a = a[Pb](b || "*");
        if (d) {
            e = {};
            for (f = g = 0; k = a[f]; f++)Og(k, d) && (e[g++] = k);
            e.length = g;
            return e
        }
        return a
    };

    function Yg(a) {
        return a[r](/\s+$/, "")[r](/^\s+/, "")
    }

    function Zg(a) {
        var b = [];
        if (a)for (var d in a)null != a[d] && b[C](c(d) + "=" + c(a[d]));
        return b[xd]("&")
    }

    function $g(a, b) {
        for (var d = a[Yb]("?"), e = d[1][Yb]("&"), g = b + "=", f = e[F]; 0 < f--;)-1 != e[f].lastIndexOf(g, 0) && e[wd](f, 1);
        return 0 < e[F] ? d[0] + "?" + e[xd]("&") : d[0]
    }

    function ah(a) {
        for (var b = window[bc][v][rd](1)[Yb]("&"), d = 0; d < b[F]; d++) {
            var e = b[d][Yb]("=");
            if (e[0] == a)return ua(e[1])
        }
    }

    function bh(a, b) {
        b || (b = h[Pb]("body")[0]);
        for (var d = 0; a != b;)d += a.offsetLeft, a = a.offsetParent;
        return d
    }

    function ch(a, b) {
        b || (b = h[gd]);
        for (var d = 0; a != b;)d += a.offsetTop, a = a.offsetParent;
        return d
    }

    function dh(a) {
        try {
            return a instanceof HTMLFormElement
        } catch (b) {
            return!!a && "object" === typeof a && 1 === a[Kc] && "object" === typeof a[u] && "object" === typeof a.ownerDocument && "form" === a[pc][yd]()
        }
    }

    function eh(a) {
        "string" == typeof a && (a = h[Lc](a));
        return a
    }

    function fh(a) {
        if (a) {
            var b = h[t]("div"), d = h[t]("a");
            Ea(d, a);
            b[p](d);
            Oa(b, b[Mc]);
            return b[Cb][mc]
        }
        return null
    }

    function gh(a) {
        var b = h[t]("a");
        Ea(b, a);
        return b[Qb]
    }

    function hh(a) {
        return!!a && /https?:\/\/([^/.:]+\.)*google(\.[^/.:]+)*(\:[0-9]+)?\/cse/[zc](a)
    }

    function ih(a, b) {
        for (; b && b != a;)b = b[ud];
        return b == a
    }

    function jh(a) {
        window[nc] && window[nc].warn(a)
    };
    google[v].Oa = {};
    google[v].Oa.Bx = function (a, b, d) {
        var e = new XMLHttpRequest;
        Ma(e, function () {
            e[Uc] == XMLHttpRequest.DONE && d(e.responseText)
        });
        e[yc]("POST", a, !0);
        e[Tc]("Content-type", "application/json");
        e[Tc]("Accept", "application/json");
        e.send(b)
    };
    google[v].Oa.jx = function (a, b) {
        var d = new XMLHttpRequest;
        Ma(d, function () {
            d[Uc] == XMLHttpRequest.DONE && b(d.responseText)
        });
        d[yc]("GET", a, !0);
        d[Tc]("Content-type", "application/json");
        d[Tc]("Accept", "application/json");
        d.send()
    };
    google[v].Oa.Dx = function (a) {
        var b = new XMLHttpRequest;
        b[yc]("GET", a, !1);
        b[Tc]("Content-type", "application/json");
        b[Tc]("Accept", "application/json");
        b.send();
        return b.responseText
    };
    google[v].Oa.Pq = function () {
        var a = ah("cx")[Yb](":");
        return window[bc][lc] + "//" + window[bc][Qb] + "/cse/api/" + a[0] + "/annotations/" + a[1] + "?xsrf=" + google[v].Oa.Xq()
    };
    google[v].Oa.Xq = function () {
        return h[Lc]("xsrf")[Mc]
    };
    google[v].Oa.Cx = function () {
        var a = ah("cx")[Yb](":");
        return window[bc][lc] + "//" + window[bc][Qb] + "/cse/api/" + a[0] + "/cse/" + a[1] + "?xsrf=" + google[v].Oa.Xq()
    };
    google[v].Oa.ox = function () {
        var a = JSON[ad](google[v].Oa.Dx(google[v].Oa.Cx()));
        if (!a.Context || !a.Context.Facet)return null;
        for (var b = [], d = 0; d < a.Context.Facet[F]; d++)for (var e = a.Context.Facet[d].FacetItem, g = 0; e && g < e[F]; g++)b[C](e[g]);
        return b
    };
    google[v].Oa.zx = function (a, b) {
        var d = JSON[ad](b);
        if (d.Annotation)for (var e = 0; e < d.Annotation[F]; e++)if (d.Annotation[e].AdditionalData[0][Pc] == a)return d.Annotation[e][mc]
    };
    google[v].Oa.Ax = function (a, b, d) {
        a = {Add: {Annotations: {Annotation: [
            {about: a, label: [
                {name: "_cse_" + ah("cx")[Yb](":")[1]}
            ]}
        ]}}};
        for (var e = a.Add.Annotations.Annotation[0][sc], g = 0; g < b[F]; g++)e[C]({name: b[g]});
        d && (a.Remove = {Annotations: {Annotation: [
            {href: d}
        ]}});
        return JSON.stringify(a)
    };
    google[v].Oa.sx = function (a) {
        var b = JSON[ad](a);
        a = [];
        if (!(b.Add && b.Add.Annotations && b.Add.Annotations.Annotation && b.Add.Annotations.Annotation[0].Label))return a;
        for (var b = b.Add.Annotations.Annotation[0].Label, d = 1; d < b[F]; d++)a[C](b[d][Zc]);
        return a
    };
    google[v].M = function (a, b) {
        this.Zl = google[v].M.xq();
        this.$l = google[v].M.yq();
        this.fm = this.Zl || this.$l;
        var d = window[bc][mc];
        this.Nw = 0 <= d[Qc]("#") ? d[rd](0, d[Qc]("#")) : d;
        this.dm = !1;
        this.Ow = b;
        d = google[v].M.bm(google[v].M.cm());
        this.Xl = d.vq;
        this.we = d[ic];
        if (this.fm) {
            d = rg(this, google[v].M[G].Sw);
            this.Zl && window[Vc] ? (window[Vc]("popstate", d, !1), window[Vc]("hashchange", d, !1)) : this.$l && (window[Vc] ? window[Vc]("hashchange", d, !1) : window[Jb] && window[Jb]("onhashchange", d));
            var d = !1, e;
            for (e in this.we) {
                d = !0;
                break
            }
            d ?
                this.wq() : this.zq(a, !0)
        }
    };
    google[v].M.Kh = "gsc.";
    google[v].M.Wg = google[v].M.Kh + "q";
    google[v].M.oj = google[v].M.Kh + "tab";
    google[v].M.nj = google[v].M.Kh + "ref";
    google[v].M.cd = google[v].M.Kh + "page";
    google[v].M.Vi = google[v].M.Kh + "sort";
    var kh = {};
    kh[google[v].M.Wg] = !0;
    kh[google[v].M.oj] = !0;
    kh[google[v].M.cd] = !0;
    kh[google[v].M.nj] = !0;
    kh[google[v].M.Vi] = !0;
    google[v].M.mx = kh;
    var lh = {};
    lh[google[v].M.oj] = !0;
    lh[google[v].M.cd] = !0;
    google[v].M.fx = lh;
    google[v].M.xq = function () {
        return!(!window[hd] || !window[hd][ib])
    };
    google[v].M.yq = function () {
        return"onhashchange"in window && (!qg() || 8 <= h.documentMode)
    };
    google[v].M.isSupported = function () {
        return google[v].M.xq() || google[v].M.yq()
    };
    google[v].M.Dv = function () {
        var a = google[v].M.bm(google[v].M.cm())[ic], b;
        for (b in a)return!0;
        return!1
    };
    I = google[v].M[G];
    I.isEnabled = function () {
        return this.fm
    };
    I.pushState = function (a) {
        this.fm && !this.dm && this.zq(a, !1)
    };
    I.zq = function (a, b) {
        a = google[v].M.Vw(a);
        if (!google[v].M.Dq(this.we, a)) {
            this.we = a;
            var d = google[v].M.Ww(a);
            this.Xl && (d = this.Xl + "&" + d);
            if (this.Zl) {
                var e = h[bd] || "", d = "#" + d;
                b ? window[hd].replaceState(null, e, d) : window[hd][ib](null, e, d)
            } else this.$l && (d = this.Nw + "#" + d, b ? window[bc][r](d) : Ea(window[bc], d))
        }
    };
    I.Qg = function () {
        var a = {}, b;
        for (b in this.we)a[b] = this.we[b];
        return a
    };
    I.Sw = function () {
        var a = google[v].M.bm(google[v].M.cm());
        this.Xl = a.vq;
        google[v].M.Dq(this.we, a[ic]) || (this.we = a[ic], this.wq())
    };
    I.wq = function () {
        this.dm = !0;
        this.Ow(this.Qg());
        this.dm = !1
    };
    google[v].M.cm = function () {
        var a = window[bc][mc], b = a[Qc]("#");
        return 0 > b ? "" : a[rd](b + 1)
    };
    google[v].M.km = function (a) {
        return!!google[v].M.mx[a]
    };
    google[v].M.Dq = function (a, b) {
        for (var d in a)if (a[d] !== b[d])return!1;
        for (d in b)if (!a[dc](d))return!1;
        return!0
    };
    google[v].M.Vw = function (a) {
        var b = {}, d;
        for (d in a)google[v].M.km(d) && (b[d] = a[d]);
        return b
    };
    google[v].M.Ww = function (a) {
        var b = [], d;
        for (d in a)null != a[d] && google[v].M.km(d) && b[C](c(d) + "=" + c(a[d]));
        return b[xd]("&")
    };
    google[v].M.bm = function (a) {
        var b = {};
        a = a[Yb]("&");
        for (var d = [], e = 0; e < a[F]; e++) {
            var g = a[e], f = g[Qc]("="), k = !1;
            if (-1 != f) {
                var l = ua(g[Rb](0, f));
                google[v].M.km(l) && (f = ua(g[Rb](f + 1)), google[v].M.fx[l] ? (f = qa(f, 10), fa(f) || (b[l] = f)) : b[l] = f, k = !0)
            }
            k || d[C](g)
        }
        return{state: b, vq: d[xd]("&")}
    };
    google[v].Jh = function (a, b) {
        this.size = b || google[v].Jh.Nx;
        this[qc]()
    };
    google[v].Jh.Nx = 20;
    google[v].Jh[G].reset = function () {
        this.Bj = null;
        for (var a = 0; a < this.size; a++)this.Ix(new google[v].fr);
        this.$q = {};
        this.dr = null
    };
    google[v].Jh[G].Ix = function (a) {
        a.next = this.Bj;
        a.hr = null;
        null == this.Bj || (this.Bj.hr = a);
        this.Bj = a
    };
    google[v].Jh[G].put = function (a, b) {
        var d;
        a in this.$q && (d = this.$q[a], d.set(a, b), this.dr == d && (this.dr = null))
    };
    google[v].fr = function () {
        this.hr = this.next = null
    };
    google[v].fr[G].set = function () {
    };
    google[v].A = function () {
        this.ht = google[v].A.Al;
        google[v].A.Al += 1;
        this.Hc = null;
        this.Ui = !0;
        this.wa = {width: 100, height: 75};
        this.Wc = google[v].A.Kf;
        this.Ej = 1;
        this.Da(google[v].A.$b);
        this.jl();
        this.gwsUrl = this.va = this.Na = this.pa = this.Hf = this.Yb = this.yl = this.Oi = this.zl = this.le = null;
        this.gd = [];
        this.fh = {};
        this.Kd = this.Ye = "";
        var a;
        if ("object" === typeof window && window[bc] && window[bc][fc] && "" != window[bc][fc]) {
            if ("" == Qg) {
                var b = window[bc][fc][yd]()[Yb](".");
                2 > b[F] && (Qg = ".com");
                a = b.pop();
                b = b.pop();
                Qg = 2 == a[F] ? Rg[b] &&
                    1 == Rg[b][a] ? "." + b + "." + a : "." + a : ".com"
            }
            a = Qg
        } else a = ".com";
        this.Fo = a;
        this.Rd = this.td = null;
        this.N = !1
    };
    Bd("google.search.Search", google[v].A, void 0);
    google[v].A.Al = 0;
    google[v].A.mp = google[pd][Yc];
    google[v].A.BASE = google[v].A.mp;
    google[v].A.Rv = /style=([^&]*)/;
    google[v].A.vc = "large";
    google[v].A.LARGE_RESULTSET = google[v].A.vc;
    google[v].A.$b = "small";
    google[v].A.SMALL_RESULTSET = google[v].A.$b;
    google[v].A.Jc = "filtered_cse";
    google[v].A.FILTERED_CSE_RESULTSET = google[v].A.Jc;
    google[v].A.Cp = 8;
    google[v].A.LARGE_RESULTS = google[v].A.Cp;
    google[v].A.Kl = 4;
    google[v].A.SMALL_RESULTS = google[v].A.Kl;
    google[v].A.Bp = 10;
    google[v].A.FILTERED_CSE_RESULTS = google[v].A.Bp;
    google[v].A.Vx = "_top";
    google[v].A.LINK_TARGET_TOP = google[v].A.Vx;
    google[v].A.yn = "_self";
    google[v].A.LINK_TARGET_SELF = google[v].A.yn;
    google[v].A.Ux = "_parent";
    google[v].A.LINK_TARGET_PARENT = google[v].A.Ux;
    google[v].A.Kf = "_blank";
    google[v].A.LINK_TARGET_BLANK = google[v].A.Kf;
    google[v].A.ph = "order-by-relevance";
    google[v].A.ORDER_BY_RELEVANCE = google[v].A.ph;
    google[v].A.md = "order-by-date";
    google[v].A.ORDER_BY_DATE = google[v].A.md;
    google[v].A.Lp = "order-by-ascending-date";
    google[v].A.ORDER_BY_ASCENDING_DATE = google[v].A.Lp;
    google[v].A.bj = "restrict-type";
    google[v].A.RESTRICT_TYPE = google[v].A.bj;
    google[v].A.Ya = "restrict-safesearch";
    google[v].A.RESTRICT_SAFESEARCH = google[v].A.Ya;
    google[v].A.Wf = "active";
    google[v].A.SAFESEARCH_STRICT = google[v].A.Wf;
    google[v].A.Vf = "off";
    google[v].A.SAFESEARCH_OFF = google[v].A.Vf;
    google[v].A.Cl = "moderate";
    google[v].A.SAFESEARCH_MODERATE = google[v].A.Cl;
    google[v].A.Ka = "restrict-extended";
    google[v].A.RESTRICT_EXTENDED_ARGS = google[v].A.Ka;
    google[v].A.iv = 5E3;
    google[v].A.mv = google[pd].ApiaryBase ? google[pd].ApiaryBase : "https://www.googleapis.com/customsearch/v1element";
    google[v].A.nv = "AIzaSyCVAXiUzRYsML1Pv6RwSG1gunmMikTzQqY";
    google[v].A.gp = !1;
    google[v].A.Ky = P;
    google[v].A.strings = google[v].A.Ky;
    google[v].A[G].Ih = function () {
    };
    google[v].A.Dk = function () {
        if (google[v].LoadArgs) {
            var a = ua(google[v].LoadArgs)[yb](google[v].A.Rv);
            if (a && a[1])return a[1]
        }
        return null
    };
    google[v].A.mt = function (a) {
        a = !!a || /\/v2\/default\.css$/[zc](google[v].A.Dk() || "");
        return{sf: a, Xi: a, Xf: a, Om: a, Ip: a}
    };
    google[v].A[G].Qi = function (a) {
        a.Na = this.Na;
        a.lf = this.lf;
        a.Wc = this.Wc;
        a.La = this.La;
        a.Yb = this.Yb;
        a.Ui = this.Ui;
        this.wa && (a.wa = {}, wa(a.wa, this.wa[lb]), Ia(a.wa, this.wa[uc]));
        a.Oh = this.Oh;
        a.gb = this.gb
    };
    google[v].A[G].sv = function () {
        var a = this.uc + "?hl=" + google[v][vd] + "&source=uds", a = this.va ? a + this.va : a + "&q=";
        return this.jd && "" != this.jd ? this.jd : a
    };
    google[v].A[G].Hb = function (a) {
        this.Na = null == a || "" == a ? null : a
    };
    google[v].A[G].setQueryAddition = google[v].A[G].Hb;
    google[v].A[G].Rc = function (a, b) {
        var d = google[v].A.mp + this.Ic + "?callback=" + a + "&rsz=" + this.La + "&hl=" + google[v][vd];
        this.gb && this.N && (d = google[v].A.mv + "?key=" + google[v].A.nv + "&rsz=" + this.La + "&num=" + this.ld() + "&hl=" + google[v][vd] + "&prettyPrint=false");
        this.lf && (d += "&source=" + c(this.lf));
        this.Fo && (d += "&gss=" + this.Fo);
        google[v].JSHash && (d += "&sig=" + google[v].JSHash);
        b && (d += "&start=" + b);
        return d
    };
    google[v].A[G].Ey = function (a) {
        this.lf = a
    };
    google[v].A[G].setSearcherSrc = google[v].A[G].Ey;
    google[v].A[G].Pa = function (a) {
        this.Wc = a
    };
    google[v].A[G].setLinkTarget = google[v].A[G].Pa;
    google[v].A[G].za = function () {
        return this.Wc && "" != this.Wc ? this.Wc : null
    };
    google[v].A[G].$d = function () {
        null == this.le && (this.le = "gsc-" + this.pa + "Result");
        return this.le
    };
    google[v].A[G].Md = function () {
        null == this.zl && (this.zl = "gs-" + this.pa + "Result");
        return this.zl
    };
    google[v].A[G].El = function () {
        null == this.Oi && (this.Oi = P[this.pa]);
        return this.Yb ? this.Yb : this.Oi
    };
    google[v].A[G].getTabLabel = google[v].A[G].El;
    google[v].A[G].Xu = function () {
        null == this.yl && (this.yl = P[this.pa]);
        return this.Yb ? this.Yb : this.yl
    };
    google[v].A[G].py = function () {
        return this.La
    };
    google[v].A[G].getResultSetSize = google[v].A[G].py;
    google[v].A[G].Da = function (a) {
        fa(qa(a, 10)) || (a = qa(a, 10));
        if (0 < a && 8 >= a)this.La = a; else switch (a) {
            case google[v].A.vc:
                this.La = google[v].A.vc;
                break;
            default:
            case google[v].A.$b:
                this.La = google[v].A.$b
        }
    };
    google[v].A[G].setResultSetSize = google[v].A[G].Da;
    google[v].A[G].ra = function (a, b, d) {
        var e = void 0;
        if (d && 0 < d)if (this[Sb] && this[Sb].pages && this[Sb].pages[d - 1] && this[Sb].pages[d - 1].start)e = this[Sb].pages[d - 1].start; else {
            var g = this.ld();
            g && (e = g * (d - 1))
        }
        d = this.fc(a, void 0, e);
        (b = Zg(b)) && (d += "&" + b);
        window._googleudsextrastuff && (d += window._googleudsextrastuff);
        b = this.fh[dc](d);
        if (d == this.Kd && !b)return this.dp(), !1;
        e = (new Date)[Nb]();
        if (b && e - this.fh[d] < google[v].A.iv)return!1;
        b && (e = -1);
        this.fh[d] = e;
        this.cursor = null;
        this.Ye = a;
        this.Kd = d;
        this.Vd = this.jp ? this.jp() :
            null;
        this.gb && this.N ? pg(google[v].A.hp(this, d)) : kg(this.ip(a, d), google[v][ed]);
        if (this.gd && 0 < this.gd[F])for (b = 0; b < this.gd[F]; b++)this.gd[b].ra(a);
        return!0
    };
    google[v].A[G].execute = google[v].A[G].ra;
    google[v].A.hp = function (a, b) {
        var d = "apiary" + na[mb](2E4 * na[kc]());
        google[v].A[d] = function (e) {
            var g = 200, f = null;
            e.error && (g = e.error.code, f = e.error.message);
            a.pb(e, g, f, g, b);
            delete google[v].A[d]
        };
        return b + "&callback=google.search.Search." + d
    };
    google[v].A[G].ip = function (a, b) {
        var d;
        d = b + (this.Vd ? "&" + this.Vd : "");
        var e = this.Cc(a, b);
        return d += "&context=" + e
    };
    google[v].A[G].kp = function (a) {
        this[Sb] && a < this[Sb].pages[F] && (a = this.fc(this.Ye, void 0, this[Sb].pages[a].start), this.cursor = null, this.Kd = a, this.gb && this.N ? pg(google[v].A.hp(this, a)) : kg(this.ip(this.Ye, a), google[v][ed]))
    };
    google[v].A[G].gotoPage = google[v].A[G].kp;
    google[v].A[G].ij = function () {
        return this[Sb] && null != this[Sb].currentPageIndex ? this[Sb].currentPageIndex + 1 : null
    };
    google[v].A[G].ld = function () {
        return fa(qa(this.La, 10)) ? this.La == google[v].A.$b ? google[v].A.Kl : this.La == google[v].A.vc ? google[v].A.Cp : this.La == google[v].A.Jc ? google[v].A.Bp : google[v].A.Kl : this.La
    };
    google[v].A[G].getNumResultsPerPage = google[v].A[G].ld;
    google[v].A[G].Yx = function (a) {
        this.gd && this.gd[C](a)
    };
    google[v].A[G].addRelatedSearcher = google[v].A[G].Yx;
    google[v].A[G].ly = function (a, b, d) {
        b = this.fc(a, b);
        if (null == d || void 0 == d)d = this.Cc(a, b);
        return b + ("&context=" + d) + "&key=" + google[pd].ApiKey + "&v=" + google[v][ed]
    };
    google[v].A[G].getExecuteUrl = google[v].A[G].ly;
    google[v].A[G].Pc = function (a) {
        var b = Eg("http://code.google.com/apis/ajaxsearch/faq.html", P.watermark + " - " + this.dy(), "_blank", "gs-watermark");
        Q(a, b)
    };
    google[v].A[G].dy = function () {
        var a = new Date;
        return a.getMonth() + 1 + "/" + a.getFullYear()
    };
    google[v].A[G].wf = function (a) {
        var b;
        b = a.getFullYear();
        var d = a.getMonth(), e = P["month-abbr"][d];
        a = a.getDate();
        10 > a && (a = "0" + a);
        switch (google[v].ShortDatePattern) {
            case "MDY":
                b = e + " " + a + ", " + b;
                break;
            case "YMD":
                "zh-CN" == google[v][vd] || "zh-TW" == google[v][vd] || "ja" == google[v][vd] || "ko" == google[v][vd] ? (e = mh[google[v][vd]], b = b + e.year + (d + 1) + e.month + a + e.day) : b = b + " " + e + " " + a;
                break;
            default:
            case "DMY":
                b = a + " " + e + " " + b
        }
        return b
    };
    google[v].A[G].formatToShortDate = google[v].A[G].wf;
    var mh = {"zh-CN": {month: " \u6708 ", year: " \u5e74 ", day: " \u65e5 "}, "zh-TW": {month: " \u6708 ", year: " \u5e74 ", day: " \u65e5 "}, ja: {month: "\u6708", year: "\u5e74", day: "\u65e5"}, ko: {month: " \uc6d4 ", year: " \ub144 ", day: " \uc77c "}};
    google[v].A.Np = 36E5;
    google[v].A.Nv = 6E4;
    google[v].A.Mv = 864E5;
    google[v].A[G].gm = function (a) {
        var b = (new Date)[Nb](), d = a[Nb]();
        if (b < d)return P["n-minutes-ago"](2);
        b -= d;
        return b < google[v].A.Np ? (a = na[mb](b / google[v].A.Nv), P["n-minutes-ago"](1 >= a ? 2 : a)) : b < google[v].A.Mv ? (a = na[mb](b / google[v].A.Np), 1 >= a ? P["one-hour-ago"] : P["n-hours-ago"](a)) : this.wf(a)
    };
    google[v].A[G].formatToRelativeDate = google[v].A[G].gm;
    google[v].A[G].jl = function () {
        this.gwsUrl = null;
        this.results = []
    };
    google[v].A[G].clearResults = google[v].A[G].jl;
    google[v].A[G].dp = function () {
        this.or && this.or()
    };
    google[v].A[G].tv = function (a, b) {
        if (a && 0 <= a) {
            var d = (new Date)[Nb](), e = d - a, g = b - a, f = [];
            if (1 == d % 100)if (this.N)f[C]("asa_" + this.pa + "_cse"), this.gb && (google[v].A.gp ? f[C]("asa_" + this.pa + "_cse_apiary_sub") : f[C]("asa_" + this.pa + "_cse_apiary_first")); else f[C]("asa_" + this.pa);
            0 < f[F] && google[pd].recordCsiStat(f, ["req." + e, "req2." + g])
        }
    };
    google[v].A[G].pb = function (a, b, d, e, g) {
        d = (new Date)[Nb]();
        var f;
        g && (f = this.fh[g], delete this.fh[g]);
        if (!g || !this.Kd || g == this.Kd) {
            this.gwsUrl = null;
            if (this.results && 0 < this.results[F])for (g = 0; g < this.results[F]; g++)this.results[g].html && nh(this.results[g].html);
            a && a.results && 0 < a.results[F] ? (this.results = a.results, a[Sb] && a[Sb].moreResultsUrl ? this.gwsUrl = this.jd && "" != this.jd ? this.jd : a[Sb].moreResultsUrl : this.va && this.uc && (this.gwsUrl = this.sv())) : this.results = [];
            this.completionStatus = b;
            this.hashStatus = e;
            this.up = a && a.resultAttribution && null != a.resultAttribution && "" != a.resultAttribution ? a.resultAttribution : null;
            a && a[Sb] && a[Sb].pages && 0 < a[Sb].pages[F] ? this.cursor = a[Sb] : "undefined" != typeof this[Sb] && delete this[Sb];
            if (a && a.context) {
                this.context = a.context;
                b = [];
                if (a.context.facets && 0 < qa(a.context.total_results, 10)) {
                    for (g = 0; g < a.context.facets[F]; g++)if (a.context.facets[g].facet_search_label) {
                        e = a.context.facets[g];
                        var k = qa(e[cc], 10);
                        0 < k && (e.count = k, wa(e, na.ceil(100 * k / qa(a.context.total_results, 10))), b[C](e))
                    }
                    0 <
                    b[F] && b[od](function (a, b) {
                        return b[cc] - a[cc]
                    })
                }
                this.context.display_facets = b
            } else"undefined" != typeof this.context && delete this.context;
            a && a.promotions ? this.promotions = a.promotions : "undefined" != typeof this.promotions && delete this.promotions;
            a && a.omittedResults ? this.omittedResults = a.omittedResults : "undefined" != typeof this.omittedResults && delete this.omittedResults;
            a && a.spelling ? this.spelling = a.spelling : "undefined" != typeof this.spelling && delete this.spelling;
            this.Ui && this.rv();
            this.dp();
            this.tv(f, d);
            this.gb && (google[v].A.gp = !0)
        }
    };
    google[v].A[G].onSearchComplete = google[v].A[G].pb;
    google[v].A[G].Sm = function () {
        var a = null;
        this.up && (a = U(this.up, "gs-results-attribution"));
        return a
    };
    google[v].A[G].getAttribution = google[v].A[G].Sm;
    google[v].A[G].uq = function (a) {
        this.Oh = a
    };
    google[v].A[G].rv = function () {
        var a, b;
        for (a = 0; a < this.results[F]; a++)b = this.results[a], this.Ra(b);
        (a = this.context) && this.Ih(a)
    };
    google[v].A[G].dh = function (a, b, d) {
        d || (d = [null]);
        this.or = ng(a, b, d)
    };
    google[v].A[G].setSearchCompleteCallback = google[v].A[G].dh;
    google[v].A[G].Mu = function (a, b) {
        this.jp = ng(a, b)
    };
    google[v].A.Nc = function (a, b, d) {
        return 3 == a[b][F] ? new google[v].nr(a[b][1] || d && d.prefetchQuery, a[b][2], a[b][0], d) : new google[v].nr("", "", a[b], d)
    };
    google[v].A.Sb = function (a, b) {
        var d;
        if (a[F])for (var e = 0; e < a[F]; e++)if (null == a[e]) {
            a[e] = b;
            d = e;
            break
        }
        d || (d = a[F], a[C](b));
        return d
    };
    google[v].A.AllocateCompletionMapContext = google[v].A.Sb;
    google[v].A[G].jc = function (a) {
        this.Yb = a
    };
    google[v].A[G].setUserDefinedLabel = google[v].A[G].jc;
    google[v].A[G].Gy = function (a) {
        this.Hf = a
    };
    google[v].A[G].setUserDefinedClassSuffix = google[v].A[G].Gy;
    google[v].A[G].zy = function () {
        this.Ui = !1
    };
    google[v].A[G].setNoHtmlGeneration = google[v].A[G].zy;
    google[v].A.Zb = function (a, b, d, e, g) {
        var f = na.min(d[lb] / a, d[uc] / b), f = na.min(f, 1), k = {};
        wa(k, na[Jc](a * f));
        Ia(k, na[Jc](b * f));
        e && (wa(e, k[lb]), Ia(e, k[uc]), g && Ra(e[u], (d[lb] - k[lb]) / 2 + "px"));
        return k
    };
    google[v].A.scaleImage = google[v].A.Zb;
    google[v].A.Pp = 1;
    google[v].A.VERTICAL_BRANDING = google[v].A.Pp;
    google[v].A.Sx = 2;
    google[v].A.HORIZONTAL_BRANDING = google[v].A.Sx;
    google[v].A.ky = function (a, b, d) {
        return Wg("gsc-", a, b && b == google[v].A.Pp, d)
    };
    google[v].A.getBranding = google[v].A.ky;
    google[v].A.setOnLoadCallback = function (a, b) {
        google.setOnLoadCallback(a, b)
    };
    google[v].A.setOnLoadCallback = google[v].A.setOnLoadCallback;
    var oh;

    function nh(a) {
        oh || (oh = h[t]("DIV"));
        oh[p](a);
        Oa(oh, "")
    }

    google[v].A[G].wr = function (a) {
        var b = this.td;
        a && (b = a);
        a = {};
        var d = W(this.Md());
        $(d, "gs-result");
        $(d, "gs-error-result");
        b = U(b, "gs-snippet");
        Q(d, b);
        a.html = d;
        return a
    };
    google[v].A[G].xr = function (a) {
        var b = this.Rd;
        a && (b = a);
        a = {};
        var d = W(this.Md());
        $(d, "gs-result");
        $(d, "gs-no-results-result");
        b = U(b, "gs-snippet");
        Q(d, b);
        a.html = d;
        return a
    };
    google[v].A[G].Ep = function (a) {
        this.wa = a
    };
    google[v].A[G].ny = function () {
        return this.Kd
    };
    google[v].A[G].getLastQueryUrl = google[v].A[G].ny;
    google[v].nr = function (a, b, d) {
        this.Zh = a;
        this.Lc = b;
        this.Mc = d
    };
    da("google.search.CurrentLocale", ta);
    da("google.search.ShortDatePattern", ea);
    google[v].Aa = function () {
        google[v].A[kd](this);
        this.pa = "blog";
        this.Ic = "/GblogSearch";
        this.uc = "http://blogsearch.google.com/blogsearch";
        this.Mb = null;
        this.Nb = !1;
        this.pf = !0;
        this.Hc = rg(this, google[v].Aa[G].kd);
        this.We = "gsc-blogConfig";
        this.na = null
    };
    Bd("google.search.BlogSearch", google[v].Aa, void 0);
    jg(google[v].Aa, google[v].A);
    google[v].Aa.Wa = "GblogSearch";
    google[v].Aa.RESULT_CLASS = google[v].Aa.Wa;
    google[v].Aa.$ = [];
    google[v].Aa.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].Aa.$, f, b);
        google[v].Aa.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].Aa.RawCompletion = google[v].Aa.Ta;
    google[v].Aa[G].Cc = function (a, b) {
        return google[v].A.Sb(google[v].Aa.$, [this, a, b])
    };
    google[v].Aa[G].fc = function (a, b, d) {
        b = this.Rc(null == b ? "google.search.BlogSearch.RawCompletion" : b, d);
        this.Na && (a = a + " " + this.Na);
        this.Mb && (a = a + " blogurl:" + this.Mb);
        a = "&q=" + c(a);
        this.Nb && (a += "&scoring=d");
        this.va = a;
        return b + a
    };
    google[v].Aa[G].Ra = function (a) {
        a.html && delete a.html;
        var b = W(this.Md());
        $(b, "gs-result");
        var d;
        d = Eg(a.postUrl, a[bd], this.za(), "gs-title");
        Q(b, d);
        d = new Date(a.publishedDate);
        d = U(this.wf(d), "gs-publishedDate");
        Q(b, d);
        d = new Date(a.publishedDate);
        d = U(this.gm(d), "gs-relativePublishedDate");
        Q(b, d);
        d = U(a[nb], "gs-snippet");
        Q(b, d);
        d = Eg(a.blogUrl, a.blogUrl, this.za(), "gs-visibleUrl");
        Q(b, d);
        a.html = b;
        this.Pc(a.html)
    };
    google[v].Aa[G].createResultHtml = google[v].Aa[G].Ra;
    google[v].Aa[G].Ub = function (a) {
        this.Mb = null == a || "" == a ? null : a
    };
    google[v].Aa[G].setSiteRestriction = google[v].Aa[G].Ub;
    google[v].Aa[G].Ib = function (a) {
        this.Nb = a == google[v].A.md ? !0 : !1
    };
    google[v].Aa[G].setResultOrder = google[v].Aa[G].Ib;
    google[v].Aa[G].kd = function (a, b) {
        if (b) {
            if (null == this.na) {
                var d = W("gsc-configSetting");
                this.na = Kg(null, "0", this.Nb, "gsc-configSettingCheckbox");
                Q(d, this.na);
                Q(d, U(P["sort-by-date"], "gsc-configSettingCheckboxLabel"));
                var e = W("gsc-configSettingSubmit");
                Q(e, Hg(P[gc], "gsc-configSettingSubmit"));
                Q(d, e);
                Q(a, d)
            } else Aa(this.na, this.Nb);
            this.na[Ab]()
        } else this.na && (this.na[Tb] ? this.Ib(google[v].A.md) : this.Ib(google[v].A.ph))
    };
    google[v].ka = function () {
        google[v].A[kd](this);
        this.pa = "book";
        this.Ic = "/GbookSearch";
        this.uc = "http://books.google.com/books";
        this.dj = !1;
        this.ej = null
    };
    Bd("google.search.BookSearch", google[v].ka, void 0);
    jg(google[v].ka, google[v].A);
    google[v].ka.Wa = "GbookSearch";
    google[v].ka.RESULT_CLASS = google[v].ka.Wa;
    google[v].ka.zp = "user-list";
    google[v].ka.USER_LIST = google[v].ka.zp;
    google[v].ka.xp = 1;
    google[v].ka.TYPE_ALL_BOOKS = google[v].ka.xp;
    google[v].ka.yp = 2;
    google[v].ka.TYPE_FULL_VIEW_BOOKS = google[v].ka.yp;
    google[v].ka.$ = [];
    google[v].ka.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].ka.$, f, b);
        google[v].ka.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].ka.RawCompletion = google[v].ka.Ta;
    google[v].ka[G].Cc = function (a, b) {
        return google[v].A.Sb(google[v].ka.$, [this, a, b])
    };
    google[v].ka[G].fc = function (a, b, d) {
        b = this.Rc(null == b ? "google.search.BookSearch.RawCompletion" : b, d);
        this.Na && (a = a + " " + this.Na);
        a = "&q=" + c(a);
        this.dj && (a += "&as_brr=1");
        this.ej && (a = a + "&as_list=" + this.ej);
        this.va = a;
        return b + a
    };
    google[v].ka[G].Ra = function (a) {
        a.html && delete a.html;
        a.thumbnailHtml = this.pm(a);
        var b = W(this.Md());
        $(b, "gs-result");
        var d = W("gs-text-box"), e = zg(), g = Ag(e, 0), f = Bg(g, "gs-image-box"), g = Bg(g, "gs-text-box");
        Q(f, a.thumbnailHtml[Fb](!0));
        Q(g, d);
        Q(b, e);
        e = Eg(a.unescapedUrl, a[bd], this.za(), "gs-title");
        Q(d, e);
        e = U(P.by + "&nbsp;" + a.authors, "gs-author");
        Q(d, e);
        e = W("gs-spacer");
        Q(d, e);
        a.publishedYear && (e = U(a.publishedYear, "gs-publishedDate"), Q(d, e));
        0 < qa(a.pageCount, 10) && (e = U("-&nbsp;" + P["page-count"](a.pageCount),
            "gs-pageCount"), Q(d, e));
        e = Eg("http://books.google.com", "books.google.com", this.za(), "gs-visibleUrl");
        Q(d, e);
        a.html = b;
        this.Pc(a.html)
    };
    google[v].ka[G].createResultHtml = google[v].ka[G].Ra;
    google[v].ka[G].pm = function (a) {
        var b = W("gs-image-box gs-book-image-box"), d = W("gs-row-1"), e = Cg("http://books.google.com/googlebooks/pages-trans.gif", null, null, "gs-pages");
        Q(d, e);
        e = Cg("http://books.google.com/googlebooks/p_edge-trans.gif", null, null, "gs-page-edge");
        Q(d, e);
        Q(b, d);
        d = W("gs-row-2");
        e = google[v].A.Zb(a.tbWidth, a.tbHeight, this.wa);
        e = Cg(a.tbUrl, e[lb], e[uc], "gs-image");
        a = Dg(a.unescapedUrl, null, this.za(), "gs-image");
        m(a, "gs-image");
        Q(a, e);
        Q(d, a);
        Q(b, d);
        return b
    };
    google[v].ka[G].Sa = function (a, b) {
        a == google[v].A.bj ? b ? b == google[v].ka.xp ? this.dj = !1 : b == google[v].ka.yp ? this.dj = !0 : this.Sa(a, null) : this.dj = !1 : a == google[v].ka.zp && (b && b[yb](/^[a-zA-Z0-9\-_]*$/) ? this.ej = b : this.ej = null)
    };
    google[v].ka[G].setRestriction = google[v].ka[G].Sa;
    google[v].D = function () {
        google[v].A[kd](this);
        this.Ej = 2;
        this.pa = "image";
        this.Ic = "/GimageSearch";
        this.uc = "http://images.google.com/images";
        this.Ja = null;
        this.fa = {};
        this.tc = this.oc = this.sc = this.qc = this.pc = this.rc = null;
        this.Rb = google[v].D.fd;
        this.P = new google[v].wc;
        this.wa = {width: 112, height: 84}
    };
    Bd("google.search.ImageSearch", google[v].D, void 0);
    jg(google[v].D, google[v].A);
    google[v].D.Wa = "GimageSearch";
    google[v].D.RESULT_CLASS = google[v].D.Wa;
    google[v].D.Hg = "restrict-imagesize";
    google[v].D.RESTRICT_IMAGESIZE = google[v].D.Hg;
    google[v].D.vm = ["icon"];
    google[v].D.IMAGESIZE_SMALL = google[v].D.vm;
    google[v].D.um = ["small", "medium", "large", "xlarge"];
    google[v].D.IMAGESIZE_MEDIUM = google[v].D.um;
    google[v].D.tm = ["xxlarge"];
    google[v].D.IMAGESIZE_LARGE = google[v].D.tm;
    google[v].D.sm = ["huge"];
    google[v].D.IMAGESIZE_EXTRA_LARGE = google[v].D.sm;
    google[v].D.Fg = "restrict-coloration";
    google[v].D.RESTRICT_COLORIZATION = google[v].D.Fg;
    google[v].D.gg = "mono";
    google[v].D.COLORIZATION_BLACK_AND_WHITE = google[v].D.gg;
    google[v].D.ig = "gray";
    google[v].D.COLORIZATION_GRAYSCALE = google[v].D.ig;
    google[v].D.hg = "color";
    google[v].D.COLORIZATION_COLOR = google[v].D.hg;
    google[v].D.Eg = "restrict-colorfilter";
    google[v].D.RESTRICT_COLORFILTER = google[v].D.Eg;
    google[v].D.rg = "red";
    google[v].D.COLOR_RED = google[v].D.rg;
    google[v].D.og = "orange";
    google[v].D.COLOR_ORANGE = google[v].D.og;
    google[v].D.ug = "yellow";
    google[v].D.COLOR_YELLOW = google[v].D.ug;
    google[v].D.ng = "green";
    google[v].D.COLOR_GREEN = google[v].D.ng;
    google[v].D.sg = "teal";
    google[v].D.COLOR_TEAL = google[v].D.sg;
    google[v].D.kg = "blue";
    google[v].D.COLOR_BLUE = google[v].D.kg;
    google[v].D.qg = "purple";
    google[v].D.COLOR_PURPLE = google[v].D.qg;
    google[v].D.pg = "pink";
    google[v].D.COLOR_PINK = google[v].D.pg;
    google[v].D.tg = "white";
    google[v].D.COLOR_WHITE = google[v].D.tg;
    google[v].D.mg = "gray";
    google[v].D.COLOR_GRAY = google[v].D.mg;
    google[v].D.jg = "black";
    google[v].D.COLOR_BLACK = google[v].D.jg;
    google[v].D.lg = "brown";
    google[v].D.COLOR_BROWN = google[v].D.lg;
    google[v].D.Gg = "restrict-filetype";
    google[v].D.RESTRICT_FILETYPE = google[v].D.Gg;
    google[v].D.xg = "jpg";
    google[v].D.FILETYPE_JPG = google[v].D.xg;
    google[v].D.yg = "png";
    google[v].D.FILETYPE_PNG = google[v].D.yg;
    google[v].D.wg = "gif";
    google[v].D.FILETYPE_GIF = google[v].D.wg;
    google[v].D.vg = "bmp";
    google[v].D.FILETYPE_BMP = google[v].D.vg;
    google[v].D.Ig = "restrict-imagetype";
    google[v].D.RESTRICT_IMAGETYPE = google[v].D.Ig;
    google[v].D.Ag = "face";
    google[v].D.IMAGETYPE_FACES = google[v].D.Ag;
    google[v].D.zg = "clipart";
    google[v].D.IMAGETYPE_CLIPART = google[v].D.zg;
    google[v].D.Bg = "lineart";
    google[v].D.IMAGETYPE_LINEART = google[v].D.Bg;
    google[v].D.Cg = "news";
    google[v].D.IMAGETYPE_NEWS = google[v].D.Cg;
    google[v].D.Dg = "photo";
    google[v].D.IMAGETYPE_PHOTO = google[v].D.Dg;
    google[v].D.Jg = "restrict-rights";
    google[v].D.RESTRICT_RIGHTS = google[v].D.Jg;
    google[v].D.Ng = "(cc_publicdomain|cc_attribute|cc_sharealike|cc_noncommercial|cc_nonderived)";
    google[v].D.RIGHTS_REUSE = google[v].D.Ng;
    google[v].D.Lg = "(cc_publicdomain|cc_attribute|cc_sharealike|cc_nonderived).-(cc_noncommercial)";
    google[v].D.RIGHTS_COMMERCIAL_REUSE = google[v].D.Lg;
    google[v].D.Mg = "(cc_publicdomain|cc_attribute|cc_sharealike|cc_noncommercial).-(cc_nonderived)";
    google[v].D.RIGHTS_MODIFICATION = google[v].D.Mg;
    google[v].D.Kg = "(cc_publicdomain|cc_attribute|cc_sharealike).-(cc_noncommercial|cc_nonderived)";
    google[v].D.RIGHTS_COMMERCIAL_MODIFICATION = google[v].D.Kg;
    google[v].D.bh = 20;
    google[v].D.CSE_LARGE_RESULTSET = google[v].D.bh;
    google[v].D.Id = "popup";
    google[v].D.LAYOUT_POPUP = google[v].D.Id;
    google[v].D.qe = "column";
    google[v].D.LAYOUT_COLUMN = google[v].D.qe;
    google[v].D.fd = "classic";
    google[v].D.LAYOUT_CLASSIC = google[v].D.fd;
    google[v].D.$ = [];
    google[v].D.de = {as_dt: !0, as_epq: !0, as_eq: !0, as_lq: !0, as_nlo: !0, as_nhi: !0, as_oq: !0, as_q: !0, as_qdr: !0, as_rq: !0, as_sitesearch: !0, cr: !0, c2coff: !0, filter: !0, gl: !0, hq: !0, lr: !0, query: !0, sort: !0};
    I = google[v].D[G];
    I.rj = function () {
        var a = new google[v].D;
        this.Qi(a);
        a.Ja = this.Ja;
        a.fa = this.fa;
        a.rc = this.rc;
        a.pc = this.pc;
        a.qc = this.qc;
        a.sc = this.sc;
        a.oc = this.oc;
        a.tc = this.tc;
        a.Xe(this.Rb);
        a.P = this.P.je();
        a.N = this.N;
        return a
    };
    I.pd = function (a) {
        a = Yg(a);
        return a[r](/\s+/g, "_")[yd]()
    };
    I.Yd = function (a) {
        return this.N ? this.P.Ha == this.pd(a) : !1
    };
    I.Bc = function (a) {
        return this.N && this.P.Ha ? a[r](new RegExp(" more:" + this.P.Ha + "$"), "") : a
    };
    I.$d = function () {
        return this.le = ["gsc-" + this.pa + "Result", "gsc-" + this.pa + "Result-" + this.Rb][xd](" ")
    };
    google[v].D.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].D.$, f, b);
        google[v].D.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].D.RawCompletion = google[v].D.Ta;
    google[v].D[G].Cc = function (a, b) {
        return google[v].A.Sb(google[v].D.$, [this, a, b])
    };
    google[v].D[G].fc = function (a, b, d) {
        b = this.Rc(null == b ? "google.search.ImageSearch.RawCompletion" : b, d);
        this.gb && this.N && (b += "&searchtype=image");
        a = [a];
        this.Na && a[C](this.Na);
        a = a[tb](this.P.se())[xd](" ");
        var e = this.P.re(), g = [], f;
        for (f in e)g[C](f + "=" + e[f]);
        f = "&" + g[xd]("&");
        f = f + "&q=" + c(a);
        this.Ja && (f = f + "&safe=" + this.Ja);
        this.rc && (f = f + "&imgsz=" + c(this.rc));
        this.pc && (f = f + "&imgc=" + c(this.pc));
        this.qc && (f = f + "&imgcolor=" + c(this.qc));
        this.sc && (f = f + "&imgtype=" + c(this.sc));
        this.oc && (f = f + "&as_filetype=" + c(this.oc));
        this.tc && (f = f + "&as_rights=" + c(this.tc));
        this.Mb && (f = f + "&as_sitesearch=" + c(this.Mb));
        this.fa && (a = Zg(this.fa)) && (f += "&" + a);
        b += f;
        this.va = f;
        d && 0 != d && (this.va = this.va + "&start=" + d);
        window.google[pd].GoogleLocale && this.gb && this.N && (b += "&googlehost=" + c(window.google[pd].GoogleLocale));
        return b
    };
    google[v].D[G].Ra = function (a) {
        a.html && delete a.html;
        cb(a, this.za() || void 0);
        a.html = google[v].ga.la("imageResult_" + this.Rb, a);
        for (var b = google[v].D.Zb(a.tbWidth, a.tbHeight, this.wa), d = a.html[Cb]; d; d = d[Mb])if (1 == d[Kc]) {
            for (var e = d[Pb]("img"), g = [], f = 0, k = e[0]; k = e[f]; ++f)g[f] = k;
            "IMG" == d[pc].toUpperCase() && g[C](d);
            for (e = 0; k = g[e]; ++e)Og(k, "gs-image-scalable") && (wa(k[u], b[lb] + "px"), Ia(k[u], b[uc] + "px"))
        }
        this.Pc(a.html)
    };
    google[v].D[G].createResultHtml = google[v].D[G].Ra;
    google[v].D[G].ym = function () {
        return this.Rb
    };
    google[v].D[G].getLayout = google[v].D[G].ym;
    google[v].D[G].Xe = function (a) {
        if (a == google[v].D.fd || a == google[v].D.qe || a == google[v].D.Id) {
            var b = this.results;
            if (this.Rb != a && b)for (var d = 0; d < b[F]; d++) {
                var e = b[d];
                e.html && delete e.html
            }
            this.Rb = a;
            a == google[v].D.fd ? this.wa = {width: 112, height: 84} : a == google[v].D.qe ? this.wa = {width: 112, height: 168} : a == google[v].D.Id && (this.wa = {width: 224, height: 84})
        }
    };
    google[v].D[G].setLayout = google[v].D[G].Xe;
    google[v].D[G].Ub = function (a, b) {
        this.P = google[v].Ac.jj(a, b);
        this.P instanceof google[v].Tc && (this.N = !0, this.P[Wc]() == google[v].K.Sc && (this.td = P["linked-cse-error-results"]))
    };
    google[v].D[G].setSiteRestriction = google[v].D[G].Ub;
    I = google[v].D[G];
    I.uh = function () {
        return this.N ? this.P[Wc]() : null
    };
    I.vh = function () {
        return this.N ? this.P.zf : null
    };
    I.nc = function () {
        return this.N ? this.P.Ha : null
    };
    I.sj = function (a) {
        this.N && a && this.P.xj(a)
    };
    I.Da = function (a) {
        fa(qa(a, 10)) || (a = qa(a, 10));
        this.N && (0 < a && a <= google[v].D.bh || google[v].A.Jc == a) ? this.La = a : google[v].A[G].Da[kd](this, a)
    };
    google[v].D[G].setResultSetSize = google[v].D[G].Da;
    google[v].D[G].ld = function () {
        var a = google[v].A[G].ld[kd](this);
        return this.N && a && "number" != typeof this.La ? 2 * a : a
    };
    google[v].D[G].getNumResultsPerPage = google[v].D[G].ld;
    google[v].D[G].Sa = function (a, b) {
        a == google[v].A.Ya ? this.Ja = b ? b == google[v].A.Wf || b == google[v].A.Vf ? b : null : null : a == google[v].D.Hg ? this.rc = b ? b[xd]("|") : null : a == google[v].D.Fg ? this.pc = b ? b == google[v].D.gg || b == google[v].D.ig || b == google[v].D.hg ? b : null : null : a == google[v].D.Eg ? this.qc = b ? b == google[v].D.rg || b == google[v].D.og || b == google[v].D.ug || b == google[v].D.ng || b == google[v].D.sg || b == google[v].D.kg || b == google[v].D.qg || b == google[v].D.pg || b == google[v].D.tg || b == google[v].D.mg || b == google[v].D.jg || b == google[v].D.lg ?
            b : null : null : a == google[v].D.Gg ? this.oc = b ? b == google[v].D.xg || b == google[v].D.yg || b == google[v].D.wg || b == google[v].D.vg ? b : null : null : a == google[v].D.Ig ? this.sc = b ? b == google[v].D.Ag || b == google[v].D.zg || b == google[v].D.Bg || b == google[v].D.Cg || b == google[v].D.Dg ? b : null : null : a == google[v].D.Jg && (this.tc = b ? b == google[v].D.Ng || b == google[v].D.Lg || b == google[v].D.Mg || b == google[v].D.Kg ? b : null : null);
        if (a == google[v].A.Ka)if (b)for (var d in b) {
            var e = b[d];
            google[v].D.de[d] && (this.fa[d] = e)
        } else this.fa = {}
    };
    google[v].D[G].setRestriction = google[v].D[G].Sa;
    google[v].D.Zb = function (a, b, d, e, g) {
        var f = na.min(d[lb] / a, d[uc] / b), k = {};
        wa(k, na[Jc](a * f));
        Ia(k, na[Jc](b * f));
        e && (wa(e, k[lb]), Ia(e, k[uc]), g && Ra(e[u], (d[lb] - k[lb]) / 2 + "px"));
        return k
    };
    google[v].D.scaleImage = google[v].D.Zb;
    google[v].D.Cm = function (a) {
        var b = a[Hb][0], d = a[Hb][1];
        if ("block" == d[u][tc])return!1;
        Fa(d[u], "block");
        Xa(a[u], 4E3);
        var e = d[Hb][0], g = d[Hb][1], f = b[Pb]("img")[0], k = d[Pb]("img")[0], l = {width: k[sb], height: k[wc]};
        k[sb] < f[sb] ? l = {width: f[sb], height: 2 * f[wc]} : k[wc] < f[wc] && (l = {width: f[sb], height: f[wc]});
        google[v].D.Zb(k[sb], k[wc], l, k);
        wa(d[u], d[sb] > 2 * b[sb] ? 2 * b[sb] + "px" : na.max(e[sb], g[sb]));
        b = bh(f, a) + f[sb] / 2;
        a = ch(f, a) + f[wc] / 2;
        f = bh(k, d) + k[sb] / 2;
        k = ch(k, d) + k[wc] / 2;
        0 === pa.appName[Qc]("Microsoft") ? (Ra(d[hb](), b - f + "px"),
            d[hb]().top = a - k + "px") : (d.offsetLeft = b - f + "px", d.offsetTop = a - k + "px");
        return!1
    };
    google[v].D.showPopup = google[v].D.Cm;
    google[v].D.zm = function (a) {
        a = a[Hb][1];
        if ("none" == a[u][tc])return!1;
        Fa(a[u], "none");
        Xa(a[ud][u], 0);
        return!1
    };
    google[v].D.hidePopup = google[v].D.zm;
    google[v].D[G].Pa = function (a) {
        google[v].A[G].Pa[kd](this, a)
    };
    google[v].D[G].setLinkTarget = google[v].D[G].Pa;
    google[v].D[G].Hb = function (a) {
        google[v].A[G].Hb[kd](this, a)
    };
    google[v].D[G].setQueryAddition = google[v].D[G].Hb;
    google[v].C = function () {
        google[v].A[kd](this);
        this.Ej = 2;
        this.pa = "image";
        this.Ic = "/GcustomimageSearch";
        this.uc = "http://images.google.com/images";
        this.Ja = null;
        this.fa = {};
        this.tc = this.oc = this.sc = this.qc = this.pc = this.rc = null;
        this.Rb = google[v].C.fd;
        this.P = new google[v].wc;
        this.wa = {width: 112, height: 84}
    };
    Bd("google.search.CustomImageSearch", google[v].C, void 0);
    jg(google[v].C, google[v].A);
    google[v].C.Wa = "GcustomimageSearch";
    google[v].C.RESULT_CLASS = google[v].C.Wa;
    google[v].C.Hg = "restrict-imagesize";
    google[v].C.RESTRICT_IMAGESIZE = google[v].C.Hg;
    google[v].C.vm = ["icon"];
    google[v].C.IMAGESIZE_SMALL = google[v].C.vm;
    google[v].C.um = ["small", "medium", "large", "xlarge"];
    google[v].C.IMAGESIZE_MEDIUM = google[v].C.um;
    google[v].C.tm = ["xxlarge"];
    google[v].C.IMAGESIZE_LARGE = google[v].C.tm;
    google[v].C.sm = ["huge"];
    google[v].C.IMAGESIZE_EXTRA_LARGE = google[v].C.sm;
    google[v].C.Fg = "restrict-coloration";
    google[v].C.RESTRICT_COLORIZATION = google[v].C.Fg;
    google[v].C.gg = "mono";
    google[v].C.COLORIZATION_BLACK_AND_WHITE = google[v].C.gg;
    google[v].C.ig = "gray";
    google[v].C.COLORIZATION_GRAYSCALE = google[v].C.ig;
    google[v].C.hg = "color";
    google[v].C.COLORIZATION_COLOR = google[v].C.hg;
    google[v].C.Eg = "restrict-colorfilter";
    google[v].C.RESTRICT_COLORFILTER = google[v].C.Eg;
    google[v].C.rg = "red";
    google[v].C.COLOR_RED = google[v].C.rg;
    google[v].C.og = "orange";
    google[v].C.COLOR_ORANGE = google[v].C.og;
    google[v].C.ug = "yellow";
    google[v].C.COLOR_YELLOW = google[v].C.ug;
    google[v].C.ng = "green";
    google[v].C.COLOR_GREEN = google[v].C.ng;
    google[v].C.sg = "teal";
    google[v].C.COLOR_TEAL = google[v].C.sg;
    google[v].C.kg = "blue";
    google[v].C.COLOR_BLUE = google[v].C.kg;
    google[v].C.qg = "purple";
    google[v].C.COLOR_PURPLE = google[v].C.qg;
    google[v].C.pg = "pink";
    google[v].C.COLOR_PINK = google[v].C.pg;
    google[v].C.tg = "white";
    google[v].C.COLOR_WHITE = google[v].C.tg;
    google[v].C.mg = "gray";
    google[v].C.COLOR_GRAY = google[v].C.mg;
    google[v].C.jg = "black";
    google[v].C.COLOR_BLACK = google[v].C.jg;
    google[v].C.lg = "brown";
    google[v].C.COLOR_BROWN = google[v].C.lg;
    google[v].C.Gg = "restrict-filetype";
    google[v].C.RESTRICT_FILETYPE = google[v].C.Gg;
    google[v].C.xg = "jpg";
    google[v].C.FILETYPE_JPG = google[v].C.xg;
    google[v].C.yg = "png";
    google[v].C.FILETYPE_PNG = google[v].C.yg;
    google[v].C.wg = "gif";
    google[v].C.FILETYPE_GIF = google[v].C.wg;
    google[v].C.vg = "bmp";
    google[v].C.FILETYPE_BMP = google[v].C.vg;
    google[v].C.Ig = "restrict-imagetype";
    google[v].C.RESTRICT_IMAGETYPE = google[v].C.Ig;
    google[v].C.Ag = "face";
    google[v].C.IMAGETYPE_FACES = google[v].C.Ag;
    google[v].C.zg = "clipart";
    google[v].C.IMAGETYPE_CLIPART = google[v].C.zg;
    google[v].C.Bg = "lineart";
    google[v].C.IMAGETYPE_LINEART = google[v].C.Bg;
    google[v].C.Cg = "news";
    google[v].C.IMAGETYPE_NEWS = google[v].C.Cg;
    google[v].C.Dg = "photo";
    google[v].C.IMAGETYPE_PHOTO = google[v].C.Dg;
    google[v].C.Jg = "restrict-rights";
    google[v].C.RESTRICT_RIGHTS = google[v].C.Jg;
    google[v].C.Ng = "(cc_publicdomain|cc_attribute|cc_sharealike|cc_noncommercial|cc_nonderived)";
    google[v].C.RIGHTS_REUSE = google[v].C.Ng;
    google[v].C.Lg = "(cc_publicdomain|cc_attribute|cc_sharealike|cc_nonderived).-(cc_noncommercial)";
    google[v].C.RIGHTS_COMMERCIAL_REUSE = google[v].C.Lg;
    google[v].C.Mg = "(cc_publicdomain|cc_attribute|cc_sharealike|cc_noncommercial).-(cc_nonderived)";
    google[v].C.RIGHTS_MODIFICATION = google[v].C.Mg;
    google[v].C.Kg = "(cc_publicdomain|cc_attribute|cc_sharealike).-(cc_noncommercial|cc_nonderived)";
    google[v].C.RIGHTS_COMMERCIAL_MODIFICATION = google[v].C.Kg;
    google[v].C.bh = 20;
    google[v].C.CSE_LARGE_RESULTSET = google[v].C.bh;
    google[v].C.Id = "popup";
    google[v].C.LAYOUT_POPUP = google[v].C.Id;
    google[v].C.qe = "column";
    google[v].C.LAYOUT_COLUMN = google[v].C.qe;
    google[v].C.fd = "classic";
    google[v].C.LAYOUT_CLASSIC = google[v].C.fd;
    google[v].C.$ = [];
    google[v].C.de = {as_dt: !0, as_epq: !0, as_eq: !0, as_lq: !0, as_nlo: !0, as_nhi: !0, as_oq: !0, as_q: !0, as_qdr: !0, as_rq: !0, as_sitesearch: !0, cr: !0, c2coff: !0, filter: !0, gl: !0, hq: !0, lr: !0, query: !0, sort: !0};
    I = google[v].C[G];
    I.rj = function () {
        var a = new google[v].C;
        this.Qi(a);
        a.Ja = this.Ja;
        a.fa = this.fa;
        a.rc = this.rc;
        a.pc = this.pc;
        a.qc = this.qc;
        a.sc = this.sc;
        a.oc = this.oc;
        a.tc = this.tc;
        a.Xe(this.Rb);
        a.P = this.P.je();
        a.N = this.N;
        return a
    };
    I.pd = function (a) {
        a = Yg(a);
        return a[r](/\s+/g, "_")[yd]()
    };
    I.Yd = function (a) {
        return this.N ? this.P.Ha == this.pd(a) : !1
    };
    I.Bc = function (a) {
        return this.N && this.P.Ha ? a[r](new RegExp(" more:" + this.P.Ha + "$"), "") : a
    };
    I.$d = function () {
        return this.le = ["gsc-" + this.pa + "Result", "gsc-" + this.pa + "Result-" + this.Rb][xd](" ")
    };
    google[v].C.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].C.$, f, b);
        google[v].C.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].C.RawCompletion = google[v].C.Ta;
    google[v].C[G].Cc = function (a, b) {
        return google[v].A.Sb(google[v].C.$, [this, a, b])
    };
    google[v].C[G].fc = function (a, b, d) {
        b = this.Rc(null == b ? "google.search.CustomImageSearch.RawCompletion" : b, d);
        this.gb && this.N && (b += "&searchtype=image");
        a = [a];
        this.Na && a[C](this.Na);
        a = a[tb](this.P.se())[xd](" ");
        var e = this.P.re(), g = [], f;
        for (f in e)g[C](f + "=" + e[f]);
        f = "&" + g[xd]("&");
        f = f + "&q=" + c(a);
        this.Ja && (f = f + "&safe=" + this.Ja);
        this.rc && (f = f + "&imgsz=" + c(this.rc));
        this.pc && (f = f + "&imgc=" + c(this.pc));
        this.qc && (f = f + "&imgcolor=" + c(this.qc));
        this.sc && (f = f + "&imgtype=" + c(this.sc));
        this.oc && (f = f + "&as_filetype=" +
            c(this.oc));
        this.tc && (f = f + "&as_rights=" + c(this.tc));
        this.Mb && (f = f + "&as_sitesearch=" + c(this.Mb));
        this.fa && (a = Zg(this.fa)) && (f += "&" + a);
        b += f;
        this.va = f;
        d && 0 != d && (this.va = this.va + "&start=" + d);
        window.google[pd].GoogleLocale && this.gb && this.N && (b += "&googlehost=" + c(window.google[pd].GoogleLocale));
        return b
    };
    google[v].C[G].Ra = function (a) {
        a.html && delete a.html;
        cb(a, this.za() || void 0);
        a.html = google[v].ga.la("imageResult_" + this.Rb, a);
        for (var b = google[v].C.Zb(a.tbWidth, a.tbHeight, this.wa), d = a.html[Cb]; d; d = d[Mb])if (1 == d[Kc]) {
            for (var e = d[Pb]("img"), g = [], f = 0, k = e[0]; k = e[f]; ++f)g[f] = k;
            "IMG" == d[pc].toUpperCase() && g[C](d);
            for (e = 0; k = g[e]; ++e)Og(k, "gs-image-scalable") && (wa(k[u], b[lb] + "px"), Ia(k[u], b[uc] + "px"))
        }
        this.Pc(a.html)
    };
    google[v].C[G].createResultHtml = google[v].C[G].Ra;
    google[v].C[G].ym = function () {
        return this.Rb
    };
    google[v].C[G].getLayout = google[v].C[G].ym;
    google[v].C[G].Xe = function (a) {
        if (a == google[v].C.fd || a == google[v].C.qe || a == google[v].C.Id) {
            var b = this.results;
            if (this.Rb != a && b)for (var d = 0; d < b[F]; d++) {
                var e = b[d];
                e.html && delete e.html
            }
            this.Rb = a;
            a == google[v].C.fd ? this.wa = {width: 112, height: 84} : a == google[v].C.qe ? this.wa = {width: 112, height: 168} : a == google[v].C.Id && (this.wa = {width: 224, height: 84})
        }
    };
    google[v].C[G].setLayout = google[v].C[G].Xe;
    google[v].C[G].Ub = function (a, b) {
        this.P = google[v].Ac.jj(a, b);
        this.P instanceof google[v].Tc && (this.N = !0, this.P[Wc]() == google[v].G.Sc && (this.td = P["linked-cse-error-results"]))
    };
    google[v].C[G].setSiteRestriction = google[v].C[G].Ub;
    I = google[v].C[G];
    I.uh = function () {
        return this.N ? this.P[Wc]() : null
    };
    I.vh = function () {
        return this.N ? this.P.zf : null
    };
    I.nc = function () {
        return this.N ? this.P.Ha : null
    };
    I.sj = function (a) {
        this.N && a && this.P.xj(a)
    };
    I.Da = function (a) {
        fa(qa(a, 10)) || (a = qa(a, 10));
        this.N && (0 < a && a <= google[v].C.bh || google[v].A.Jc == a) ? this.La = a : google[v].A[G].Da[kd](this, a)
    };
    google[v].C[G].setResultSetSize = google[v].C[G].Da;
    google[v].C[G].ld = function () {
        var a = google[v].A[G].ld[kd](this);
        return this.N && a && "number" != typeof this.La ? 2 * a : a
    };
    google[v].C[G].getNumResultsPerPage = google[v].C[G].ld;
    google[v].C[G].Sa = function (a, b) {
        a == google[v].A.Ya ? this.Ja = b ? b == google[v].A.Wf || b == google[v].A.Vf ? b : null : null : a == google[v].C.Hg ? this.rc = b ? b[xd]("|") : null : a == google[v].C.Fg ? this.pc = b ? b == google[v].C.gg || b == google[v].C.ig || b == google[v].C.hg ? b : null : null : a == google[v].C.Eg ? this.qc = b ? b == google[v].C.rg || b == google[v].C.og || b == google[v].C.ug || b == google[v].C.ng || b == google[v].C.sg || b == google[v].C.kg || b == google[v].C.qg || b == google[v].C.pg || b == google[v].C.tg || b == google[v].C.mg || b == google[v].C.jg || b == google[v].C.lg ?
            b : null : null : a == google[v].C.Gg ? this.oc = b ? b == google[v].C.xg || b == google[v].C.yg || b == google[v].C.wg || b == google[v].C.vg ? b : null : null : a == google[v].C.Ig ? this.sc = b ? b == google[v].C.Ag || b == google[v].C.zg || b == google[v].C.Bg || b == google[v].C.Cg || b == google[v].C.Dg ? b : null : null : a == google[v].C.Jg && (this.tc = b ? b == google[v].C.Ng || b == google[v].C.Lg || b == google[v].C.Mg || b == google[v].C.Kg ? b : null : null);
        if (a == google[v].A.Ka)if (b)for (var d in b) {
            var e = b[d];
            google[v].C.de[d] && (this.fa[d] = e)
        } else this.fa = {}
    };
    google[v].C[G].setRestriction = google[v].C[G].Sa;
    google[v].C.Zb = function (a, b, d, e, g) {
        var f = na.min(d[lb] / a, d[uc] / b), k = {};
        wa(k, na[Jc](a * f));
        Ia(k, na[Jc](b * f));
        e && (wa(e, k[lb]), Ia(e, k[uc]), g && Ra(e[u], (d[lb] - k[lb]) / 2 + "px"));
        return k
    };
    google[v].C.scaleImage = google[v].C.Zb;
    google[v].C.Cm = function (a) {
        var b = a[Hb][0], d = a[Hb][1];
        if ("block" == d[u][tc])return!1;
        Fa(d[u], "block");
        Xa(a[u], 4E3);
        var e = d[Hb][0], g = d[Hb][1], f = b[Pb]("img")[0], k = d[Pb]("img")[0], l = {width: k[sb], height: k[wc]};
        k[sb] < f[sb] ? l = {width: f[sb], height: 2 * f[wc]} : k[wc] < f[wc] && (l = {width: f[sb], height: f[wc]});
        google[v].C.Zb(k[sb], k[wc], l, k);
        wa(d[u], d[sb] > 2 * b[sb] ? 2 * b[sb] + "px" : na.max(e[sb], g[sb]));
        b = bh(f, a) + f[sb] / 2;
        a = ch(f, a) + f[wc] / 2;
        f = bh(k, d) + k[sb] / 2;
        k = ch(k, d) + k[wc] / 2;
        0 === pa.appName[Qc]("Microsoft") ? (Ra(d[hb](), b - f + "px"),
            d[hb]().top = a - k + "px") : (d.offsetLeft = b - f + "px", d.offsetTop = a - k + "px");
        return!1
    };
    google[v].C.showPopup = google[v].C.Cm;
    google[v].C.zm = function (a) {
        a = a[Hb][1];
        if ("none" == a[u][tc])return!1;
        Fa(a[u], "none");
        Xa(a[ud][u], 0);
        return!1
    };
    google[v].C.hidePopup = google[v].C.zm;
    google[v].C[G].Pa = function (a) {
        google[v].A[G].Pa[kd](this, a)
    };
    google[v].C[G].setLinkTarget = google[v].C[G].Pa;
    google[v].C[G].Hb = function (a) {
        google[v].A[G].Hb[kd](this, a)
    };
    google[v].C[G].setQueryAddition = google[v].C[G].Hb;
    google[v].H = function () {
        google[v].A[kd](this);
        this.zc = null;
        this.yc = "San Francisco, CA";
        this.Qc = {y: 37.77916, x: -122.42009};
        this.rf = null;
        this.jh = !0;
        this.kh = !1;
        this.tf = null;
        this.pf = !0;
        this.Hc = rg(this, this.kd);
        this.We = "gsc-locationConfig";
        this.pa = "local";
        this.Ic = "/GlocalSearch";
        this.uc = "http://www.google.com/local";
        this.vf = this.Ab = null
    };
    Bd("google.search.LocalSearch", google[v].H, void 0);
    jg(google[v].H, google[v].A);
    google[v].H.Wa = "GlocalSearch";
    google[v].H.RESULT_CLASS = google[v].H.Wa;
    google[v].H.rp = "blended";
    google[v].H.TYPE_BLENDED_RESULTS = google[v].H.rp;
    google[v].H.sp = "kmlonly";
    google[v].H.TYPE_KMLONLY_RESULTS = google[v].H.sp;
    google[v].H.tp = "localonly";
    google[v].H.TYPE_LOCALONLY_RESULTS = google[v].H.tp;
    google[v].H.Iq = "disabled";
    google[v].H.ADDRESS_LOOKUP_DISABLED = google[v].H.Iq;
    google[v].H.Jq = "enabled";
    google[v].H.ADDRESS_LOOKUP_ENABLED = google[v].H.Jq;
    google[v].H.Oq = 0;
    google[v].H.STATIC_MAP_ZOOM_FARTHEST = google[v].H.Oq;
    google[v].H.Wx = 13;
    google[v].H.STATIC_MAP_ZOOM_DEFAULT = google[v].H.Wx;
    google[v].H.Nq = 21;
    google[v].H.STATIC_MAP_ZOOM_CLOSEST = google[v].H.Nq;
    google[v].H.hm = 8;
    google[v].H.STATIC_MAP_MAX_POINTS = google[v].H.hm;
    google[v].H.$w = 3.141592653589;
    google[v].H.Zw = 6367E3;
    google[v].H.bx = 16093;
    google[v].H.$ = [];
    google[v].H.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].H.$, f, b);
        google[v].H.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].H.RawCompletion = google[v].H.Ta;
    google[v].H[G].pb = function (a, b, d, e, g) {
        g && this.Kd && g != this.Kd || (this.resultViewport = a && a.viewport ? a.viewport : null, google[v].A[G].pb[kd](this, a, b, d, e, g))
    };
    google[v].H[G].Cc = function (a, b) {
        return google[v].A.Sb(google[v].H.$, [this, a, b])
    };
    google[v].H[G].ra = function (a, b, d) {
        window[nc] && window[nc].log && window[nc].log("The Google Local Search API is deprecated. Please migrate to the Google Places API (https://developers.google.com/places)");
        google[v].A[G].ra[kd](this, a, b, d)
    };
    google[v].H[G].execute = google[v].H[G].ra;
    google[v].H[G].fc = function (a, b, d) {
        b = this.Rc(null == b ? "google.search.LocalSearch.RawCompletion" : b, d);
        d = "";
        d = "&q=" + c(a);
        b += d;
        this.viewport = null;
        if (this.zc) {
            var e, g;
            this.jh ? (e = this.zc.getCenterLatLng(), g = this.zc.getSpanLatLng(), a = "&sll=" + e.y + "," + e.x, a += "&sspn=" + g[uc] + "," + g[lb]) : (e = this.zc.getCenter(), g = this.zc.getBounds().toSpan().toUrlValue(), a = "&sll=" + e.y + "," + e.x, a += "&sspn=" + g);
            a += google[v].H.Wl(e.y, e.x);
            b += a;
            d += a
        } else this.Qc ? (a = "&sll=" + this.Qc.y + "," + this.Qc.x, this.rf && (a = a + "&sspn=" + this.rf.lat + "," +
            this.rf.lng), a += google[v].H.Wl(this.Qc.y, this.Qc.x), b += a, d += a) : this.yc && (a = "&near=" + c(this.yc), b += a, d += a);
        this.kh && (b += "&nogeocode=t", d += "&nogeocode=t");
        this.tf && (b += "&mrt=" + c(this.tf), d += "&mrt=" + c(this.tf));
        d && (this.va = d);
        return b
    };
    google[v].H.Wl = function (a, b) {
        var d = google[v].H.bx / google[v].H.Zw * 4 * google[v].H.$w;
        return"&gll=" + na[mb](1E6 * (a - d)) + "," + na[mb](1E6 * (b - d)) + "," + na[mb](1E6 * (a + d)) + "," + na[mb](1E6 * (b + d)) + "&llsep=500,500"
    };
    google[v].H.centerToGll = google[v].H.Wl;
    google[v].H[G].Ra = function (a) {
        a.html && delete a.html;
        var b = W(this.Md());
        $(b, "gs-result");
        var d;
        d = Eg(a.url, a[bd], this.za(), "gs-title");
        Q(b, d);
        "kml" == a.listingType && a[nb] && "" != a[nb] && (d = U(a[nb], "gs-snippet"), Q(b, d));
        var e = W("gs-address");
        if (a.addressLines && 0 < a.addressLines[F])for (var g = 0; g < a.addressLines[F]; g++) {
            d = a.addressLines[g];
            var f = "gs-addressLine";
            0 == g ? f = "gs-street gs-addressLine" : 1 == g && (f = "gs-city gs-addressLine");
            d = U(d, f);
            Q(e, d)
        } else d = U(a.streetAddress, "gs-street"), Q(e, d), g = "", "" != a.city &&
            (g = a.city, "" != a.region && (g += ", ")), d = U(g, "gs-city"), Q(e, d), d = U(a.region, "gs-region"), Q(e, d);
        d = U(a.country, "gs-country");
        Q(e, d);
        Q(b, e);
        if (a.phoneNumbers && a.phoneNumbers[F]) {
            g = e = null;
            d = a.phoneNumbers[0];
            for (var k = 0; k < a.phoneNumbers[F]; k++) {
                f = a.phoneNumbers[k];
                if ("main" == f[Wc]) {
                    e = f;
                    break
                }
                if ("" == f[Wc] || "mobile" == f[Wc] && null == g)g = f
            }
            d = U((e ? e : g ? g : d).number, "gs-phone");
            Q(b, d)
        }
        a.ddUrl && "" != a.ddUrl && (d = Eg(a.ddUrl, P.directions, this.za(), "gs-directions"), Q(b, d));
        a.ddUrlToHere && "" != a.ddUrlToHere && a.ddUrlFromHere &&
            "" != a.ddUrlFromHere && (d = W("gs-directions-to-from"), e = U(P["get-directions"] + ":", "gs-label"), d[p](e), e = Eg(a.ddUrlToHere, P["to-here"], this.za(), "gs-secondary-link"), d[p](e), e = U("-", "gs-spacer"), d[p](e), e = Eg(a.ddUrlFromHere, P["from-here"], this.za(), "gs-secondary-link"), d[p](e), Q(b, d));
        a.html = b;
        this.Pc(a.html)
    };
    google[v].H[G].createResultHtml = google[v].H[G].Ra;
    google[v].H[G].Vq = function (a) {
        if (a.centerAndZoom)this.jh = !0, this.zc = a, this.Qc = null, this.yc = "", this.Ab && (this.Ab = null); else if (a.setCenter)this.jh = !1, this.zc = a, this.rf = this.Qc = null, this.yc = "", this.Ab && (this.Ab = null); else if (a.x && a.y)this.jh = !0, this.Qc = a, this.zc = this.rf = null, this.yc = "", this.Ab && (this.Ab = null); else if (null != a && "" != a) {
            this.jh = !0;
            this.zc = null;
            this.yc = a;
            this.Qc = null;
            this.Ab && (this.Ab = null);
            var b = new google[v].H;
            b.dh(this, this.Iw, [b, a]);
            b.ra(a)
        }
    };
    google[v].H[G].setCenterPoint = google[v].H[G].Vq;
    google[v].H[G].Iw = function (a, b) {
        if (a.results && a.results[F]) {
            var d = {};
            d.y = ra(a.results[0].lat);
            d.x = ra(a.results[0].lng);
            this.Qc = d;
            this.yc = b;
            this.pf = !0;
            this.zc = null;
            a.resultViewport && (d = {}, d.fA = ra(a.resultViewport.span.lat) / 2, d.gA = ra(a.resultViewport.span.lng) / 2, this.rf = d)
        }
    };
    google[v].H[G].kd = function (a, b) {
        if (b) {
            if (null == this.Ab) {
                var d = null;
                if (null == this.zc) {
                    var e = W("gsc-configSetting");
                    this.Ab = Jg(null, "gsc-configSettingInput", "" == this.yc ? null : this.yc);
                    Q(e, U(P["search-location"], "gsc-configSettingInputLabel"));
                    Q(e, this.Ab);
                    Q(a, e);
                    d = this.Ab
                }
                e = W("gsc-configSetting");
                this.vf = Kg(null, "0", this.kh, "gsc-configSettingCheckbox");
                Q(e, this.vf);
                Q(e, U(P["disable-address-lookup"], "gsc-configSettingCheckboxLabel"));
                null == d && (d = this.vf);
                var g = U(null, "gsc-configSettingSubmit");
                Q(g, Hg(P[gc],
                    "gsc-configSettingSubmit"));
                Q(e, g);
                Q(a, e);
                d[Ab]()
            }
        } else this.Ab && (this.Ab[Pc] && (this.yc = this.Ab[Pc], this.Vq(this.yc)), this.Ab = null), this.vf && (this.kh = this.vf[Tb], this.vf = null), tg(a)
    };
    google[v].H[G].uy = function (a) {
        a == google[v].H.Iq ? this.kh = !0 : a == google[v].H.Jq && (this.kh = !1)
    };
    google[v].H[G].setAddressLookupMode = google[v].H[G].uy;
    google[v].H.Mq = function (a, b, d, e) {
        var g = a.staticMapUrl, g = g[r](/&size=\d*x\d*/, "&size=" + d + "x" + b);
        e && e <= google[v].H.Nq && e >= google[v].H.Oq && (g = g[r](/&zoom=\d*/, "&zoom=" + e));
        return a.staticMapUrl = g
    };
    google[v].H.resizeStaticMapUrl = google[v].H.Mq;
    google[v].H.ey = function (a, b, d, e) {
        var g = "", f = {staticMapUrl: "http://maps.google.com/maps/api/staticmap?maptype=roadmap&size=150x100&zoom=13&format=gif&sensor=false"};
        b = google[v].H.Mq(f, b, d, e);
        null == e && (b = b[r](/&zoom=\d*/, ""));
        e = a[F];
        e > google[v].H.hm && (e = google[v].H.hm);
        for (d = 0; d < e; d++) {
            var k;
            k = a[d];
            if (k.lat && k.lng)"string" == typeof k.lat ? (f = ra(k.lat), k = ra(k.lng)) : (f = k.lat, k = k.lng); else if (k.x && k.y)f = k.y, k = k.x; else return null;
            f = "&markers=__ICONID____LAT__,__LNG__"[r](/__LAT__/, f);
            f = f[r](/__LNG__/, k);
            k = 65 + d;
            f = 1 < e ? f[r](/__ICONID__/, "label:" + sa.fromCharCode(k) + "|") : f[r](/__ICONID__/, "");
            g += f
        }
        return b + g
    };
    google[v].H.computeStaticMapUrl = google[v].H.ey;
    google[v].H[G].Sa = function (a, b) {
        a == google[v].A.bj && (b ? (this.tf = null, this.tf = b == google[v].H.rp || b == google[v].H.sp || b == google[v].H.tp ? b : null) : this.tf = null)
    };
    google[v].H[G].setRestriction = google[v].H[G].Sa;
    google[v].ma = function () {
        google[v].A[kd](this);
        this.pa = "news";
        this.Ic = "/GnewsSearch";
        this.uc = "http://news.google.com/nwshp";
        this.uf = "site:";
        this.Nb = !1;
        this.pf = !0;
        this.Hc = rg(this, this.kd);
        this.We = "gsc-newsConfig";
        this.fa = this.na = null
    };
    Bd("google.search.NewsSearch", google[v].ma, void 0);
    jg(google[v].ma, google[v].A);
    google[v].ma.Wa = "GnewsSearch";
    google[v].ma.RESULT_CLASS = google[v].ma.Wa;
    google[v].ma.Kq = "GnewsSearch.quote";
    google[v].ma.QUOTE_RESULT_CLASS = google[v].ma.Kq;
    google[v].ma.$ = [];
    google[v].ma.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].ma.$, f, b);
        google[v].ma.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].ma.RawCompletion = google[v].ma.Ta;
    google[v].ma[G].Cc = function (a, b) {
        return google[v].A.Sb(google[v].ma.$, [this, a, b])
    };
    google[v].ma[G].fc = function (a, b, d) {
        b = this.Rc(null == b ? "google.search.NewsSearch.RawCompletion" : b, d);
        var e = null;
        a && (e = a);
        this.Na && (e = null == e ? this.Na : e + " " + this.Na);
        this.Mb && (e = null == e ? this.uf + this.Mb : e + " " + this.uf + this.Mb);
        a = e ? "&q=" + c(e) : "";
        this.Nb && (a += "&scoring=d");
        if (this.fa) {
            var e = "", g;
            for (g in this.fa)":" == g[ub](0) && (e += "&" + this.fa[g]);
            a += e
        }
        this.Mb && "source:" == this.uf && (b = b[r](/&hl=.*&/, "&hl=en&"));
        this.va = a;
        d && 0 != d && (this.va = this.va + "&start=" + d);
        return b + a
    };
    google[v].ma[G].Ra = function (a) {
        a.html && delete a.html;
        if (a.GsearchResultClass != google[v].ma.Kq) {
            var b = W(this.Md());
            $(b, "gs-result");
            var d;
            d = Eg(a.unescapedUrl, a[bd], this.za(), "gs-title");
            Q(b, d);
            d = U(a.publisher, "gs-publisher");
            Q(b, d);
            d = a[bc][Yb](",");
            1 < d[F] && (d = U(", " + d[d[F] - 1], "gs-location"), Q(b, d));
            d = new Date(a.publishedDate);
            d = U(" - " + this.wf(d), "gs-publishedDate");
            Q(b, d);
            d = new Date(a.publishedDate);
            d = U(" - " + this.gm(d), "gs-relativePublishedDate");
            Q(b, d);
            d = U(a[nb], "gs-snippet");
            Q(b, d);
            a.clusterUrl &&
                "" != a.clusterUrl && (d = Eg(a.clusterUrl, P["related-articles"] + "&nbsp;&raquo;", this.za(), "gs-clusterUrl"), Q(b, d));
            a.html = b;
            this.Pc(a.html)
        }
    };
    google[v].ma[G].createResultHtml = google[v].ma[G].Ra;
    google[v].ma[G].Ub = function (a) {
        null == a || "" == a ? (this.Mb = null, this.uf = "site:") : a[yb]("[./:]") ? (this.uf = "site:", this.Mb = a) : (this.uf = "source:", this.Mb = a[r](/\s/g, "_"))
    };
    google[v].ma[G].setSiteRestriction = google[v].ma[G].Ub;
    google[v].ma[G].Ib = function (a) {
        this.Nb = a == google[v].A.md ? !0 : !1
    };
    google[v].ma[G].setResultOrder = google[v].ma[G].Ib;
    google[v].ma[G].kd = function (a, b) {
        if (b) {
            if (null == this.na) {
                var d = W("gsc-configSetting");
                this.na = Kg(null, "0", this.Nb, "gsc-configSettingCheckbox");
                Q(d, this.na);
                Q(d, U(P["sort-by-date"], "gsc-configSettingCheckboxLabel"));
                var e = W("gsc-configSettingSubmit");
                Q(e, Hg(P[gc], "gsc-configSettingSubmit"));
                Q(d, e);
                Q(a, d)
            } else Aa(this.na, this.Nb);
            this.na[Ab]()
        } else this.na && (this.na[Tb] ? this.Ib(google[v].A.md) : this.Ib(google[v].A.ph))
    };
    google[v].ma[G].Jv = {geo: !0, qsid: !0, quotesearch: !0, topic: !0, ned: !0, scoring: !0, as_mind: !0, as_minm: !0, as_miny: !0, as_maxd: !0, as_maxm: !0, as_maxy: !0};
    google[v].ma[G].Sa = function (a, b) {
        if (a == google[v].A.Ka)if (b)for (var d in b) {
            var e = b[d];
            "undefined" != typeof this.Jv[d] && (this.fa = this.fa || {}, this.fa[":" + d] = d + "=" + c(e))
        } else this.fa = null
    };
    google[v].ma[G].setRestriction = google[v].ma[G].Sa;
    google[v].da = function () {
        google[v].A[kd](this);
        this.pa = "patent";
        this.Ic = "/GpatentSearch";
        this.uc = "http://www.google.com/patents";
        this.fp = "";
        this.lh = null;
        this.pf = !0;
        this.Hc = rg(this, this.kd);
        this.We = "gsc-patentConfig";
        this.na = null
    };
    Bd("google.search.PatentSearch", google[v].da, void 0);
    jg(google[v].da, google[v].A);
    google[v].da.Wa = "GpatentSearch";
    google[v].da.RESULT_CLASS = google[v].da.Wa;
    google[v].da.Fp = 1;
    google[v].da.TYPE_ANY_STATUS = google[v].da.Fp;
    google[v].da.Hp = 2;
    google[v].da.TYPE_ISSUED_PATENTS = google[v].da.Hp;
    google[v].da.Gp = 3;
    google[v].da.TYPE_APPLICATIONS = google[v].da.Gp;
    google[v].da.$ = [];
    google[v].da.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].da.$, f, b);
        google[v].da.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].da.RawCompletion = google[v].da.Ta;
    google[v].da[G].Cc = function (a, b) {
        return google[v].A.Sb(google[v].da.$, [this, a, b])
    };
    google[v].da[G].fc = function (a, b, d) {
        b = this.Rc(null == b ? "google.search.PatentSearch.RawCompletion" : b, d);
        this.Na && (a = a + " " + this.Na);
        a = "&q=" + c(a) + this.fp;
        this.lh && (a += this.lh);
        this.va = a;
        return b + a
    };
    google[v].da[G].Ra = function (a) {
        a.html && delete a.html;
        a.thumbnailHtml = this.pm(a);
        var b = W(this.Md());
        $(b, "gs-result");
        var d = W("gs-text-box"), e = zg(), g = Ag(e, 0), f = Bg(g, "gs-image-box"), g = Bg(g, "gs-text-box");
        Q(f, a.thumbnailHtml[Fb](!0));
        Q(g, d);
        Q(b, e);
        f = Eg(a.unescapedUrl, a[bd], this.za(), "gs-title");
        Q(d, f);
        e = W("gs-patent-info gs-metadata");
        Q(d, e);
        f = null;
        f = a.patentNumber ? "issued" == a.patentStatus ? P["us-pat"] + "&nbsp;" + a.patentNumber : P["us-pat-app"] + "&nbsp;" + a.patentNumber : P["us-pat-app"] + "&nbsp; N/A";
        f = U(f, "gs-patent-number");
        Q(e, f);
        a.applicationDate && (f = U(" - " + this.wf(new Date(a.applicationDate)), "gs-publishedDate"), Q(e, f));
        a.assignee && (f = U(" - " + a.assignee, "gs-author"), Q(e, f));
        f = U(a[nb], "gs-snippet");
        Q(d, f);
        Q(d, f);
        a.html = b;
        this.Pc(a.html)
    };
    google[v].da[G].createResultHtml = google[v].da[G].Ra;
    google[v].da[G].pm = function (a) {
        var b = W("gs-patent-image"), d = Cg(a.tbUrl, 75, 100, "gs-image");
        a = Dg(a.unescapedUrl, null, this.za(), "gs-image");
        m(a, "gs-image");
        Q(a, d);
        Q(b, a);
        return b
    };
    google[v].da[G].Ib = function (a) {
        this.lh = a == google[v].A.md ? "&scoring=d" : a == google[v].A.Lp ? "&scoring=ad" : null
    };
    google[v].da[G].setResultOrder = google[v].da[G].Ib;
    google[v].da[G].Sa = function (a, b) {
        a == google[v].A.bj && (this.fp = b ? b == google[v].da.Fp ? "" : b == google[v].da.Hp ? "&as_psrg=1" : b == google[v].da.Gp ? "&as_psra=1" : "" : "")
    };
    google[v].da[G].setRestriction = google[v].da[G].Sa;
    google[v].da[G].kd = function (a, b) {
        if (b) {
            var d = !1;
            this.lh && "&scoring=d" == this.lh && (d = !0);
            if (null == this.na) {
                var e = W("gsc-configSetting");
                this.na = Kg(null, "0", d, "gsc-configSettingCheckbox");
                Q(e, this.na);
                Q(e, U(P["sort-by-date"], "gsc-configSettingCheckboxLabel"));
                d = W("gsc-configSettingSubmit");
                Q(d, Hg(P[gc], "gsc-configSettingSubmit"));
                Q(e, d);
                Q(a, e)
            } else Aa(this.na, d);
            this.na[Ab]()
        } else this.na && (this.na[Tb] ? this.Ib(google[v].A.md) : this.Ib(google[v].A.ph))
    };
    google[v].eb = function () {
        this.Nm = this.lc = google[v].B.Xd;
        Ja(this, null);
        this.wa = {width: 112, height: 84};
        this.Sh = {width: 100, height: 75};
        this.Rd = null
    };
    Bd("google.search.SearcherOptions", google[v].eb, void 0);
    google[v].eb[G].ep = function (a) {
        switch (a) {
            case google[v].B.Yp:
            case google[v].B.Be:
            case google[v].B.Xd:
                this.lc = a;
                break;
            default:
                this.lc = google[v].B.Xd
        }
        this.Nm = this.lc
    };
    google[v].eb[G].setExpandMode = google[v].eb[G].ep;
    google[v].eb[G].Cy = function (a) {
        tg(a);
        Ja(this, a)
    };
    google[v].eb[G].setRoot = google[v].eb[G].Cy;
    google[v].eb[G].Pe = function (a) {
        this.Rd = a
    };
    google[v].eb[G].setNoResultsString = google[v].eb[G].Pe;
    google[v].eb[G].wy = function (a) {
        100 < a && (a = 100);
        Ia(this.wa, a);
        wa(this.wa, na[Jc](1.33 * a))
    };
    google[v].eb[G].setImageResultsTbHeight = google[v].eb[G].wy;
    google[v].eb[G].Hy = function (a) {
        100 < a && (a = 100);
        Ia(this.Sh, a);
        wa(this.Sh, na[Jc](1.33 * a))
    };
    google[v].eb[G].setVideoResultsTbHeight = google[v].eb[G].Hy;
    google[v].qa = function () {
        Na(this, null);
        this.eo = null;
        this.ib = google[v].B.Gc;
        this.Ii = !1;
        this.Ma = null;
        this.gc = google[v].B.mk;
        this.Ji = !1;
        this.ze = -1
    };
    Bd("google.search.DrawOptions", google[v].qa, void 0);
    google[v].qa[G].xy = function (a) {
        Na(this, a)
    };
    google[v].qa[G].setInput = google[v].qa[G].xy;
    google[v].qa[G].En = function (a) {
        this.eo = eh(a)
    };
    google[v].qa[G].setSearchFormRoot = google[v].qa[G].En;
    google[v].qa[G].Ko = function (a) {
        this.ib = a == google[v].B.Gc || a == google[v].B.hc ? a : google[v].B.Gc
    };
    google[v].qa[G].setDrawMode = google[v].qa[G].Ko;
    google[v].qa[G].Dn = function (a) {
        this.Ii = a
    };
    google[v].qa[G].setAutoComplete = google[v].qa[G].Dn;
    google[v].qa[G].Fn = function (a) {
        this.Ji = a
    };
    google[v].qa[G].setSpeech = google[v].qa[G].Fn;
    google[v].qa[G].Gn = function (a) {
        this.ze = a
    };
    google[v].qa[G].setTopRefinementsWanted = google[v].qa[G].Gn;
    google[v].qa[G].Bn = function (a, b, d, e) {
        this.gc = google[v].B.Nf;
        this.Ma = {};
        this.Ma.Ik = a;
        this.Ma.mw = b || "q";
        this.Ma.kw = d || !1;
        this.Ma.lw = e || "?"
    };
    google[v].qa[G].enableSearchboxOnly = google[v].qa[G].Bn;
    google[v].qa[G].An = function () {
        this.gc = google[v].B.Ff
    };
    google[v].qa[G].enableSearchResultsOnly = google[v].qa[G].An;
    google[v].hb = function (a, b, d) {
        this.ob = d;
        this.ul = this.xl = !1;
        this.J = a;
        this.xa = null;
        this.Rt = ng(b, google[v].B[G].Lu, [this]);
        this.Ut = ng(b, google[v].B[G].Bl, [this, google[v].hb.wk]);
        this.Tt = ng(b, google[v].B[G].Bl, [this, google[v].hb.vk]);
        this.St = ng(b, google[v].B[G].Bl, [this, google[v].hb.xn]);
        this.Qt = ng(b, google[v].B[G].Ku, [this]);
        this.Pt = ng(b, google[v].B[G].Ju, [this]);
        this.J.dh(b, b.pb, [this]);
        this.J.Mu(b, google[v].B[G].Iu);
        this.J.Da(b.Oe);
        this.J.Pa(b.Wc);
        Ja(this, null);
        this.lb = this.nf = this.Ld = this.ik = this.Jf =
            this.Si = null;
        this.dl = !0;
        this.Za = [];
        this.eh = this.$g = this.Kc = this.Ia = null;
        this.Pb = 0;
        this.De = !1
    };
    google[v].hb.Kj = 0;
    google[v].hb.wk = 1;
    google[v].hb.vk = 2;
    google[v].hb.xn = 3;
    google[v].hb[G].Ij = function (a) {
        var b = "gsc-results-selector ", b = a == google[v].hb.Kj ? this.ob.lc == google[v].B.Xd ? b + "gsc-one-result-active" : this.J.La == google[v].A.$b ? b + "gsc-more-results-active" : b + "gsc-all-results-active" : a == google[v].hb.wk ? b + "gsc-one-result-active" : a == google[v].hb.vk ? b + "gsc-more-results-active" : b + "gsc-all-results-active";
        m(this.ik, b)
    };
    google[v].B = function (a) {
        if (!google[pd].KeyVerified)if (google[v].B.un())google[pd].KeyVerified = !0; else return;
        this.bk = this.Oe = google[v].A.$b;
        this.ib = google[v].B.Gc;
        Ja(this, null);
        Na(this, null);
        this.Je = null;
        this.qi = google[v].B.vi;
        this.qr = ng(this, google[v].B[G].es, [null]);
        this.rr = ng(this, google[v].B[G].fs, [null]);
        this.Gf = this.ck = this.dk = this.Mh = null;
        this.Ze = 0;
        this.Ef = !1;
        this.Wc = google[v].A.Kf;
        this.gc = google[v].B.mk;
        this.Gj = P.copy;
        this.Td = this.kb = null;
        this.Mm = 0;
        this.rd = {};
        this.Kb = this.Fd = this.ri = this.Xb =
            this.Df = null;
        this.Dm = !1;
        this.Vc = null;
        this.Qd = this.Sd = 0;
        this.Lm = !1;
        this.sd = null;
        this.Cf = !1;
        this.oa = this.$c = null;
        this.rn = !1;
        this.Va = {};
        this.Va[google[v].Ea.kc] = {$a: !0, className: "gsc-adBlock", cc: "", ji: {lines: 2}};
        this.Va[google[v].Ea.Qb] = {$a: !1, className: "gsc-adBlockVertical", cc: "gsc-thinWrapper", ji: {}};
        this.Va[google[v].Ea.Eb] = {$a: !1, className: "gsc-adBlockBottom", cc: "", ji: {}};
        this.Z = [];
        var b;
        if (a)for (var d = 0; d < a[F]; d++)b = new google[v].hb(a[d], this, !1), this.Z[C](b);
        this.Lh(google[v].B.qk);
        this.cn = {};
        this.If = !1;
        this.Ud = !0;
        this.Jb = null
    };
    Bd("google.search.SearchControl", google[v].B, void 0);
    google[v].B[G].Tk = !1;
    google[v].Ea = {kc: "top", Qb: "right", Eb: "bottom"};
    google[v].B.Io = P["no-results"];
    google[v].B.NO_RESULTS_DEFAULT_STRING = google[v].B.Io;
    google[v].B.iq = 350;
    google[v].B.TIMEOUT_SHORT = google[v].B.iq;
    google[v].B.vi = 500;
    google[v].B.TIMEOUT_MEDIUM = google[v].B.vi;
    google[v].B.gq = 700;
    google[v].B.TIMEOUT_LONG = google[v].B.gq;
    google[v].B.Yp = 1;
    google[v].B.EXPAND_MODE_CLOSED = google[v].B.Yp;
    google[v].B.Be = 2;
    google[v].B.EXPAND_MODE_OPEN = google[v].B.Be;
    google[v].B.Xd = 3;
    google[v].B.EXPAND_MODE_PARTIAL = google[v].B.Xd;
    google[v].B.Gc = 1;
    google[v].B.DRAW_MODE_LINEAR = google[v].B.Gc;
    google[v].B.hc = 2;
    google[v].B.DRAW_MODE_TABBED = google[v].B.hc;
    google[v].B.dq = "save";
    google[v].B.KEEP_LABEL_SAVE = google[v].B.dq;
    google[v].B.cq = "keep";
    google[v].B.KEEP_LABEL_KEEP = google[v].B.cq;
    google[v].B.bq = "include";
    google[v].B.KEEP_LABEL_INCLUDE = google[v].B.bq;
    google[v].B.$p = "copy";
    google[v].B.KEEP_LABEL_COPY = google[v].B.$p;
    google[v].B.Zp = "blank";
    google[v].B.KEEP_LABEL_BLANK = google[v].B.Zp;
    google[v].B.qk = "tab";
    google[v].B.REFINEMENT_AS_TAB = google[v].B.qk;
    google[v].B.Fk = "link";
    google[v].B.REFINEMENT_AS_LINK = google[v].B.Fk;
    google[v].B.mk = "standard";
    google[v].B.MODE_STANDARD = google[v].B.mk;
    google[v].B.Nf = "searchbox-only";
    google[v].B.MODE_SEARCHBOX_ONLY = google[v].B.Nf;
    google[v].B.Ff = "searchresults-only";
    google[v].B.MODE_RESULTS_ONLY = google[v].B.Ff;
    var ph = google[pd][sd].BUBBLEGUM, qh = google[pd][sd].GREENSKY, rh = google[pd][sd].ESPRESSO, sh = google[pd][sd].SHINY, th = google[pd][sd].MINIMALIST, uh = google[pd][sd].V2_DEFAULT;
    google[v].B.Jd = {};
    google[v].B.Jd[ph] = {colorBackground: "#FDE5FF", colorTitleLink: "#0568CD", colorText: "#000", colorDomainLink: "#CC7A9F", fontFamily: "Arial"};
    google[v].B.Jd[qh] = {colorBackground: "#EEFFE5", colorBorder: "#A9DA92", colorTitleLink: "#06C", colorText: "#454545", colorDomainLink: "#8D5FA7", fontFamily: "Trebuchet MS", fontSizeDescription: "14"};
    google[v].B.Jd[rh] = {colorBackground: "#F2F0E6", colorTitleLink: "#950000", colorText: "#333", colorDomainLink: "#A25B08", fontFamily: "Georgia", fontSizeDescription: "14", fontSizeDomainLink: "12"};
    google[v].B.Jd[sh] = {colorBackground: "#F0F0F6", colorBorder: "#CCC", colorTitleLink: "#06C", colorDomainLink: "#008000", fontFamily: "Verdana"};
    google[v].B.Jd[th] = {colorBackground: "#EEE", colorBorder: "#CCC", colorTitleLink: "#000", colorText: "#444", colorDomainLink: "#333", fontSizeDescription: "14", fontFamily: "Arial"};
    google[v].B.Jd[uh] = {colorBackground: "#fff", colorBorder: "#ddd", colorTitleLink: "#1155CC", colorText: "#222", colorDomainLink: "#093", fontSizeDescription: "13", fontFamily: "Arial, sans-serif"};
    google[v].B.ho = "13";
    google[v].B.Ts = "16";
    try {
        google[v].B.appPath = window[bc][mc]
    } catch (vh) {
        google[v].B.appPath = null
    }
    google[v].B.un = function () {
        var a;
        a = window[bc][Qb][yd]()[Yb](".");
        if (2 > a[F])a = !1; else {
            var b = a.pop(), d = a.pop();
            "igoogle" != d && "gmodules" != d && "googlesyndication" != d || "com" != b ? (2 == b[F] && 0 < a[F] && Rg[d] && 1 == Rg[d][b] && (d = a.pop()), a = "google" == d) : a = !0
        }
        if (a)return!0;
        google[pd].KeyVerified = !0;
        google[pd].LoadFailure = !1;
        return!0
    };
    google[v].B.keyCheck = google[v].B.un;
    google[v].B[G].Jw = function () {
        var a = this;
        return function () {
            a.Tk && (a.fo(), a.Tk = !1)
        }
    };
    google[v].B[G].Ug = function (a, b) {
        google.load("ads.search", "3", {callback: this.Jw()});
        this.yd = !0;
        this.Ed = a;
        if (b) {
            var d = this.Va[google[v].Ea.kc], e = this.Va[google[v].Ea.Qb], g = this.Va[google[v].Ea.Eb];
            void 0 != b.includeVerticalAds && (e.$a = b.includeVerticalAds);
            void 0 != b.includeSideAds && (e.$a = b.includeSideAds);
            void 0 != b._includeBottomAds_ && (g.$a = b._includeBottomAds_);
            void 0 != b.iframes && (this.bo = b.iframes);
            b.channel && (this.Ei = b.channel);
            b.clientIP && (this.Zn = b.clientIP);
            b.safe && (this.Ek = b.safe);
            b[$b] && (this.$n =
                b[$b]);
            b.adStyle && (this.Yn = b.adStyle);
            b.cseGoogleHosting && (this.Fi = b.cseGoogleHosting);
            if (g = b.adtest || b.debug)this.jk = g;
            void 0 != b.numTopAds && (d.ed = na.max(0, na.min(4, b.numTopAds)), d.$a = d.ed ? !0 : !1);
            void 0 != b.numSideAds && (e.ed = na.max(0, na.min(8, b.numSideAds)), e.$a = e.ed ? !0 : !1);
            "noTop" == b.layout && (d.$a = !1, e.$a = !0);
            this.Co = b.enableSearchCompleteCallback ? !0 : !1
        }
    };
    google[v].B[G].enableAds = google[v].B[G].Ug;
    google[v].B[G].Zd = function (a, b, d) {
        b || (b = new google[v].eb);
        b && b.wa && a.Ep(b.wa);
        a.gd = null;
        b = new google[v].hb(a, this, b);
        d ? (d.Za[C](b), b.eh = d, b.Pb = d.Pb + 1) : (this.Z[C](b), b.Pb = 0);
        this.Zf(a) && (this.cs = !0);
        a.lf = "gsc"
    };
    google[v].B[G].addSearcher = google[v].B[G].Zd;
    google[v].B[G].fn = function (a) {
        a.ob[vc] ? (a.dl = !1, Ja(a, a.ob[vc]), $(a[vc], "gsc-resultsRoot"), Pg(a[vc], "gsc-resultsbox-visible"), $(a[vc], "gsc-resultsbox-invisible")) : Ja(a, W("gsc-resultsRoot"));
        a.J.Hf && $(a[vc], "gsc-resultsRoot-" + a.J.Hf);
        this.ib == google[v].B.hc && (a.Ia.Fb = a[vc]);
        var b = zg(null, null, "gsc-resultsHeader"), d = Ag(b, 0);
        a.ne = Bg(d, "gsc-twiddleRegionCell");
        d = Bg(d, "gsc-configLabelCell");
        a.Si = U("", "gsc-twiddle");
        Q(a.ne, a.Si);
        var e = xg(a.J.Xu(), "gsc-title");
        Q(a.Si, e);
        a.Jf = U("", "gsc-stats");
        Q(a.ne, a.Jf);
        var e = U(), g = U(P.blank, "gsc-result-selector gsc-one-result"), f = U(P.blank, "gsc-result-selector gsc-more-results"), k = U(P.blank, "gsc-result-selector gsc-all-results");
        ab(g, P["show-one-result"]);
        ab(f, P["show-more-results"]);
        ab(k, P["show-all-results"]);
        Q(e, g);
        Q(e, f);
        Q(e, k);
        fb(g, a.Ut);
        fb(f, a.Tt);
        fb(k, a.St);
        a.ik = e;
        a.Ij(google[v].hb.Kj);
        Q(a.ne, a.ik);
        fb(a.Si, a.Rt);
        a.J.Hc && (a.Vb = yg("", "gsc-configLabel"), Oa(a.Vb, P.blank), $(a.Vb, "gsc-twiddle-closed"), Q(d, a.Vb), fb(a.Vb, a.Qt), ab(a.Vb, P.settings), a.Ld = W("gsc-config"),
            $(a.Ld, a.J.We), a.nf = Gg("gsc-config"), $(a.nf, a.J.We), a.nf.onsubmit = a.Pt, Q(a.Ld, a.nf), Fa(a.Ld[u], "none"));
        a.lb = W();
        this.Bb && (a.lb.onmousedown = rg(this, google[v].B[G].Wu), fb(a.lb, rg(this, google[v].B[G].Vu)));
        a.xa = W("gsc-expansionArea");
        Q(a.lb, a.xa);
        a.dl && Q(this.ee, a[vc]);
        Q(a[vc], b);
        a.Ld && Q(a[vc], a.Ld);
        Q(a[vc], a.lb)
    };
    google[v].B.Vv = /^https?:\/\/www\.google\.com\/url\?/;
    I = google[v].B[G];
    I.Wu = function (a) {
        this.If && this.Fq(this.Eq(a));
        return!0
    };
    I.Vu = function (a) {
        var b = this.Eq(a);
        this.If || this.Fq(b);
        b && window[Xb](function () {
            var a = b[md](google[v].G.ue);
            a && Ea(b, a)
        }, 0);
        return!0
    };
    I.Eq = function (a) {
        a = a || window[zd];
        for (a = a[jd] || a[Nc]; a && !(a[mc] && a[md](google[v].G.oe) && a[md](google[v].G.ue));)a = a[ud];
        return a
    };
    I.Fq = function (a) {
        if (a) {
            var b = a[md](google[v].G.oe);
            b && google[v].B.Vv[zc](b) && Ea(a, b)
        }
    };
    I.Im = function (a) {
        var b = xg();
        $(b, "gsc-refinementBlockInvisible");
        Q(this.Oc, b);
        a.Kc = b;
        this.Ex(a)
    };
    I.Yw = function (a) {
        return this.rd.Ip ? yg(a) : wg(a)
    };
    I.Pm = function (a) {
        if (this.rd.Ip) {
            var b = h.createDocumentFragment();
            b[p](yg());
            Oa(b[Cb], a);
            return b
        }
        var b = h.createDocumentFragment(), d = h[t]("div");
        for (Oa(d, a); d[Cb];)b[p](d[Cb]);
        return b
    };
    I.Ex = function (a) {
        var b = a.Ia, d = this.ak(a, a);
        d.Pb += 1;
        "tab" == this.Kp ? ug(d.ta, wg(P["all-results-short"])) : ug(d.ta, this.Yw(P["all-results-long"]));
        a.Ia = b;
        a.$g = d;
        a.$g.Fb = a.Ia.Fb
    };
    I.Lh = function (a) {
        a == google[v].B.Fk ? (this.cp = "gsc-refinementHeader", this.Yi = "gsc-refinementhInactive", this.Pl = "gsc-refinementhActive", this.Kp = a, this.ok = "gsc-refinementsAreaInvisible", this.Jp = "gsc-refinementsArea") : a == google[v].B.qk && (this.cp = "gsc-tabHeader", this.Yi = "gsc-tabhInactive", this.Pl = "gsc-tabhActive", this.Kp = a, this.ok = "gsc-tabsAreaInvisible", this.Jp = "gsc-tabsArea")
    };
    google[v].B[G].setRefinementStyle = google[v].B[G].Lh;
    I = google[v].B[G];
    I.ak = function (a, b) {
        var d = {}, e = a.J.El();
        a.Ia = d;
        d.Pb = a.Pb;
        d.ta = U(google[v].V.Wd(e));
        d.Fb = null;
        d.nb = a.J;
        d.pa = a.J.pa;
        Mg(d.ta, ng(this, this.Ue, [d]));
        d.Jb = a;
        var g = "gs-spacer";
        lg("opera") && (g += " gs-spacer-opera");
        b ? (e = b.Kc, $(d.ta, this.cp), $(d.ta, this.Yi)) : (e = this.Dc, $(d.ta, "gsc-tabHeader"), $(d.ta, "gsc-tabhInactive"));
        $(d.ta, "gsc-inline-block");
        Q(e, d.ta);
        g = yg(" ", g);
        Q(e, g);
        a.ob.ep(google[v].B.Be);
        return d
    };
    I.Tm = function (a) {
        if (1 != a.Za[F]) {
            var b = a.Za.shift();
            if (b) {
                a.Za[C](b);
                a = b.Ia.ta;
                var d = a[Mb];
                Q(a[ud], a);
                Q(a[ud], d);
                b = b.Ia.Fb;
                Q(b[ud], b)
            }
        }
    };
    I.Xj = function (a) {
        for (var b = 0; b < this.Vc[F]; ++b)if (this.Vc[b].key == a)return b;
        return null
    };
    I.rw = function (a) {
        m(this.Kb, "gsc-option-menu-invisible");
        this.Sd != a && (this.pk(a), this.di(a, this.Y.nb), this.ra())
    };
    I.sw = function (a) {
        a = a || window[zd];
        m(this.Kb, "gsc-option-menu");
        this.Kb[u].top = ch(this.Kb, this.Fd) + ch(this.ri, this.Fd) - ch(Xg(this.Kb, "div", "gsc-option-menu-item-highlighted")[0], this.Fd) + "px";
        za(a, !0);
        a[Zb] && a[Zb]()
    };
    I.pw = function (a) {
        a = a || window[zd];
        this.Kb && !ih(this.Kb, a[jd] || a[Nc]) && m(this.Kb, "gsc-option-menu-invisible")
    };
    google[v].B.qw = function (a) {
        a = a || window[zd];
        za(a, !0);
        a[Zb] && a[Zb]()
    };
    I = google[v].B[G];
    I.bt = function () {
        var a = W("gsc-orderby-invisible"), b = xg(P["order-results-by"], "gsc-orderby-label");
        $(b, "gsc-inline-block");
        Q(a, b);
        this.Fd = W("gsc-option-menu-container");
        $(this.Fd, "gsc-inline-block");
        Q(a, this.Fd);
        b = W("gsc-selected-option-container");
        $(b, "gsc-inline-block");
        this.ri = W("gsc-selected-option");
        var d = W("gsc-option-selector");
        Q(b, this.ri);
        Q(b, d);
        fb(b, rg(this, this.sw));
        Q(this.Fd, b);
        this.Kb = W("gsc-option-menu-invisible");
        for (b = 0; b < this.Vc[F]; ++b) {
            var e = this.Vc[b][sc], d = W("gsc-option-menu-item"),
                e = xg(e, "gsc-option");
            Q(d, e);
            Q(this.Kb, d);
            fb(e, ng(this, google[v].B[G].rw, [b]))
        }
        Q(this.Fd, this.Kb);
        fb(this.Kb, google[v].B.qw);
        b = rg(this, this.pw);
        this[vc][Jb] ? (this[vc][Jb]("onmousedown", b), h[Jb]("onmousedown", b)) : h[Vc] && h[Vc]("mousedown", b, !0);
        return a
    };
    I.Lx = function (a) {
        a = a || window[zd];
        this.sd && !ih(this.sd, a[jd] || a[Nc]) && m(this.$c, "gsc-getlink-text-invisible")
    };
    I.Kx = function (a) {
        a = a || window[zd];
        this.$c && ih(this.$c, a[jd] || a[Nc]) || (m(this.$c, Og(this.$c, "gsc-getlink-text-visible") ? "gsc-getlink-text-invisible" : "gsc-getlink-text-visible"), za(a, !0), a[Zb] && a[Zb]())
    };
    I.wx = function () {
        var a = Gg(), b = Lg("label", "page", !0), d = Fg(P["label-page"], "gsc-label-result-form-label");
        Q(a, b);
        Q(a, d);
        Mg(b, rg(this, this.kr));
        b = Lg("label", "site");
        d = Fg(P["label-site"], "gsc-label-result-form-label");
        Q(a, b);
        Q(a, d);
        Mg(b, rg(this, this.kr));
        b = Lg("label", "prefix");
        d = Fg(P["label-prefix"], "gsc-label-result-form-label");
        Q(a, b);
        Q(a, d);
        Mg(b, rg(this, this.Qx));
        return a
    };
    I.px = function (a) {
        var b = h[t]("a"), d = "more:" + a;
        m(b, "gs-label");
        Za(b, a);
        b[Eb]("data-refinementlabel", a);
        b[Eb]("label-with-op", d);
        b[Eb]("dir", "ltr");
        Mg(b, ng(this, this.Rj, [this.Xc(this.Jb), d]));
        return b
    };
    I.$s = function () {
        this.Od = W("gsc-modal-background-image");
        Mg(this.Od, ng(this, this.Af));
        Q(this.ee, this.Od);
        var a = W("gsc-label-result-main-box-invisible"), b = W("gsc-label-result-saving-popup");
        $(b, "gsc-label-result-saving-popup-invisible");
        vg(b, P.saving);
        Q(a, b);
        b = W("gsc-results-close-btn");
        $(b, "gsc-label-results-close-btn-visible");
        Q(a, b);
        Mg(b, ng(this, this.Af));
        var b = P["add-label"], d = h[t]("h");
        m(d, "gsc-label-result-heading");
        b && Za(d, b);
        Q(a, d);
        b = W("gsc-labels-label-div-visible");
        Q(a, b);
        this.Hq = b;
        this.yj =
            W("gsc-labels-no-label-div-invisible");
        vg(this.yj, P["no-refinement"]);
        Q(a, this.yj);
        d = W("gsc-label-result-url-heading");
        Q(b, d);
        d = h[t]("a");
        cb(d, "_blank");
        m(d, "gsc-label-result-url-title");
        Q(b, d);
        d = W("gsc-label-result-url");
        Q(b, d);
        d = W("gsc-label-result-form-div");
        Q(b, d);
        Q(d, this.wx());
        d = Jg(null, "gsc-label-result-label-prefix-invisible");
        $(d, "gsc-label-result-label-prefix-visible");
        Q(b, d);
        d = W("gsc-label-result-label-prefix-error");
        vg(d, P["invalid-url-prefix"]);
        $(d, "gsc-label-result-label-prefix-error-invisible");
        Q(b, d);
        d = W("gsc-labels-box");
        Q(b, d);
        d = W("gsc-add-label-error");
        $(d, "gsc-add-label-error-invisible");
        vg(d, P["error-adding-label"]);
        Q(b, d);
        d = W("gsc-label-result-buttons");
        Q(b, d);
        b = Ig(P.Save, "gsc-result-label-button");
        $(b, "gsc-result-label-save-button");
        Q(d, b);
        Mg(b, rg(this, this.xx));
        b = Ig(P.Cancel, "gsc-result-label-button");
        Q(d, b);
        Mg(b, rg(this, this.Af));
        return a
    };
    I.Zs = function () {
        var a = W("gsc-getlink-invisible"), b = W("gsc-getlink-box");
        $(b, "gsc-inline-block");
        var d = Cg(google[pd][Yc] + "/css/link.png", null, null, "gsc-getlink-image");
        this.$c = W("gsc-getlink-text-invisible");
        var e = W("gsc-getlink-textbox"), g = U(P["get-link"], "gsc-getlink-label"), f = Jg(null, "gsc-getlink-inputbox");
        f.readOnly = !0;
        fb(f, f[Db]);
        Q(b, d);
        Q(a, b);
        Q(a, this.$c);
        Q(this.$c, e);
        Q(e, g);
        Q(e, f);
        Mg(a, rg(this, this.Kx));
        b = rg(this, this.Lx);
        this[vc][Jb] ? (this[vc][Jb]("onclick", b), h[Jb]("onclick", b)) : h[Vc] && h[Vc]("click",
            b, !0);
        return a
    };
    I.Rf = function (a, b) {
        var d = null, e = null;
        b ? b.ib ? (this.ib = b.ib, d = b[Bc], e = b.eo, this.gc = b.gc, this.Ii = b.Ii, this.Ji = b.Ji, this.ze = b.ze, this.gc == google[v].B.Nf && (this.Ma = b.Ma)) : this.ib = google[v].B.Gc : this.ib = google[v].B.Gc;
        Ja(this, W(this.Ma ? "gsc-control-searchbox-only" : "gsc-control"));
        this[vc].dir = google[v].V.Hi;
        (a = eh(a)) && ug(a, this[vc]);
        this.Bb && this.et();
        if (null != d)Na(this, d), this[Bc].onkeyup = this.qr, this[Bc].onpaste = this.rr, this.Ud = !1; else {
            this.Ud = !0;
            null == e ? e = this[vc] : e.dir = google[v].V.Hi;
            this.Je = new google[v].Ca(!0,
                e, {Gi: !0, Ss: this.If, Xf: this.rd.Xf});
            this.Je.io(this, this.Zc);
            Na(this, this.Je[Bc]);
            var e = this.Je.Di, g = this.Je.Ci, f = {interfaceLanguage: google[v][vd]};
            this.If && (f.brandingImageUrl = google[v].Ca.Uk, f.brandingImageStyle = google[v].Ca.Ys);
            this.Ii ? this.Qh && (f.maxSuggestions = this.Qh.maxCompletions, f.maxPromotions = this.Qh.maxPromotions) : f.disableAutoCompletions = !0;
            this.Ma && (f.enableAsynchronousLogging = !hh(fh(this.Ma.Ik)));
            f.useKennedyLookAndFeel = this.rd.Xf;
            f.searchButton = e;
            f.enableSpeech = b ? b.Ji : !1;
            this.Td = hg();
            this.Td.Dr(g, this[Bc], this, f);
            f.useKennedyLookAndFeel && $(g, "gsc-search-box-tools")
        }
        d || this.gc != google[v].B.Ff || (Fa(this.Je.Ci[u], "none"), Ya(this[vc][u], "hidden"));
        if (!this.Ma) {
            this.ee = W("gsc-resultsbox-invisible");
            Ng() && (this.oa = this.$s(), Q(this.ee, this.oa));
            this.vb = this.Km ? W("gsc-results-wrapper-overlay") : W("gsc-results-wrapper-nooverlay");
            Q(this[vc], this.vb);
            this.Km && (this.hf = W("gsc-modal-background-image"), Q(this[vc], this.hf), Mg(this.hf, ng(this, google[v].B[G].Zc)), this.jf = W("gsc-results-close-btn"),
                Q(this.vb, this.jf), Mg(this.jf, ng(this, google[v].B[G].Zc)));
            if (this.ib == google[v].B.hc)for (this.Dc = W("gsc-tabsAreaInvisible"), Q(this.vb, this.Dc), this.Bb && (1 < this.Z[F] && this.Lh(google[v].B.Fk), this.Oc = W(this.ok), Q(this.vb, this.Oc)), d = 0; d < this.Z[F]; d++)this.ak(this.Z[d]);
            this.Df = W("gsc-above-wrapper-area-invisible");
            Q(this.vb, this.Df);
            d = zg(0, 0, "gsc-above-wrapper-area-container");
            Q(this.Df, d);
            d = Ag(d, 0);
            e = Bg(d, "gsc-result-info-container");
            this.kf = W("gsc-result-info-invisible");
            Q(e, this.kf);
            this.Bb && this.Dm &&
                this.ib == google[v].B.hc && (e = Bg(d, "gsc-orderby-container"), this.Xb = this.bt(), Q(e, this.Xb), m(this.Xb, "gsc-orderby-invisible"));
            this.Cf && (d = Bg(d, "gsc-getlink-container"), this.sd = this.Zs(), Q(d, this.sd), m(this.sd, "gsc-getlink-invisible"));
            this.mc = this.vb;
            this.yd && (this.mc = W("gsc-wrapper"), this.wd(function (a, b) {
                b.ua = W("gsc-adBlockInvisible");
                a == google[v].Ea.kc ? Q(this.mc, b.ua) : a == google[v].Ea.Qb && Q(this.vb, b.ua)
            }), Q(this.vb, this.mc));
            Q(this.mc, this.ee);
            for (d = 0; d < this.Z[F]; d++)this.fn(this.Z[d]), this.ib ==
                google[v].B.hc && ($(this.Z[d].Ia.Fb, "gsc-tabData"), $(this.Z[d].Ia.Fb, "gsc-tabdInactive"));
            this.ib == google[v].B.hc && 0 < this.Z[F] && (this.Y = this.Z[0].Ia, this.Ve(this.Y), Pg(this.Z[0].Ia.Fb, "gsc-tabdInactive"), $(this.Z[0].Ia.Fb, "gsc-tabdActive"), this.Xb && (this.pk(this.Qd), this.di(this.Qd, this.Y.nb)))
        }
        a && (d = this.dt()) && 300 > d && $(this[vc], "gsc-narrow")
    };
    google[v].B[G].draw = google[v].B[G].Rf;
    google[v].B[G].pk = function (a) {
        if (this.Xb) {
            var b = Xg(this.Kb, "div", "gsc-option-menu-item-highlighted")[0];
            b && Pg(b, "gsc-option-menu-item-highlighted");
            this.Sd = a;
            $(Xg(this.Kb, "div", "gsc-option")[this.Sd][ud], "gsc-option-menu-item-highlighted");
            vg(this.ri, this.Vc[this.Sd][sc])
        }
    };
    google[v].B[G].di = function (a, b) {
        b instanceof google[v].G && b.Sa(google[v].A.Ka, {sort: this.Vc[a].key})
    };
    google[v].B[G].Hk = function (a) {
        var b = Xg(Xg(this.$c, "div", "gsc-getlink-textbox")[0], "input", null)[0], d = {}, e = window[bc][mc];
        var g = e[Yb]("#");
        if (1 != g[F]) {
            for (var e = g[1][Yb]("&"), f = e[F]; 0 < f--;)-1 != e[f].lastIndexOf("gsc.", 0) && e[wd](f, 1);
            e = 0 < e[F] ? g[0] + "#" + e[xd]("&") : g[0]
        }
        if (-1 != e[Qc]("?gcse-bookmark=") || -1 != e[Qc]("&gcse-bookmark="))g = e[Yb]("#"), e = 1 == g[F] ? $g(g[0], "gcse-bookmark") : $g(g[0], "gcse-bookmark") + "#" + g[1];
        d.query = this.Qe;
        this.Y.nb.Yb != P.web && this.Y.nb.Yb != P.image && (d.refine = this.Y.nb.Yb);
        this.Y.nb instanceof
        google[v].C && (d.image = "1");
        this.Xb && this.Y.nb instanceof google[v].G && (d.sortBy = this.Vc[this.Sd].key);
        a && (d.page = a);
        a = e;
        g = [];
        if (d)for (var k in d)null != d[k] && g[C]("gcse-bookmark=" + c(k + ":" + d[k]));
        d = g[xd]("&");
        k = -1 !== a[Qc]("?") ? "&" : "?";
        g = "";
        -1 !== a[Qc]("#") && (g = a[r](/.*#/, "#"), a = a[r](/#.*/, ""));
        e = a + k + d + g;
        Qa(b, e);
        vg(b, e)
    };
    google[v].B[G].Fy = function (a) {
        switch (a) {
            case google[v].B.iq:
            case google[v].B.vi:
            case google[v].B.gq:
                this.qi = a;
                break;
            default:
                this.qi = google[v].B.vi
        }
    };
    google[v].B[G].setTimeoutInterval = google[v].B[G].Fy;
    google[v].B[G].Ay = function (a, b, d) {
        if (d)switch (d) {
            case google[v].B.dq:
            case google[v].B.cq:
            case google[v].B.bq:
            case google[v].B.$p:
            case google[v].B.Zp:
                this.Gj = P[d];
                break;
            default:
                this.Gj = d
        }
        this.Mh = rg(a, b)
    };
    google[v].B[G].setOnKeepCallback = google[v].B[G].Ay;
    I = google[v].B[G];
    I.Zf = function (a) {
        var b = a.pa;
        return this.Bb ? "web" == b && a.N ? !1 : !0 : "blog" == b || "image" == b ? !0 : !1
    };
    I.Ve = function (a) {
        1 == a.Pb ? a.ta.onclick ? (Mg(a.ta, null), Pg(a.ta, this.Yi), $(a.ta, this.Pl)) : (Mg(a.ta, ng(this, this.Ue, [a])), Pg(a.ta, this.Pl), $(a.ta, this.Yi)) : a.ta.onclick ? (Mg(a.ta, null), Pg(a.ta, "gsc-tabhInactive"), $(a.ta, "gsc-tabhActive")) : (Mg(a.ta, ng(this, this.Ue, [a])), Pg(a.ta, "gsc-tabhActive"), $(a.ta, "gsc-tabhInactive"))
    };
    I.Ue = function (a, b) {
        if (this.Y != a) {
            this.Hj(!0);
            Pg(this.Y.Fb, "gsc-tabdActive");
            $(this.Y.Fb, "gsc-tabdInactive");
            this.Ve(this.Y);
            var d = this.Xc(this.Y.Jb), e = this.Xc(a.Jb);
            1 == this.Y.Pb && d != e && ($(d.Kc, "gsc-refinementBlockInvisible"), this.Ve(d.Ia));
            this.Y = a;
            d = this.Y.nb;
            this.Ve(this.Y);
            this.Xb && this.di(this.Sd, this.Y.nb);
            this.Cf && this.Hk();
            1 == this.Y.Pb && e.Ia.ta.onclick && this.Ve(e.Ia);
            this.to();
            e = null;
            !b && this.kb && this.kb[jc]() && (e = this.kb.Qg(), this.Vo(a, e));
            $(this.Y.Fb, "gsc-tabdActive");
            Pg(this.Y.Fb, "gsc-tabdInactive");
            var g = b ? b.Zh : this.Qe, f = g && g == d.Ye;
            b && (f = f && b[xc] == d.ij());
            this.sd && this.Gm();
            if (f) {
                e && (e[google[v].M.cd] = d.ij(), this.kb[ib](e));
                if (!this.uo(d.Ye, d.ij()) || lg("opera") && b)this.Vd = d.Vd, this.Gk(d.Ye, d.ij());
                this.Y.Jb.vp || (this.Fm(this.Y.Jb), this.Em(d), this.Xb && this.Hm())
            } else g && this.Dp(g, b && b[xc], null, e)
        }
    };
    I.uo = function (a, b) {
        var d = this.Va[google[v].Ea.Eb];
        return!!this.Ga && this.Ga.query == a && (this.Ga.adPage || 1) == (b || 1) && !(d.$a && this.Y && this.Y.Jb.xa != d.ua[ud])
    };
    I.Em = function (a) {
        var b = a.results, d = a[Sb];
        this.ib != google[v].B.Gc && (this.kf.id = "resInfo-" + a.ht);
        this.ib != google[v].B.Gc && 0 < b[F] && d && d.resultCount && d.searchResultTime ? (a = wg(P["result-info"](d.resultCount, d.searchResultTime)), ug(this.kf, a), m(this.kf, "gsc-result-info")) : (m(this.kf, "gsc-result-info-invisible"), tg(this.kf))
    };
    I.vr = function () {
        if (this.oa && !this.rn) {
            var a = google[v].Oa.ox();
            this.rn = !0;
            if (a && a[F])for (var b = Xg(this.oa, null, "gsc-labels-box")[0], d = 0; d < a[F]; d++) {
                var e = Kg(a[d].Title, a[d].Label[Zc], null, "gsc-label-checkbox"), g = yg(a[d].Title, "gsc-label-result-labels"), f = W("gsc-label-box");
                Q(f, e);
                Q(f, g);
                Q(b, f)
            } else Pg(this.yj, "gsc-labels-no-label-div-invisible"), $(this.yj, "gsc-labels-no-label-div-visible"), Pg(this.Hq, "gsc-labels-label-div-visible"), $(this.Hq, "gsc-labels-label-div-invisible")
        }
    };
    I.Vp = function (a, b) {
        if (a.J.N)for (var d = 0; d < a.Za[F]; d++) {
            var e = a.Za[d];
            if (e.J.Yd(b))return e.Ia
        }
        return null
    };
    I.Rj = function (a, b) {
        var d = this.Vp(a, b), e = !0;
        d || (d = a.Ia, e = !1);
        this.Ue(d);
        return e
    };
    I.Br = function (a, b, d) {
        var e = Xg(this.oa, "input", "gsc-label-checkbox");
        d = Xg(d, "a", "gs-label");
        for (var g = 0; g < e[F]; g++) {
            Aa(e[g], !1);
            bb(e[g], !1);
            for (var f = 1; d && f < d[F]; f++)e[g][Pc] == d[f][md]("data-refinementlabel") && (Aa(e[g], !0), bb(e[g], !0))
        }
        (e = Xg(this.oa, null, "gsc-label-result-form-div")[0]) && (e = Xg(e, "input", null)[0]) && e.click();
        $(this.Od, "gsc-modal-background-image-visible");
        Pg(this.oa, "gsc-label-result-main-box-invisible");
        m(this.oa, "gsc-label-result-main-box-visible");
        vg(Xg(this.oa, null, "gsc-label-result-url")[0],
            unescape(a));
        e = Xg(this.oa, null, "gsc-label-result-url-title")[0];
        Ea(e, a);
        vg(e, b);
        Qa(Xg(this.oa, null, "gsc-label-result-label-prefix-visible")[0], unescape(a))
    };
    I.Af = function () {
        Pg(this.oa, "gsc-label-result-main-box-visible");
        m(this.oa, "gsc-label-result-main-box-invisible");
        Pg(this.Od, "gsc-modal-background-image-visible");
        this.im();
        this.qx()
    };
    I.qx = function () {
        $(Xg(this.oa, null, "gsc-add-label-error")[0], "gsc-add-label-error-invisible")
    };
    I.ux = function () {
        Pg(Xg(this.oa, null, "gsc-add-label-error")[0], "gsc-add-label-error-invisible")
    };
    I.tx = function () {
        $(Xg(this.oa, null, "gsc-label-result-saving-popup")[0], "gsc-label-result-saving-popup-invisible")
    };
    I.lx = function () {
        Pg(Xg(this.oa, null, "gsc-label-result-saving-popup")[0], "gsc-label-result-saving-popup-invisible")
    };
    I.im = function () {
        $(Xg(this.oa, null, "gsc-label-result-label-prefix-error")[0], "gsc-label-result-label-prefix-error-invisible")
    };
    I.kx = function () {
        Pg(Xg(this.oa, null, "gsc-label-result-label-prefix-error")[0], "gsc-label-result-label-prefix-error-invisible")
    };
    I.Qx = function () {
        var a = Xg(this.oa, null, "gsc-label-result-label-prefix-invisible")[0];
        a && Pg(a, "gsc-label-result-label-prefix-invisible")
    };
    I.kr = function () {
        this.im();
        var a = Xg(this.oa, null, "gsc-label-result-label-prefix-visible")[0];
        a && $(a, "gsc-label-result-label-prefix-invisible")
    };
    I.vx = function (a, b) {
        for (var d = Xg(this.Y.Jb[vc], null, "gs-per-result-labels"), e = null, g = 0; g < d[F]; g++)if (d[g][md]("url") == a) {
            e = d[g];
            break
        }
        if (e) {
            for (; 1 < e[Hb][F];)e[id](e[Hb][1]);
            for (g = 0; g < b[F]; g++)e[p](this.px(b[g]))
        }
    };
    I.xx = function () {
        for (var a = Xg(this.oa, null, "gsc-label-checkbox"), b = [], d = !1, e = 0; e < a[F]; e++)a[e][Tb] && b[C](a[e][Pc]), a[e][Tb] && !a[e].disabled && (d = !0);
        if (d) {
            var g = Xg(this.oa, null, "gsc-label-result-url")[0].innerText, f = this.ix(g);
            if (f) {
                this.im();
                this.gx();
                this.lx();
                var k = this;
                google[v].Oa.jx(google[v].Oa.Pq() + "&num=5000", function (a) {
                    k.hx(g, f, b, a)
                })
            } else this.kx()
        }
    };
    I.gx = function () {
        var a = Xg(this.oa, null, "gsc-label-results-close-btn-visible")[0];
        a && Mg(a, null);
        this.Od && Mg(this.Od, null);
        this.Wq(!0)
    };
    I.rx = function () {
        var a = Xg(this.oa, null, "gsc-label-results-close-btn-visible")[0];
        a && Mg(a, ng(this, this.Af));
        this.Od && Mg(this.Od, ng(this, this.Af));
        this.Wq(!1)
    };
    I.Wq = function (a) {
        for (var b = Xg(this.oa, null, "gsc-result-label-button"), d = 0; b && d < b[F]; d++)bb(b[d], a);
        if (d = Xg(this.oa, null, "gsc-label-result-form-div")[0])for (b = Xg(d, "input", null), d = 0; b && d < b[F]; d++)bb(b[d], a)
    };
    I.hx = function (a, b, d, e) {
        e = google[v].Oa.zx(b, e);
        b = google[v].Oa.Ax(b, d, e);
        var g = this;
        google[v].Oa.Bx(google[v].Oa.Pq(), b, function (b) {
            g.yx(a, b)
        })
    };
    I.yx = function (a, b) {
        var d = google[v].Oa.sx(b);
        this.tx();
        this.rx();
        d && d[F] ? (this.vx(a, d), this.Af()) : this.ux()
    };
    I.ix = function (a) {
        var b = "", d = gh(a), e = Xg(Xg(this.oa, "div", "gsc-label-result-form-div")[0], "input");
        e[0][Tb] ? b = a : e[1][Tb] ? b = d : e[2][Tb] && (e = Xg(this.oa, "input", "gsc-label-result-label-prefix-visible")[0][Pc], d == gh(e) && 0 == a[Qc](e) && (b = e));
        return b
    };
    I.Nh = function (a, b) {
        b ? ($(this[vc], "gsc-loading-fade"), a.vp = !0, $(a.lb, "gsc-loading-resultsRoot"), 0 == a.Pb && this.Oc && $(this.Oc, "gsc-loading-refinementsArea")) : (Pg(this[vc], "gsc-loading-fade"), a.vp = !1, Pg(a.lb, "gsc-loading-resultsRoot"), this.Oc && Pg(this.Oc, "gsc-loading-refinementsArea"))
    };
    I.to = function () {
        this.yd && (this.Zf(this.Y.nb) ? this.Og() : this.Yl())
    };
    I.Fw = function (a) {
        var b = this.Va[google[v].Ea.Eb];
        if (b.ua[ud] != a.xa) {
            var d = Xg(a.xa, "div", "gsc-cursor-box")[0];
            d && d[ud] == a.xa ? a.xa[xb](b.ua, d) : Q(a.xa, b.ua)
        }
    };
    I.Og = function () {
        this.yd && this.wd(function (a, b) {
            m(b.ua, "gsc-adBlockInvisible");
            b.$a && b.cc && Pg(this.mc, b.cc)
        })
    };
    I.Yl = function () {
        this.yd && this.wd(function (a, b) {
            0 < b.ke ? (m(b.ua, b[cd]), b.cc && $(this.mc, b.cc)) : (m(b.ua, "gsc-adBlockInvisible"), b.cc && Pg(this.mc, b.cc))
        })
    };
    I.submit = function () {
        return this.pr(null)
    };
    google[v].B[G].submit = google[v].B[G][Dc];
    I = google[v].B[G];
    I.pr = function (a, b) {
        this[Bc][Pc][F] ? this.Ma ? this.qp(b) : this.ra(void 0, void 0, b) : this.Zc();
        return!1
    };
    I.Qv = function (a) {
        return this.pr(null, a)
    };
    I.qp = function (a) {
        var b = this.Ma.lw, b = this.Ma.Ik + (0 <= this.Ma.Ik[Qc](b) ? "&" : b) + c(this.Ma.mw) + "=" + c(this[Bc][Pc]);
        (a = Zg(a)) && (b += "&" + a);
        this.Ma.kw ? window[yc](b) : window.location = b
    };
    I.Jj = function () {
        this.Dc && !this.Wt && (!this.Bb || 1 < this.Z[F]) && m(this.Dc, "gsc-tabsArea");
        !this.Oc || 1 == this.Z[F] && 0 == this.Z[0].Za[F] || m(this.Oc, this.Jp)
    };
    I.Ew = function (a) {
        var b = this;
        return function (d, e) {
            if (e) {
                b.Va[a].ke = 1;
                var g = 0, f = 0;
                b.wd(function (a, b) {
                    b.$a && b.jq && (g++, b.ke && f++)
                });
                g == f ? (window[kb](b.nx), b.Yl()) : 1 == f && (b.nx = window[Xb](function () {
                    b.Yl()
                }, 200))
            }
        }
    };
    I.kj = function () {
        return null
    };
    google[v].B[G].getPartnerId = google[v].B[G].kj;
    google[v].B[G].et = function () {
        var a = xg("", "gsc-input"), b = Jg(null, "gsc-input", null);
        Fa(b[u], "none");
        b[u].background = google[v].Ca.Mw();
        Q(a, b);
        Q(this[vc], a);
        var d = "";
        h[Xc] && h[Xc][ec] ? (b = h[Xc][ec](b, null)) && (d = b.backgroundImage || "") : b[qd] && (d = b[qd].backgroundImage || "");
        -1 != d[v](google[v].I.Lw) && (this.If = !0, this.Xa && this.Xa.uq(Wg("gcsc-", void 0, !1, "http://www.google.com/cse/?hl=" + google[v][vd], P["custom-search"])), this.cb && this.cb.uq(Wg("gcsc-", void 0, !1, "http://www.google.com/cse/?hl=" + google[v][vd], P["custom-search"])));
        this[vc][id](a)
    };
    google[v].B[G].hj = function (a) {
        if (this.Ud)this.Td.Uc(a); else if (Qa(this[Bc], a), this[Bc].onfocus)this[Bc].onfocus(null)
    };
    google[v].B[G].prefillQuery = google[v].B[G].hj;
    google[v].B[G].Ox = function (a) {
        a ? this.hj(a) : a = this.Ud ? this.Td.fb() : this[Bc][Pc];
        return a
    };
    google[v].B[G].Gq = function () {
        return this.Ud ? this.Td.fb() : this[Bc][Pc]
    };
    google[v].B[G].getInputQuery = google[v].B[G].Gq;
    google[v].B[G].ra = function (a, b, d) {
        this.Dp(a, b, d)
    };
    google[v].B[G].execute = google[v].B[G].ra;
    I = google[v].B[G];
    I.Dp = function (a, b, d, e, g) {
        a = this.Ox(a);
        this.Il(a, b, d, e, g)
    };
    I.Il = function (a, b, d, e, g) {
        if (a[F]) {
            this.Ef = !1;
            this.Qe = a;
            this.Vg = b || 1;
            this.Cf && this.Hk();
            this.kb && this.kb[jc]() && (e = e || this.kb.Qg(), e[google[v].M.Wg] = a, null == b ? delete e[google[v].M.cd] : e[google[v].M.cd] = b, this.Xb && this.Y.nb instanceof google[v].G && (e[google[v].M.Vi] = this.Vc[this.Sd].key), this.kb[ib](e));
            this.Vd = google[pd].createGuidArg_();
            e = !1;
            if (this.ib == google[v].B.hc)e = this.Wo(this.Y.Jb, this.Y.Fb, a, g, b, d) || e; else for (var f = 0; f < this.Z[F]; f++)e = this.Wo(this.Z[f], this.Z[f][vc], a, g, b, d) || e;
            g = this.uo(a,
                b);
            e || !g ? (g = "", d && d.gs_l && 23 < d.gs_l[Yb](".")[F] && (g = d.gs_l[Yb](".")[23]), this.Gk(a, b, g)) : this.to()
        }
    };
    I.Iu = function () {
        return this.Vd
    };
    I.Gk = function (a, b, d) {
        var e = this.yd;
        e && (this.cs && this.ib == google[v].B.Gc || this.ib == google[v].B.hc && this.Zf(this.Y.nb)) && (e = !1);
        var g = this.Vs(), f = this.Us();
        void 0 != g || this.Ed || this.bo || (e = !1);
        this.ib != google[v].B.hc && (this.Va[google[v].Ea.Eb].$a = !1);
        if (e)if (this.Xs(), this.bo) {
            this.Og();
            this.wd(function (a, b) {
                Oa(b.ua, "")
            });
            this.Ga = {};
            this.Ga.pubId = this.Ed || "google-coop";
            this.Ga.gcsc = !0;
            g ? this.Ga.cx = g : f && (this.Ga.cref = f);
            this.Ga.hl = google[v][vd] ? c(google[v][vd]) : null;
            this.Ga.adtest = this.jk ? "on" : null;
            this.Ga.channel =
                this.Ei ? this.Ei : null;
            this.Ga.adsafe = this.Ek || null;
            this.Ga.query = a;
            this.Ga.adstyle = this.Yn ? this.Yn : null;
            b && (this.Ga.adPage = b);
            this.Ga.containerWidth = this.Mm || this.vb[sb];
            this.Bb && (this.Ga.cseGoogleHosting = "full" == this.Fi || "iframe" == this.Fi || "partner" == this.Fi ? this.Fi : "partner", this.Ga.fontSizeDescription = google[v].B.ho, this.Ga.fontSizeDomainLink = google[v].B.ho, this.Ga.fontSizeTitle = google[v].B.Ts);
            window.___bg_ && h[Lc]("bgresponse") && (window.___bg_.invoke(function (a) {
                Qa(h[Lc]("bgresponse"), a)
            }), this.Ga.bgresponse =
                h[Lc]("bgresponse")[Pc], d && (this.Ga.sbsignals = d), window.___gcse_nc_ && (this.Ga.num_comp = window.___gcse_nc_));
            if ((b = google[v].A.Dk()) && b in google[v].B.Jd) {
                b = google[v].B.Jd[b];
                for (var k in b)this.Ga[k] = b[k]
            }
            google && google.ads && google.ads[v] && google.ads[v].Ads ? this.fo() : this.Tk = !0
        } else {
            k = "";
            this.Va[google[v].Ea.kc].$a && (k = k + "w" + this.Va[google[v].Ea.kc].ed);
            this.Va[google[v].Ea.Qb].$a && (k = k + "n" + this.Va[google[v].Ea.Qb].ed);
            k = "http://www.google.com/" + (g ? "cse" : "search") + "?output=js&num=0&ie=utf8&oe=utf8&q=" +
                c(a) + "&hl=" + c(google[v][vd]) + "&ad=" + c(k) + "&js=uds&" + this.Vd;
            g && (k += "&cx=" + g);
            this.Ed && (k += "&client=" + c(this.Ed));
            this.Ei && (k += "&channel=" + c(this.Ei));
            this.jk && (k += "&adtest=on");
            this.Zn && (k += "&ip=" + c(this.Zn));
            this.Ek && (k += "&adsafe=" + c(this.Ek));
            this.$n && (k += "&useragent=" + c(this.$n));
            b && (k += "&adpage=" + c(b + ""));
            var l = this;
            window.google_afs_request_done = function (a) {
                l.Ws(a)
            };
            pg(k)
        }
    };
    I.wd = function (a) {
        for (var b in google[v].Ea)if (google[v].Ea[dc](b)) {
            var d = google[v].Ea[b];
            a[kd](this, d, this.Va[d])
        }
    };
    I.fo = function () {
        var a = [];
        this.wd(function (b, d) {
            d.ke = 0;
            if (d.$a && 0 < d.ed) {
                d.jq = !0;
                d.Ul = {container: d.ua, number: d.ed, callback: this.Ew(b), position: b};
                for (var e in d.ji)null != d.Ul[e] && (d.Ul[e] = d.ji);
                a[C](d.Ul)
            } else d.jq = !1;
            b == google[v].Ea.Eb && this.Fw(this.Y.Jb);
            m(d.ua, "gsc-adBlockNoHeight");
            Ia(d.ua[u], "0px")
        });
        0 < a[F] && new google.ads[v].Ads(this.Ga, a)
    };
    I.Wo = function (a, b, d, e, g, f) {
        b = a.J;
        this.dk && this.dk(this, b, d);
        this.ck && this.ck(this, b, d);
        b.gd && (b.gd = null);
        var k = !1;
        if (e)b.vj(e); else {
            e = {};
            if (f)for (var l in f)e[l] = f[l];
            for (l in this.cn)e[l] || (e[l] = this.cn[l]);
            this.Bb && this.Ed && (e.cseclient = this.Ed);
            k = b.ra(d, e, g)
        }
        this.Nh(a, k);
        return k
    };
    I.Vs = function () {
        for (var a = 0; a < this.Z[F]; a++) {
            var b = this.Z[a].J;
            if ("web" == b.pa && b.N && b.uh() == google[v].G.yf)return b.vh()
        }
        return null
    };
    I.Us = function () {
        for (var a = 0; a < this.Z[F]; a++) {
            var b = this.Z[a].J;
            if ("web" == b.pa && b.N && b.uh() == google[v].G.Sc)return b.vh()
        }
        return null
    };
    I.Ws = function (a) {
        window.google_afs_request_done = null;
        var b = this.Va[google[v].Ea.kc], d = this.Va[google[v].Ea.Qb];
        if (b.ua)if (Oa(b.ua, ""), Oa(d.ua, ""), b.ke = d.ke = 0, !a || 1 > a[F])this.Og(); else {
            if (!this.Dc)for (var e = 0; e < this.Z[F]; e++) {
                var g = this.Z[e].J;
                if (this.Zf(g)) {
                    this.Og();
                    return
                }
            }
            m(b.ua, b[cd]);
            var g = !1, f = h[t]("h2"), e = "";
            this.jk && (e = "*DEBUG* ");
            e += P["ads-by-google"];
            Oa(f, e);
            Q(b.ua, f);
            for (var k = a[F], e = 0; e < k; e++) {
                var l = a[e];
                if ("text/wide" == l[Wc]) {
                    b.ke++;
                    var n = W("gsc-ad"), q = Eg(l.url, l.line1, google[v].A.Kf);
                    Q(n, q);
                    q = h[t]("cite");
                    Oa(q, l.visible_url);
                    Q(n, q);
                    q = yg();
                    Oa(q, l.line2);
                    Q(n, q);
                    Q(b.ua, n)
                } else d.$a && (d.ke++, g || (g = !0, $(this.mc, d.cc), Q(d.ua, f[Fb](!0)), m(d.ua, d[cd])), n = W("gsc-ad"), q = Eg(l.url, l.line1, google[v].A.Kf), Q(n, q), q = yg(), Oa(q, l.line2 + "<br/>" + l.line3), Q(n, q), q = h[t]("cite"), Oa(q, l.visible_url), Q(n, q), Q(d.ua, n))
            }
            d.$a && !g && Pg(this.mc, d.cc);
            this.Dc && (g = this.Y.nb, this.Zf(g) && this.Og());
            this.Gf && this.Co && this.Gf(this, "ads")
        }
    };
    I.es = function () {
        var a = this[Bc][Pc];
        a && "" != a && (this.Ze && window[kb](this.Ze), this.Ze = window[Xb](ng(this, google[v].B[G].ra, [null]), this.qi))
    };
    I.fs = function () {
        this.Ze && window[kb](this.Ze);
        this.Ze = window[Xb](ng(this, google[v].B[G].ra, [null]), this.qi)
    };
    I.Xs = function () {
        var a = google[v].Ea, b = {};
        if (this.Va[a.kc].$a)switch (this.bk) {
            case google[v].A.Jc:
                b[a.kc] = 3;
                b[a.Qb] = 5;
                b[a.Eb] = 3;
                break;
            case google[v].A.vc:
                b[a.kc] = 2;
                b[a.Qb] = 4;
                b[a.Eb] = 2;
                break;
            default:
                b[a.kc] = 1, b[a.Qb] = 2, b[a.Eb] = 1
        } else switch (b[a.kc] = 0, this.bk) {
            case google[v].A.Jc:
                b[a.Qb] = 8;
                b[a.Eb] = 3;
                break;
            case google[v].A.vc:
                b[a.Qb] = 6;
                b[a.Eb] = 2;
                break;
            case google[v].A.$b:
                b[a.Qb] = 3;
                b[a.Eb] = 1;
                break;
            default:
                b[a.Qb] = 6, b[a.Eb] = 2
        }
        this.wd(function (a, e) {
            void 0 == e.ed && (e.ed = b[a])
        })
    };
    I.Da = function (a) {
        if (0 < a && 8 >= a)this.Oe = a; else switch (a) {
            case google[v].A.vc:
                this.Oe = google[v].A.vc;
                break;
            case google[v].A.Jc:
                this.Oe = google[v].A.Jc;
                break;
            default:
            case google[v].A.$b:
                this.Oe = google[v].A.$b
        }
        for (var b = 0; b < this.Z[F]; b++)this.Z[b].J.Da(a);
        this.bk = a
    };
    google[v].B[G].setResultSetSize = google[v].B[G].Da;
    google[v].B[G].Pa = function (a) {
        this.Wc = a;
        for (var b = 0; b < this.Z[F]; b++)this.Z[b].J.Pa(a)
    };
    google[v].B[G].setLinkTarget = google[v].B[G].Pa;
    google[v].B[G].Pe = function (a) {
        for (var b = 0; b < this.Z[F]; b++)this.Z[b].ob.Pe(a)
    };
    google[v].B[G].setNoResultsString = google[v].B[G].Pe;
    I = google[v].B[G];
    I.Lu = function (a) {
        a.xl ? this.Ne(a, !1) : this.Ne(a, !0)
    };
    I.Ne = function (a, b, d) {
        b ? (Pg(a.ne, "gsc-twiddle-closed"), $(a.ne, "gsc-twiddle-opened"), a.xl = !0, Fa(a.lb[u], "block")) : (Pg(a.ne, "gsc-twiddle-opened"), $(a.ne, "gsc-twiddle-closed"), a.xl = !1, Fa(a.lb[u], "none"), ug(a.Jf, d ? wg("(0)") : wg("(" + a.J.results[F] + ")")))
    };
    I.Ju = function (a) {
        this.Vh(a, !1, !0);
        return!1
    };
    I.Ku = function (a) {
        a.J.pf && (a.ul ? this.Vh(a, !1, !0) : this.Vh(a, !0, !0))
    };
    I.Vh = function (a, b, d) {
        b ? a.Vb && a.J.Hc && ($(a.Vb, "gsc-twiddle-opened"), Pg(a.Vb, "gsc-twiddle-closed"), Oa(a.Vb, P[gc]), a.ul = !0, Fa(a.Ld[u], "block"), a.J.Hc(a.nf, !0)) : a.Vb && a.J.Hc && (Pg(a.Vb, "gsc-twiddle-opened"), $(a.Vb, "gsc-twiddle-closed"), Oa(a.Vb, P.blank), a.ul = !1, a.J.Hc(a.nf, !1), Fa(a.Ld[u], "none"), d && this.ra())
    };
    I.zr = function (a) {
        this.Mh && this.Mh(a)
    };
    I.$x = function () {
        this.Ef = !0
    };
    google[v].B[G].cancelSearch = google[v].B[G].$x;
    google[v].B[G].Hj = function (a) {
        if (a) {
            if (m(this.ee, "gsc-resultsbox-visible"), $(this.vb, "gsc-results-wrapper-visible"), this.jf && $(this.jf, "gsc-results-close-btn-visible"), this.hf) {
                $(this.hf, "gsc-modal-background-image-visible");
                var b = h[Pb]("body")[0];
                $(b, "gsc-overflow-hidden")
            }
        } else m(this.ee, "gsc-resultsbox-invisible"), Pg(this.vb, "gsc-results-wrapper-visible"), this.jf && Pg(this.jf, "gsc-results-close-btn-visible"), this.hf && (Pg(this.hf, "gsc-modal-background-image-visible"), b = h[Pb]("body")[0], Pg(b, "gsc-overflow-hidden"));
        for (b = 0; b < this.Z[F]; b++)this.Z[b].dl || (a ? (Pg(this.Z[b][vc], "gsc-resultsbox-invisible"), $(this.Z[b][vc], "gsc-resultsbox-visible")) : (Pg(this.Z[b][vc], "gsc-resultsbox-visible"), $(this.Z[b][vc], "gsc-resultsbox-invisible")))
    };
    google[v].B[G].Zc = function () {
        this.Ud ? this.Td.Uc("") : Qa(this[Bc], "");
        this.Vg = this.Qe = null;
        if (this.gc != google[v].B.Nf && (this.gc == google[v].B.Ff && Ya(this[vc][u], "hidden"), this.Hj(!1), this.Dc && m(this.Dc, "gsc-tabsAreaInvisible"), this.Oc && m(this.Oc, this.ok), this.wd(function (a, d) {
            d.ua && (m(d.ua, "gsc-adBlockInvisible"), d.cc && Pg(this.mc, d.cc))
        }), m(this.Df, "gsc-above-wrapper-area-invisible"), this.kb && this.kb[jc]())) {
            var a = this.kb.Qg();
            delete a[google[v].M.cd];
            delete a[google[v].M.Wg];
            this.kb[ib](a)
        }
    };
    google[v].B[G].clearAllResults = google[v].B[G].Zc;
    google[v].B[G].iy = function () {
        var a = google[v].F[H].ll(window[bc][v]) || {};
        if (!a.query)return!1;
        a.refine && (this.Fj = a.refine);
        a.image && (this.Yj = 1 == a.image ? google[v].I.sn : google[v].I.tn);
        a.sortBy && (this.Qd = this.Xj(a.sortBy) || 0);
        return this.Lm = !0
    };
    google[v].B[G].enableBookmark = google[v].B[G].iy;
    I = google[v].B[G];
    I.Sj = function (a, b, d, e, g) {
        a = a.Bc ? a.Bc(b) : b;
        e ? (b = {}, b[e] = g, e = ng(this, this.ra, [a, void 0, b])) : e = ng(this, this.ra, [a]);
        Mg(d, e)
    };
    I.Hm = function () {
        m(this.Xb, this.Bb && this.Y.Jb.J instanceof google[v].G ? "gsc-orderby" : "gsc-orderby-invisible")
    };
    I.Gm = function () {
        m(this.sd, this.Bb ? "gsc-getlink" : "gsc-getlink-invisible")
    };
    I.Rm = function (a) {
        var b = function (a, b) {
            for (var g = a[Cb]; g;) {
                var f = g[Mb];
                g != b && a[id](g);
                g = f
            }
        };
        b(a.xa, this.Va[google[v].Ea.Eb].ua);
        b(a.lb, a.xa)
    };
    I.pb = function (a) {
        this.gc == google[v].B.Ff && Ya(this[vc][u], "visible");
        this.Nh(a, !1);
        this.Hj(!0);
        var b, d, e = !1, g;
        if (!this.Ef) {
            this.Rm(a);
            var f = ["gsc-results", a.J.$d()][xd](" ");
            m(a.lb, f);
            this.Ne(a, !1, !0);
            this.Vh(a, !1, !1);
            a.Ij(google[v].hb.Kj);
            this.rd.Om && (d = a.J.Oh) && a.lb[xb](d[Fb](!0), a.xa);
            if (f = a.J.spelling)if (!f.html && a.J.Pf && a.J.Pf(f), f.html) {
                var k = f.html[Fb](!0), l = k[Pb]("a");
                f[Wc] && "SPELL_CORRECTED_RESULTS" == f[Wc] ? l && 1 < l[F] && (this.Sj(a.J, f.correctedQuery, l[0], f.correctedParamName, f.correctedParamValue),
                    this.Sj(a.J, f.originalQuery, l[1], f.originalParamName, f.originalParamValue)) : l && 0 < l[F] && this.Sj(a.J, f.correctedQuery, l[0]);
                g = W(a.J.$d());
                $(g, "gsc-result");
                Q(g, k);
                a.lb[xb](g, a.xa)
            }
            f = a.J.context || {};
            l = this.Dc && f;
            this.Bb && !this.sr && l && (d = f[bd], g = this.Xc(a), d && !g.J.Yb && ug(g.Ia.ta, this.Pm(google[v].V.Wd(d))), this.sr = !0);
            var n = a.J.promotions;
            if (n && 0 < n[F])for (d = 0; d < n[F]; d++)b = n[d], b.html || a.J.Xh(b, this.rd), b.html && (g = W(a.J.$d()), $(g, "gsc-result"), $(g, "gsc-promotion"), k = b.html[Fb](!0), Q(g, k), a.lb[xb](g, a.xa));
            n = a.J.results;
            a.J.td && 400 <= a.J.completionStatus ? (n = [], n[C](a.J.wr())) : 0 == n[F] && a.ob.Rd && 200 == a.J.completionStatus && (n = [], n[C](a.J.xr(a.ob.Rd)));
            m(this.Df, "gsc-above-wrapper-area");
            this.Em(a.J);
            this.oa && this.vr();
            this.Xb && this.Hm();
            this.sd && this.Gm();
            d = this.Y && this.Y.nb && "Web" == this.Y.nb.Yb && 0 < a.J.results[F] && 0 === a.J[Sb].currentPageIndex;
            if (f.html && d) {
                g = W(a.J.$d());
                $(g, "gsc-result");
                k = f.html[Fb](!0);
                Q(g, k);
                d = Xg(g, "div", "gsc-facet-label");
                for (var q = 0; q < d[F]; q++)if (b = d[q]) {
                    var s = b[Pb]("a"), k = this.Xc(a);
                    b = 0;
                    for (var x; x = s[b]; b++) {
                        var y = x[md]("data-refinementLabel");
                        if (y != a.J.nc()) {
                            var E = x[md]("label-with-op");
                            E || (E = y);
                            Mg(x, ng(this, this.Rj, [k, E]))
                        } else $(x, "gs-labelActive")
                    }
                }
                a.lb[xb](g, a.xa)
            }
            Ng() && (this.Jb = a);
            for (d = 0; d < n[F]; d++)if (b = n[d], b.html || a.J.Ra(b), b.html) {
                e = !0;
                g = W(a.J.$d());
                $(g, "gsc-result");
                a.J.Hf && $(g, "gsc-result-" + a.J.Hf);
                k = b.html[Fb](!0);
                if (b.GsearchResultClass == google[v].ya.Wa && a.ob.Sh)for (q = k[Pb]("img"), s = 0; s < q[F]; s++)google[v].A.Zb(b.tbWidth, b.tbHeight, a.ob.Sh, q[s]);
                Q(g, k);
                (k = Xg(g, "div",
                    "gs-per-result-labels")[0]) && (q = Xg(k, null, "gs-add-label")[0]) && Mg(q, ng(this, this.Br, [b.url, b.titleNoFormatting, k]));
                if (b.perResultLabels && this.Bb && (k = Xg(g, "div", "gs-per-result-labels")[0]))for (s = k[Pb]("a"), k = this.Xc(a), q = Ng() ? 1 : 0; x = s[q]; q++)y = x[md]("data-refinementLabel"), y != a.J.nc() ? ((E = x[md]("label-with-op")) || (E = y), Mg(x, ng(this, this.Rj, [k, E]))) : $(x, "gs-labelActive");
                this.Mh && (k = this.Gj, q = U("", "gsc-keeper"), Oa(q, k), Q(g, q), fb(q, ng(this, google[v].B[G].zr, [b, a])));
                if (d >= a.J.Ej)0 == d && a.ob.lc == google[v].B.Xd &&
                Fa(a.xa[u], "none"), (b = this.Va[google[v].Ea.Eb].ua) && b[ud] == a.xa ? a.xa[xb](g, b) : Q(a.xa, g); else a.lb[xb](g, a.xa)
            }
            a.J.va && a.J.gwsUrl && a.J[Sb] && (d = W("gsc-cursor-box gs-bidi-start-align"), d.dir = "ltr", g = this.ur(a), d[p](g), Q(a.xa, d));
            e ? (ug(a.Jf, wg("(" + a.J.results[F] + ")")), a.ob.lc == google[v].B.Xd || a.ob.lc == google[v].B.Be ? this.Ne(a, !0) : this.Ne(a, !1), (e = a.J.Sm()) && Q(a.lb, e)) : (ug(a.Jf, wg("(0)")), this.Rm(a), this.Ne(a, !1));
            a.ob.lc = a.ob.Nm;
            this.rd.Om || (d = a.J.Oh) && Q(a.lb, d[Fb](!0));
            if (this.Bb && l && (0 == a.Pb || a.De)) {
                k =
                    this.Xc(a);
                e = 0 == a.Pb && this.yr(a);
                l = a.De && 1 == k.Za[F];
                if (e || l) {
                    if (e && this.tr(a), f.facets && 0 < f.facets[F]) {
                        e && this.Im(a);
                        g = !1;
                        n = f.facets;
                        if (n[F] > this.ze && 0 < f.display_facets[F] && -1 !== this.ze)for (n[od](function (a, b) {
                            return b[cc] - a[cc]
                        }), d = n[F]; d > this.ze; d--)n.pop();
                        for (d = 0; d < n[F]; d++) {
                            f = n[d];
                            b = f.label_with_op;
                            if (!b || this.Fj)b = f[sc];
                            e || l && !a.J.Yd(b) ? this.Jm(k, b, f[ld]) : (a.J.jc(f[ld]), this.Tm(k), g = !0)
                        }
                        l && !g && this.Tm(k)
                    }
                } else if (a.De && f.facets && 0 < f.facets[F])for (n = f.facets, d = 0; d < n[F]; d++)f = n[d], a.J.Yd(f[sc]) &&
                    a.J.jc(f[ld]);
                a.De && (a.De = !1)
            }
            this.Bb && this.Dc && this.Y && a == this.Y.Jb && this.Fm(a);
            this.Bb && this.Ar(a);
            this.Jj();
            this.Gf && this.Gf(this, a.J)
        }
    };
    google[v].B[G].onSearchComplete = google[v].B[G].pb;
    I = google[v].B[G];
    I.Jm = function (a, b, d) {
        var e = a.J, g = e.rj();
        g.sj(b);
        g.jc(d);
        b = new google[v].eb;
        b.Rd = a.ob.Rd;
        this.Zd(g, b, a);
        g.Da(e.La);
        e.wa && g.Ep(e.wa);
        e = a.Za[a.Za[F] - 1];
        this.ak(e, a);
        this.fn(e);
        $(e.Ia.Fb, "gsc-tabData");
        $(e.Ia.Fb, "gsc-tabdInactive");
        return e
    };
    I.Ar = function (a) {
        var b = this[Bc][Pc];
        a = this.Xc(a);
        if (a.Za)for (var d = 0; d < a.Za[F]; d++) {
            var e = a.Za[d];
            ug(e.Ia.ta, this.Pm(google[v].V.Wd(e.J.El()[r](/\$q/g, b))))
        }
    };
    I.Xc = function (a) {
        return a.eh || a
    };
    I.Fm = function (a) {
        a.Kc ? (Pg(a.Kc, "gsc-refinementBlockInvisible"), this.Y != a.$g && (this.Y = a.$g, this.Ve(this.Y))) : a.eh && a.eh.Kc && Pg(a.eh.Kc, "gsc-refinementBlockInvisible")
    };
    I.yr = function (a) {
        var b = a.J.context ? a.J.context.facets : null;
        if (!b)return 0 < a.Za[F];
        if (b[F] != a.Za[F])return!0;
        for (var d = 0; d < b[F]; d++) {
            var e = b[d].label_with_op;
            e || (e = b[d][sc]);
            if (!a.Za[d].J.Yd(e))return!0
        }
        return!1
    };
    I.tr = function (a) {
        if (0 != a.Za[F]) {
            var b = a.Kc;
            tg(b);
            b[ud][id](b);
            for (a.Kc = null; 0 < a.Za[F];)b = a.Za.pop(), tg(b[vc]), this.ee[id](b[vc])
        }
    };
    I.ur = function (a) {
        for (var b = W("gsc-cursor"), d = a.J[Sb], e = 0; e < d.pages[F]; e++) {
            var g = "gsc-cursor-page";
            e == d.currentPageIndex && (g += " gsc-cursor-current-page");
            g = U(d.pages[e][sc], g);
            Mg(g, ng(this, google[v].B[G].Xv, [a, e]));
            b[p](g)
        }
        return b
    };
    google[v].B.kq = {border: "border", borderColor: "border-color", borderStyle: "border-style", borderWidth: "border-width", borderTop: "border-top", borderTopColor: "border-top-color", borderTopStyle: "border-top-style", borderTopWidth: "border-top-width", borderRight: "border-right", borderRightColor: "border-right-color", borderRightStyle: "border-right-style", borderRightWidth: "border-right-width", borderBottom: "border-bottom", borderBottomColor: "border-bottom-color", borderBottomStyle: "border-bottom-style", borderBottomWidth: "border-bottom-width",
        borderLeft: "border-left", borderLeftColor: "border-left-color", borderLeftStyle: "border-left-style", borderLeftWidth: "border-left-width", color: "color", cssFloat: "float", styleFloat: "float", clear: "clear", cursor: "cursor", display: "display", font: "font", fontFamily: "font-family", fontSize: "font-size", fontStyle: "font-style", fontWeight: "font-weight", height: "height", margin: "margin", marginTop: "margin-top", marginRight: "margin-right", marginBottom: "margin-bottom", marginLeft: "margin-left", overflow: "overflow", padding: "padding",
        paddingTop: "padding-top", paddingRight: "padding-right", paddingBottom: "padding-bottom", paddingLeft: "padding-left", textAlign: "text-align", textDecoration: "text-decoration", textTransform: "text-transform", verticalAlign: "vertical-align", visibility: "visibility", width: "width"};
    google[v].B.lq = function (a, b) {
        if (lg("safari") || lg("konqueror"))alert("google.search.SearchControl.inlineCurrentStyle is not supported on Safari"); else {
            var d = !0;
            b && (d = b);
            if (d)for (d = 0; d < a[Hb][F]; d++)google[v].B.lq(a[Hb][d], !0);
            if (1 == a[Kc]) {
                var e, g, f = !1, d = !1;
                window[ec] ? (e = window[ec](a, null), f = g = !0) : a[qd] && (e = a[qd], g = !1, f = !0);
                if (f) {
                    for (var k in e)if (google[v].B.kq[k]) {
                        var f = google[v].B.kq[k], l = e[k];
                        "display" == k && "none" == l && (Oa(a, ""), d = !0);
                        "" != e[k] && (g ? a[u].setProperty(f, l) : a[u][Eb](f, l))
                    }
                    d && !g && (a.outerHTML =
                        '<div style="display:none"/>')
                }
            }
        }
    };
    google[v].B.inlineCurrentStyle = google[v].B.lq;
    google[v].B[G].dt = function (a) {
        a = a ? a : this[vc];
        var b = null;
        window[ec] ? b = window[ec](a, null) : a[qd] ? b = a[qd] : h[Xc][ec] && (b = h[Xc][ec](a, null));
        return b ? qa(b[lb], 10) : 300
    };
    google[v].B[G].dh = function (a, b) {
        this.Gf = rg(a, b)
    };
    google[v].B[G].setSearchCompleteCallback = google[v].B[G].dh;
    google[v].B[G].Dy = function (a, b) {
        this.ck = rg(a, b)
    };
    google[v].B[G].setSearchStartingCallback = google[v].B[G].Dy;
    google[v].B[G].ro = function (a, b) {
        this.dk = rg(a, b)
    };
    google[v].B[G].setTrackingCallback = google[v].B[G].ro;
    google[v].B[G].Bl = function (a, b) {
        a.Ij(b);
        var d = !1;
        switch (b) {
            default:
            case google[v].hb.wk:
                a.xa && Fa(a.xa[u], "none");
                break;
            case google[v].hb.vk:
                a.xa && Fa(a.xa[u], "block");
                a.J.La != google[v].A.$b && (d = !0);
                a.J.Da(google[v].A.$b);
                break;
            case google[v].hb.xn:
                a.xa && Fa(a.xa[u], "block"), a.J.La != google[v].A.vc && (d = !0), a.J.Da(google[v].A.vc)
        }
        d && (d = this[Bc][Pc], d[F] && (this.Ef = !1, this.Jj(), a.ob.lc = google[v].B.Be, this.Nh(a, !0), a.J.ra(d)))
    };
    google[v].B[G].Xv = function (a, b) {
        this.Ef = !1;
        this.Jj();
        this.Nh(a, !0);
        a.ob.lc = google[v].B.Be;
        this.Vg = b + 1;
        if (this.kb && this.kb[jc]()) {
            var d = this.kb.Qg();
            d[google[v].M.cd] = b + 1;
            this.kb[ib](d)
        }
        this.Gk(this.Qe, b + 1);
        a.J.kp(b);
        this.Cf && this.Hk(this.Vg);
        this.vb.scrollIntoView()
    };
    google[v].B[G].Hn = function (a) {
        !a || google[v].M.isSupported() && google[v].M.Dv() || a(this);
        a = {};
        this.Ma || this.Vo(this.Y, a);
        this.Qe && (a[google[v].M.Wg] = this.Qe);
        this.Vg && (a[google[v].M.cd] = this.Vg);
        this.kb = new google[v].M(a, rg(this, google[v].B[G].Cv));
        return this.kb[jc]()
    };
    google[v].B[G].startHistoryManagement = google[v].B[G].Hn;
    google[v].B[G].oo = function (a, b) {
        var d = null;
        if (null == a || 0 > a || a >= this.Z[F])d = this.Y; else {
            var e = this.Z[a];
            if (e.J.N && b) {
                var g = b;
                e.J.pd && (g = e.J.pd(b));
                d = this.Vp(e, g);
                d || (e.Kc || this.Im(e), d = this.Jm(e, g, b), d.De = !0, d = d.Ia)
            } else d = e.$g || e.Ia
        }
        return d
    };
    google[v].B[G].Cv = function (a) {
        var b = this.oo(a[google[v].M.oj], a[google[v].M.nj]);
        if (b) {
            if (this.Xb) {
                var d;
                null != a[google[v].M.Vi] && (d = this.Xj(a[google[v].M.Vi]));
                null == d && (d = this.Qd);
                this.pk(d);
                this.di(d, b.nb)
            }
            d = a[google[v].M.Wg] || "";
            a = a[google[v].M.cd];
            if (null == a || 0 >= a)a = 1;
            this.Y == b ? d ? this.ra(d, a) : this.Zc() : (this.Ue(b, {Zh: d, page: a}), d || this.Zc())
        }
    };
    google[v].B[G].Vo = function (a, b) {
        for (var d = this.Xc(a.Jb), e = 0; e < this.Z[F]; e++)if (this.Z[e] == d) {
            b[google[v].M.oj] = e;
            break
        }
        d = a.nb;
        d.nc && null != d.nc() ? b[google[v].M.nj] = d.nc() : delete b[google[v].M.nj]
    };
    google[v].Ca = function (a, b, d) {
        google[v].Ca.om++;
        var e = Gg("gsc-search-box");
        e.acceptCharset = "utf-8";
        var g = null, f = P["search-uc"], k = P[v];
        d && d.Gi && d.Xf && (f = "");
        d && (d.buttonText && (k = f = d.buttonText), d.clickableBrandingUrl && (g = "http://www.google.com", "string" == typeof d.clickableBrandingUrl && d.clickableBrandingUrl[yb](/^http:\/\/[a-z]*\.google\.com/) && (g = d.clickableBrandingUrl), g = Dg(g, null, "_BLANK"), m(g, "gsc-branding-clickable")));
        if (d && d.Gi)if ("" == f) {
            var f = google[pd][Yc] + "/css/v2/search_box_icon.png", l = h[t]("input");
            Ua(l, "image");
            l.src = f;
            m(l, "gsc-search-button gsc-search-button-v2");
            f = l
        } else f = Ig(f, "gsc-search-button"); else f = Hg(f, "gsc-search-button");
        this.Di = f;
        ab(this.Di, k);
        Na(this, Jg(null, "gsc-input", null));
        Va(this[Bc], "search");
        ab(this[Bc], k);
        f = this[Bc];
        d && d.Gi && d.Xf && (m(this[Bc], ""), wa(this[Bc][u], "100%"), ya(this[Bc][u], "0 2px 0 0"), this.nm = W("gsc-input-box"), this.nm.id = "gsc-iw-id" + google[v].Ca.om, Q(this.nm, this[Bc]), f = this.nm);
        d && d.Gi && (this[Bc].id = "gsc-i-id" + google[v].Ca.om);
        l = h[t]("input");
        Ua(l, "hidden");
        Va(l, "bgresponse");
        l.id = "bgresponse";
        k = zg(null, null, "gsc-search-box");
        Q(e, k);
        k = Ag(k, 0);
        this.lm = Bg(k, "gsc-input");
        var n = Bg(k, "gsc-search-button");
        Q(this.lm, f);
        Q(this.lm, l);
        Q(n, this.Di);
        f = zg(null, null, "gsc-branding");
        Q(e, f);
        l = "gsc-branding-img-noclear";
        n = Ag(f, 0);
        this.userDefinedCell = Bg(n, "gsc-branding-user-defined");
        var q = Bg(n, "gsc-branding-text"), f = Bg(n, l), s = U(P["powered-by"], "gsc-branding-text"), x;
        x = google[pd][Yc] + "/css/small-logo.png";
        qg() ? (l = W(l), l[u].filter = 'progid:DXImageTransform.Microsoft.AlphaImageLoader(src="' +
            x + '")', wa(l[u], "51px"), Ia(l[u], "15px")) : l = Cg(x, null, null, l);
        x = l;
        Q(q, s);
        g ? (Q(g, x), Q(f, g)) : Q(f, x);
        d && d.Ss || Fa(n[u], "none");
        this.Ci = e;
        tg(b);
        Q(b, this.Ci);
        a && (l = "gsc-branding-img", this.mm = U(P.blank, "gsc-clear-button"), ab(this.mm, P["clear-results"]), a = Bg(k, "gsc-clear-button"), Q(a, this.mm), m(f, l), m(x, l))
    };
    Bd("google.search.SearchForm", google[v].Ca, void 0);
    google[v].Ca.Uk = ("https:" == h[bc][lc] ? "https:" : "http:") + "//www.google.com/cse/intl/" + google[v][vd] + "/images/google_custom_search_watermark.gif";
    google[v].Ca.Ys = "#FFFFFF " + google[v].V.Rq + " no-repeat";
    google[v].Ca.Mw = function () {
        return"#FFFFFF url(" + google[v].Ca.Uk + ") " + google[v].V.Rq + " no-repeat"
    };
    google[v].Ca.om = 0;
    google[v].Ca[G].By = function (a, b) {
        this.Zq = ng(this, this.Hx, [this]);
        this.Aj = ng(a, b, [this]);
        this.Ci.onsubmit = this.Zq;
        fb(this.Di, this.Zq)
    };
    google[v].Ca[G].setOnSubmitCallback = google[v].Ca[G].By;
    google[v].Ca[G].io = function (a, b) {
        fb(this.mm, ng(a, b, [this]))
    };
    google[v].Ca[G].setOnClearCallback = google[v].Ca[G].io;
    google[v].Ca[G].Hx = function () {
        var a = this.lm[sb], b = this[Bc][Pc];
        this.Aj && this.Aj();
        if (qg()) {
            var d = this, e;
            e = 8 * b[F] >= a ? a - 6 : "99%";
            window[Xb](function () {
                wa(d[Bc][u], e)
            }, 1)
        }
        return!1
    };
    google[v].Ca[G].ra = function (a) {
        a && Qa(this[Bc], a);
        this.Aj && this.Aj()
    };
    google[v].Ca[G].execute = google[v].Ca[G].ra;
    google[v].I = function (a, b) {
        this.Rn = (new Date)[Nb]();
        google[v].B[kd](this);
        b = b || {};
        this.rd = google[v].A.mt(b.forceV2LookAndFeel);
        this.Bb = !0;
        this.gb = null != b._enableApiary_ ? !!b._enableApiary_ : !0;
        this.Da(b.resultSetSize || google[v].A.vc);
        var d = {};
        if (b.adoptions)for (var e in b.adoptions)b.adoptions[dc](e) && (d[e] = b.adoptions[e]);
        d.iframes = !0;
        d.adtest = b.adtest || null;
        d.channel = b.adchannel || null;
        b.enableMobileLayout && (d.includeSideAds = !1, d.numTopAds = 2);
        window.innerWidth < google[v].I.jt && (d.includeSideAds = !1, d.numTopAds =
            2);
        this.Ug(b.adclient || "", d);
        this.Qh = b.autoCompleteOptions;
        this.qo = google[v].I.lo(a, this.Qh);
        this.Wh = a;
        this.Wh || (this.Wh = {crefUrl: "http://www.google.com/coop/tools/autocse?referer=" + window[bc]}, this.Cr = !0);
        this.Yj = google[v].I.tn;
        this.Fj = b.defaultToRefinement;
        this.Cf = (this.po = b.bookmarkOptions) ? this.po.showBookmarkLink || !1 : !1;
        this.Xa = null;
        if (!b.disableWebSearch || !b.enableImageSearch) {
            var g = {};
            b[google[v].A.Ka] && (g[google[v].A.Ka] = b[google[v].A.Ka]);
            b[google[v].A.Ya] && (g[google[v].A.Ya] = b[google[v].A.Ya]);
            if (b.webSearchOptions)for (e in b.webSearchOptions)g[e] = b.webSearchOptions[e];
            this.lt(g)
        }
        this.cb = null;
        if (b.enableImageSearch) {
            d = {};
            b[google[v].A.Ya] && (d[google[v].A.Ya] = b[google[v].A.Ya]);
            if (b.imageSearchOptions)for (e in b.imageSearchOptions)d[e] = b.imageSearchOptions[e];
            this.kt(d);
            b.defaultToImageSearch && this.Xa && (this.Yj = google[v].I.sn)
        }
        this.Xa && this.cb && this.jc({web: P.web, image: P.image});
        b.googleAnalyticsOptions && b.googleAnalyticsOptions.queryParameter && (this.Yk = b.googleAnalyticsOptions, this.ro(null,
            google[v].I.nt));
        b.enableOrderBy && (this.Dm = !0, this.Vc = b.orderByOptions && b.orderByOptions.keys && 0 < b.orderByOptions.keys[F] ? b.orderByOptions.keys : [
            {key: "", label: P["order-by-relevance"]},
            {key: "date", label: P["order-by-date"]}
        ], void 0 !== g && b.orderByOptions && g["restrict-extended"] && void 0 !== g["restrict-extended"][od] && (this.Qd = this.Xj(g["restrict-extended"][od]) || 0), void 0 == this.Qd && (this.Qd = 0));
        this.Km = b.overlayResults ? !0 : !1;
        this.Sn = !0
    };
    Bd("google.search.CustomSearchControl", google[v].I, void 0);
    jg(google[v].I, google[v].B);
    google[v].I.Rl = (new Date)[Nb]();
    google[v].I.ye = null;
    google[v].I.Lq = !1;
    google[v].I.Jo = function () {
        var a = google[v].I;
        a.Lq || (a.ye = new Image, va(a.ye, a.ye.onerror = a.ye.onabort = a.ye.ontimeout = function () {
            a.ye = null
        }), a.ye.src = "https://www.googleapis.com/generate_204", a.Lq = !0)
    };
    google[v].A.Dk() && google[v].I.Jo();
    google[v].I[G].lt = function (a) {
        this.Xa || (this.Xa = new google[v].G, this.Xa.Ub(this.Wh), this.Xa.Oi = P["custom-search"], this.Xa.gb = this.gb, this.Zd(this.Xa), a && (a.resultSetSize && this.Xa.Da(a.resultSetSize), a[google[v].A.Ka] && this.Xa.Sa(google[v].A.Ka, a[google[v].A.Ka]), a[google[v].A.Ya] && this.Xa.Sa(google[v].A.Ya, a[google[v].A.Ya]), a.linkTarget && this.Xa.Pa(a.linkTarget), a.queryAddition && this.Xa.Hb(a.queryAddition)))
    };
    google[v].I[G].kt = function (a) {
        this.cb || (this.cb = new google[v].C, this.cb.Ub(this.Wh), this.cb.gb = this.gb, this.Zd(this.cb), a && (a.resultSetSize && this.cb.Da(a.resultSetSize), this.cb.Xe(a.layout || google[v].D.Id), a[google[v].A.Ya] && this.cb.Sa(google[v].A.Ya, a[google[v].A.Ya]), a[google[v].A.Ka] && this.cb.Sa(google[v].A.Ka, a[google[v].A.Ka]), a.linkTarget && this.cb.Pa(a.linkTarget), a.queryAddition && this.cb.Hb(a.queryAddition)))
    };
    google[v].I[G].vy = function (a) {
        this.qo = "string" == typeof a ? a : null
    };
    google[v].I[G].setAutoCompletionId = google[v].I[G].vy;
    google[v].I.lo = function (a, b) {
        var d = "string" == typeof a ? a : null;
        if (b) {
            var e = {prefix: 0, ordered: 3, any: 1}, g = b.matchType;
            g && e[g] && (d = d + "+qptype:" + e[g]);
            if (e = b.validLanguages)for (e = e[Yb](","), g = 0; g < e[F]; ++g)e[g] && (d = d + "+lang:" + e[g])
        }
        return d
    };
    google[v].I[G].kj = function () {
        return this.qo
    };
    google[v].I[G].getPartnerId = google[v].I[G].kj;
    google[v].I.Zx = function (a, b, d, e, g, f, k, l) {
        return google[v].I.Qq(a, b, d, {saytActor: e, callback: g, maxCompletions: f, styleOptions: l})
    };
    google[v].I.attachAutoCompletion = google[v].I.Zx;
    google[v].I.Qq = function (a, b, d, e) {
        if (d instanceof google[v].B && window[nc])return window[nc].log("We no longer support attachAutoCompletionWithOptions for SearchControl object"), {};
        a = google[v].I.lo(a, e);
        e = e || {};
        var g = "string" == typeof d ? eh(d) : d;
        b = eh(b);
        if (!g)for (var f = b; f;)f = f[ud], dh(f) && (g = f);
        var f = hg(), k = {interfaceLanguage: google[v][vd], saytSubmit: e.saytActor, maxSuggestions: e.maxCompletions, maxPromotions: e.maxPromotions, styleOptions: e.styleOptions, isLoggingWithHiddenFormFields: e.isLoggingWithHiddenFormFields, saytKeyboardNavigationEnabled: e.saytKeyboardNavigationEnabled,
            saytExtraParameters: e.saytExtraParameters};
        (e = e.searchButton ? eh(e.searchButton) : null) && ("submit" != e[Wc] ? k.searchButton = e : window[nc] && window[nc].warn("Cannot associate searchButton with a button of type submit."));
        if (k.isLoggingWithHiddenFormFields && !k.searchButton)return window[nc] && window[nc].warn('The "searchButton" option is required when "isLoggingWithHiddenFormFields" is true.'), {};
        e = d && (d.execute || d[Dc]);
        dh(g) ? (k.isLoggingWithHiddenFormFields = k.isLoggingWithHiddenFormFields || hh(fh(g.action)),
            f.el(g, b, a, k)) : f.Hu(e ? rg(d, e) : function () {
        }, b, a, k);
        return{getInputQuery: f.fb, prefillQuery: f.Uc}
    };
    google[v].I.attachAutoCompletionWithOptions = google[v].I.Qq;
    google[v].I[G].hy = function (a) {
        if (this.Ud) {
            if (a)throw"Please use constructor of CustomSearchControl to pass in additional options.";
            this.Td.ea(!1)
        }
    };
    google[v].I[G].enableAutoCompletion = google[v].I[G].hy;
    google[v].I[G].ju = function () {
        var a = (new Date)[Nb]();
        if (window.googleLT_ && 1 == window.googleLT_ % 100) {
            var b = google[v].I.Rl - window.googleLT_, d = this.Rn - window.googleLT_, a = a - window.googleLT_;
            0 < b && 0 < d && 0 < a && google[pd].recordCsiStat(["asa_cse"], ["cl." + b, "cc." + d, "cd." + a])
        }
    };
    google[v].I[G].Rf = function (a, b) {
        var d = b;
        d || (d = new google[v].qa);
        d.Ko(google[v].B.hc);
        this.Cr && 1 == this.Z[F] && (this.Wt = !0);
        this.Pe(google[v].B.Io);
        d.gc != google[v].B.Nf && this.gb && google[v].I.Jo();
        google[v].B[G].Rf[kd](this, a, d);
        this.Ma || (d = this.oo(this.Yj, this.Fj)) && this.Ue(d);
        var d = this.Ma ? "gsc-control-searchbox-only" : "gsc-control-cse", e = this[vc];
        this.Ma || (e = W(), this[vc][ud] && this[vc][ud][xb](e, this[vc]), Q(e, this[vc]), m(this[vc], "gsc-control-wrapper-cse"));
        m(e, d);
        $(e, d + "-" + google[v][vd]);
        this.ju();
        if (this.Lm) {
            d = google[v].F[H].ll(window[bc][v]) || {};
            e = qa(d[xc], 10);
            if (fa(e) || 0 >= e)e = 1;
            this.ra(d.query, e, {bm_req: "1"})
        }
    };
    google[v].I[G].draw = google[v].I[G].Rf;
    google[v].I[G].Il = function (a, b, d, e, g) {
        if (this.Ma)this.qp(); else {
            var f = this.vb[sb];
            Pg(this.mc, "gsc-thinWrapper");
            this.Sn && (f = this.zv(), this.Sn = !1);
            this.Mm = f;
            f < google[v].I.vv ? this.yd = !1 : f < google[v].I.xv ? this.Ug(this.Ed, {includeVerticalAds: !1}) : (f = {includeVerticalAds: f >= google[v].I.wv}, this.wp && (f.numTopAds = google[v].I.yv), this.Ug(this.Ed, f));
            if ((new Date)[Nb]() - this.Rn < google[v].I.uv && this.yd)try {
                var k = ua(window[bc][mc])[r](/\+/g, " "), l = ua(a)[r](/\+/g, " ");
                this.yd = -1 != k[Qc](l)
            } catch (n) {
            }
            google[v].B[G].Il[kd](this,
                a, b, d, e, g)
        }
    };
    google[v].I[G].zv = function () {
        var a = xg(google[v].I.Xw());
        a[u].fontFamily = "arial";
        a[u].fontSize = "16px";
        Ya(a[u], "hidden");
        Q(this.vb, a);
        var b = this.vb[sb];
        this.vb[id](a);
        return b
    };
    google[v].I.Xw = function () {
        for (var a = "", a = "a a a a a ", b = 5; 80 > b; b *= 2)a += a;
        return a
    };
    google[v].I[G].jc = function (a) {
        "string" == typeof a ? this.Xa ? this.Xa.jc(a) : this.cb && this.cb.jc(a) : (a.web && this.Xa && this.Xa.jc(a.web), a.image && this.cb && this.cb.jc(a.image))
    };
    google[v].I[G].setUserDefinedLabel = google[v].I[G].jc;
    google[v].I[G].Zd = function (a, b, d) {
        google[v].B[G].Zd[kd](this, a, b, d);
        a.lf = "gcsc"
    };
    google[v].I[G].addSearcher = google[v].I[G].Zd;
    google[v].I[G].gy = function () {
        this.Ug("", {numTopAds: 0, numSideAds: 0, _includeBottomAds_: !1});
        this.Co = !1
    };
    google[v].I[G].disableAds = google[v].I[G].gy;
    google[v].I[G].yy = function () {
        this.wp = !0
    };
    google[v].I[G].setMoreAds = google[v].I[G].yy;
    google[v].I[G].my = function () {
        return this.cb
    };
    google[v].I[G].getImageSearcher = google[v].I[G].my;
    google[v].I[G].qy = function () {
        return this.Xa
    };
    google[v].I[G].getWebSearcher = google[v].I[G].qy;
    google[v].I[G].ir = function (a) {
        var b = a.pa;
        "web" == b && (b = "");
        a.N && a.nc() && (b = b ? b + ":" + a.nc() : a.nc());
        return b
    };
    google[v].I[G].getTrackingCategory = google[v].I[G].ir;
    google[v].I.nt = function (a, b, d) {
        var e = h[bc];
        d = [e.pathname, e[v], e[v] ? "&" : "?", c(a.Yk.queryParameter), "=", c(d)];
        a.Yk.categoryParameter && (b = a.ir(b)) && d[C]("&", c(a.Yk.categoryParameter), "=", c(b));
        window._gaq && "function" == typeof window._gaq[C] ? window._gaq[C](["_trackPageview", d[xd]("")]) : window[nc] && window[nc].log("Google Analytics tracking was not correctly setup.")
    };
    google[v].I.Rx = "";
    google[v].I.AUTO_PUBID = google[v].I.Rx;
    google[v].I.tn = 0;
    google[v].I.sn = 1;
    google[v].I.vv = 250;
    google[v].I.xv = 500;
    google[v].I.wv = 795;
    google[v].I.uv = 500;
    google[v].I.jt = 480;
    google[v].I[G].wp = !1;
    google[v].I.yv = 4;
    google[v].I.Lw = new RegExp('^url\\("?' + google[v].Ca.Uk + '"?\\)$');
    google[v].ya = function () {
        google[v].A[kd](this);
        this.pa = "video";
        this.Ic = "/GvideoSearch";
        this.uc = "http://video.google.com/videosearch";
        this.Nb = !1;
        this.pf = !0;
        this.Hc = rg(this, this.kd);
        this.We = "gsc-videoConfig";
        this.na = null
    };
    Bd("google.search.VideoSearch", google[v].ya, void 0);
    jg(google[v].ya, google[v].A);
    google[v].ya.Wa = "GvideoSearch";
    google[v].ya.RESULT_CLASS = google[v].ya.Wa;
    google[v].ya.$ = [];
    google[v].ya.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].ya.$, f, b);
        google[v].ya.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].ya.RawCompletion = google[v].ya.Ta;
    google[v].ya[G].Cc = function (a, b) {
        return google[v].A.Sb(google[v].ya.$, [this, a, b])
    };
    google[v].ya[G].fc = function (a, b, d) {
        b = this.Rc(null == b ? "google.search.VideoSearch.RawCompletion" : b, d);
        this.Na && (a = a + " " + this.Na);
        a = "&q=" + c(a);
        this.Nb && (a += "&scoring=d");
        this.va = a;
        d && 0 != d && (this.va = this.va + "&start=" + d);
        return b + a
    };
    google[v].ya[G].Ra = function (a) {
        a.html && delete a.html;
        var b = W(this.Md());
        $(b, "gs-result");
        var d = W("gs-image-box"), e = W("gs-text-box"), g = zg(), f = Ag(g, 0), k = Bg(f, "gs-image-box"), f = Bg(f, "gs-text-box");
        Q(k, d);
        Q(f, e);
        Q(b, g);
        g = google[v].A.Zb(a.tbWidth, a.tbHeight, this.wa);
        g = Cg(a.tbUrl, g[lb], g[uc], "gs-image");
        k = Dg(a.url, null, this.za(), "gs-image");
        m(k, "gs-image");
        Q(k, g);
        Q(d, k);
        d = Eg(a.url, a[bd], this.za(), "gs-title");
        Q(e, d);
        d = U(a[nb], "gs-snippet");
        qg() && Ia(d[u], "2.6em");
        Q(e, d);
        d = U(this.wf(new Date(a.published)),
            "gs-publishedDate");
        Q(e, d);
        d = Eg("http://" + a.publisher, a.publisher, this.za(), "gs-publisher");
        Q(e, d);
        a.html = b;
        this.Pc(a.html)
    };
    google[v].ya[G].createResultHtml = google[v].ya[G].Ra;
    google[v].ya.fy = function (a, b) {
        var d = null;
        if (a.playUrl && "" != a.playUrl) {
            var d = a.playUrl, e = "gsc-video-player";
            b && (e = b);
            if (lg("opera")) {
                var g = h[t]("object");
                m(g, e);
                g[Eb]("type", "application/x-shockwave-flash");
                g[Eb]("data", d)
            } else g = h[t]("embed"), m(g, e), g[Eb]("type", "application/x-shockwave-flash"), g[Eb]("src", d), a.videoType ? "Google" == a.videoType ? g[Eb]("bgcolor", "#000000") : g[Eb]("wmode", "transparent") : g[Eb]("bgcolor", "#000000");
            d = W(b);
            d[p](g)
        }
        return d
    };
    google[v].ya.createPlayer = google[v].ya.fy;
    google[v].ya[G].Ib = function (a) {
        this.Nb = a == google[v].A.md ? !0 : !1
    };
    google[v].ya[G].setResultOrder = google[v].ya[G].Ib;
    google[v].ya[G].kd = function (a, b) {
        if (b) {
            if (null == this.na) {
                var d = W("gsc-configSetting");
                this.na = Kg(null, "0", this.Nb, "gsc-configSettingCheckbox");
                Q(d, this.na);
                Q(d, U(P["sort-by-date"], "gsc-configSettingCheckboxLabel"));
                var e = W("gsc-configSettingSubmit");
                Q(e, Hg(P[gc], "gsc-configSettingSubmit"));
                Q(d, e);
                Q(a, d)
            } else Aa(this.na, this.Nb);
            this.na[Ab]()
        } else this.na && (this.na[Tb] ? this.Ib(google[v].A.md) : this.Ib(google[v].A.ph))
    };
    google[v].K = function () {
        google[v].A[kd](this);
        this.pa = "web";
        this.Ic = "/GwebSearch";
        this.uc = "http://www.google.com/search";
        this.Ja = this.jd = this.ie = null;
        this.fa = {};
        this.P = new google[v].wc
    };
    Bd("google.search.WebSearch", google[v].K, void 0);
    jg(google[v].K, google[v].A);
    google[v].K.Wa = "GwebSearch";
    google[v].K.RESULT_CLASS = google[v].K.Wa;
    google[v].K.yf = "cx";
    google[v].K.cxRestriction_CX = google[v].K.yf;
    google[v].K.Sc = "cref";
    google[v].K.cxRestriction_CREF = google[v].K.Sc;
    google[v].K.xm = "none";
    google[v].K.cxRestriction_NONE = google[v].K.xm;
    google[v].K.$ = [];
    google[v].K.de = {as_dt: !0, as_epq: !0, as_eq: !0, as_lq: !0, as_nlo: !0, as_nhi: !0, as_oq: !0, as_q: !0, as_qdr: !0, as_rq: !0, as_sitesearch: !0, cr: !0, c2coff: !0, filter: !0, gl: !0, hq: !0, lr: !0, query: !0, richsnippet: !0, sort: !0, usg: !0};
    google[v].K.Dl = 20;
    google[v].K.oe = "data-cturl";
    google[v].K.ue = "data-ctorig";
    google[v].K.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].K.$, f, b);
        google[v].K.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].K.RawCompletion = google[v].K.Ta;
    google[v].K[G].rj = function () {
        var a = new google[v].K;
        this.Qi(a);
        a.Ja = this.Ja;
        a.fa = this.fa;
        a.P = this.P.je();
        a.N = this.N;
        return a
    };
    google[v].K[G].vj = function (a) {
        var b = google[v].A.Sb(google[v].K.$, [this, null, null]);
        google[v].K.Ta(b, a, 200, void 0, 200)
    };
    google[v].K[G].renderJson = google[v].K[G].vj;
    I = google[v].K[G];
    I.pd = function (a) {
        a = Yg(a);
        return a[r](/\s+/g, "_")[yd]()
    };
    I.Yd = function (a) {
        return this.N ? this.P.Ha == this.pd(a) : !1
    };
    I.Bc = function (a) {
        return this.N && this.P.Ha ? a[r](new RegExp(" more:" + this.P.Ha + "$"), "") : a
    };
    I.Cc = function (a, b) {
        return google[v].A.Sb(google[v].K.$, [this, a, b])
    };
    I.ra = function (a, b, d) {
        window[nc] && window[nc].log && window[nc].log("The Google Web Search API has been officially deprecated. For more information on its deprecation, see https://developers.google.com/web-search/. We suggest you migrate to the Google Custom Search API. (see https://developers.google.com/custom-search/)");
        google[v].A[G].ra[kd](this, a, b, d)
    };
    google[v].K[G].execute = google[v].K[G].ra;
    google[v].K[G].fc = function (a, b, d) {
        b = null == b ? "google.search.WebSearch.RawCompletion" : b;
        a = [a];
        this.Na && a[C](this.Na);
        a = a[tb](this.P.se())[xd](" ");
        if (this.N && this.ie) {
            var e = this.ie, e = e[r](/__HL__/, google[v][vd]);
            this.jd = e = e[r](/__QUERY__/, c(a))
        }
        var e = this.P.re(), g = [], f;
        for (f in e)g[C](f + "=" + e[f]);
        f = "&" + g[xd]("&");
        f += "&q=" + c(a);
        this.Ja && (f += "&safe=" + this.Ja);
        this.fa && (a = Zg(this.fa)) && (f += "&" + a);
        b = this.Rc(b, d);
        b += f;
        this.va = f;
        d && 0 != d && (this.va = this.va + "&start=" + d);
        window.google[pd].GoogleLocale && (b = this.gb &&
            this.N ? b + ("&googlehost=" + c(window.google[pd].GoogleLocale)) : b + ("&gl=" + c(window.google[pd].GoogleLocale)));
        return b
    };
    google[v].K[G].Pf = function (a) {
        a.html && delete a.html;
        var b;
        if (a[Wc] && "SPELL_CORRECTED_RESULTS" == a[Wc]) {
            b = W("gs-result");
            var d = xg(P["showing-results-for"] + " ", "gs-spelling"), e = h[t]("a");
            Oa(e, google[v].V.Bf(this.Bc(a.correctedAnchor)));
            d[p](e);
            b[p](d);
            d = xg(P["search-instead-for"] + " ", "gs-spelling");
            $(d, "gs-spelling-original");
            e = h[t]("a");
            Oa(e, google[v].V.Bf(this.Bc(a.originalAnchor)));
            d[p](e)
        } else b = xg(P.dym + " ", "gs-spelling"), $(b, "gs-result"), d = h[t]("a"), Oa(d, google[v].V.Bf(this.Bc(a[ld])));
        b[p](d);
        a.html = b
    };
    google[v].K[G].createSpellingHtml = google[v].K[G].Pf;
    google[v].K[G].zh = function (a, b) {
        var d = U(google[v].V.Wd(a.visibleUrl), "gs-visibleUrl");
        Q(b, d);
        $(d, "gs-visibleUrl-short");
        d = U(google[v].V.Wd(a.url), "gs-visibleUrl");
        Q(b, d);
        $(d, "gs-visibleUrl-long")
    };
    google[v].K[G].yh = function (a, b) {
        var d = Bg(a, "gs-promotion-image-cell"), e = W("gs-promotion-image-box");
        Q(e, b);
        Q(d, e)
    };
    google[v].K[G].Xh = function (a, b) {
        a.html && delete a.html;
        var d = W("gs-promotion");
        $(d, "gs-result");
        var e = zg(0, 1, "gs-promotion-table"), g = Ag(e, 0), f;
        Q(d, e);
        var k;
        a.image && (e = a.image.url[r]("resize_w=40", "resize_w=60"), e = e[r]("resize_h=40", "resize_h=60"), e = Cg(e, null, null, "gs-promotion-image"), a.url && (f = Dg(a.url, "", this.za()), a.clicktrackUrl && google[v].K.od(f, a.clicktrackUrl, a.url), Q(f, e), e = f), k = e, b.sf || google[v].K[G].yh(g, k));
        e = null;
        a.clicktrackUrl && (e = {}, e[google[v].K.oe] = a.clicktrackUrl, e[google[v].K.ue] =
            a.url);
        e = Eg(a.url, a[bd], this.za(), "gs-title", void 0, e);
        a.titleRight && (f = yg("", "gs-promotion-title-right"), Oa(f, " " + a.titleRight), Q(e, f));
        e.dir = google[v].V.qh(e[Mc]);
        $(e, "gs-bidi-start-align");
        f = Bg(g, b.sf && a.image ? "" : "gs-promotion-text-cell");
        Q(f, e);
        b.Xi && google[v].K[G].zh(a, f);
        var l;
        b.sf && a.image ? (e = zg(0, 0, "gs-promotion-table-snippet-with-image"), g = Ag(e, 0), Q(f, e), google[v].K[G].yh(g, k), l = Bg(g, "gs-promotion-text-cell-with-image")) : a.bodyLines && (l = W(), Q(f, l));
        if (a.bodyLines) {
            g = a.bodyLines;
            k = "right" ==
                a.bodyLinkAlignment;
            for (var n = 0; n < g[F]; n++) {
                var q = g[n], s = q[bd], x = q.url, y = q.visibleUrl, e = W("gs-snippet"), E;
                s && (E = yg(""), Oa(E, s));
                var w;
                x && y && (w = Dg(x, "", this.za()), q.clicktrackUrl && google[v].K.od(w, q.clicktrackUrl, x), q = yg("", "gs-title"), Oa(q, y), Q(w, q));
                E && k && (Q(e, E), w && Q(e, wg(" ")));
                w && Q(e, w);
                E && !k && (w && Q(e, wg(" ")), Q(e, E));
                e.dir = google[v].V.qh(e[Mc]);
                $(e, "gs-bidi-start-align");
                Q(l, e)
            }
        }
        b.Xi || google[v].K[G].zh(a, f);
        a.html = d
    };
    google[v].K[G].createPromotionHtml = google[v].K[G].Xh;
    google[v].K[G].Ih = function (a) {
        delete a.html;
        0 < a.display_facets[F] && (a.html = google[v].ga.la("facets", a))
    };
    google[v].K[G].createFacetResultHtml = google[v].K[G].Ih;
    google[v].K[G].Ra = function (a) {
        a.html && delete a.html;
        cb(a, this.za() || void 0);
        ab(a, a[bd] || a.visibleUrl);
        a.html = google[v].ga.la("webResult", a, {isLabelUrl: Ng()});
        if (a.clicktrackUrl)for (var b = a.html[Cb]; b; b = b[Mb])if (1 == b[Kc]) {
            "a" == b[pc][yd]() && b[mc] == a.unescapedUrl && google[v].K.od(b, a.clicktrackUrl, a.unescapedUrl);
            for (var d = b[Pb]("a"), e = 0, g; g = d[e]; e++)g[mc] == a.unescapedUrl && google[v].K.od(g, a.clicktrackUrl, a.unescapedUrl)
        }
        this.Pc(a.html)
    };
    google[v].K[G].createResultHtml = google[v].K[G].Ra;
    google[v].K.od = function (a, b, d) {
        a[Eb](google[v].K.oe, b);
        a[Eb](google[v].K.ue, d)
    };
    google[v].K[G].Ub = function (a, b, d) {
        this.td = null;
        this.P = google[v].Ac.jj(a, b);
        this.P instanceof google[v].Tc && (this.N = !0, this.P[Wc]() == google[v].K.Sc && (this.td = P["linked-cse-error-results"]), d && d[yb](/__HL__/) && d[yb](/__QUERY__/) && (this.ie = d))
    };
    google[v].K[G].setSiteRestriction = google[v].K[G].Ub;
    I = google[v].K[G];
    I.uh = function () {
        return this.N ? this.P[Wc]() : null
    };
    I.vh = function () {
        return this.N ? this.P.zf : null
    };
    I.nc = function () {
        return this.N ? this.P.Ha : null
    };
    I.sj = function (a) {
        this.N && a && this.P.xj(a)
    };
    I.Sa = function (a, b) {
        a == google[v].A.Ya && (this.Ja = b ? b == google[v].A.Wf || b == google[v].A.Vf || b == google[v].A.Cl ? b : null : null);
        if (a == google[v].A.Ka)if (b)for (var d in b) {
            var e = b[d];
            google[v].K.de[d] && (this.fa[d] = e)
        } else this.fa = {}
    };
    google[v].K[G].setRestriction = google[v].K[G].Sa;
    google[v].K[G].Da = function (a) {
        fa(qa(a, 10)) || (a = qa(a, 10));
        this.N && (0 < a && a <= google[v].K.Dl || google[v].A.Jc == a) ? this.La = a : google[v].A[G].Da[kd](this, a)
    };
    google[v].K[G].setResultSetSize = google[v].K[G].Da;
    google[v].K[G].Pa = function (a) {
        google[v].A[G].Pa[kd](this, a)
    };
    google[v].K[G].setLinkTarget = google[v].K[G].Pa;
    google[v].K[G].Hb = function (a) {
        google[v].A[G].Hb[kd](this, a)
    };
    google[v].K[G].setQueryAddition = google[v].K[G].Hb;
    google[v].G = function () {
        google[v].A[kd](this);
        this.pa = "web";
        this.Ic = "/GcustomwebSearch";
        this.uc = "http://www.google.com/search";
        this.Ja = this.jd = this.ie = null;
        this.fa = {};
        this.P = new google[v].wc
    };
    Bd("google.search.CustomWebSearch", google[v].G, void 0);
    jg(google[v].G, google[v].A);
    google[v].G.Wa = "GcustomwebSearch";
    google[v].G.RESULT_CLASS = google[v].G.Wa;
    google[v].G.yf = "cx";
    google[v].G.cxRestriction_CX = google[v].G.yf;
    google[v].G.Sc = "cref";
    google[v].G.cxRestriction_CREF = google[v].G.Sc;
    google[v].G.xm = "none";
    google[v].G.cxRestriction_NONE = google[v].G.xm;
    google[v].G.$ = [];
    google[v].G.de = {as_dt: !0, as_epq: !0, as_eq: !0, as_lq: !0, as_nlo: !0, as_nhi: !0, as_oq: !0, as_q: !0, as_qdr: !0, as_rq: !0, as_sitesearch: !0, cr: !0, c2coff: !0, filter: !0, gl: !0, hq: !0, lr: !0, query: !0, richsnippet: !0, sort: !0, usg: !0};
    google[v].G.Dl = 20;
    google[v].G.oe = "data-cturl";
    google[v].G.ue = "data-ctorig";
    google[v].G.Ta = function (a, b, d, e, g) {
        var f = 0;
        a && (f = qa(a, 10));
        a = google[v].A.Nc(google[v].G.$, f, b);
        google[v].G.$[f] = null;
        a.Mc.pb(b, d, e, g, a.Lc)
    };
    google[v].G.RawCompletion = google[v].G.Ta;
    google[v].G[G].rj = function () {
        var a = new google[v].G;
        this.Qi(a);
        a.Ja = this.Ja;
        a.fa = this.fa;
        a.P = this.P.je();
        a.N = this.N;
        return a
    };
    google[v].G[G].vj = function (a) {
        var b = google[v].A.Sb(google[v].G.$, [this, null, null]);
        google[v].G.Ta(b, a, 200, void 0, 200)
    };
    google[v].G[G].renderJson = google[v].G[G].vj;
    I = google[v].G[G];
    I.pd = function (a) {
        a = Yg(a);
        return a[r](/\s+/g, "_")[yd]()
    };
    I.Yd = function (a) {
        return this.N ? this.P.Ha == this.pd(a) : !1
    };
    I.Bc = function (a) {
        return this.N && this.P.Ha ? a[r](new RegExp(" more:" + this.P.Ha + "$"), "") : a
    };
    I.Cc = function (a, b) {
        return google[v].A.Sb(google[v].G.$, [this, a, b])
    };
    I.fc = function (a, b, d) {
        b = null == b ? "google.search.CustomWebSearch.RawCompletion" : b;
        a = [a];
        this.Na && a[C](this.Na);
        a = a[tb](this.P.se())[xd](" ");
        if (this.N && this.ie) {
            var e = this.ie, e = e[r](/__HL__/, google[v][vd]);
            this.jd = e = e[r](/__QUERY__/, c(a))
        }
        var e = this.P.re(), g = [], f;
        for (f in e)g[C](f + "=" + e[f]);
        f = "&" + g[xd]("&");
        f += "&q=" + c(a);
        this.Ja && (f += "&safe=" + this.Ja);
        this.fa && (a = Zg(this.fa)) && (f += "&" + a);
        b = this.Rc(b, d);
        b += f;
        this.va = f;
        d && 0 != d && (this.va = this.va + "&start=" + d);
        window.google[pd].GoogleLocale && (b = this.gb &&
            this.N ? b + ("&googlehost=" + c(window.google[pd].GoogleLocale)) : b + ("&gl=" + c(window.google[pd].GoogleLocale)));
        return b
    };
    I.Pf = function (a) {
        a.html && delete a.html;
        var b;
        if (a[Wc] && "SPELL_CORRECTED_RESULTS" == a[Wc]) {
            b = W("gs-result");
            var d = xg(P["showing-results-for"] + " ", "gs-spelling"), e = h[t]("a");
            Oa(e, google[v].V.Bf(this.Bc(a.correctedAnchor)));
            d[p](e);
            b[p](d);
            d = xg(P["search-instead-for"] + " ", "gs-spelling");
            $(d, "gs-spelling-original");
            e = h[t]("a");
            Oa(e, google[v].V.Bf(this.Bc(a.originalAnchor)));
            d[p](e)
        } else b = xg(P.dym + " ", "gs-spelling"), $(b, "gs-result"), d = h[t]("a"), Oa(d, google[v].V.Bf(this.Bc(a[ld])));
        b[p](d);
        a.html = b
    };
    google[v].G[G].createSpellingHtml = google[v].G[G].Pf;
    google[v].G[G].zh = function (a, b) {
        var d = U(google[v].V.Wd(a.visibleUrl), "gs-visibleUrl");
        Q(b, d);
        $(d, "gs-visibleUrl-short");
        d = U(google[v].V.Wd(a.url), "gs-visibleUrl");
        Q(b, d);
        $(d, "gs-visibleUrl-long")
    };
    google[v].G[G].yh = function (a, b) {
        var d = Bg(a, "gs-promotion-image-cell"), e = W("gs-promotion-image-box");
        Q(e, b);
        Q(d, e)
    };
    google[v].G[G].Xh = function (a, b) {
        a.html && delete a.html;
        var d = W("gs-promotion");
        $(d, "gs-result");
        var e = zg(0, 1, "gs-promotion-table"), g = Ag(e, 0), f;
        Q(d, e);
        var k;
        a.image && (e = a.image.url[r]("resize_w=40", "resize_w=60"), e = e[r]("resize_h=40", "resize_h=60"), e = Cg(e, null, null, "gs-promotion-image"), a.url && (f = Dg(a.url, "", this.za()), a.clicktrackUrl && google[v].G.od(f, a.clicktrackUrl, a.url), Q(f, e), e = f), k = e, b.sf || google[v].G[G].yh(g, k));
        e = null;
        a.clicktrackUrl && (e = {}, e[google[v].G.oe] = a.clicktrackUrl, e[google[v].G.ue] =
            a.url);
        e = Eg(a.url, a[bd], this.za(), "gs-title", void 0, e);
        a.titleRight && (f = yg("", "gs-promotion-title-right"), Oa(f, " " + a.titleRight), Q(e, f));
        e.dir = google[v].V.qh(e[Mc]);
        $(e, "gs-bidi-start-align");
        f = Bg(g, b.sf && a.image ? "" : "gs-promotion-text-cell");
        Q(f, e);
        b.Xi && google[v].G[G].zh(a, f);
        var l;
        b.sf && a.image ? (e = zg(0, 0, "gs-promotion-table-snippet-with-image"), g = Ag(e, 0), Q(f, e), google[v].G[G].yh(g, k), l = Bg(g, "gs-promotion-text-cell-with-image")) : a.bodyLines && (l = W(), Q(f, l));
        if (a.bodyLines) {
            g = a.bodyLines;
            k = "right" ==
                a.bodyLinkAlignment;
            for (var n = 0; n < g[F]; n++) {
                var q = g[n], s = q[bd], x = q.url, y = q.visibleUrl, e = W("gs-snippet"), E;
                s && (E = yg(""), Oa(E, s));
                var w;
                x && y && (w = Dg(x, "", this.za()), q.clicktrackUrl && google[v].G.od(w, q.clicktrackUrl, x), q = yg("", "gs-title"), Oa(q, y), Q(w, q));
                E && k && (Q(e, E), w && Q(e, wg(" ")));
                w && Q(e, w);
                E && !k && (w && Q(e, wg(" ")), Q(e, E));
                e.dir = google[v].V.qh(e[Mc]);
                $(e, "gs-bidi-start-align");
                Q(l, e)
            }
        }
        b.Xi || google[v].G[G].zh(a, f);
        a.html = d
    };
    google[v].G[G].createPromotionHtml = google[v].G[G].Xh;
    google[v].G[G].Ih = function (a) {
        delete a.html;
        0 < a.display_facets[F] && (a.html = google[v].ga.la("facets", a))
    };
    google[v].G[G].createFacetResultHtml = google[v].G[G].Ih;
    google[v].G[G].Ra = function (a) {
        a.html && delete a.html;
        cb(a, this.za() || void 0);
        ab(a, a[bd] || a.visibleUrl);
        a.html = google[v].ga.la("webResult", a, {isLabelUrl: Ng()});
        if (a.clicktrackUrl)for (var b = a.html[Cb]; b; b = b[Mb])if (1 == b[Kc]) {
            "a" == b[pc][yd]() && b[mc] == a.unescapedUrl && google[v].G.od(b, a.clicktrackUrl, a.unescapedUrl);
            for (var d = b[Pb]("a"), e = 0, g; g = d[e]; e++)g[mc] == a.unescapedUrl && google[v].G.od(g, a.clicktrackUrl, a.unescapedUrl)
        }
        this.Pc(a.html)
    };
    google[v].G[G].createResultHtml = google[v].G[G].Ra;
    google[v].G.od = function (a, b, d) {
        a[Eb](google[v].G.oe, b);
        a[Eb](google[v].G.ue, d)
    };
    google[v].G[G].Ub = function (a, b, d) {
        this.td = null;
        this.P = google[v].Ac.jj(a, b);
        this.P instanceof google[v].Tc && (this.N = !0, this.P[Wc]() == google[v].G.Sc && (this.td = P["linked-cse-error-results"]), d && d[yb](/__HL__/) && d[yb](/__QUERY__/) && (this.ie = d))
    };
    google[v].G[G].setSiteRestriction = google[v].G[G].Ub;
    I = google[v].G[G];
    I.uh = function () {
        return this.N ? this.P[Wc]() : null
    };
    I.vh = function () {
        return this.N ? this.P.zf : null
    };
    I.nc = function () {
        return this.N ? this.P.Ha : null
    };
    I.sj = function (a) {
        this.N && a && this.P.xj(a)
    };
    I.Sa = function (a, b) {
        a == google[v].A.Ya && (this.Ja = b ? b == google[v].A.Wf || b == google[v].A.Vf || b == google[v].A.Cl ? b : null : null);
        if (a == google[v].A.Ka)if (b)for (var d in b) {
            var e = b[d];
            google[v].G.de[d] && (this.fa[d] = e)
        } else this.fa = {}
    };
    google[v].G[G].setRestriction = google[v].G[G].Sa;
    google[v].G[G].Da = function (a) {
        fa(qa(a, 10)) || (a = qa(a, 10));
        this.N && (0 < a && a <= google[v].G.Dl || google[v].A.Jc == a) ? this.La = a : google[v].A[G].Da[kd](this, a)
    };
    google[v].G[G].setResultSetSize = google[v].G[G].Da;
    google[v].G[G].Pa = function (a) {
        google[v].A[G].Pa[kd](this, a)
    };
    google[v].G[G].setLinkTarget = google[v].G[G].Pa;
    google[v].G[G].Hb = function (a) {
        google[v].A[G].Hb[kd](this, a)
    };
    google[v].G[G].setQueryAddition = google[v].G[G].Hb;
    google[v].Ac = function () {
    };
    google[v].Ac[G].se = function () {
    };
    google[v].Ac[G].re = function () {
    };
    google[v].Ac[G].je = function () {
    };
    google[v].Ac.jj = function (a, b) {
        var d;
        null == a || "string" == typeof a && "" == a ? d = new google[v].wc : "string" == typeof a ? d = a[yb](/(^partner-pub-\d*:.*)|(^\d{21}:.*)/) ? new google[v].Tc(google[v].G.yf, a, b) : new google[v].xe(a) : a.siteUrl ? d = new google[v].xe(a.siteUrl) : a.cseId ? d = new google[v].Tc(google[v].G.yf, a.cseId, b) : a.crefUrl && (d = new google[v].Tc(google[v].G.Sc, a.crefUrl, b));
        return d || new google[v].wc
    };
    google[v].wc = function () {
    };
    jg(google[v].wc, google[v].Ac);
    google[v].wc[G].se = function () {
        return[]
    };
    google[v].wc[G].re = function () {
        return{}
    };
    google[v].wc[G].je = function () {
        return new google[v].wc
    };
    google[v].Tc = function (a, b, d) {
        this.wj = a;
        this.zf = b;
        this.Ha = null;
        d && (this.Ha = d)
    };
    jg(google[v].Tc, google[v].Ac);
    I = google[v].Tc[G];
    Ua(I, function () {
        return this.wj
    });
    I.xj = function (a) {
        this.Ha = a
    };
    I.se = function () {
        var a = [];
        this.Ha && (0 == this.Ha[Qc]("more:") || 0 == this.Ha[Qc]("less:") ? a[C](this.Ha) : a[C]("more:" + this.Ha));
        return a
    };
    I.re = function () {
        var a = this.zf;
        this.wj == google[v].G.Sc && (a = c(a));
        var b = {};
        b[this.wj] = a;
        return b
    };
    I.je = function () {
        return new google[v].Tc(this.wj, this.zf, this.Ha)
    };
    google[v].xe = function (a) {
        this.gr = a
    };
    jg(google[v].xe, google[v].Ac);
    google[v].xe[G].se = function () {
        var a = [];
        a[C]("site:" + this.gr);
        return a
    };
    google[v].xe[G].re = function () {
        return{}
    };
    google[v].xe[G].je = function () {
        return new google[v].xe(this.gr)
    };
    google[v].NoOldNames || (da("GwebSearch", google[v].K), da("GcustomwebSearch", google[v].G), da("GbookSearch", google[v].ka), da("GblogSearch", google[v].Aa), da("GvideoSearch", google[v].ya), da("GnewsSearch", google[v].ma), da("GlocalSearch", google[v].H), da("GimageSearch", google[v].D), da("GcustomimageSearch", google[v].C), da("GpatentSearch", google[v].da), da("GSearch", google[v].A), da("GSearchControl", google[v].B), da("GSearchForm", google[v].Ca), da("GsearcherOptions", google[v].eb), da("GdrawOptions", google[v].qa));
    google[v].ga = {};
    google[v].ga.zn = function (a) {
        google[v].ga.zj.unshift(a);
        return google[v].ga.zj
    };
    Bd("google.search.Csedr.addOverride", google[v].ga.zn, void 0);
    google[v].ga.zj = ["base_", ""];
    google[v].ga.dx = function (a, b) {
        google[v].ga.em[a] || (google[v].ga.em[a] = eval("[function(Vars,render,html,bidiTextDir,bidiHtmlDir,bidiTextMarkAfter,bidiHtmlMarkAfter, localizedMessages){with(Vars)return(" + a + ")}][0]"));
        return google[v].ga.em[a](b, google[v].ga.la, google[v].ga.Hh, google[v].V.Pw, google[v].V.qh, google[v].V.Rw, google[v].V.Qw, P)
    };
    google[v].ga.em = {};
    google[v].ga.Hh = function (a) {
        var b = h.createDocumentFragment(), d = h[t]("div");
        for (Oa(d, a); d[Cb];)b[p](d[Cb]);
        return b
    };
    google[v].ga.la = function (a, b) {
        google[v].ga.jm && (h[gd][p](google[v].ga.Hh(google[v].ga.jm)), google[v].ga.jm = 0);
        for (var d = 0; !a[p];) {
            if (d >= google[v].ga.zj[F])return google[v].ga.Hh(a + " not found");
            a = h[Lc](google[v].ga.zj[d++] + a) || a
        }
        for (var e = {}, g = 1; g < arguments[F]; g++)for (d in arguments[g])e[d] = arguments[g][d];
        try {
            for (var f = google[v].ga.Hh(""), k, l, n = 0, q, s, x = function (a) {
                a = "data-" + a;
                s = (q = y[md](a)) ? google[v].ga.dx(q, e) : "";
                k[rc] && k[rc](a);
                return q
            }, y = a[Cb]; y; y = l ? y : y[Mb])if (k = y[Fb](!1), 1 != y[Kc])(3 != y[Kc] ||
                y.nodeValue[yb](/\S/)) && f[p](k); else {
                x("foreach");
                !l && q && (e.Foreach = s && "function" == typeof s[xd] ? s : [s], d = 0, l = 1);
                if (l)if (d < e.Foreach[F])e.Cur = e.Foreach[e.Index = d++]; else {
                    l = 0;
                    continue
                }
                x("if") && (n = 0);
                if (q || x("elif"))if (n || !s)continue; else n = 1;
                if (!x("attr") || s) {
                    if (f[p](k), q)for (var E in s)void 0 != s[E] && ("class" == E ? m(k, s[E]) : "style" == E && qg() ? k[u].cssText = s[E] : k[Eb](E, s[E]))
                } else k = f;
                if (x("facetgroup"))for (g = 0; g < e.display_facets[F]; g++) {
                    var w = {index: ""};
                    1 == e.display_facets[F] ? w = {index: "sizeone"} : 0 == g ? w =
                    {index: "first"} : g == e.display_facets[F] - 1 && (w = {index: "last"});
                    k[p](google[v].ga.la("facetGroupEntry", e.display_facets[g], w))
                }
                var N = x("body") ? s && s[p] ? s : h[wb](s) : google[v].ga.la(y, e, x("vars") ? s : {});
                try {
                    N && k[p](N)
                } catch (z) {
                }
            }
            return f
        } catch (J) {
            return google[v].ga.Hh(J.toString() + ": " + q)
        }
    };
    Bd("google.search.Csedr.render", google[v].ga.la, void 0);
    google[v].Dj = {};
    google[v].Dj.ty = function (a) {
        if (!(a && a instanceof oa))return a;
        for (var b = {}, d = 0; d < a[F]; d++)for (var e in a[d])b[e] = a[d][e];
        return b
    };
    Bd("google.search.richsnippets.merge", google[v].Dj.ty, void 0);
    google[v].Dj.ry = function (a) {
        if (!(a instanceof oa))return!(!a.description && !a.summary);
        for (var b = 0; b < a[F]; b++)if (a[b].description || a[b].summary)return!0;
        return!1
    };
    Bd("google.search.richsnippets.hreviewNonEmpty", google[v].Dj.ry, void 0);
    google[v].F = {};
    google[v].F.element = {};
    google[v].F[H].Fa = {ki: "searchbox+results", yb: "searchbox", ec: "results"};
    google[v].F[H].dd = {wm: "standard", df: "two-column", $e: "searchbox-only", xi: "searchresults-only"};
    google[v].F[H].Wb = function (a) {
        return"string" == typeof a ? "" != a && "0" != a && "false" != a[yd]() : !!a
    };
    google[v].F[H].Am = function (a) {
        a = qa(a, 10);
        return fa(a) ? void 0 : a
    };
    google[v].F[H].ca = function (a) {
        return function (b) {
            for (var d = 0; d < a[F]; d++)if (typeof b == a[d])return b
        }
    };
    google[v].F[H].Xx = function (a) {
        if ("string" == typeof a && (a = fh(a)) && (0 == a[Qc]("http://") || 0 == a[Qc]("https://")))return a
    };
    google[v].F[H].Bw = function (a) {
        var b = {};
        if (1 < a[F]) {
            a = a[Rb](1)[Yb]("&");
            for (var d = 0; d < a[F]; d++) {
                var e = a[d][Yb]("=");
                try {
                    var g = ua(e[0])
                } catch (f) {
                    continue
                }
                if (g) {
                    try {
                        var k = e[1] ? ua(e[1][r](/\+/g, " ")) : e[1]
                    } catch (l) {
                    }
                    b[g] = k
                }
            }
        }
        return b
    };
    google[v].F[H].ll = function (a) {
        var b = {};
        if (1 < a[F]) {
            a = a[Rb](1)[Yb]("&");
            for (var d = 0; d < a[F]; d++) {
                var e = a[d][Yb]("=");
                try {
                    var g = ua(e[0])
                } catch (f) {
                    continue
                }
                if ("gcse-bookmark" === g)try {
                    var k = ua(e[1]);
                    b[k[Yb](":")[0]] = k[rd](k[Qc](":") + 1)
                } catch (l) {
                }
            }
        }
        return b
    };
    google[v].F[H].Op = function (a, b) {
        for (var d = {}, e = 0; e < b[F]; e++)a[dc](b[e]) && (d[b[e]] = a[b[e]]);
        return d
    };
    google[v].F[H].U = {};
    google[v].F[H].U.Dh = "gcse";
    google[v].F[H].U.Sv = "data-";
    google[v].F[H].U.Ol = "div";
    google[v].F[H].U.Tv = "gname";
    google[v].F[H].U.Uv = google[v].F[H].U.Dh + ":";
    google[v].F[H].U.Nl = google[v].F[H].U.Dh + "-";
    google[v].F[H].U.mj = {REPLACE: 0, Qp: 1};
    google[v].F[H].U.tw = function () {
        var a = 0, b = "___" + google[v].F[H].U.Dh + "_";
        return function () {
            return b + a++
        }
    }();
    google[v].F[H].U.oy = function (a) {
        var b = 0;
        return function (d) {
            return a == google[v].F[H].dd.df ? d || a : d || a + b++
        }
    };
    var wh = google[v].F[H].U, xh = google[v].F[H].dd, yh = google[v].F[H].Fa, zh = google[v].F[H].U.oy, Ah = {};
    Ah[xh.wm] = {wh: [yh.ki], getName: zh(xh.wm)};
    Ah[xh.df] = {wh: [yh.yb, yh.ec], getName: zh(xh.df)};
    Ah[xh.$e] = {wh: [yh.yb], getName: zh(xh.$e)};
    Ah[xh.xi] = {wh: [yh.ec], getName: zh(xh.xi)};
    wh.Ll = Ah;
    google[v].F[H].U.sh = {search: {Nd: google[v].F[H].dd.wm, th: google[v].F[H].Fa.ki}, searchbox: {Nd: google[v].F[H].dd.df, th: google[v].F[H].Fa.yb}, searchresults: {Nd: google[v].F[H].dd.df, th: google[v].F[H].Fa.ec}, "searchbox-only": {Nd: google[v].F[H].dd.$e, th: google[v].F[H].Fa.yb}, "searchresults-only": {Nd: google[v].F[H].dd.xi, th: google[v].F[H].Fa.ec}};
    var Bh = google[v].F[H].U, Ch = [], Dh = google[v].F[H].U.Dh + "\\:", Eh;
    for (Eh in google[v].F[H].U.sh)Ch[C](Dh + Eh), Ch[C](google[v].F[H].U.Ol + "." + google[v].F[H].U.Nl + Eh);
    Bh.uw = Ch[xd](", ");
    google[v].F[H].U.ww = function (a) {
        var b = [], d = google[v].F[H].U.Dh + ":", e;
        for (e in google[v].F[H].U.sh) {
            for (var g = a[Pb](d + e), f = 0; f < g[F]; f++)b[C](g[f]);
            g = Xg(a, google[v].F[H].U.Ol, google[v].F[H].U.Nl + e);
            for (f = 0; f < g[F]; f++)b[C](g[f])
        }
        return b
    };
    google[v].F[H].U.Cw = {nB: {name: "resultsUrl", R: google[v].F[H].Xx, defaultValue: void 0, T: !0, Q: void 0, O: void 0, S: google[v].F[H].Fa.yb}, aB: {name: "newWindow", R: google[v].F[H].Wb, defaultValue: !1, T: !0, Q: void 0, O: void 0, S: google[v].F[H].Fa.yb}, jB: {name: "queryParameterName", R: google[v].F[H].ca(["string"]), defaultValue: "q", T: !0, Q: void 0, O: void 0, S: void 0}, uA: {name: "autoSearchOnLoad", R: google[v].F[H].Wb, defaultValue: !0, T: !0, Q: void 0, O: void 0, S: void 0}, yA: {name: "defaultToRefinement", R: google[v].F[H].ca(["string"]),
        defaultValue: void 0, T: !0, Q: "defaultToRefinement", O: void 0, S: void 0}, FA: {name: "enableOrderBy", R: google[v].F[H].Wb, defaultValue: void 0, T: !0, Q: "enableOrderBy", O: void 0, S: void 0}, eB: {name: "orderByOptions", R: google[v].F[H].ca(["object"]), defaultValue: void 0, T: !1, Q: "keys", O: "orderByOptions", S: void 0}, oB: {name: "resultSetSize", R: google[v].F[H].ca(["string", "number"]), defaultValue: void 0, T: !0, Q: "resultSetSize", O: void 0, S: void 0}, mB: {name: "extendedRestricts", R: google[v].F[H].ca(["object"]), defaultValue: void 0,
        T: !1, Q: google[v].A.Ka, O: void 0, S: void 0}, pB: {name: "safeSearch", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: google[v].A.Ya, O: void 0, S: void 0}, kB: {name: "refinementStyle", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: void 0, O: void 0, S: google[v].F[H].Fa.ec}, CA: {name: "enableHistory", R: google[v].F[H].Wb, defaultValue: !1, T: !0, Q: void 0, O: void 0, S: void 0}, ZA: {name: "linkTarget", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: void 0, O: void 0, S: google[v].F[H].Fa.ec}, GA: {name: "enableSpeech",
        R: google[v].F[H].Wb, defaultValue: !1, T: !0, Q: void 0, O: void 0, S: google[v].F[H].Fa.yb}, BA: {name: "enableAutoComplete", R: google[v].F[H].Wb, defaultValue: void 0, T: !0, Q: void 0, O: void 0, S: google[v].F[H].Fa.yb}, qA: {name: "autoCompleteMatchType", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "matchType", O: "autoCompleteOptions", S: google[v].F[H].Fa.yb}, tA: {name: "autoCompleteValidLanguages", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "validLanguages", O: "autoCompleteOptions", S: google[v].F[H].Fa.yb},
        rA: {name: "autoCompleteMaxCompletions", R: google[v].F[H].Am, defaultValue: void 0, T: !0, Q: "maxCompletions", O: "autoCompleteOptions", S: google[v].F[H].Fa.yb}, sA: {name: "autoCompleteMaxPromotions", R: google[v].F[H].Am, defaultValue: void 0, T: !0, Q: "maxPromotions", O: "autoCompleteOptions", S: google[v].F[H].Fa.yb}, bB: {name: "noResultsString", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: void 0, O: void 0, S: google[v].F[H].Fa.ec}, nA: {name: "addOverride", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0,
            Q: void 0, O: void 0, S: void 0}, cB: {name: "numTopRefinements", R: google[v].F[H].Am, defaultValue: void 0, T: !1, Q: void 0, O: void 0, S: void 0}, NB: {name: "webSearchResultSetSize", R: google[v].F[H].ca(["number", "string"]), defaultValue: void 0, T: !0, Q: "resultSetSize", O: "webSearchOptions", S: void 0}, MB: {name: "webSearchExtendedRestricts", R: google[v].F[H].ca(["object"]), defaultValue: void 0, T: !1, Q: google[v].A.Ka, O: "webSearchOptions", S: void 0}, KB: {name: "lr", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "lr", O: "webSearchExtendedRestricts",
            S: void 0}, GB: {name: "cr", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "cr", O: "webSearchExtendedRestricts", S: void 0}, IB: {name: "gl", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "gl", O: "webSearchExtendedRestricts", S: void 0}, HB: {name: "filter", R: google[v].F[H].ca(["number"]), defaultValue: void 0, T: !0, Q: "filter", O: "webSearchExtendedRestricts", S: void 0}, FB: {name: "as_sitesearch", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "as_sitesearch", O: "webSearchExtendedRestricts",
            S: void 0}, EB: {name: "as_oq", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "as_oq", O: "webSearchExtendedRestricts", S: void 0}, PB: {name: "sort_by", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "sort_by", O: "webSearchExtendedRestricts", S: void 0}, OB: {name: "webSearchSafesearch", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: google[v].A.Ya, O: "webSearchOptions", S: void 0}, JB: {name: "webSearchLinkTarget", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "linkTarget",
            O: "webSearchOptions", S: google[v].F[H].Fa.ec}, LB: {name: "webSearchQueryAddition", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "queryAddition", O: "webSearchOptions", S: void 0}, DA: {name: "enableImageSearch", R: google[v].F[H].Wb, defaultValue: void 0, T: !0, Q: "enableImageSearch", O: void 0, S: google[v].F[H].Fa.ec}, AA: {name: "disableWebSearch", R: google[v].F[H].Wb, defaultValue: void 0, T: !0, Q: "disableWebSearch", O: void 0, S: void 0}, xA: {name: "defaultToImageSearch", R: google[v].F[H].Wb, defaultValue: void 0, T: !0,
            Q: "defaultToImageSearch", O: void 0, S: void 0}, RA: {name: "imageSearchLayout", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "layout", O: "imageSearchOptions", S: google[v].F[H].Fa.ec}, TA: {name: "imageSearchExtendedRestricts", R: google[v].F[H].ca(["object"]), defaultValue: void 0, T: !1, Q: google[v].A.Ka, O: "imageSearchOptions", S: void 0}, SA: {name: "image_lr", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "lr", O: "imageSearchExtendedRestricts", S: void 0}, OA: {name: "image_cr", R: google[v].F[H].ca(["string"]),
            defaultValue: void 0, T: !0, Q: "cr", O: "imageSearchExtendedRestricts", S: void 0}, QA: {name: "image_gl", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "gl", O: "imageSearchExtendedRestricts", S: void 0}, PA: {name: "image_filter", R: google[v].F[H].ca(["number"]), defaultValue: void 0, T: !0, Q: "filter", O: "imageSearchExtendedRestricts", S: void 0}, NA: {name: "image_as_sitesearch", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "as_sitesearch", O: "imageSearchExtendedRestricts", S: void 0}, MA: {name: "image_as_oq",
            R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "as_oq", O: "imageSearchExtendedRestricts", S: void 0}, VA: {name: "image_sort_by", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "sort_by", O: "imageSearchExtendedRestricts", S: void 0}, UA: {name: "imageSearchResultSetSize", R: google[v].F[H].ca(["number", "string"]), defaultValue: void 0, T: !0, Q: "resultSetSize", O: "imageSearchOptions", S: void 0}, KA: {name: "gaQueryParameter", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "queryParameter",
            O: "googleAnalyticsOptions", S: google[v].F[H].Fa.yb}, JA: {name: "gaCategoryParameter", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "categoryParameter", O: "googleAnalyticsOptions", S: google[v].F[H].Fa.yb}, lA: {name: "adchannel", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "adchannel", O: void 0, S: void 0}, mA: {name: "adclient", R: google[v].F[H].ca(["string"]), defaultValue: void 0, T: !0, Q: "adclient", O: void 0, S: void 0}, pA: {name: "adtest", R: google[v].F[H].ca(["string"]), defaultValue: void 0,
            T: !0, Q: "adtest", O: void 0, S: void 0}, oA: {name: "adoptions", R: google[v].F[H].ca(["object"]), defaultValue: void 0, T: !1, Q: "adoptions", O: void 0, S: void 0}, rB: {name: "overlayResults", R: google[v].F[H].Wb, defaultValue: !1, T: !0, Q: "overlayResults", O: void 0, S: void 0}, qB: {name: "showBookmarkLink", R: google[v].F[H].Wb, defaultValue: !1, T: !1, Q: "showBookmarkLink", O: "bookmarkOptions", S: void 0}, WA: {name: "isSitesearch", R: google[v].F[H].Wb, defaultValue: !1, T: !1, Q: "isSiteSearch", O: "bookmarkOptions", S: void 0}, EA: {name: "enableMobileLayout",
            R: google[v].F[H].Wb, defaultValue: !1, T: !1, Q: "enableMobileLayout", O: void 0, S: void 0}};
    google[v].F[H].U.hi = function (a, b) {
        var d = google[v].F[H].U.Cw, e;
        for (e in d)d[dc](e) && a[kd](b, d[e])
    };
    google[v].F[H].U.Mp = ["oq", "gs_204"];
    google[v].F[H].rh = function (a, b) {
        this.te = a;
        this.Rp = b ? google[v].F[H].U.mj.Qp : google[v].F[H].U.mj.REPLACE;
        var d, e;
        if (b)d = b.tag || "search", e = b.attributes || {}; else {
            d = a.nodeName[yd]();
            var g = "";
            d == google[v].F[H].U.Ol ? (g = google[v].F[H].U.Sv, d = (a[cd] || a[md]("class"))[Rb](google[v].F[H].U.Nl[F])) : d = d[Rb](google[v].F[H].U.Uv[F]);
            e = google[v].F[H].rh.Wv(a, g)
        }
        this.attributes = e;
        this.Nd = google[v].F[H].U.sh[d].Nd;
        Ua(this, google[v].F[H].U.sh[d].th);
        g = b ? b.gname : a[md](g + google[v].F[H].U.Tv);
        this.dc = google[v].F[H].U.Ll[this.Nd].getName(g)
    };
    google[v].F[H].rh.Wv = function (a, b) {
        var d = {};
        google[v].F[H].U.hi(function (e) {
            var g = a[md](b + e[Zc]);
            null != g && (d[e[Zc]] = g)
        }, this);
        return d
    };
    google[v].F[H].rh[G].bw = function () {
        var a = this.te, b;
        if (this.Rp == google[v].F[H].U.mj.REPLACE) {
            b = h[t]("div");
            var d = a[ud];
            d[xb](b, a);
            d[id](a);
            b.id = a.id;
            this.te = b
        } else this.Rp == google[v].F[H].U.mj.Qp && (b = h[t]("div"), a[p](b), this.te = b);
        this.te.id && 0 !== this.te.id[F] || (this.te.id = google[v].F[H].U.tw())
    };
    google[v].F[H].eq = function (a, b, d, e, g, f) {
        this.fe = a;
        this.dc = b;
        Ua(this, d);
        this.xf = {};
        this.ha = this.ex(e);
        this.oh = g;
        this.xc = f
    };
    I = google[v].F[H].eq[G];
    I.xh = 0;
    I.nd = null;
    I.rs = !1;
    I.yw = function (a) {
        if (a.dc != this.dc)return jh("Name of the component, " + a.dc + ", should match name of the element, " + this.dc + "."), this.xh;
        var b = !1;
        this.xf[a[Wc]] && (jh("Multiple components of the same type " + a[Wc] + " for Element named " + this.dc + " are detected. Only the last is used."), b = !0);
        for (var d = google[v].F[H].U.Ll[this[Wc]].wh, e = 0; e < d[F]; e++)if (d[e] == a[Wc])return this.xf[a[Wc]] = a, b || this.xh++, this.xh;
        jh("Component of type " + a[Wc] + " is not allowed for Element named " + this.dc + " of type " + this[Wc] +
            ".");
        return this.xh
    };
    I.la = function () {
        var a = google[v].F[H].U.Ll[this[Wc]].wh;
        if (a[F] != this.xh)for (var b = 0; b < a[F]; b++)if (!this.xf[a[b]])return jh("Component of type " + a[b] + " is missing for Element named " + this.dc + "."), !1;
        var a = {}, d;
        for (d in this.xf)this.xf[dc](d) && (b = this.xf[d], b.bw(), a[d] = b.te, this.ew(b.attributes, d));
        this.nd = this.cw(a);
        return!0
    };
    I.ex = function (a) {
        var b = {}, d;
        for (d in a)a[dc](d) && (b[d] = a[d]);
        return b
    };
    I.ew = function (a, b) {
        var d = google[v].F[H].Fa;
        google[v].F[H].U.hi(function (e) {
            if (a[dc](e[Zc]) && e.T && (b == d.ki || void 0 == e.S || e.S == b)) {
                var g = e.R(a[e[Zc]]);
                null != g && ("webSearchExtendedRestricts" === e.O ? (this.ha.webSearchExtendedRestricts || (this.ha.webSearchExtendedRestricts = {}), this.ha.webSearchExtendedRestricts[e[Zc]] = g) : "imageSearchExtendedRestricts" === e.O ? (this.ha.imageSearchExtendedRestricts || (this.ha.imageSearchExtendedRestricts = {}), this.ha.imageSearchExtendedRestricts[e.Q] = g) : this.ha[e[Zc]] = g)
            }
        }, this)
    };
    I.cw = function (a) {
        var b = {imageSearchOptions: {}, webSearchOptions: {}, autoCompleteOptions: {}, googleAnalyticsOptions: {}, orderByOptions: {}, bookmarkOptions: {}};
        google[v].F[H].U.hi(function (a) {
            if (a.Q && void 0 != this.ha[a[Zc]]) {
                var d = b;
                a.O && (d = b[a.O]);
                d[a.Q] = this.ha[a[Zc]]
            }
        }, this);
        this.ha.isSitesearch && void 0 !== this.xc.sortBy && (b.webSearchOptions || (b.webSearchOptions = {}), b.webSearchOptions[google[v].A.Ka] || (b.webSearchOptions[google[v].A.Ka] = {}), b.webSearchOptions[google[v].A.Ka].sort = this.xc.sortBy);
        this.ha.isSitesearch &&
        this.xc.refine && (b.defaultToRefinement = this.xc.refine);
        this.ha.isSitesearch && this.xc.image && (b.defaultToImageSearch = "0" != this.xc.image ? !0 : !1);
        var d = new google[v].I(this.fe, b);
        void 0 != this.ha.refinementStyle && d.Lh(this.ha.refinementStyle);
        void 0 != this.ha.addOverride && google[v].ga.zn(this.ha.addOverride);
        void 0 != this.ha.linkTarget && d.Pa(this.ha.linkTarget);
        var e = new google[v].qa;
        void 0 != this.ha.enableAutoComplete && e.Dn(this.ha.enableAutoComplete);
        void 0 != this.ha.enableSpeech && e.Fn(this.ha.enableSpeech);
        void 0 != this.ha.numTopRefinements && e.Gn(this.ha.numTopRefinements);
        var g = null, f = google[v].F[H].dd, g = google[v].F[H].Fa;
        this[Wc] == f.$e ? (f = this.ha.resultsUrl, !f && this.fe ? f = "http://www.google.com/cse?" + ("string" == typeof this.fe ? "cx=" + c(this.fe) : "cref=" + c(this.fe.crefUrl)) : void 0 == f && (f = window[bc][mc]), e.Bn(f, this.ha.queryParameterName, this.ha.newWindow), g = a[g.yb]) : this[Wc] == f.xi ? (e.An(), g = a[g.ec]) : this[Wc] == f.df ? (e.En(a[g.yb]), g = a[g.ec]) : g = a[g.ki];
        this.rs && this.dc === this[Wc] + "0" && (a = h[t]("script"), Ua(a,
            "text/javascript"), a.src = "//www.google.com/cse/btguard.js?gcse_nc=" + window.___gcse_nc_, h.head[p](a));
        d.Rf(g, e);
        this.ha.noResultsString && (e = this.ha.noResultsString, e = Jd(e), d.Pe(e));
        this.ha.enableHistory ? d.Hn(rg(this, this.Cn)) && void 0 == this.ha.linkTarget && d.Pa(google[v].A.yn) : this.Cn(d);
        return d
    };
    I.Cn = function (a) {
        var b = google[v].F[H].dd, d = this.oh[this.ha.queryParameterName];
        if (this.ha.isSitesearch && this.xc.query && this[Wc] != b.$e) {
            d = this.xc.query;
            b = qa(this.xc[xc], 10);
            fa(b) && (b = 1);
            var e = google[v].F[H].Op(this.oh, google[v].F[H].U.Mp);
            a.ra(d, b, e)
        } else d && this.ha.autoSearchOnLoad && (this[Wc] == b.$e ? a.hj(d) : (e = google[v].F[H].Op(this.oh, google[v].F[H].U.Mp), a.ra(d, void 0, e)))
    };
    google[v].F[H].qq = function (a) {
        a = a || {};
        this.fe = a.cx || (a.cref ? {crefUrl: a.cref} : null);
        this.nw = this.Aw(a.uiOptions);
        this.ve = {};
        this.Ah = {};
        this.oh = google[v].F[H].Bw(window[bc][v]);
        this.xc = google[v].F[H].ll(window[bc][v]);
        this.Sl = a.rawCss;
        this.zw()
    };
    I = google[v].F[H].qq[G];
    I.Aw = function (a) {
        a = a || {};
        var b = {};
        google[v].F[H].U.hi(function (d) {
            var e = d[Zc], g = null;
            a[dc](e) && (g = d.R(a[e]));
            null != g ? b[e] = g : void 0 != d.defaultValue && (b[e] = d.defaultValue)
        }, this);
        return b
    };
    I.vw = function () {
        if ("boolean" == typeof this.Bm)return this.Bm;
        var a = h[t]("div"), b = h[t]("G:TEST");
        a[p](b);
        return this.Bm = !!(a.querySelectorAll && 0 < a.querySelectorAll("G\\:TEST")[F])
    };
    I.go = function (a) {
        a = (a ? eh(a) : null) || h[gd];
        a = this.vw() ? a.querySelectorAll(google[v].F[H].U.uw) : google[v].F[H].U.ww(a);
        window || (window = {});
        window.___gcse_nc_ = a[F] || 0;
        for (var b = 0; b < a[F]; ++b)this.Xp(new google[v].F[H].rh(a[b]));
        this.Wp()
    };
    I.la = function (a, b) {
        if (b && "searchbox" != a.tag && "searchresults" != b.tag)return jh('First and second components must be of tag "searchbox"  and "searchresults" separately.'), null;
        if (b && a.gname != b.gname)return jh("First and second components must be of the same gname."), null;
        var d = [a];
        b && d[C](b);
        for (var e, g = [], f = 0; f < d[F]; f++) {
            if (!d[f].div)return jh("div required for component."), null;
            d[f].tag || (d[f].tag = "search");
            if (!google[v].F[H].U.sh[d[f].tag])return jh("tag named " + d[f].tag + " is not recognized"), null;
            var k = eh(d[f].div);
            k && 1 === k[Kc] && (k = new google[v].F[H].rh(k, d[f]), e = k.dc, g[C](k))
        }
        for (f = 0; f < g[F]; f++)this.Xp(g[f]);
        this.Wp();
        return e ? this.qj(e) : null
    };
    I.qj = function (a) {
        return this.Ah[a] ? new google[v].F[H].Vl(this.Ah[a]) : null
    };
    I.Tl = function () {
        var a = {}, b;
        for (b in this.Ah)a[b] = new google[v].F[H].Vl(this.Ah[b]);
        return a
    };
    I.Xp = function (a) {
        var b = a.dc;
        this.ve[b] || (this.ve[b] = new google[v].F[H].eq(this.fe, b, a.Nd, this.nw, this.oh, this.xc));
        this.ve[b].yw(a)
    };
    I.zw = function () {
        if (this.Sl) {
            var a = h[Pb]("head")[0];
            a || (a = h[gd][ud][p](h[t]("head")));
            var b = h[t]("style");
            Ua(b, "text/css");
            b[Cc] ? b[Cc].cssText = this.Sl : b[p](h[wb](this.Sl));
            a[p](b)
        }
    };
    I.Wp = function () {
        for (var a in this.ve)if (this.ve[dc](a)) {
            var b = this.ve[a];
            b.la() && (this.Ah[a] = b);
            delete this.ve[a]
        }
    };
    google[v].F[H].Vl = function (a) {
        this.gname = a.dc;
        Ua(this, a[Wc]);
        this.uiOptions = a.ha;
        this.execute = rg(a.nd, a.nd.ra);
        this.prefillQuery = rg(a.nd, a.nd.hj);
        this.getInputQuery = rg(a.nd, a.nd.Gq);
        this.clearAllResults = rg(a.nd, a.nd.Zc)
    };
    Bd("google.search.cse.element.ElementInterface", google[v].F[H].Vl, void 0);
    google[v].F[H].Ch = function () {
        return(new Date)[Nb]()
    };
    google[v].F[H].Rl = google[v].F[H].Ch();
    google[v].F[H].fq = function (a, b) {
        if (!google[v].F[H].rq && (google[v].F[H].rq = google[v].F[H].Ch(), window.googleLT_ && 1 == window.googleLT_ % 100)) {
            var d = "e", e = window.googleLT_;
            window.__gcse && window.__gcse.ct && (e = window.__gcse.ct, d = "c");
            var g = window.googleLT_ - e, f = google[v].F[H].Rl - e, k = google[v].F[H].Dw - e, l = b - e, e = google[v].F[H].rq - e;
            if (0 < f && 0 < k && 0 < l) {
                var n = "ex";
                "c" == d && "explicit" != window.__gcse.parsetags && (n = "ol");
                var q = "render" == a ? "r" : "g", s = [];
                "c" == d && s[C]("gl." + g);
                s = s[tb](["el." + f, "mc." + k, q + "s." + l, q + "e." +
                    e]);
                google[pd].recordCsiStat(["element_" + (d + n)], s)
            }
        }
    };
    google[v].F[H].Eh = function (a) {
        return google[v].F[H].Bh ? !1 : (google[v].F[H].Bh = new google[v].F[H].qq(a), google[v].F[H].Dw = google[v].F[H].Ch(), !0)
    };
    Bd("google.search.cse.element.init", google[v].F[H].Eh, void 0);
    google[v].F[H].go = function (a) {
        google[v].F[H].Eh();
        var b = google[v].F[H].Ch();
        google[v].F[H].Bh.go(a);
        google[v].F[H].fq("go", b)
    };
    Bd("google.search.cse.element.go", google[v].F[H].go, void 0);
    google[v].F[H].la = function (a, b) {
        google[v].F[H].Eh();
        var d = google[v].F[H].Ch(), e = google[v].F[H].Bh.la(a, b);
        google[v].F[H].fq("render", d);
        return e
    };
    Bd("google.search.cse.element.render", google[v].F[H].la, void 0);
    google[v].F[H].qj = function (a) {
        google[v].F[H].Eh();
        return google[v].F[H].Bh.qj(a)
    };
    Bd("google.search.cse.element.getElement", google[v].F[H].qj, void 0);
    google[v].F[H].Tl = function () {
        google[v].F[H].Eh();
        return google[v].F[H].Bh.Tl()
    };
    Bd("google.search.cse.element.getAllElements", google[v].F[H].Tl, void 0);
    google[v].ga.jm = ' <div style="display:none"> <span id="private_ratings"> <span class="gsc-snippet-metadata"> <span data-if="Vars.ratingstars"> <span class="gsc-rating-bar"> <span data-attr="{style:\'width:\' + (Vars.ratingstars * 20) + \'%\'}"></span> </span> <span data-if="Vars.ratingcount"> <span data-body="\' \' + Vars.ratingcount"></span> <span> reviews</span> </span> </span> <span data-if="Vars.totaltime"> <span data-if="Vars.ratingstars && Vars.ratingcount"> - </span> <span data-body="Vars.totaltime"></span> </span> <span data-if="Vars.calories"> <span data-if="Vars.ratingstars && Vars.ratingcount || Vars.totaltime"> - </span> <span data-body="Vars.calories"></span> <span> cal</span> </span> <span data-if="Vars.pricerange"> <span data-if="Vars.ratingstars && Vars.ratingcount || Vars.totaltime || Vars.calories"> - </span> <span> Price range: </span> <span data-body="Vars.pricerange"></span> </span> <span data-if="Vars.reviewer" class="gsc-reviewer"> <span data-body="\' \' + Vars.reviewer"></span> </span> </span> </span> <span id="private_hproduct"> <span class="gsc-snippet-metadata"> <span data-if="Vars.availability">Availability: <span data-body="Vars.availability"></span>.</span> <span data-if="Vars.availability && Vars.price">&nbsp;</span> <span data-if="Vars.price"> Price: <span data-body="Vars.price"></span>.</span> </span> </span> <span id="private_hreview_icon"> <span data-if="google.search.richsnippets.hreviewNonEmpty(Vars.hreview)"> <span class="gsc-zippy"></span> </span> </span> <span id="private_hreview_content"> <span data-if="google.search.richsnippets.hreviewNonEmpty(Vars.hreview)" class="gsc-preview-reviews"> <ul> <span data-foreach="Vars.hreview" data-attr="0"> <li data-if="(Cur.description || Cur.summary) && Index == 0" class = "gsc-review-agregate-first-line"> <span data-if="Cur.description" data-body="Cur.description"></span> <span data-elif="Cur.summary" data-body="Cur.summary"></span> </li> <li data-elif="(Cur.description || Cur.summary) && Index < 10" data-attr="{\'class\': Index % 2 == 0 ? \'gsc-review-agregate-even-lines\' : \'gsc-review-agregate-odd-lines\'}"> <span data-if="Cur.description" data-body="Cur.description"></span> <span data-elif="Cur.summary" data-body="Cur.summary"></span> </li> </span> </ul> </span> </span> <span id="private_hrecipe"> <span data-if="Vars.author" class="gsc-author"> <span data-body="\' \' + Vars.author"></span> </span> </span> <span id="private_recipe"> <span data-attr="0" data-body="render(\'private_ratings\',google.search.richsnippets.merge(richSnippet.recipe))"> </span> <span data-if="Vars.richSnippet.hrecipe && Vars.richSnippet.hrecipe.author && !Vars.richSnippet.recipe.reviewer" data-attr="0" data-body="render(\'private_hrecipe\',richSnippet.hrecipe)"> </span> </span> <span id="private_person"> <span data-vars="{vcard:google.search.richsnippets.merge(Vars.richSnippet.vcard)}"> <span data-if="Vars.richSnippet.vcard && vcard.adr"> <span data-if="vcard.adr" class="gs-location"> <span data-body="\' \' + vcard.adr"> </span> </span> </span> <span data-elif="Vars.richSnippet.person"> <span data-if="person.role" class="gsc-role"> <span data-attr="0" data-body="\' \' + person.role"> </span> </span> <span data-if="person.org" class="gsc-org"> <span data-body="\' @\' + person.org"> </span> </span> <span data-if="person.location" class="gsc-location"> <span data-if="person.org || person.role || Vars.richSnippet.review"> - </span> <span data-body="\' \' + person.location"> </span> </span> </span> <span data-if="Vars.richSnippet.vcard && vcard.tel" class="gsc-tel"> <span data-if="(person && (person.org || person.role || Vars.richSnippet.review || person.location)) || (Vars.richSnippet.vcard && vcard.adr) "> - </span> <span data-body="\' Tel: \' + vcard.tel"> </span> </span> </span> </span> <span id="private_metadata" class="gsc-snippet-metadata"> <span data-vars="{person:google.search.richsnippets.merge(Vars.richSnippet.person), product:google.search.richsnippets.merge(Vars.richSnippet.hproduct)}"> <span data-if="Vars.richSnippet.recipe" data-attr="0" data-body="render(\'private_recipe\', Vars)"> </span> <span data-elif="Vars.richSnippet.review" data-attr="0" data-body="render(\'private_ratings\',google.search.richsnippets.merge(richSnippet.review))"> </span> <span data-if="Vars.richSnippet.hproduct && (product.availability || product.price)" data-attr="0" data-body="render(\'private_hproduct\', product)"> </span> <span data-elif="Vars.richSnippet.person || Vars.richSnippet.vcard" data-attr="0" data-body="render(\'private_person\', Vars)"> </span> </span> </span> <div id="base_facets"> <div class="gsc-context-box" data-facetgroup=\'title\'> </div> </div> <div id="base_facetGroupEntry"> <div> <div class="gsc-facet-label gsc-col" style="display:inline-block;"> <a data-attr="{\'data-refinementLabel\': label, \'label-with-op\': label_with_op}" data-body="html(anchor)"></a> </div> <div class="gsc-facet-result gsc-col" data-body="html(width + \'%\')" style="display:inline-block;"> </div> <div data-attr="{\'class\': index == \'first\' ? \'gsc-chart gsc-top gsc-col\' : index == \'last\' ? \'gsc-chart gsc-bottom gsc-col\' : index == \'sizeone\' ? \'gsc-chart gsc-bottom gsc-col gsc-top\' : \'gsc-chart gsc-col\'}" style="display:inline-block;"> <div class="" data-attr="{style:\'width:\' + width + \'%\'}"></div> </div> </div> </div> <div id="base_webResult"> <div class="gs-webResult gs-result" data-vars="{longUrl:function() { var i = unescapedUrl.indexOf(visibleUrl); return i < 1 ? visibleUrl : unescapedUrl.substring(i);}}"> <div class="gsc-thumbnail-inside"> <div class="gs-title"> <a class="gs-title" data-attr="{href:unescapedUrl,target:target,dir:bidiHtmlDir(title)}" data-body="html(title)"> </a> </div> </div> <div class="gsc-url-top"> <div class="gs-bidi-start-align gs-visibleUrl gs-visibleUrl-short" data-body="visibleUrl" data-attr="{dir:bidiTextDir(visibleUrl)}"> </div> <div class="gs-bidi-start-align gs-visibleUrl gs-visibleUrl-long" data-body="Vars.formattedUrl ? html(Vars.formattedUrl) : longUrl()" data-attr="{dir: Vars.formattedUrl ? bidiHtmlDir(Vars.formattedUrl) : bidiTextDir(longUrl()), style:\'word-break:break-all;\'}"> </div> </div> <table class="gsc-table-result"> <tbody> <tr> <td class="gsc-table-cell-thumbnail gsc-thumbnail" style="display:none"> <div data-if="Vars.richSnippet" data-attr="0" data-body="render(\'thumbnail\',richSnippet,{url:unescapedUrl,target:target})"> </div> </td> <td data-attr="{\'class\': \'gsc-table-cell-snippet-close\' + ((google.search.CurrentLocale == \'en\' && Vars.richSnippet && Vars.richSnippet.hreview && google.search.richsnippets.hreviewNonEmpty(Vars.richSnippet.hreview)) ? \' gsc-collapsable\' : \'\')}" onclick="if (this.className == \'gsc-table-cell-snippet-close gsc-collapsable\') { this.className = \'gsc-table-cell-snippet-open gsc-collapsable\'; } else if (this.className == \'gsc-table-cell-snippet-open gsc-collapsable\') { this.className = \'gsc-table-cell-snippet-close gsc-collapsable\'; };"> <span data-if="google.search.CurrentLocale == \'en\' && Vars.richSnippet && Vars.richSnippet.hreview" data-attr="0" data-body="render(\'private_hreview_icon\',richSnippet)"> </span> <div class="gs-title gsc-table-cell-thumbnail gsc-thumbnail-left"> <a class="gs-title" data-attr="{href:unescapedUrl,target:target,dir:bidiHtmlDir(title)}" data-body="html(title)"> </a> </div> <div class="gs-fileFormat" data-if="Vars.fileFormat"> <span class="gs-fileFormat" data-body="localizedMessages[\'file-format\'] + \' \'"></span> <span class="gs-fileFormatType" data-body="Vars.fileFormat"></span> </div> <div data-if="google.search.CurrentLocale == \'en\' && Vars.richSnippet"> <span data-attr="0" data-body="render(\'private_metadata\', Vars)"> </span> </div> <div class="gs-bidi-start-align gs-snippet" data-body="html(content)" data-attr="{dir:bidiHtmlDir(content)}"> </div> <div class="gsc-url-bottom"> <div class="gs-bidi-start-align gs-visibleUrl gs-visibleUrl-short" data-body="visibleUrl" data-attr="{dir:bidiTextDir(visibleUrl)}"> </div> <div class="gs-bidi-start-align gs-visibleUrl gs-visibleUrl-long" data-body="Vars.formattedUrl ? html(Vars.formattedUrl) : longUrl()" data-attr="{dir: Vars.formattedUrl ? bidiHtmlDir(Vars.formattedUrl) : bidiTextDir(longUrl()), style:\'word-break:break-all;\'}"> </div> </div> <div data-if="Vars.richSnippet && Vars.richSnippet.action" class="gs-actions" data-body="render(\'action\',richSnippet,{url:unescapedUrl,target:target})"> </div> <span data-if="google.search.CurrentLocale == \'en\' && Vars.richSnippet && Vars.richSnippet.hreview" data-attr="0" data-body="render(\'private_hreview_content\',richSnippet)"> </span> <div class="gs-per-result-labels" data-attr="{url:unescapedUrl}"> <span data-body="localizedMessages[\'labeled\']" data-if="!Vars.isLabelUrl && Vars.perResultLabels"></span> <a class=\'gs-label gs-add-label\' data-if="Vars.isLabelUrl" data-body="localizedMessages[\'add-label\']"></a> <div data-foreach="Vars.perResultLabels" data-attr="0" data-if="Vars.perResultLabels"> <a class="gs-label" data-attr="{\'data-refinementLabel\': Cur[\'label\'], \'label-with-op\': Cur[\'label_with_op\'], \'dir\' : bidiTextDir(Cur.anchor)}" data-body="Cur.anchor"></a> <span data-body="bidiTextMarkAfter(Cur.anchor)"></span> </div> </div> </td> </tr> </tbody> </table> </div> </div> <div id="base_imageResult_image" ><a data-attr="{ \'href\':originalContextUrl, \'target\':target, \'class\':imageClass }" ><img data-attr="{ \'src\':tbUrl, \'title\':titleNoFormatting, \'class\':imageClass }"/ ></a ></div> <div id="base_imageResult_text" ><div class="gs-title gs-ellipsis" ><a class="gs-title" data-attr="{ href:originalContextUrl, target:target, dir:bidiHtmlDir(title) }" data-body="html(title)"></a ></div ><div class="gs-visibleUrl gs-bidi-start-align gs-ellipsis gsc-url-top" data-attr="{title:visibleUrl, dir:bidiTextDir(visibleUrl)}" data-body="visibleUrl" ></div ><div class="gs-snippet gs-bidi-start-align gs-ellipsis" data-attr="{title:contentNoFormatting, dir:bidiHtmlDir(content)}" data-body="html(content)" ></div ><div class="gs-size gs-ellipsis" data-body="width + \' \u00d7 \' + height" ></div ><div class="gs-visibleUrl gs-bidi-start-align gs-ellipsis gsc-url-bottom" data-attr="{title:visibleUrl, dir:bidiTextDir(visibleUrl)}" data-body="visibleUrl" ></div ></div> <div id="base_imageResult_content" ><div data-body="render(\'base_imageResult_image\', Vars)" class="gs-image-box" ></div ><div data-body="render(\'base_imageResult_text\', Vars)" class="gs-text-box" ></div ></div> <div id="base_imageResult_classic" ><div class="gs-result gs-imageResult gs-imageResult-classic" data-body="render(\'base_imageResult_content\', Vars, { imageClass: \'gs-image gs-image-scalable\' })" ></div ></div> <div id="base_imageResult_column" ><div class="gs-result gs-imageResult gs-imageResult-column" data-body="render(\'base_imageResult_content\', Vars, { imageClass: \'gs-image gs-image-scalable\' })" ></div ></div> <div id="base_imageResult_popup" ><div class="gs-result gs-imageResult gs-imageResult-popup" onmouseover="google.search.ImageSearch.showPopup(this)" onmouseout="google.search.ImageSearch.hidePopup(this)" ><div class="gs-image-thumbnail-box" ><div data-body="render(\'base_imageResult_image\', Vars, { imageClass: \'gs-image gs-image-scalable\' })" class="gs-image-box" ></div ></div ><div data-body="render(\'base_imageResult_content\', Vars, { imageClass: \'gs-image\' })" class="gs-image-popup-box" ></div ></div ></div> <div id="base_thumbnail"> <div data-attr="0" data-vars="{tn:(Vars.cseThumbnail && cseThumbnail.src) ? cseThumbnail : ( (Vars.thumbnail && thumbnail.src) ? thumbnail : {src:Vars.document && document.thumbnailUrl})}"> <div data-if="tn.src"> <a class="gs-image" data-attr="{href:url,target:target}"> <img data-if="!tn.width || !tn.height || tn.width >= tn.height * 7 / 5" class="gs-image" data-attr="{src:tn.src}" onload="if (this.parentNode && this.parentNode.parentNode && this.parentNode.parentNode.parentNode) { this.parentNode.parentNode.parentNode.style.display = \'\'; this.parentNode.parentNode.className = \'gs-image-box gs-web-image-box gs-web-image-box-landscape\'; } "/> <img data-elif="true" class="gs-image" data-attr="{src:tn.src}" onload="if (this.parentNode && this.parentNode.parentNode && this.parentNode.parentNode.parentNode) { this.parentNode.parentNode.parentNode.style.display = \'\'; this.parentNode.parentNode.className = \'gs-image-box gs-web-image-box gs-web-image-box-portrait\'; } "/> </a> </div> </div> </div> <div id="base_action"> <div data-foreach="Vars.action" data-attr="0"> <div data-attr="{\'class\': \'gs-action \' + Cur[\'class\']}" data-if="Cur.url && Cur.label"> <a class="gs-action" data-attr="{href:Cur.url,target:target,dir:bidiTextDir(Cur.label)}" data-body="Cur.label"></a> </div> </div> </div> </div> ';
    google.loader.loaded({"module": "search", "version": "1.0", "components": ["default"]});
    google.loader.eval.search = function () {
        eval(arguments[0]);
    };
    if (google.loader.eval.scripts && google.loader.eval.scripts['search']) {
        (function () {
            var scripts = google.loader.eval.scripts['search'];
            for (var i = 0; i < scripts.length; i++) {
                google.loader.eval.search(scripts[i]);
            }
        })();
        google.loader.eval.scripts['search'] = null;
    }
})();