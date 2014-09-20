(function () {
    var h;
    var aa = this, ba = function (a) {
        var b = typeof a;
        if ("object" == b)if (a) {
            if (a instanceof Array)return"array";
            if (a instanceof Object)return b;
            var c = Object.prototype.toString.call(a);
            if ("[object Window]" == c)return"object";
            if ("[object Array]" == c || "number" == typeof a.length && "undefined" != typeof a.splice && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("splice"))return"array";
            if ("[object Function]" == c || "undefined" != typeof a.call && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("call"))return"function"
        } else return"null";
        else if ("function" == b && "undefined" == typeof a.call)return"object";
        return b
    }, ca = function (a) {
        return null != a
    }, da = function (a) {
        return"string" == typeof a
    }, ea = function (a, b) {
        var c = Array.prototype.slice.call(arguments, 1);
        return function () {
            var b = c.slice();
            b.push.apply(b, arguments);
            return a.apply(this, b)
        }
    }, fa = Date.now || function () {
        return+new Date
    }, ga = function (a, b) {
        function c() {
        }

        c.prototype = b.prototype;
        a.ci = b.prototype;
        a.prototype = new c;
        a.prototype.constructor = a;
        a.bi = function (a, c, f) {
            return b.prototype[c].apply(a,
                Array.prototype.slice.call(arguments, 2))
        }
    };
    var ha = ["iPhone OS 5_", "iPhone OS 4_", "SC-02C Build/GINGERBREAD"], ia = window.navigator ? window.navigator.userAgent : "", oa = function () {
        return 5 == ja(ka) || 6 == ja(ka) || 7 == ja(ka)
    }, ka = /MSIE\s+(\d+)\./, pa = /Opera\/.*Version\/(\d+)\./, ra = /Firefox\/(\d+)\./, sa = /Version\/(\d+)\..*Safari/, ja = function (a) {
        a = (a = a.exec(ia)) ? a[1] : "";
        return 0 < a.length && (a = parseInt(a, 10)) ? a : null
    }, ta = function () {
        for (var a = 0; a < ha.length; a++)if (-1 != ia.indexOf(ha[a]))return!0;
        return!1
    };
    var ua = function (a) {
        a = String(a);
        if (/^\s*$/.test(a) ? 0 : /^[\],:{}\s\u2028\u2029]*$/.test(a.replace(/\\["\\\/bfnrtu]/g, "@").replace(/"[^"\\\n\r\u2028\u2029\x00-\x08\x0a-\x1f]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:[\s\u2028\u2029]*\[)+/g, "")))try {
            return eval("(" + a + ")")
        } catch (b) {
        }
        throw Error("Invalid JSON string: " + a);
    }, va = function () {
        this.kc = void 0
    }, xa = function (a, b, c) {
        switch (typeof b) {
            case "string":
                wa(b, c);
                break;
            case "number":
                c.push(isFinite(b) && !isNaN(b) ? b : "null");
                break;
            case "boolean":
                c.push(b);
                break;
            case "undefined":
                c.push("null");
                break;
            case "object":
                if (null == b) {
                    c.push("null");
                    break
                }
                if ("array" == ba(b)) {
                    var d = b.length;
                    c.push("[");
                    for (var e = "", f = 0; f < d; f++)c.push(e), e = b[f], xa(a, a.kc ? a.kc.call(b, String(f), e) : e, c), e = ",";
                    c.push("]");
                    break
                }
                c.push("{");
                d = "";
                for (f in b)Object.prototype.hasOwnProperty.call(b, f) && (e = b[f], "function" != typeof e && (c.push(d), wa(f, c), c.push(":"), xa(a, a.kc ? a.kc.call(b, f, e) : e, c), d = ","));
                c.push("}");
                break;
            case "function":
                break;
            default:
                throw Error("Unknown type: " + typeof b);
        }
    }, ya = {'"': '\\"', "\\": "\\\\", "/": "\\/", "\b": "\\b", "\f": "\\f", "\n": "\\n", "\r": "\\r", "\t": "\\t", "\x0B": "\\u000b"}, za = /\uffff/.test("\uffff") ? /[\\\"\x00-\x1f\x7f-\uffff]/g : /[\\\"\x00-\x1f\x7f-\xff]/g, wa = function (a, b) {
        b.push('"', a.replace(za, function (a) {
            if (a in ya)return ya[a];
            var b = a.charCodeAt(0), e = "\\u";
            16 > b ? e += "000" : 256 > b ? e += "00" : 4096 > b && (e += "0");
            return ya[a] = e + b.toString(16)
        }), '"')
    };
    var Ba = function (a, b) {
        var c = b || new Image;
        c.onload = c.onerror = Aa(c);
        c.src = a
    }, Ca = function (a) {
        for (var b = 0; b < a.length; b++)Ba(a[b])
    }, Aa = function (a) {
        return function () {
            a.onload = a.onerror = null
        }
    };
    var Da = function (a, b) {
        this.rb = Math.ceil(a);
        this.qb = Math.floor(b)
    };
    Da.prototype.R = function () {
        return this.rb + "px - " + this.qb + "px"
    };
    Da.prototype.K = function (a) {
        a = parseInt(a, 10);
        return isNaN(a) ? null : Math.max(this.rb, Math.min(this.qb, a))
    };
    Da.prototype.Q = function (a) {
        return this.K(a)
    };
    var Ea = function (a, b, c, d, e) {
        this.Ph = a;
        this.Qh = b;
        this.Oh = c;
        this.version = d;
        this.Wd = e
    }, Fa = {};
    Ea.prototype.log = function (a, b) {
        var c;
        c = (window.google && window.google.loader && window.google.loader.GoogleApisBase ? window.google.loader.GoogleApisBase : googleApisBase_ ? googleApisBase_ : "//ajax.googleapis.com/ajax") + "/services/js/error";
        var d = {};
        d.mn = this.Ph + "." + this.Qh;
        d.vh = this.Oh;
        d.v = this.version;
        d.em = a.message;
        d.cem = b;
        var e = [], f;
        for (f in d)d.hasOwnProperty(f) && d[f] && e.push([f, encodeURIComponent(d[f])].join("="));
        e = e.join("&");
        d = document.createElement("img");
        c = c + "?" + e;
        Fa[c] ? c = !1 : (d.src = [c, "&nc", (new Date).getTime()].join(""),
            c = Fa[c] = !0);
        return c
    };
    var Ga = function (a, b) {
        var c = l;
        return function () {
            var d = Array.prototype.slice.call(arguments, 0) || [];
            try {
                return a.apply(this, d)
            } catch (e) {
                d = e;
                "string" == (typeof d).toLowerCase() && (d = {message: d});
                var f = d.message;
                b && -1 == f.indexOf(c.Wd) && c.log(d, b);
                throw-1 != f.indexOf(c.Wd) ? f : c.Wd + f;
            }
        }
    }, m = function (a) {
        return"google.ads.search.Ads: " + a
    }, Ha;
    if (window.google && window.google.ads) {
        var Ia = window.google.ads;
        if (Ia && Ia.LoadArgs) {
            var Ja = Ia.LoadArgs.match(/file=([^&]*)/);
            Ha = Ja && Ja[1] ? Ja[1] : ""
        } else Ha = ""
    } else Ha = module_;
    var Ka = Ha, La;
    if (window.google && window.google.ads) {
        var Ma = window.google.ads;
        if (Ma && Ma.LoadArgs) {
            var Na = Ma.LoadArgs.match(/packages=([^&]*)/);
            La = Na && Na[1] ? Na[1] : ""
        } else La = ""
    } else La = packages_;
    var l = new Ea(Ka, La, window.google && window.google.ads ? window.google.ads.JSHash : hash_, window.google && window.google.ads ? window.google.ads.Version : version_, "google.ads.search.Ads: "), q = function (a, b) {
        return b ? Ga(a, b) : Ga(a)
    };
    var Pa = function (a) {
        this.ic = [];
        this.Sd = [];
        a = a.split("#");
        this.Gf = a[0];
        this.Jb = 1 < a.length ? decodeURI(a[1]) : "";
        this.maxLength = 1999
    }, t = function (a, b, c, d) {
        (c || 0 === c || !1 === c) && (d ? a.ic : a.Sd).push([encodeURIComponent(b), encodeURIComponent("" + c)])
    }, Qa = function (a) {
        var b = a.Gf, c = -1 != a.Gf.indexOf("?"), d;
        for (d = 0; d < a.Sd.length; d++) {
            var e = (c ? "&" : "?") + a.Sd[d].join("=");
            e.length + b.length <= a.maxLength && (b += e, c = !0)
        }
        for (d = 0; d < a.ic.length; d++)a.ic[d][0].length + 3 + b.length <= a.maxLength && (b += (c ? "&" : "?") + a.ic[d].join("="), c = !0);
        b = b.substring(0, a.maxLength);
        b = b.replace(/%\w?$/, "");
        a.Jb && (b += "#" + encodeURI(a.Jb));
        return b
    };
    var Ra = /^https?:\/\//, Sa = function (a) {
        return Ra.test(a) ? a : "/" == a.charAt(0) ? "//www.google.com" + a : "//www.google.com/" + a
    }, Ta = /\/aclk\?.*/, Ua = {ads: 0, plas: 1, singleProduct: 2, relatedsearch: 3}, Va = 42 == Math.floor(100 * Math.random()), Wa = {}, Xa = function (a, b) {
        this.Pf = b || (new Date).getTime();
        this.action = a
    };
    Xa.prototype.clone = function (a) {
        return new Xa(a, this.Pf)
    };
    var Ya = function (a, b) {
        u && Va && (Wa[a.action] = Wa[a.action] || [], Wa[a.action].push([b, (new Date).getTime() - a.Pf].join(".")))
    }, Za = function () {
        if (u && Va) {
            var a = Wa;
            Wa = {};
            for (var b in a)if (a.hasOwnProperty(b)) {
                var c = a[b];
                c && 0 < c.length && Ba(["//www.google.com/csi?s=csa&v=3&action=", b, "&rt=", c.join(",")].join(""))
            }
        }
    }, u = null;
    window._googCsa && window._googCsa.t ? u = new Xa("ppla", window._googCsa.t) : window.googleNDT_ && !window.googleLT_ ? u = new Xa("pplnd", window.googleNDT_) : window.googleLT_ && (u = new Xa("pplal", window.googleLT_));
    var $a = {"google-hotels": !0}, ab = window.caps_ && window.caps_.largeFonts, bb = !window.IS_GOOGLE_AFS_IFRAME_ || ab ? 8 : 6, cb = !window.IS_GOOGLE_AFS_IFRAME_ || ab ? 24 : 16, db = new Da(8, cb), gb = function (a, b) {
            var c = a.a.K(b);
            if (null == c && !a.G)throw m(a.key + " has an invalid value. Valid input values: [" + a.a.R() + "].");
            return c
        }, hb = function (a, b) {
            for (var c = 0; c < b.length; c++)a[b[c].key] = b[c]
        }, ib = function (a) {
            var b = 8 == ja(ka), c = ja(pa), d = ja(ra), e = ja(sa);
            return!!(v.K(a.waitForAds) && !b && (null == c || 11 < c) && (null == d || 3 < d) && (null == e || 4 < e))
        },
        jb = function (a) {
            return(a = a.match(/slave-(\d+)-/)) ? parseInt(a[1], 10) + 1 : 1
        }, kb = function (a, b, c) {
            for (var d = [], e = 0, f; f = c[e]; e++)f = new Pa(f), t(f, a, b), d.push(Qa(f));
            return d
        }, lb = function (a) {
            for (var b = [], c = 0; c < a.length; c++) {
                var d = new Pa(a[c]);
                t(d, "nc", [Math.round(9E6 * Math.random()), (new Date).getTime()].join(""));
                b.push(Qa(d))
            }
            return b
        }, mb = function (a) {
            var b = a.pubId;
            return/^pub-.*/.test(b) || "gcsc"in a || b in $a
        };
    var nb = null, w = null, x = function (a) {
        this.Ed = a;
        this.state = {};
        this.Ba = null;
        this.J = !1
    }, x = q(x, "fsI");
    h = x.prototype;
    h.Qd = function (a, b) {
        this.state.hasOwnProperty(a) || (this.state[a] = new ob);
        this.Na(a, b)
    };
    h.Qd = q(x.prototype.Qd, "fsiSS");
    h.Bd = function (a) {
        return this.state[a].value
    };
    h.Bd = q(x.prototype.Bd, "fsiGI");
    h.mb = function (a, b) {
        this.state.hasOwnProperty(a) || (this.state[a] = new y);
        this.Na(a, b)
    };
    h.mb = q(x.prototype.mb, "fsiSI");
    h.$a = function (a, b) {
        this.state.hasOwnProperty(a) || (this.state[a] = new z);
        this.Na(a, b)
    };
    h.$a = q(x.prototype.$a, "fsiSB");
    h.S = function (a, b, c) {
        null == nb && pb();
        if (nb != A || b != ob)this.state.hasOwnProperty(a) || (this.state[a] = new b), b = this.state[a], b.Oa = c || null, b.Oa && null != b.value && b.Oa(this, this.Ed, a, b.value)
    };
    h.S = q(x.prototype.S, "fsiSTC");
    h.Ya = function () {
        return!!(this.Ba && this.Ba.parentNode && this.Ba.contentWindow)
    };
    h.Ya = q(x.prototype.Ya, "fsiHVI");
    h.Na = function (a, b) {
        var c = this.state[a];
        b = c.ja(a, b);
        null != b && c.value != b && (c = this.state[a], c.value = b, this.J = c.J = !0)
    };
    h.Na = q(x.prototype.Na, "fsiS");
    h.ac = function () {
        if (this.J) {
            for (var a in this.state)if (this.state.hasOwnProperty(a)) {
                var b = this.state[a];
                b.J && (b.J = !1, b.Oa && b.Oa(this, this.Ed, a, b.value))
            }
            this.J = !1
        }
    };
    h.ac = q(x.prototype.ac, "fsiNC");
    h.dc = function (a) {
        var b = ["FSXDC"], c;
        for (c in this.state)if (this.state.hasOwnProperty(c)) {
            var d = this.state[c];
            if (a || d.J) {
                var e = d.ia();
                b.push([encodeURIComponent(c), d.Hd, e].join(":"));
                d.J = !1
            }
        }
        this.J = !1;
        return b.join(",")
    };
    h.dc = q(x.prototype.dc, "fsiGCM");
    h.gc = function (a) {
        if (a && a.split && (a = a.split(","), "FSXDC" == a[0])) {
            for (var b = 1; b < a.length; b++) {
                var c = a[b].split(":"), d = decodeURIComponent(c[0]);
                this.state.hasOwnProperty(d) || (this.state[d] = new (qb[parseInt(c[1], 10)]));
                c = this.state[d].ka(c[2]);
                this.Na(d, c)
            }
            this.ac()
        }
    };
    h.gc = q(x.prototype.gc, "fsiECM");
    var rb = function (a, b) {
        l.log({message: a}, b)
    }, rb = q(rb, "fsLE"), z = function () {
        this.Oa = this.value = null;
        this.J = !1
    }, z = q(z, "fsB");
    h = z.prototype;
    h.Hd = 0;
    h.Xb = 1;
    h.ja = function (a, b) {
        return!!b
    };
    h.ja = q(z.prototype.ja, "fsbGVV");
    h.Ma = function () {
        return this.value ? 1 : 0
    };
    h.Ma = q(z.prototype.Ma, "fsbTB");
    h.Za = function (a) {
        return!!a
    };
    h.Za = q(z.prototype.Za, "fsbPFB");
    h.ia = function () {
        return this.value ? "t" : "f"
    };
    h.ia = q(z.prototype.ia, "fsbTES");
    h.ka = function (a) {
        return"t" == a
    };
    h.ka = q(z.prototype.ka, "fsbPES");
    var y = function () {
        this.Oa = this.value = null;
        this.J = !1
    }, y = q(y, "fsSI");
    h = y.prototype;
    h.Hd = 1;
    h.Xb = 14;
    h.Mf = (1 << y.prototype.Xb) - 1;
    h.ja = function (a, b) {
        var c = parseInt(b, 10);
        if (isNaN(c))return rb("Tried to set int value to a non-number ( " + a + " = " + b + ")", "sIGVV"), null;
        c > this.Mf && (rb("Tried to set int value to a number too large ( " + a + " = " + b + ")", "sIGVV"), c = this.Mf);
        0 > c && (rb("Tried to set int value to a number too small ( " + a + " = " + b + ")", "sIGVV"), c = 0);
        return c
    };
    h.ja = q(y.prototype.ja, "fssiGVV");
    h.Ma = function () {
        return this.value || 0
    };
    h.Ma = q(y.prototype.Ma, "fssiTB");
    h.Za = function (a) {
        return a
    };
    h.Za = q(y.prototype.Za, "fssiPFB");
    h.ia = function () {
        return this.value + ""
    };
    h.ia = q(y.prototype.ia, "fssiTES");
    h.ka = function (a) {
        return parseInt(a, 10)
    };
    h.ka = q(y.prototype.ka, "fssiPES");
    var ob = function () {
        this.Oa = this.value = null;
        this.J = !1
    }, ob = q(ob, "fsES");
    h = ob.prototype;
    h.Hd = 2;
    h.ja = function (a, b) {
        return b = b ? b.toString() : ""
    };
    h.ja = q(ob.prototype.ja, "fsesGVV");
    h.ia = function () {
        return this.value ? encodeURIComponent(this.value) : ""
    };
    h.ia = q(ob.prototype.ia, "fsesTES");
    h.ka = function (a) {
        return decodeURIComponent(a)
    };
    h.ka = q(ob.prototype.ka, "fsesPES");
    var qb = [z, y, ob], sb = function (a) {
        null == nb && pb();
        return nb.ma(a)
    }, sb = q(sb, "fsSC"), ub = function (a, b) {
        null == nb && pb();
        null == w && (w = {}, tb());
        a.Ba = b;
        w[a.Ed] = a
    }, ub = q(ub, "fsLFC"), tb = function () {
        window.setInterval(vb, 500);
        nb.la()
    }, tb = q(tb, "fsIL"), vb = function () {
        for (var a in w)if (w.hasOwnProperty(a)) {
            var b = w[a];
            b.Ya() || (b.Ba = null, delete w[a])
        }
    }, vb = q(vb, "fsCDI"), pb = function () {
        B.Zd();
        nb = B.Jd ? B : oa() ? A : C
    }, pb = q(pb, "fsLT"), A = {Cf: "exists", ma: function (a) {
        if (!a.J)return!0;
        for (var b in a.state)if (a.state.hasOwnProperty(b)) {
            var c =
                a.state[b];
            if (c.J && c.Ma) {
                var d = c.Xb, e = c.Ma(), f = b + ":";
                A.$b(f + A.Cf);
                for (var g = 0, k = 1; g < d; g++, k <<= 1) {
                    var n = f + g;
                    e & k ? A.$b(n) : A.Dd(n)
                }
                c.J = !1
            }
        }
        a.J = !1;
        return!0
    }};
    A.ma = q(A.ma, "fsnbtSC");
    A.la = function () {
        window.setInterval(A.T, 50)
    };
    A.la = q(A.la, "fsnbtIL");
    A.T = function () {
        for (var a in w)if (w.hasOwnProperty(a)) {
            var b = w[a];
            if (b.Ya()) {
                var c = b.Ba.contentWindow, d;
                for (d in b.state)b.state.hasOwnProperty(d) && A.Rd(b, d, c);
                b.ac()
            }
        }
    };
    A.T = q(A.T, "fsnbtEC");
    A.Rd = function (a, b, c) {
        var d = A.Od, e = b + ":";
        if (d(c, e + A.Cf)) {
            for (var f = a.state[b], g = f.Xb, k = 0, n = 0, p = 1; n < g; n++, p <<= 1) {
                var r = d(c, e + n);
                if (null === r)return;
                r && (k += p)
            }
            c = f.Za(k);
            a.Na(b, c)
        }
    };
    A.Rd = q(A.Rd, "fsnbtSV");
    A.Od = function (a, b) {
        var c = null;
        try {
            c = b in a
        } catch (d) {
            rb(b, "fsnbtGSB2")
        }
        return c
    };
    A.Od = q(A.Od, "fsnbtGSB");
    A.$b = function (a) {
        if (!document.getElementById(a)) {
            var b = document.createElement("img");
            b.name = a;
            b.id = a;
            b.height = 0;
            b.width = 0;
            document.body.appendChild(b)
        }
    };
    A.$b = q(A.$b, "fsnbtSSB");
    A.Dd = function (a) {
        (a = document.getElementById(a)) && a.parentNode.removeChild(a)
    };
    A.Dd = q(A.Dd, "fsnbtCSB");
    var B = {ma: function (a) {
        if (a.J) {
            if (!B.Jd)return!1;
            B.Jd.postMessage(a.dc(!1), "*")
        }
        return!0
    }};
    B.ma = q(B.ma, "fspmtSC");
    B.la = function () {
        window.attachEvent ? window.attachEvent("onmessage", B.T) : window.addEventListener && window.addEventListener("message", B.T, !1)
    };
    B.la = q(B.la, "fspmtIL");
    B.T = function (a) {
        if (a = a ? a : window.event)for (var b in w)if (w.hasOwnProperty(b)) {
            var c = w[b];
            if (c.Ya() && a.source == c.Ba.contentWindow) {
                c.gc(a.data);
                break
            }
        }
    };
    B.T = q(B.T, "fspmtEC");
    B.Zd = function () {
        var a = window.parent;
        try {
            var b = a.postMessage ? a : a.document.postMessage ? a.document : null;
            b && b.postMessage && (B.Jd = b)
        } catch (c) {
        }
    };
    B.Zd = q(B.Zd, "fspmtLPM");
    var C = {ma: function (a) {
        if (a.J) {
            if (!window.relay)return!1;
            C.Pd(window.relay, a.dc(!0))
        }
        return!0
    }};
    C.ma = q(C.ma, "fsnitSC");
    C.la = function () {
        window.setInterval(C.T, 5)
    };
    C.la = q(C.la, "fsnitIL");
    C.T = function () {
        for (var a in w)if (w.hasOwnProperty(a)) {
            var b = w[a], c = C.Yd(b);
            c && b.gc(c)
        }
    };
    C.T = q(C.T, "fsnitEC");
    C.Yd = function (a) {
        try {
            if (a.Ya()) {
                var b = a.Ba.contentWindow;
                if (b.frames && b.frames.length && 0 < b.frames.length && b.frames[b.frames.length - 1].name)return b.frames[b.frames.length - 1].name
            }
        } catch (c) {
        }
        return null
    };
    C.Yd = q(C.Yd, "fsnitGM");
    C.Pd = function (a, b) {
        var c = document.createElement("iframe");
        c.style.position = "absolute";
        c.style.top = "0";
        c.style.left = "0";
        c.style.display = "none";
        c.width = "0";
        c.height = "0";
        c.src = a + "crossdomain.xml";
        c.name = b;
        c.onload = function () {
            C.de(this, 100)
        };
        document.body.appendChild(c)
    };
    C.Pd = q(C.Pd, "fsnitCRI");
    C.de = function (a, b) {
        window.setTimeout(function () {
            a.parentNode.removeChild(a)
        }, b)
    };
    C.de = q(C.de, "fsnitDMI");
    if (window.IS_GOOGLE_AFS_IFRAME_)var wb = function (a) {
        return function (b, c) {
            return"undefined" == typeof a[b] ? c || null : a[b]
        }
    }, xb = function (a) {
        return function (b, c) {
            if (a.hasOwnProperty(b)) {
                for (var d = a[b].split(","), e = 0; e < d.length; e++)if (d[e] == c)return!0;
                return!1
            }
            return!0
        }
    }, yb = function (a, b) {
        var c = {ba: !1, ub: null, tb: null}, d = b ? "verticalSpacing" : "horizontalSpacing";
        a[d] && (d = a[d], d = b && !a.isPla ? Math.min(d, 12) : d, d /= 2, c.ba = !0, c.ub = Math.floor(d), c.tb = Math.ceil(d));
        return c
    }, zb = function (a, b) {
        return b && (b.clickBg || b.mclickBg) &&
            a.clickableBackgrounds && (!b.isHighendMobile || b.mclickBg) ? !0 : !1
    }, Ab = function (a) {
        return 6 == ja(ka) ? !0 : "_blank" == (a.linkTarget ? a.linkTarget : "_top")
    }, Bb = function (a, b) {
        return!0 == (!0 === a.heightConstrained && !!b && !!b.mayLimitHeight)
    };
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var Cb = 1, E = function () {
            return"e" + Cb++
        }, Db = function (a) {
            this.ha = a
        };
        Db.prototype.o = function () {
            return this.ha
        };
        var F = new Db("")
    }
    ;
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var Fb = function (a, b) {
            this.F = E();
            this.sf = a;
            this.B = b || Eb
        };
        Fb.prototype.o = function () {
            for (var a = [], b = 0; b < this.sf.length; b++)a.push(this.sf[b].o());
            return this.B({uid: this.F, Ka: a})
        };
        var Eb = function (a) {
            return a.Ka.join("")
        }
    }
    ;
    var Gb = function (a) {
        if (Error.captureStackTrace)Error.captureStackTrace(this, Gb); else {
            var b = Error().stack;
            b && (this.stack = b)
        }
        a && (this.message = String(a))
    };
    ga(Gb, Error);
    Gb.prototype.name = "CustomError";
    var Hb;
    var Jb = function (a, b) {
        for (var c = a.split("%s"), d = "", e = Array.prototype.slice.call(arguments, 1); e.length && 1 < c.length;)d += c.shift() + e.shift();
        return d + c.join("%s")
    }, Kb = function (a) {
        return a.replace(/^[\s\xa0]+|[\s\xa0]+$/g, "")
    }, Sb = function (a) {
        if (!Lb.test(a))return a;
        -1 != a.indexOf("&") && (a = a.replace(Mb, "&amp;"));
        -1 != a.indexOf("<") && (a = a.replace(Nb, "&lt;"));
        -1 != a.indexOf(">") && (a = a.replace(Ob, "&gt;"));
        -1 != a.indexOf('"') && (a = a.replace(Pb, "&quot;"));
        -1 != a.indexOf("'") && (a = a.replace(Qb, "&#39;"));
        -1 != a.indexOf("\x00") &&
        (a = a.replace(Rb, "&#0;"));
        return a
    }, Mb = /&/g, Nb = /</g, Ob = />/g, Pb = /"/g, Qb = /'/g, Rb = /\x00/g, Lb = /[\x00&<>"']/, Ub = function (a) {
        var b = {"&amp;": "&", "&lt;": "<", "&gt;": ">", "&quot;": '"'}, c;
        c = aa.document.createElement("div");
        return a.replace(Tb, function (a, e) {
            var f = b[a];
            if (f)return f;
            if ("#" == e.charAt(0)) {
                var g = Number("0" + e.substr(1));
                isNaN(g) || (f = String.fromCharCode(g))
            }
            f || (c.innerHTML = a + " ", f = c.firstChild.nodeValue.slice(0, -1));
            return b[a] = f
        })
    }, Vb = function (a) {
        return a.replace(/&([^;]+);/g, function (a, c) {
            switch (c) {
                case "amp":
                    return"&";
                case "lt":
                    return"<";
                case "gt":
                    return">";
                case "quot":
                    return'"';
                default:
                    if ("#" == c.charAt(0)) {
                        var d = Number("0" + c.substr(1));
                        if (!isNaN(d))return String.fromCharCode(d)
                    }
                    return a
            }
        })
    }, Tb = /&([^;\s<&]+);?/g, Wb = function () {
        return Math.floor(2147483648 * Math.random()).toString(36) + Math.abs(Math.floor(2147483648 * Math.random()) ^ fa()).toString(36)
    }, Xb = function (a, b) {
        return a < b ? -1 : a > b ? 1 : 0
    };
    var Yb = function (a, b) {
        b.unshift(a);
        Gb.call(this, Jb.apply(null, b));
        b.shift()
    };
    ga(Yb, Gb);
    Yb.prototype.name = "AssertionError";
    var Zb = function (a, b, c, d) {
        var e = "Assertion failed";
        if (c)var e = e + (": " + c), f = d; else a && (e += ": " + a, f = b);
        throw new Yb("" + e, f || []);
    }, $b = function (a, b, c) {
        a || Zb("", null, b, Array.prototype.slice.call(arguments, 2))
    }, ac = function (a, b) {
        throw new Yb("Failure" + (a ? ": " + a : ""), Array.prototype.slice.call(arguments, 1));
    }, bc = function (a, b, c) {
        var d = typeof a;
        "object" == d && null != a || "function" == d || Zb("Expected object but got %s: %s.", [ba(a), a], b, Array.prototype.slice.call(arguments, 2))
    };
    var cc = Array.prototype, dc = cc.filter ? function (a, b, c) {
        $b(null != a.length);
        return cc.filter.call(a, b, c)
    } : function (a, b, c) {
        for (var d = a.length, e = [], f = 0, g = da(a) ? a.split("") : a, k = 0; k < d; k++)if (k in g) {
            var n = g[k];
            b.call(c, n, k, a) && (e[f++] = n)
        }
        return e
    };
    var ec = function () {
        return null
    }, fc = function (a) {
        var b = arguments, c = b.length;
        return function () {
            for (var a, e = 0; e < c; e++)a = b[e].apply(this, arguments);
            return a
        }
    };
    var gc = function (a, b) {
        this.x = void 0 !== a ? a : 0;
        this.y = void 0 !== b ? b : 0
    };
    h = gc.prototype;
    h.clone = function () {
        return new gc(this.x, this.y)
    };
    h.toString = function () {
        return"(" + this.x + ", " + this.y + ")"
    };
    h.ceil = function () {
        this.x = Math.ceil(this.x);
        this.y = Math.ceil(this.y);
        return this
    };
    h.floor = function () {
        this.x = Math.floor(this.x);
        this.y = Math.floor(this.y);
        return this
    };
    h.round = function () {
        this.x = Math.round(this.x);
        this.y = Math.round(this.y);
        return this
    };
    var H = function (a, b) {
        this.width = a;
        this.height = b
    };
    h = H.prototype;
    h.clone = function () {
        return new H(this.width, this.height)
    };
    h.toString = function () {
        return"(" + this.width + " x " + this.height + ")"
    };
    h.ceil = function () {
        this.width = Math.ceil(this.width);
        this.height = Math.ceil(this.height);
        return this
    };
    h.floor = function () {
        this.width = Math.floor(this.width);
        this.height = Math.floor(this.height);
        return this
    };
    h.round = function () {
        this.width = Math.round(this.width);
        this.height = Math.round(this.height);
        return this
    };
    var hc = function (a) {
        var b = arguments.length;
        if (1 == b && "array" == ba(arguments[0]))return hc.apply(null, arguments[0]);
        for (var c = {}, d = 0; d < b; d++)c[arguments[d]] = !0;
        return c
    };
    var I;
    i:{
        var ic = aa.navigator;
        if (ic) {
            var jc = ic.userAgent;
            if (jc) {
                I = jc;
                break i
            }
        }
        I = ""
    }
    ;
    var kc = -1 != I.indexOf("Opera") || -1 != I.indexOf("OPR"), J = -1 != I.indexOf("Trident") || -1 != I.indexOf("MSIE"), lc = -1 != I.indexOf("Gecko") && -1 == I.toLowerCase().indexOf("webkit") && !(-1 != I.indexOf("Trident") || -1 != I.indexOf("MSIE")), mc = -1 != I.toLowerCase().indexOf("webkit"), nc = function () {
        var a = aa.document;
        return a ? a.documentMode : void 0
    }, oc = function () {
        var a = "", b;
        if (kc && aa.opera)return a = aa.opera.version, "function" == ba(a) ? a() : a;
        lc ? b = /rv\:([^\);]+)(\)|;)/ : J ? b = /\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/ : mc && (b = /WebKit\/(\S+)/);
        b && (a = (a = b.exec(I)) ? a[1] : "");
        return J && (b = nc(), b > parseFloat(a)) ? String(b) : a
    }(), pc = {}, K = function (a) {
        var b;
        if (!(b = pc[a])) {
            b = 0;
            for (var c = Kb(String(oc)).split("."), d = Kb(String(a)).split("."), e = Math.max(c.length, d.length), f = 0; 0 == b && f < e; f++) {
                var g = c[f] || "", k = d[f] || "", n = RegExp("(\\d*)(\\D*)", "g"), p = RegExp("(\\d*)(\\D*)", "g");
                do {
                    var r = n.exec(g) || ["", "", ""], s = p.exec(k) || ["", "", ""];
                    if (0 == r[0].length && 0 == s[0].length)break;
                    b = Xb(0 == r[1].length ? 0 : parseInt(r[1], 10), 0 == s[1].length ? 0 : parseInt(s[1], 10)) || Xb(0 == r[2].length,
                            0 == s[2].length) || Xb(r[2], s[2])
                } while (0 == b)
            }
            b = pc[a] = 0 <= b
        }
        return b
    }, qc = aa.document, rc = qc && J ? nc() || ("CSS1Compat" == qc.compatMode ? parseInt(oc, 10) : 5) : void 0;
    !lc && !J || J && J && 9 <= rc || lc && K("1.9.1");
    J && K("9");
    var uc = function (a) {
        return a ? new sc(tc(a)) : Hb || (Hb = new sc)
    }, tc = function (a) {
        $b(a, "Node cannot be null or undefined.");
        return 9 == a.nodeType ? a : a.ownerDocument || a.document
    }, sc = function (a) {
        this.sb = a || aa.document || document
    };
    sc.prototype.Bf = function (a) {
        return da(a) ? this.sb.getElementById(a) : a
    };
    sc.prototype.createElement = function (a) {
        return this.sb.createElement(a)
    };
    var vc = function (a, b) {
        var c;
        var d = a.sb;
        c = d.createElement("div");
        J ? (c.innerHTML = "<br>" + b, c.removeChild(c.firstChild)) : c.innerHTML = b;
        if (1 == c.childNodes.length)c = c.removeChild(c.firstChild); else {
            for (d = d.createDocumentFragment(); c.firstChild;)d.appendChild(c.firstChild);
            c = d
        }
        return c
    };
    sc.prototype.appendChild = function (a, b) {
        a.appendChild(b)
    };
    J && K(8);
    hc("area base br col command embed hr img input keygen link meta param source track wbr".split(" "));
    var wc = /<[^>]*>|&[^;]+;/g, xc = function (a, b) {
        return b ? a.replace(wc, "") : a
    }, yc = RegExp("[A-Za-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02b8\u0300-\u0590\u0800-\u1fff\u200e\u2c00-\ufb1c\ufe00-\ufe6f\ufefd-\uffff]"), zc = RegExp("^[^A-Za-z\u00c0-\u00d6\u00d8-\u00f6\u00f8-\u02b8\u0300-\u0590\u0800-\u1fff\u200e\u2c00-\ufb1c\ufe00-\ufe6f\ufefd-\uffff]*[\u0591-\u07ff\u200f\ufb1d-\ufdff\ufe70-\ufefc]"), Ac = /^http:\/\/.*/, Bc = /\s+/, Cc = /\d/;
    var Ec = function () {
        this.Hf = "";
        this.Mh = Dc;
        this.Nh = null
    };
    Ec.prototype.toString = function () {
        return"SafeHtml{" + this.Hf + "}"
    };
    hc("action", "cite", "data", "formaction", "href", "manifest", "poster", "src");
    hc("link", "script", "style");
    var Dc = {};
    var Fc = {gi: !0}, Gc = {hi: !0}, Hc = function () {
        throw Error("Do not instantiate directly");
    };
    Hc.prototype.ce = null;
    Hc.prototype.toString = function () {
        return this.content
    };
    var Ic = function (a) {
        if (null != a)switch (a.ce) {
            case 1:
                return 1;
            case -1:
                return-1;
            case 0:
                return 0
        }
        return null
    }, Jc = function () {
        Hc.call(this)
    };
    ga(Jc, Hc);
    Jc.prototype.cc = Fc;
    var L = function (a) {
        if (null != a && a.cc === Fc)return $b(a.constructor === Jc), a;
        if (a instanceof Ec) {
            var b = Kc, c;
            a instanceof Ec && a.constructor === Ec && a.Mh === Dc ? c = a.Hf : (ac("expected object of type SafeHtml, got '" + a + "'"), c = "type_error:SafeHtml");
            a = b(c, a.Nh)
        } else a = Kc(Sb(String(String(a))), Ic(a));
        return a
    }, Lc = function () {
        Hc.call(this)
    };
    ga(Lc, Hc);
    Lc.prototype.cc = {fi: !0};
    var Mc = function (a) {
        function b() {
        }

        b.prototype = a.prototype;
        return function (a, d) {
            var e = new b;
            e.content = String(a);
            void 0 !== d && (e.ce = d);
            return e
        }
    }, Kc = Mc(Jc);
    Mc(Lc);
    var Nc = function (a, b) {
        function c() {
        }

        c.prototype = a;
        var d = new c, e;
        for (e in b)d[e] = b[e];
        return d
    };
    (function (a) {
        function b() {
        }

        b.prototype = a.prototype;
        return function (a, d) {
            if (!String(a))return"";
            var e = new b;
            e.content = String(a);
            void 0 !== d && (e.ce = d);
            return e
        }
    })(Jc);
    var Oc = function (a) {
        var b = Ic(a);
        if (null == b) {
            var c = b = 0, d = !1;
            a = xc(a + "", null != a && a.cc === Fc).split(Bc);
            for (var e = 0; e < a.length; e++) {
                var f = a[e];
                zc.test(xc(f, void 0)) ? (b++, c++) : Ac.test(f) ? d = !0 : yc.test(xc(f, void 0)) ? c++ : Cc.test(f) && (d = !0)
            }
            b = 0 == c ? d ? 1 : 0 : .4 < b / c ? -1 : 1
        }
        return b
    };
    var M = function (a) {
        return'target="' + (a.k ? "_blank" : "_top") + '"'
    };
    var Qc = function (a) {
        return"" + Pc({text: a.text.c, Ta: a.text.rtl, f: a.f})
    }, Rc = function (a) {
        return"" + Pc({text: a.text, Ta: 0 > Oc(a.text), f: a.f})
    }, Sc = function (a) {
        var b = "";
        if (a.hb && a.hb.c)var c = a.Lb.rtl || a.hb.rtl, b = b + Pc({Ta: c, f: a.f, text: Qc({text: a.Lb, f: c}) + " " + Qc({text: a.hb, f: c})}); else b += Qc({text: a.Lb, f: a.f});
        return b
    }, Pc = function (a) {
        return'<span dir="' + (a.Ta ? "rtl" : "ltr") + '">' + a.text + "</span>" + (a.f ? "&rlm;" : "&lrm;")
    };
    var Tc = function (a) {
        var b = "";
        if (a.dd && 0 < a.dd.length) {
            for (var b = b + "<div class='apareviews'>", c = a.dd, d = c.length, e = 0; e < d; e++)var f = c[e], f = {text: f.t, source: f.s, tf: f.su, f: a.f}, f = "" + (f.text ? "<div class='apareview'>" + Rc(f) + "&nbsp;-&nbsp;" + (f.tf ? '<a href="' + L(f.tf) + '" class="reviewlink"' + M({k: !0}) + ">" + Rc({text: f.source, f: f.f}) + "</a>" : Rc({text: f.source, f: f.f})) + "</div>" : ""), b = b + f;
            b += "</div>"
        }
        return b
    };
    Tc.D = "csa.soy.apa_reviews.block";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var Uc = function (a, b, c) {
            this.F = E();
            this.Vg = a;
            this.H = b;
            this.B = c || Tc
        };
        Uc.prototype.o = function () {
            return this.B({uid: this.F, dd: this.Vg, f: this.H})
        };
        var Vc = function (a, b) {
            return a.ar && 0 < a.ar.length ? new Uc(a.ar, b.f) : F
        }
    }
    ;
    var Wc = function (a) {
        var b = "";
        if (a.Ka) {
            for (var b = b + ('<div class="buttonsWrapper" id="' + a.uid + '">'), c = a.Ka, d = c.length, e = 0; e < d; e++)b += '<div style="width: ' + Math.floor(1 / a.Ka.length * 100) + '%;" class="inlineButton' + (0 == e ? " firstButton" : "") + '">' + c[e] + "</div>";
            b += "</div>"
        }
        return b
    };
    Wc.D = "csa.soy.button.row";
    var Xc = function (a) {
        return'<div class="button" id="' + a.uid + '"><div class="buttonImageWrapper"><a href="' + a.url + '" ' + M(a) + '><img class="buttonImage" src="' + a.Fb + '" width="28" height="28"></a></div><div class="buttonTextWrapper"><a href="' + a.url + '" class="buttonText" ' + M(a) + ">" + a.text + "</a></div></div>"
    };
    Xc.D = "csa.soy.button.single";
    var Yc = function (a) {
        var b = a.Ue ? "right" : "left";
        return a = "" + ('<div style="overflow: hidden;"><div style="float: ' + b + "; width: " + (a.Ib + "px") + ';">' + a.Dc + '</div><div style="margin-' + b + ": " + (a.Ib + a.Fc + "px") + ';">' + a.Ec + "</div></div>")
    };
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var Zc = function (a, b, c, d, e) {
            this.F = E();
            this.W = a;
            this.zc = b;
            this.ha = c;
            this.L = d;
            this.B = e || Xc
        };
        Zc.prototype.o = function () {
            return this.B({uid: this.F, url: this.W, Fb: this.zc, text: this.ha, k: this.L})
        };
        var $c = function (a, b) {
            var c = [];
            a.ctc && c.push(new Zc(a.ctc.u, "//www.google.com/images/afs/mobile/button_ctc.png", a.ctc.bt, b.k, void 0));
            !(1 <= c.length) || a.ctc && a.ctc.coa || c.push(new Zc(a.u, "//www.google.com/images/afs/mobile/button_visit_site.png", b.eh, b.k, void 0));
            return c
        }
    }
    ;
    var ad = function (a) {
        return"" + (a.Hc ? "<div class='location'>" + Rc({text: a.Hc, f: a.f}) + "</div>" : "")
    };
    ad.D = "csa.soy.location.location";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var bd = function (a, b, c) {
            this.F = E();
            this.ha = a;
            this.H = b;
            this.B = c || ad
        };
        bd.prototype.o = function () {
            return this.B({uid: this.F, Hc: this.ha, f: this.H})
        };
        var cd = function (a, b) {
            return a.location ? new bd(a.location, b.f) : F
        }
    }
    ;
    var dd = function (a) {
        var b = "";
        if (a.Ka && 0 < a.Ka.length) {
            b += '<table class="ohTbl"><tbody><tr>';
            a = a.Ka;
            for (var c = a.length, d = 0; d < c; d++)b += '<td class="ohTd">' + a[d] + "</td>";
            b += "</tr></tbody></table>"
        }
        return b
    };
    dd.D = "csa.soy.offerHighlight.row";
    var ed = function (a) {
        return'<div class="ohWrapper"><div class="ohImg" style="background-position: ' + -15 * a.Oe + 'px 0px; width: 15px; height: 13px;"></div><span class="ohTxt">' + a.text + "</span></div>"
    };
    ed.D = "csa.soy.offerHighlight.single";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var fd = function (a, b, c) {
            this.F = E();
            this.ha = a;
            this.Fh = b;
            this.B = c || ed
        };
        fd.prototype.o = function () {
            return this.B({uid: this.F, text: this.ha, Oe: this.Fh})
        };
        var gd = function (a) {
            var b = [];
            if (a.oh)for (var c = 0; c < a.oh.length; ++c)b.push(new fd(a.oh[c].t, a.oh[c].p));
            return 0 < b.length ? new Fb(b, dd) : F
        }
    }
    ;
    var id = function (a) {
        var b = "";
        if (a.Gc) {
            for (var b = b + "<div class='plus-ones'>", c = a.Gc, d = c.length, e = 0; e < d; e++)var f = c[e], b = b + ("TARGET" == f ? M(a) : f);
            b += "</div>"
        }
        return b
    };
    id.D = "csa.soy.social.plusOnes";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var jd = function (a, b, c, d) {
            this.F = E();
            this.Fg = a;
            this.L = b;
            this.H = c;
            this.B = d || id
        };
        jd.prototype.o = function () {
            return this.B({uid: this.F, Gc: this.Fg, k: this.L, f: this.H})
        };
        var kd = function (a, b) {
            return a.plus_ones ? new jd(a.plus_ones, b.k, b.f) : F
        }
    }
    ;
    var ld = function (a) {
        for (var b = '<div class="sr-div">', c = a.Ce, d = c.length, e = 0; e < d; e++)var f = c[e], f = "RATING" == f ? '<div class="sr-nsc"><img src="//www.google.com/images/sr-star-off.png" class="sr-star"/><img src="//www.google.com/images/sr-star-on' + (a.Ze ? "-gray" : "") + '.png" class="sr-star" style="clip: rect(0px, ' + 13.2 * a.Be + 'px, 13px, 0px);"/></div>' + (a.jg ? "<br>" : '<span class="sr-p">&nbsp;</span>') : "LINK_START" == f ? '<a href="' + a.De + '" class="sr-rl' + (a.Ze ? " sr-gl" : "") + '"' + M(a) + ">" : "LINK_END" == f ? "</a>" : "NUM_START" ==
            f ? '<span class="sr-number">' : "NUM_END" == f ? "</span>&nbsp;" : Rc({text: f, f: a.f}), b = b + f;
        return b + "</div>"
    };
    ld.D = "csa.soy.sellerRating.render";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var md = function (a, b, c, d, e, f) {
            this.F = E();
            this.ha = a;
            this.L = b;
            this.wg = c;
            this.W = d;
            this.H = e;
            this.B = f || ld
        };
        md.prototype.o = function () {
            return this.B({uid: this.F, Ce: this.ha, k: this.L, Be: this.wg, De: this.W, f: this.H})
        };
        var nd = function (a, b) {
            return a.sr && a.sr.nt && a.sr.r && a.sr.u ? new md(a.sr.nt, b.k, a.sr.r, a.sr.u, b.f) : F
        }
    }
    ;
    var pd = function (a) {
        var b = "";
        if (a.bd && 0 < a.bd.length) {
            for (var b = b + '<table class="sl-table" cellspacing="0" cellpadding="0"><tbody><tr><td>', c = a.bd, d = c.length, e = 0; e < d; e++)b += od({position: "left", Tb: c[e], k: a.k, f: a.f});
            b += "</td><td>";
            c = a.Cg;
            d = c.length;
            for (e = 0; e < d; e++)b += od({position: "right", Tb: c[e], k: a.k, f: a.f});
            b += "</td></tr></tbody></table>";
            if (a.Mc && a.Ra && 0 < a.Ra.length) {
                b += '<div class="sl-column">';
                c = a.Ra;
                d = c.length;
                for (e = 0; e < d; e++)b += od({position: "left", Tb: c[e], k: a.k, f: a.f});
                b += "</div>"
            }
        }
        return b
    };
    pd.D = "csa.soy.sitelinks.sitelinks";
    var od = function (a) {
        return"<div class='sl-" + a.position + "'><a href=\"" + a.Tb.u + '" class="sl" ' + M(a) + ">" + Rc({text: a.Tb.t, f: a.f}) + "</a></div>"
    }, qd = function (a) {
        for (var b = '<ul class="sitelinks">', c = a.Ra, d = c.length, e = 0; e < d; e++)var f = c[e], b = b + ('<li class="' + (2 == a.df ? "twoColSitelink " : "") + a.ad + '"><div class="sitelink-spacer"><div class="sitelink-nowrap" style="direction: ' + (0 > Oc(f.t) ? "rtl" : "ltr") + ';"><a href="' + f.u + '" class="' + a.ad + '" ' + M(a) + ">" + f.t + "</a></div></div></li>");
        return b + "</ul>"
    };
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var rd = function (a, b, c, d, e) {
            this.F = E();
            this.Ob = a;
            this.L = b;
            this.Eg = c;
            this.H = d;
            this.B = e || pd
        };
        rd.prototype.o = function () {
            for (var a = [], b = [], c = 0; c < this.Ob.length; c++)0 == c % 2 ? a.push(this.Ob[c]) : b.push(this.Ob[c]);
            return this.B({uid: this.F, Ra: this.Ob, bd: a, Cg: b, k: this.L, Mc: this.Eg, f: this.H})
        };
        var sd = function (a, b) {
            return a.sls && 0 < a.sls.length ? new rd(a.sls, b.k, b.Mc, b.f) : F
        }
    }
    ;
    var td = function (a) {
        return"<span class='individualLabel " + (a.N ? L(a.N) : "") + "'>" + L(a.text) + "</span>"
    };
    td.D = "csa.soy.attribution.individualAdAttribution";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var ud = function (a, b) {
            this.Jh = a;
            this.B = b || td
        };
        ud.prototype.o = function () {
            return this.B({text: this.Jh, N: null})
        }
    }
    ;
    var vd = function (a) {
        return'<img class="adIcon" src="' + L(a.Z) + '"/>'
    };
    vd.D = "csa.soy.icon.imgIcon";
    var wd = function (a) {
        return'<iframe class="adIcon" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" allowTransparency="true" sandbox="" src="' + L(a.Z) + '"></iframe>'
    };
    wd.D = "csa.soy.icon.iframeIcon";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var xd = function (a, b) {
            this.Kh = a;
            this.B = b
        };
        xd.prototype.o = function () {
            return this.B({Z: this.Kh})
        }
    }
    ;
    var yd = function (a) {
        return'<a id="' + L(a.uid) + '" href="' + L(a.url) + '" class="titleLink"' + M(a) + ">" + Qc(a) + "</a>"
    };
    yd.D = "csa.soy.textAd.title";
    var zd = function (a) {
        return'<div class="ctcT"><img src="//www.google.com/images/mobile_ad/phone_icon-lb32.png" class="ctcCOI" /><a id="' + L(a.uid) + '" href="' + L(a.url) + '"' + M(a) + ">" + Pc({text: a.vg, Ta: !1, f: a.f}) + "</a>" + (a.bf ? '<span class="ctcLD"> (' + Rc({text: a.bf, f: a.f}) + ")</span>" : "") + '</div><span class="ctcCO">' + Qc(a) + "</span>"
    };
    zd.D = "csa.soy.textAd.clickToCallTitle";
    var Ad = function (a) {
        return'<a id="' + L(a.uid) + '" href="' + L(a.url) + '" class="domainLink"' + M(a) + ">" + Pc({text: a.text, Ta: !1, f: a.f}) + "</a>"
    };
    Ad.D = "csa.soy.textAd.visUrl";
    var Bd = function (a) {
        return'<span class="descText">' + Sc({Lb: a.Xe, hb: a.Ye, f: a.f}) + "</span>"
    };
    Bd.D = "csa.soy.textAd.description";
    var Cd = function (a) {
        return'<a id="' + L(a.uid) + '" href="' + L(a.url) + '" class="textLink"' + M(a) + ">" + Bd(a) + "</a>"
    };
    Cd.D = "csa.soy.textAd.clickableDescription";
    var Dd = function (a) {
        return"<div>" + a.rd + "</div>" + a.sd + "<br />" + a.th
    };
    Dd.D = "csa.soy.textAd.threeLine";
    var Ed = function (a) {
        return"<div>" + a.rd + "</div>" + a.sd
    };
    Ed.D = "csa.soy.textAd.twoLine";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var Fd = function (a, b, c, d, e, f, g) {
            this.aa = a;
            this.Xa = b;
            this.Da = c;
            this.yf = d;
            this.od = e;
            this.kb = f;
            this.pd = g || Dd
        };
        Fd.prototype.o = function () {
            var a = this.kb.o() + this.Da.o();
            return this.pd({rd: this.aa.o() + this.od.o(), sd: this.yf ? a : this.Xa.o(), th: this.yf ? this.Xa.o() : a})
        };
        var Gd = function (a, b, c, d, e, f) {
            this.aa = a;
            this.Xa = b;
            this.Da = c;
            this.od = d;
            this.kb = e;
            this.pd = f || Ed
        };
        Gd.prototype.o = function () {
            var a = this.aa.o() + this.od.o(), b = this.kb.o() + this.Da.o() + this.Xa.o();
            return this.pd({rd: a, sd: b})
        };
        var Hd = function (a, b, c, d) {
            this.aa = a;
            this.Xa = b;
            this.Da = c;
            this.kb = d
        };
        Hd.prototype.o = function () {
            return this.kb.o() + this.aa.o() + this.Xa.o() + this.Da.o()
        };
        var Id = function (a, b, c, d, e, f) {
            this.F = E();
            this.Pc = a;
            this.W = b;
            this.L = c;
            this.Oc = d;
            this.H = e;
            this.B = f || yd
        };
        Id.prototype.o = function () {
            return this.B({uid: this.F, text: {c: this.Pc, rtl: this.Oc}, url: this.W, k: this.L, f: this.H})
        };
        var Jd = function (a, b, c, d, e, f, g, k) {
            this.F = E();
            this.Pc = a;
            this.W = b;
            this.L = c;
            this.Oc = d;
            this.H = e;
            this.Ag = f;
            this.zg = g || "";
            this.B = k || zd
        };
        Jd.prototype.o =
            function () {
                return this.B({uid: this.F, text: {c: this.Pc, rtl: this.Oc}, vg: this.Ag, bf: this.zg, url: this.W, k: this.L, f: this.H})
            };
        var Kd = function (a, b, c, d, e) {
            this.F = E();
            this.Da = a;
            this.W = b;
            this.L = c;
            this.H = d;
            this.B = e || Ad
        };
        Kd.prototype.o = function () {
            return this.B({uid: this.F, text: this.Da, url: this.W, k: this.L, f: this.H})
        };
        var Ld = function (a, b, c, d, e) {
            this.Rc = a;
            this.Sc = b;
            this.Qc = c;
            this.H = d;
            this.B = e || Bd
        };
        Ld.prototype.o = function () {
            return this.B({Xe: {c: this.Rc, rtl: this.Qc}, Ye: {c: this.Sc}, f: this.H})
        };
        var Md = function (a, b, c, d, e, f, g) {
            this.F = E();
            this.Rc = a;
            this.Sc = b;
            this.Qc = c;
            this.H = d;
            this.W = e;
            this.L = f;
            this.B = g || Cd
        };
        Md.prototype.o = function () {
            return this.B({Xe: {c: this.Rc, rtl: this.Qc}, Ye: {c: this.Sc}, f: this.H, uid: this.F, url: this.W, k: this.L})
        };
        var Nd = function (a, b, c, d, e, f, g, k, n) {
            this.We = a;
            this.na = b;
            this.hg = c;
            this.ig = d;
            this.Mc = e;
            this.Nc = f;
            this.eh = g;
            this.f = k;
            this.k = n
        }
    }
    ;
    var Od = {aliceblue: "#f0f8ff", antiquewhite: "#faebd7", aqua: "#00ffff", aquamarine: "#7fffd4", azure: "#f0ffff", beige: "#f5f5dc", bisque: "#ffe4c4", black: "#000000", blanchedalmond: "#ffebcd", blue: "#0000ff", blueviolet: "#8a2be2", brown: "#a52a2a", burlywood: "#deb887", cadetblue: "#5f9ea0", chartreuse: "#7fff00", chocolate: "#d2691e", coral: "#ff7f50", cornflowerblue: "#6495ed", cornsilk: "#fff8dc", crimson: "#dc143c", cyan: "#00ffff", darkblue: "#00008b", darkcyan: "#008b8b", darkgoldenrod: "#b8860b", darkgray: "#a9a9a9", darkgreen: "#006400",
        darkgrey: "#a9a9a9", darkkhaki: "#bdb76b", darkmagenta: "#8b008b", darkolivegreen: "#556b2f", darkorange: "#ff8c00", darkorchid: "#9932cc", darkred: "#8b0000", darksalmon: "#e9967a", darkseagreen: "#8fbc8f", darkslateblue: "#483d8b", darkslategray: "#2f4f4f", darkslategrey: "#2f4f4f", darkturquoise: "#00ced1", darkviolet: "#9400d3", deeppink: "#ff1493", deepskyblue: "#00bfff", dimgray: "#696969", dimgrey: "#696969", dodgerblue: "#1e90ff", firebrick: "#b22222", floralwhite: "#fffaf0", forestgreen: "#228b22", fuchsia: "#ff00ff", gainsboro: "#dcdcdc",
        ghostwhite: "#f8f8ff", gold: "#ffd700", goldenrod: "#daa520", gray: "#808080", green: "#008000", greenyellow: "#adff2f", grey: "#808080", honeydew: "#f0fff0", hotpink: "#ff69b4", indianred: "#cd5c5c", indigo: "#4b0082", ivory: "#fffff0", khaki: "#f0e68c", lavender: "#e6e6fa", lavenderblush: "#fff0f5", lawngreen: "#7cfc00", lemonchiffon: "#fffacd", lightblue: "#add8e6", lightcoral: "#f08080", lightcyan: "#e0ffff", lightgoldenrodyellow: "#fafad2", lightgray: "#d3d3d3", lightgreen: "#90ee90", lightgrey: "#d3d3d3", lightpink: "#ffb6c1", lightsalmon: "#ffa07a",
        lightseagreen: "#20b2aa", lightskyblue: "#87cefa", lightslategray: "#778899", lightslategrey: "#778899", lightsteelblue: "#b0c4de", lightyellow: "#ffffe0", lime: "#00ff00", limegreen: "#32cd32", linen: "#faf0e6", magenta: "#ff00ff", maroon: "#800000", mediumaquamarine: "#66cdaa", mediumblue: "#0000cd", mediumorchid: "#ba55d3", mediumpurple: "#9370db", mediumseagreen: "#3cb371", mediumslateblue: "#7b68ee", mediumspringgreen: "#00fa9a", mediumturquoise: "#48d1cc", mediumvioletred: "#c71585", midnightblue: "#191970", mintcream: "#f5fffa", mistyrose: "#ffe4e1",
        moccasin: "#ffe4b5", navajowhite: "#ffdead", navy: "#000080", oldlace: "#fdf5e6", olive: "#808000", olivedrab: "#6b8e23", orange: "#ffa500", orangered: "#ff4500", orchid: "#da70d6", palegoldenrod: "#eee8aa", palegreen: "#98fb98", paleturquoise: "#afeeee", palevioletred: "#db7093", papayawhip: "#ffefd5", peachpuff: "#ffdab9", peru: "#cd853f", pink: "#ffc0cb", plum: "#dda0dd", powderblue: "#b0e0e6", purple: "#800080", red: "#ff0000", rosybrown: "#bc8f8f", royalblue: "#4169e1", saddlebrown: "#8b4513", salmon: "#fa8072", sandybrown: "#f4a460", seagreen: "#2e8b57",
        seashell: "#fff5ee", sienna: "#a0522d", silver: "#c0c0c0", skyblue: "#87ceeb", slateblue: "#6a5acd", slategray: "#708090", slategrey: "#708090", snow: "#fffafa", springgreen: "#00ff7f", steelblue: "#4682b4", tan: "#d2b48c", teal: "#008080", thistle: "#d8bfd8", tomato: "#ff6347", turquoise: "#40e0d0", violet: "#ee82ee", wheat: "#f5deb3", white: "#ffffff", whitesmoke: "#f5f5f5", yellow: "#ffff00", yellowgreen: "#9acd32"};
    var Td = function (a) {
        var b = {};
        a = String(a);
        var c = "#" == a.charAt(0) ? a : "#" + a;
        if (Pd.test(c))return b.be = Qd(c), b.type = "hex", b;
        i:{
            var d = a.match(Rd);
            if (d) {
                var c = Number(d[1]), e = Number(d[2]), d = Number(d[3]);
                if (0 <= c && 255 >= c && 0 <= e && 255 >= e && 0 <= d && 255 >= d) {
                    c = [c, e, d];
                    break i
                }
            }
            c = []
        }
        if (c.length)return b.be = Sd(c[0], c[1], c[2]), b.type = "rgb", b;
        if (Od && (c = Od[a.toLowerCase()]))return b.be = c, b.type = "named", b;
        throw Error(a + " is not a valid color string");
    }, Ud = /#(.)(.)(.)/, Qd = function (a) {
        if (!Pd.test(a))throw Error("'" + a + "' is not a valid hex color");
        4 == a.length && (a = a.replace(Ud, "#$1$1$2$2$3$3"));
        return a.toLowerCase()
    }, Sd = function (a, b, c) {
        a = Number(a);
        b = Number(b);
        c = Number(c);
        if (isNaN(a) || 0 > a || 255 < a || isNaN(b) || 0 > b || 255 < b || isNaN(c) || 0 > c || 255 < c)throw Error('"(' + a + "," + b + "," + c + '") is not a valid RGB color');
        a = Vd(a.toString(16));
        b = Vd(b.toString(16));
        c = Vd(c.toString(16));
        return"#" + a + b + c
    }, Pd = /^#(?:[0-9a-f]{3}){1,2}$/i, Rd = /^(?:rgb)?\((0|[1-9]\d{0,2}),\s?(0|[1-9]\d{0,2}),\s?(0|[1-9]\d{0,2})\)$/i, Vd = function (a) {
        return 1 == a.length ? "0" + a : a
    }, Yd = function (a, b) {
        for (var c =
            [], d = 0; d < b.length; d++)c.push({color: b[d], Nf: Wd(b[d], a) + Xd(b[d], a)});
        c.sort(function (a, b) {
            return b.Nf - a.Nf
        });
        return c[0].color
    }, Wd = function (a, b) {
        return Math.abs(Math.round((299 * a[0] + 587 * a[1] + 114 * a[2]) / 1E3) - Math.round((299 * b[0] + 587 * b[1] + 114 * b[2]) / 1E3))
    }, Xd = function (a, b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]) + Math.abs(a[2] - b[2])
    };
    var Zd = function (a) {
        this.Kf = a
    };
    Zd.prototype.R = function () {
        var a = "A CSS color";
        this.Kf && (a += " including 'transparent'");
        return a
    };
    Zd.prototype.K = function (a) {
        if (this.Kf && da(a) && "transparent" == a.toLowerCase())return"transparent";
        try {
            return Td("" + a).be
        } catch (b) {
            return null
        }
    };
    Zd.prototype.Q = ec;
    var N = new Zd(!1), $d = new Zd(!0);
    var ae = function (a) {
        var b = "";
        a = a.uh;
        for (var c = a.length, d = 0; d < c; d++)b += '<div class="ad' + (0 == d ? " f" : "") + (d == c - 1 ? " l" : "") + ' adUnit_js">' + a[d] + "</div>";
        return b
    };
    ae.D = "csa.soy.ads.singleColumn";
    var be = function (a) {
        return"" + (a.A.adIconUrl && "ad-left" == a.A.adIconLocation && a.A.img ? (a.Mb ? '<a href="' + a.A.u + '" ' + M(a) + ">" : "") + '<img class="adIcon" src="' + a.A.adIconUrl + '"/>' + (a.Mb ? "</a>" : "") : "")
    }, ce = function (a) {
        return"" + (a.A.adIconUrl && "ad-left" == a.A.adIconLocation && !a.A.img ? '<iframe class="adIcon" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" allowTransparency="true" sandbox="" src="' + a.A.adIconUrl + '"></iframe>' : "")
    };
    var de = function (a) {
        return"" + (a.Id ? '<span class="' + (a.N ? L(a.N) : "") + '" id="attribution">' + (a.ec ? '<a href="' + L(a.ec) + '" target="_blank">' : "") + L(a.Id) + (a.ec ? "</a>" : "") + "</span>" : "")
    }, ee = function (a) {
        var b;
        a.pb ? (b = '<span class="' + (a.N ? L(a.N) : "") + '" id="' + L(a.id) + '">', a = a.pb, null != a && a.cc === Gc && (ac("Tainted SanitizedContentKind.TEXT for |noAutoescape: `%s`", [a.content]), a = "zSoyz"), b = b + a + "</span>") : b = "";
        return"" + b
    };
    var fe = function (a, b) {
        return(new RegExp("(\\s|^)" + b + "(\\s|$)")).test(a.className)
    }, ge = function (a, b) {
        var c = a.className, d = new RegExp("(\\s|^)" + b + "(\\s|$)", "g"), c = c.replace(new RegExp("\\s" + b + "\\s", "g"), " ");
        a.className = c.replace(d, "")
    }, O = function (a, b) {
        a.className ? fe(a, b) || (a.className += " " + b) : a.className = b
    }, P = function (a, b, c) {
        var d = [];
        if ("getElementsByClassName"in document) {
            a = a.getElementsByClassName(c);
            for (var e = 0, f; f = a[e]; e++)f.nodeName && f.nodeName.toLowerCase() == b && d.push(f)
        } else for (a = a.getElementsByTagName(b),
                        e = 0; f = a[e]; e++)fe(f, c) && d.push(f);
        return d
    }, he = function (a, b) {
        var c = a.getElementById(b);
        if (!c)throw"Could not find element with id: " + b;
        return c
    }, ie = function (a, b) {
        for (; a.parentNode;)if (a = a.parentNode, a.id == b)return!0;
        return!1
    };
    var Q = function (a, b, c) {
        if (a.addEventListener)a.addEventListener(b, c, !1); else if (a.attachEvent)a.attachEvent("on" + b, c); else {
            var d = a["on" + b];
            a["on" + b] = null != d ? fc(c, d) : c
        }
    }, je = function (a, b) {
        Q(a, "mousedown", b);
        Q(a, "mousedown", function (a, b, e) {
            var f = !1;
            return function () {
                f || (a.removeEventListener ? a.removeEventListener(b, e, !1) : a.detachEvent && a.detachEvent("on" + b, e), f = !0)
            }
        }(a, "mousedown", b))
    };
    var ke = null, le = function () {
        if (null != ke)return ke;
        var a = document.createElement("div");
        a.style.width = "1px";
        a.style.height = "1px";
        a.style.border = "1px solid black";
        a.style.padding = "1px";
        a.style.visibility = "hidden";
        document.body.appendChild(a);
        var b = a.offsetWidth;
        document.body.removeChild(a);
        return ke = 5 == b
    };

    function me(a) {
        return parseFloat(a.replace("px", "")) || 0
    }

    function R(a, b) {
        "string" == typeof a && (a = document.getElementById(a));
        var c = document.defaultView || {}, d = b ? a.offsetHeight : a.offsetWidth, e = b ? ["Top", "Bottom"] : ["Right", "Left"], f;
        f = le() ? ["margin"] : ["border", "margin", "padding"];
        var g = f.length, k = e.length;
        if (c && c.getComputedStyle)for (var n = c.getComputedStyle(a, !1), c = 0; c < g; c++)for (var p = 0; p < k; p++)d += me(n.getPropertyValue([f[c], e[p].toLowerCase()].join("-"))); else {
            n = a.currentStyle;
            if (!le())for (p = 0; p < k; p++)d += me(n[["border", e[p], "Width"].join("")]);
            for (c = 0; c < g; c++)if ("border" !=
                f[c])for (p = 0; p < k; p++)d += me(n[[f[c], e[p]].join("")])
        }
        return d
    }

    var ne = function (a) {
        return a.replace(/<[^>^<]*>/g, "")
    }, oe = function (a) {
        var b = a.offsetWidth;
        if (!le())return b;
        var c = document.defaultView || {};
        c && c.getComputedStyle ? (a = c.getComputedStyle(a, !1), b -= me(a.getPropertyValue("padding-left")) + me(a.getPropertyValue("padding-right"))) : (a = a.currentStyle, b -= me(a.paddingLeft) + me(a.paddingRight));
        return b
    };
    if (window.IS_GOOGLE_AFS_IFRAME_)var pe = /^https?:\/\/afs.googleusercontent.com\//, re = function (a, b, c, d, e) {
        if (!e || pe.test(b))for (var f = 0; f < a.length; f++)a[f].adIconUrl = d ? b + qe(encodeURIComponent(a[f].v)) : b, a[f].adIconLocation = c, a[f].img = e
    }, re = q(re, "aiIID"), qe = function (a) {
        for (var b = [], c = 0; c < a.length; c += 3) {
            var d = [a.charCodeAt(c), a.charCodeAt(c + 1), a.charCodeAt(c + 2)];
            b.push("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".charAt(d[0] >> 2));
            b.push("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".charAt((d[0] &
                3) << 4 | d[1] >> 4));
            b.push("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".charAt(isNaN(d[1]) ? 64 : (d[1] & 15) << 2 | d[2] >> 6));
            b.push("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".charAt(isNaN(d[2]) ? 64 : d[2] & 63))
        }
        return b.join("")
    }, qe = q(qe, "aiBE");
    var se = function (a) {
        var b;
        i:{
            b = tc(a);
            if (b.defaultView && b.defaultView.getComputedStyle && (b = b.defaultView.getComputedStyle(a, null))) {
                b = b.position || b.getPropertyValue("position") || "";
                break i
            }
            b = ""
        }
        return b || (a.currentStyle ? a.currentStyle.position : null) || a.style && a.style.position
    }, te = function (a) {
        if (J && !(J && 8 <= rc))return a.offsetParent;
        var b = tc(a), c = se(a), d = "fixed" == c || "absolute" == c;
        for (a = a.parentNode; a && a != b; a = a.parentNode)if (c = se(a), d = d && "static" == c && a != b.documentElement && a != b.body, !d && (a.scrollWidth >
            a.clientWidth || a.scrollHeight > a.clientHeight || "fixed" == c || "absolute" == c || "relative" == c))return a;
        return null
    };
    var ue = /([?|&]{1}nm=)([\d]{1,})/, ve = /(\?|&)clkt=-?[\d]*/g, we = /[&\?]nb=\d/, xe = /(\?|&)nx=-?[\d]+/g, ye = /(\?|&)ny=-?[\d]+/g, Ae = function (a) {
            return function () {
                for (var b = 0; b < a.length; b++) {
                    var c = a[b], d = c.element.href, e = d.match(ue);
                    e ? 3 == e.length && (d = d.replace(ue, e[1] + (parseInt(e[2], 10) + 1))) : d += (-1 == d.indexOf("?") ? "?" : "&") + "nm=1";
                    ze(c, d)
                }
            }
        }, Be = function (a) {
            return function () {
                if (a.Ud) {
                    var b = "&clkt=" + ((new Date).getTime() - a.Ud), c = a.element.href, c = c.replace(ve, "");
                    ze(a, c + b)
                }
            }
        }, Ce = function (a) {
            return function (b) {
                a.Ud =
                    (new Date).getTime();
                var c = a.element, d, e = tc(c), f = se(c);
                bc(c, "Parameter is required");
                var g = lc && e.getBoxObjectFor && !c.getBoundingClientRect && "absolute" == f && (d = e.getBoxObjectFor(c)) && (0 > d.screenX || 0 > d.screenY), k = new gc(0, 0), n;
                d = e ? tc(e) : document;
                (n = !J || J && 9 <= rc) || (n = "CSS1Compat" == uc(d).sb.compatMode);
                n = n ? d.documentElement : d.body;
                if (c != n)if (c.getBoundingClientRect) {
                    t:{
                        var p;
                        try {
                            p = c.getBoundingClientRect()
                        } catch (r) {
                            d = {left: 0, top: 0, right: 0, bottom: 0};
                            break t
                        }
                        J && c.ownerDocument.body && (d = c.ownerDocument, p.left -=
                            d.documentElement.clientLeft + d.body.clientLeft, p.top -= d.documentElement.clientTop + d.body.clientTop);
                        d = p
                    }
                    c = uc(e).sb;
                    e = mc || "CSS1Compat" != c.compatMode ? c.body || c.documentElement : c.documentElement;
                    c = c.parentWindow || c.defaultView;
                    e = J && K("10") && c.pageYOffset != e.scrollTop ? new gc(e.scrollLeft, e.scrollTop) : new gc(c.pageXOffset || e.scrollLeft, c.pageYOffset || e.scrollTop);
                    k.x = d.left + e.x;
                    k.y = d.top + e.y
                } else if (e.getBoxObjectFor && !g)d = e.getBoxObjectFor(c), e = e.getBoxObjectFor(n), k.x = d.screenX - e.screenX, k.y = d.screenY -
                    e.screenY; else {
                    d = c;
                    do {
                        k.x += d.offsetLeft;
                        k.y += d.offsetTop;
                        d != c && (k.x += d.clientLeft || 0, k.y += d.clientTop || 0);
                        if (mc && "fixed" == se(d)) {
                            k.x += e.body.scrollLeft;
                            k.y += e.body.scrollTop;
                            break
                        }
                        d = d.offsetParent
                    } while (d && d != c);
                    if (kc || mc && "absolute" == f)k.y -= e.body.offsetTop;
                    for (d = c; (d = te(d)) && d != e.body && d != n;)k.x -= d.scrollLeft, kc && "TR" == d.tagName || (k.y -= d.scrollTop)
                }
                d = b.clientY;
                b = Math.round(b.clientX - k.x);
                k = Math.round(d - k.y);
                d = a.element.href;
                d = d.replace(xe, "");
                d = d.replace(ye, "");
                d = d + ("&nx=" + b) + ("&ny=" + k);
                ze(a, d)
            }
        },
        De = function (a, b, c) {
            return-1 == a.indexOf(b) && 1950 > a.length + b.length && (a += b + encodeURIComponent(c), 1950 < a.length) ? a.substring(0, 1950) : a
        }, Ee = function (a, b) {
            je(a.element, function () {
                var c, d;
                try {
                    c = R(b, !0), d = R(b, !1)
                } catch (e) {
                }
                if (c && d) {
                    var f = a.element.href, f = De(f, "&is=", [d, c].join("x"));
                    ze(a, f)
                }
            })
        }, Fe = function (a, b) {
            this.Rh = b;
            this.element = a;
            this.Ud = null
        }, ze = function (a, b) {
            var c = a.element;
            if (!(2E3 < b.length)) {
                for (var d = [], e = c.innerHTML, f = c.firstChild; f; f = f.nextSibling)d.push(f.cloneNode(!0));
                c.href = b;
                if (J && c.innerHTML !=
                    e)for (c.innerHTML = "", e = 0; e < d.length; e++)c.appendChild(d[e])
            }
        };
    if (window.IS_GOOGLE_AFS_IFRAME_)var Ie = function (a, b, c, d) {
        if ((a = Ge(a, d)) && 0 < a.length)if (d.adClicktracking) {
            c = kb("block", "" + c, a);
            d = P(b, "div", "adC");
            d = d.concat(P(b, "tr", "adC"));
            b = 0;
            for (var e; e = d[b]; b++)a = c, a = kb("ad", "" + (b + 1), a), He(e, a)
        } else He(b, a)
    }, Ge = function (a, b) {
        return b && b.clicktracking && a.clicktrackUrl && 0 < a.clicktrackUrl.length ? a.clicktrackUrl : null
    }, He = function (a, b) {
        for (var c = a.getElementsByTagName("a"), d = 0; d < c.length; d++) {
            var e = c[d];
            Ta.test(e.href) && ("ontouchstart"in document.documentElement ?
                (Q(e, "touchstart", Je), Q(e, "touchmove", Ke), Q(e, "touchend", function () {
                    Le && Ca(lb(b));
                    Le = !1
                })) : Q(e, "mousedown", function (a) {
                var c = !1;
                (c = a.which ? 2 > a.which : 2 > a.button) && Ca(lb(b))
            }))
        }
    }, Me, Ne, Le = !1, Je = function (a) {
        Le = !1;
        a = a.touches;
        1 == a.length && (a = a[0], Me = a.clientX, Ne = a.clientY, Le = !0)
    }, Ke = function (a) {
        a = a.touches[0];
        if (10 < Math.abs(a.clientX - Me) || 10 < Math.abs(a.clientY - Ne))Le = !1
    };
    if (window.IS_GOOGLE_AFS_IFRAME_)var Oe = function (a) {
        var b = [];
        a = P(a, "div", "adC");
        for (var c = 0, d; d = a[c]; c++) {
            d = P(d, "div", "adStd");
            for (var e = 0, f; f = d[e]; e++)b.push(f)
        }
        return b
    }, Oe = q(Oe, "fCE"), Qe = function (a, b, c) {
        var d = a.getAttribute("data-click-s"), e = a.getAttribute("data-click-trg");
        d && e && Q(a, "click", Pe(d, e, c && 0 < c.length ? lb(kb("ad", "" + (b + 1), c)) : null))
    }, Qe = q(Qe, "aCB"), Re = function (a, b, c) {
        b && 0 < b.length && (b = kb("block", "" + c, b));
        a = Oe(a);
        c = 0;
        for (var d; d = a[c]; c++)Qe(d, c, b)
    }, Re = q(Re, "cbACB"), Pe = function (a, b, c) {
        return function (d) {
            d &&
            (d = d.target || d.srcElement) && (3 == d.nodeType && (d = d.parentNode), Se(d) || (c && Ca(c), a += "&nb=2", "_blank" == b ? window.open(a) : window.top.location.href = a))
        }
    }, Pe = q(Pe, "cbBCH"), Se = function (a) {
        for (; a && !fe(a, "adStd");) {
            if ("a" == a.nodeName.toLowerCase())return!0;
            a = a.parentNode
        }
        return!1
    }, Se = q(Se, "cbLTOCH");
    if (window.IS_GOOGLE_AFS_IFRAME_)var Te = function (a) {
        if (a = P(a.document, "div", "raiDiv"))for (var b = 0, c; c = a[b]; b++) {
            var d = P(c, "img", "raiImg");
            c = Math.floor(c.offsetWidth / 180);
            for (var e = 0, f; f = d[e]; e++)e < c && fe(f, "invisible") ? ge(f, "invisible") : e >= c && !fe(f, "invisible") && O(f, "invisible")
        }
    }, Te = q(Te, "aIF");
    var Ue = function (a) {
        return'<div class="button" id="' + a.sh + '">' + a.rh + '<div class="wrapper hidden" id="' + a.qh + '"><div class="triangle outer"><div class="bubbleWrapper"><div class="bubblePadder">' + a.nh + '</div></div><div class="triangle inner"> </div></div></div></div>'
    };
    Ue.D = "csa.soy.bubble.bubble";
    var Ve = function (a) {
        return".button {position: relative; display: inline-block;}.bubbleWrapper {position: absolute; -moz-box-shadow: 0 4px 16px rgba(0, 0, 0, 0.2); -webkit-box-shadow: 0 4px 16px rgba(0, 0, 0, 0.2); box-shadow: 0 4px 16px rgba(0, 0, 0, 0.2); width: " + L(a.Rb) + "px; bottom: " + L(a.X ? a.Df : 9) + "px; right: " + L(a.X ? 8 : a.Df) + "px; background: white;}.bubblePadder {border: 1px solid #CCCCCC; padding: 10px; word-wrap: break-word;}.wrapper {position: absolute; cursor: default;}.wrapper.hidden {visibility: hidden;}.triangle {width: 0; border-style: solid; border-" +
            L(a.X ? "left" : "top") + "-color: #CCCCCC; border-" + L(a.X ? "top" : "left") + "-color: transparent; border-right-color: transparent; border-bottom-color: transparent;}.triangle.outer {border-width: 10px; border-" + L(a.X ? "right" : "bottom") + "-width: 0; position: absolute; bottom: " + L(a.X ? 17 : 41) + "px; left: " + L(a.X ? -5 : 2) + "px;}.triangle.inner {border-width: 9px; border-" + L(a.X ? "right" : "bottom") + "-width: 0; border-" + L(a.X ? "left" : "top") + "-color: white; position: absolute; margin-" + L(a.X ? "left" : "top") + ": -10px; margin-" +
            L(a.X ? "top" : "left") + ": -9px;}"
    };
    Ve.D = "csa.soy.bubble.style";
    var We = function (a) {
        We[" "](a);
        return a
    };
    We[" "] = function () {
    };
    J && K("9");
    !mc || K("528");
    lc && K("1.9b") || J && K("8") || kc && K("9.5") || mc && K("528");
    lc && !K("8") || J && K("9");
    var Xe = function (a, b, c, d, e, f, g) {
        this.ld = E();
        this.Ub = E();
        this.fh = a;
        this.kd = b;
        this.Ch = c;
        this.Ah = d;
        this.Bh = e;
        this.B = f || Ue;
        this.Jc = g || Ve
    };
    Xe.prototype.o = function () {
        return this.B({sh: this.ld, qh: this.Ub, rh: this.fh.o(), nh: this.kd.o()})
    };
    Xe.prototype.cd = function () {
        return this.Jc({Rb: this.Ch, Df: this.Ah, X: this.Bh})
    };
    var Ye = function (a, b) {
        return function (c) {
            ie(c.target || c.srcElement, a.Ub) || (c = b.getElementById(a.Ub)) && (fe(c, "hidden") ? ge(c, "hidden") : O(c, "hidden"))
        }
    }, Ze = function (a, b) {
        return function (c) {
            ie(c.target || c.srcElement, a.ld) || (c = b.getElementById(a.Ub)) && O(c, "hidden")
        }
    };
    Xe.prototype.Kd = function (a) {
        var b = a.getElementById(this.ld);
        b && (Q(b, "click", Ye(this, a)), Q(a.body, "click", Ze(this, a)))
    };
    Xe.prototype.lb = function (a) {
        return this.kd.lb(a)
    };
    Xe.prototype.ob = function (a) {
        this.kd.ob(a)
    };
    var $e = function (a) {
        return'<div style="font-size: 14px;"><div><a href="' + L(a.sa) + '" style="color: #281ab3; text-decoration: none" id="' + L(a.Hb) + '" ' + M(a) + ">" + L(a.title) + '</a></div><div id="' + L(a.Tg) + '"><div style="color: #222222; font-weight: bold;">' + L(a.Gb) + '</div><div style="color: #777777; font-size: 13px;">' + (a.kf ? "<div>" + L(a.kf) + "</div>" : "") + (a.lf ? "<div>" + L(a.lf) + "</div>" : "") + (a.jf ? "<div>" + L(a.jf) + "</div>" : "") + "</div></div></div>"
    };
    $e.D = "csa.soy.pla.bubble.textContent";
    var af = function () {
        return'<div style="width: 30px; height: 42px;"><div style="cursor: pointer; width: 15px; padding-left: 5px;"><div style="width: 5px; padding-left: 5px; padding-top: 7px;"><div style="height: 5px; background: gray; margin-bottom: 2px; border-radius: 50%;"> </div><div style="height: 5px; background: gray; margin-bottom: 2px; border-radius: 50%;"> </div><div style="height: 5px; background: gray; border-radius: 50%;"> </div></div></div></div>'
    };
    af.D = "csa.soy.pla.bubble.buttonContent";
    var bf = function (a, b, c, d, e, f, g, k, n) {
        this.Ac = a;
        this.aa = b;
        this.Cc = c;
        this.Kc = d;
        this.Lc = e;
        this.Sg = f;
        this.Bc = g;
        this.Eh = k;
        this.B = n || $e;
        this.Ca = E();
        this.hf = E()
    };
    bf.prototype.o = function () {
        return this.B({sa: this.Ac, title: this.aa, Hb: this.Ca, Gb: this.Cc, kf: this.Kc, lf: this.Lc, jf: this.Sg, k: this.Bc, Tg: this.hf})
    };
    bf.prototype.lb = function (a) {
        return[new Fe(he(a, this.Ca), "&nb=0")]
    };
    bf.prototype.ob = function (a) {
        var b = a.document.getElementById(this.hf);
        b && cf(a.document.getElementById(this.Ca), this.Eh - b.offsetHeight)
    };
    var df = function (a) {
        this.B = a || af
    };
    df.prototype.o = function () {
        return this.B()
    };
    var ef = function (a, b, c, d, e, f, g) {
        a = new bf(d, a.t, a.pr, a.s, a.ppu, a.er, e, c);
        return new Xe(new df, a, b, f, g)
    };
    var cf = function (a, b) {
        if (a && 1 == a.childNodes.length && a.childNodes[0] && a.childNodes[0].nodeValue && "string" == typeof a.childNodes[0].nodeValue && 0 < b) {
            for (var c = a.innerHTML, d = c.length; 0 < d && a.offsetHeight > b; d--) {
                var e = c, f = d, e = -1 != e.indexOf("&") ? "document"in aa ? Ub(e) : Vb(e) : e;
                e.length > f && (e = e.substring(0, f - 3) + "...");
                e = Sb(e);
                a.innerHTML = e
            }
            a.offsetHeight > b && (a.innerHTML = "")
        } else l.log({message: "Input to truncateToHeight was invalid."}, "cdMtt")
    };
    var ff = function (a) {
        return'<a href="' + a.href + '" target="' + (a.k ? "_blank" : "_top") + '"' + (a.Ja ? 'id="' + a.Ja + '"' : "") + " " + (a.Ia ? 'class="' + a.Ia + '"' : "") + ">" + a.content + "</a>"
    };
    if (window.IS_GOOGLE_AFS_IFRAME_)var gf = function (a, b, c) {
        var d, e;
        e = a.ctc && a.ctc.coa ? new Jd(a.tr.c, a.ctc.u, c.k, a.tr.rtl, c.f, a.ctc.ph, a.ctc.d) : new Id(a.tr.c, a.u, c.k, a.tr.rtl, c.f);
        var f = new Kd(a.v, a.u, c.k, c.f), g;
        d = a.l1r && a.l1r.c ? a.l1r.c : "";
        g = a.l2r && a.l2r.c ? a.l2r.c : "";
        var k = a.l1r && a.l1r.rtl ? a.l1r.rtl : !1;
        g = c.hg && !c.na ? new Md(d, g, k, c.f, a.u, c.k) : new Ld(d, g, k, c.f);
        k = a.adIconUrl && "title-right" == a.adIconLocation ? new xd(a.adIconUrl, a.img ? vd : wd) : F;
        d = a.u;
        switch (c.We) {
            case 1:
                e = new Hd(e, g, f, c.Nc);
                break;
            case 2:
                e = new Gd(e,
                    g, f, k, c.Nc);
                break;
            default:
                e = new Fd(e, g, f, c.ig, k, c.Nc)
        }
        e = e.o();
        f = $c(a, c);
        1 == f.length && (f = f[0].o(), g = c.f, e = "" + ('<table style="border-collapse: collapse; border-spacing: 0; width: 100%; table-layout: fixed;"><tr><td style="vertical-align: middle; padding-' + (g ? "left" : "right") + ': 12px;">' + e + '</td><td style="width: 78px; vertical-align: middle;' + ("border-" + (g ? "right" : "left") + ": 1px solid #DDDDDD") + '">' + f + "</td></tr></table>"));
        f = c.na;
        g = c.k;
        k = "";
        switch (c.We) {
            case 1:
                k += "oneLine";
                break;
            case 2:
                k += "twoLine";
                break;
            case 3:
                k += "threeLine"
        }
        d = "" + ('<div class="adStd ' + k + '"' + (f ? 'data-click-s="' + d + '"' + ('data-click-trg="' + (g ? "_blank" : "_top") + '"') : "") + ">" + e + "</div>");
        if (b.isHighendMobile) {
            b = Vc(a, c);
            e = sd(a, c);
            f = nd(a, c);
            g = kd(a, c);
            var k = cd(a, c), n = gd(a), p;
            p = $c(a, c);
            p = 1 < p.length ? new Fb(p, Wc) : F;
            b = [b, e, f, g, k, n, p]
        } else b = [Vc(a, c), kd(a, c), cd(a, c), sd(a, c), nd(a, c), gd(a)];
        b = (new Fb(b)).o();
        a = {A: a, k: c.k, xg: d, yg: b, na: c.na, Ua: null, Bg: null, cf: null};
        c = "";
        if (a.A.rais && 0 < a.A.rais.length) {
            c += '<div class="nowrap">';
            b = a.A.rais;
            d = b.length;
            for (e = 0; e < d; e++)f = b[e], c += '<a href="' + a.A.u + '" ' + M(a) + '><img class="raiImg" width="' + f.w + '" height="' + f.h + '" src="' + f.u + '"></a>';
            c += "</div>"
        }
        return(a.cf ? "" : ce(a)) + '<div class="adC' + (a.Ua ? " nesBorder" : "") + (a.A.rais && 0 < a.A.rais.length ? " raiDiv" : "") + '">' + (a.cf ? "" : be({A: a.A, Mb: a.na, k: a.k})) + '<div class="adD' + (a.Ua ? " nesAdD" : "") + '">' + c + (a.Bg ? '<a href="' + a.A.u + '" class="thumbicon" style="background-image:url(\'' + a.A.kodachrome.u + "');\"" + M(a) + "></a>" : "") + a.xg + a.yg + "</div>" + (a.Ua ? '<div class="aicon"><a href="' +
            a.A.u + '" class="nArr" ' + M(a) + ">" + ("arrowbox" == a.Ua ? '<img class="aiconi" src="http://pagead2.googlesyndication.com/pagead/images/mobile_unified_button_icon_black.png"/>' : "chevroncircle" == a.Ua ? '<img class="aiconi" src="http://pagead2.googlesyndication.com/pagead/images/nessie_icon_chevron_white.png"/>' : "chevronbox" == a.Ua ? '<img class="aiconi" src="http://pagead2.googlesyndication.com/pagead/images/nessie_icon_tiamat_white.png"/>' : "") + "</a></div>" : "") + "</div>" + ("" + (a.A.adIconUrl && "ad-left" == a.A.adIconLocation && !a.A.img ? '<div style="clear: both;"></div>' : ""))
    }, kf = function (a, b, c, d, e, f) {
        var g = wb(d), k = xb(d), n = g("type") || "ads", p = g("colorDomainLink", a.sellerFirstBoxLeft ? "#4272db" : a.linkColorSchemeVisUrlLinkColor || "#008000"), r = g("colorTitleLink", a.sellerFirstBoxLeft ? "#4272db" : a.linkColorSchemeTitleLinkColor || "#0000CC"), s = d.width, s = s && "auto" != s ? s : "100%", D = yb(d, !0), la = yb(d, !1), eb = g("spacingPlaImageText"), G = g("spacingPlaTextPrice"), T;
        T = (T = g("colorAdSeparator")) ? T : a.isHighendMobile || a.isTablet ? "#E6E6E6" : null;
        var ma =
            g("colorAdBackground"), qa = g("colorAdBorder"), fb = g("colorText"), hd = g("colorBackground"), Oa = g("colorBorder"), qi = g("colorAttribution"), ri = g("colorPlusOnes"), si = g("colorPlaImageBorder"), ti = g("colorPrice"), ui = g("colorKeyword"), vi = g("colorLocation"), wi = g("colorAnnotation"), na;
        na = [
            [0, 0, 0],
            [255, 255, 255]
        ];
        if (p) {
            var Ib;
            Ib = Qd(p);
            na = Yd([parseInt(Ib.substr(1, 2), 16), parseInt(Ib.substr(3, 2), 16), parseInt(Ib.substr(5, 2), 16)], na);
            na = Sd(na[0], na[1], na[2])
        } else na = null;
        a = {j: a, Zf: e, Wf: s, U: D, wc: la, xe: eb, ye: G, ca: T, me: ma,
            Y: qa, oa: fb, Bb: r, xb: p, ne: hd, da: Oa, wb: qi, Ab: ri, zb: si, pe: ti, Yf: ui, yb: vi, I: wi, Xf: na, fontFamily: g("fontFamily"), vc: g("fontFamilyAttribution"), ra: g("fontSizeTitle"), qa: g("fontSizeDescription"), ea: g("fontSizeDomainLink"), Pa: g("fontSizeAttribution"), Db: g("fontSizePlusOnes"), cb: g("fontSizePrice"), Cb: g("fontSizeLocation"), M: g("fontSizeAnnotation"), bg: g("titleBold"), cg: f, $f: g("rolloverLinkBold"), we: g("rolloverLinkColor"), ve: g("rolloverLinkBackgroundColor"), ag: g("rolloverLinkUnderline"), ue: g("rolloverAdBackgroundColor"),
            te: g("noTitleUnderline"), ze: hf(a), Rf: k("adBorderSelections", "left"), he: k("adBorderSelections", "right"), Sf: k("adBorderSelections", "top"), Qf: k("adBorderSelections", "bottom"), Uf: k("borderSelections", "left"), le: k("borderSelections", "right"), Vf: k("borderSelections", "top"), Tf: k("borderSelections", "bottom"), na: zb(d, a), se: g("lineHeightTitle"), yc: g("lineHeightDescription"), re: g("lineHeightDomainLink"), ke: g("attributionSpacingBelow")};
        g("adIconUrl") ? (a.vb = g("adIconWidth"), a.nc = g("adIconHeight"), a.oc = g("adIconLocation"),
            a.qc = g("adIconSpacingAbove"), a.sc = g("adIconSpacingBefore"), a.rc = g("adIconSpacingAfter"), a.je = g("adIconSpacingBelow"), a.uc = !0) : g("adIconPageUrl") && (a.vb = g("adIconPageWidth"), a.nc = g("adIconPageHeight"), a.oc = g("adIconPageLocation"), a.qc = g("adIconPageSpacingAbove"), a.sc = g("adIconPageSpacingBefore"), a.rc = g("adIconPageSpacingAfter"), a.uc = !1);
        "relatedsearch" == n && (a.type = "relatedsearch", a.qe = g("columnSpacing"), a.xc = g("horizontalFlow"), a.Eb = g("horizontalAlignment"));
        n = a.j.isRtl ? "right" : "left";
        d = a.j.isRtl ?
            "left" : "right";
        f = (e = a.j.isRtl) ? "right" : "left";
        g = "";
        n = '<style type="text/css">body {' + (a.j.isHighendMobile ? "-webkit-text-size-adjust: 100%;" : "") + "color: " + (a.oa ? a.oa : "black") + "; font-family: " + (a.dg ? "'" + a.dg + "'," : "") + (a.fontFamily ? a.fontFamily : "arial") + ", sans-serif; font-size: " + (a.j.isHighendMobile || a.j.isTablet ? "14" : "12") + "px; width: " + a.Wf + "; padding: 0px; margin: 0px;" + (a.da && (a.le || a.he) ? "padding-right: 2px;" : "") + "}.ad {padding: 2px 0; margin: 0px; word-wrap: break-word;" + (a.U.ba ? "padding-top: " +
            a.U.ub + "px; padding-bottom: " + a.U.tb + "px;" : a.j.isHighendMobile || a.j.isTablet ? "padding-top: 7px;" : "") + (a.ca ? "border-bottom: 1px solid " + a.ca + ";" : "") + "}" + (a.ue ? ".adC:hover {background-color: " + a.ue + ";}" : "") + ".ad.f {" + (a.U.ba ? "padding-top:2px;" : "") + "}.ad.fr {" + (a.U.ba ? "padding-top:2px;" : "") + "}.ad.l {" + (a.U.ba ? "padding-bottom:2px;" : "") + (a.ca ? "border-bottom: 0px;" : "") + "}.ad.lr {" + (a.U.ba ? "padding-bottom:2px;" : "") + "}#adBlock b {" + (a.j.adbold ? "" : "font-weight: normal;") + (a.j.keywordColor ? "color: " + a.Yf + ";" :
            "") + "}.descText, .ctcCO {" + (a.qa ? "font-size: " + a.qa + "px;" : "") + "}.sr-div, .sl-table-ol td, .sl-table td, .sl-column {" + (a.M ? "font-size: " + a.M + "px;" : a.qa ? "font-size: " + a.qa + "px;" : "") + "}" + (a.yc || a.j.isHighendMobile || a.j.isTablet ? ".descText {line-height: " + (a.yc ? a.yc + "px" : "1.5em") + ";}" : "") + ".adC {padding: 4px 4px; position: relative;" + (a.me ? "background-color: " + a.me + ";" : "") + (a.Y && a.Rf ? "border-left: 1px solid " + a.Y + ";" : "") + (a.Y && a.he ? "border-right: 1px solid " + a.Y + ";" : "") + (a.Y && a.Sf ? "border-top: 1px solid " +
            a.Y + ";" : "") + (a.Y && a.Qf ? "border-bottom: 1px solid " + a.Y + ";" : "") + "}.ad span {_width: 99%;}" + (a.na ? ".adStd {cursor: pointer; width: 100%;}" : "") + "#adBlock {background: #FFFFFF none repeat scroll 0 0; margin: 0; padding: 0;" + (a.ne ? "background-color: " + a.ne + ";" : "") + (a.da && a.Uf ? "border-left: 1px solid " + a.da + ";" : "") + (a.da && a.le ? "border-right: 1px solid " + a.da + ";" : "") + (a.da && a.Vf ? "border-top: 1px solid " + a.da + ";" : "") + (a.da && a.Tf ? "border-bottom: 1px solid " + a.da + ";" : "") + "}#adBlock h2 {font-size: " + (a.Pa ? a.Pa :
            a.j.isTablet ? "15" : "13") + "px; font-weight: normal;" + (a.ke ? "padding-bottom: " + a.ke + "px;" : "padding: 0;") + "margin: 0;" + (a.vc || a.Ae ? "font-family: " + (a.Ae ? "'" + a.Ae + "'," : "") + (a.vc ? a.vc + "," : "") + " sans-serif;" : "") + (a.j.isCse ? "text-align: " + n + ";" : "") + "}#adBlock span.lhHeader {margin: 3px 4px 0;}#adBlock span.rhHeader {margin: 0 4px; float: " + d + ";" + (a.j.isHighendMobile ? "display: inline;" : "") + "position: relative; z-index: 1;}#adBlock h2 a, #adBlock h2 {color: " + (a.wb ? a.wb : "#676767") + "; text-decoration: none;}.titleLink, .sl-table a, .sl-table-ol a, .sl-column a {color: " +
            a.Bb + ";}.titleLink, .ctcT a {" + (a.ra ? "font-size: " + a.ra + "px;" : a.j.isHighendMobile ? "font-size: 18px;" : "") + "font-weight: " + (a.bg ? "bold" : "normal") + ";}.titleLink {" + (a.cg ? "display: -moz-inline-box; display:inline-block; zoom: 1; *display: inline;" : "") + "line-height: " + (a.se ? a.se + "px" : "1.4em") + ";" + (a.te ? "text-decoration: none;" : "") + (a.ze ? "letter-spacing: " + a.ze + ";" : "") + "margin: 0; padding: 0;}" + (a.ag ? ".titleLink:hover, .domainLink:hover, .sr-rl:hover {text-decoration: underline;}a {text-decoration: none;}" :
            "") + "h2 a:hover {color: " + (a.wb ? a.wb : "#676767") + "; text-decoration: none; font-weight: normal; background-color: transparent;}.domainLink {" + (a.re ? "line-height: " + a.re + "px;" : a.j.isHighendMobile || a.j.isTablet ? "line-height: 1.5em;" : "") + "color: " + a.xb + "; font-style: normal; font-weight: normal;" + (a.ea ? "font-size: " + a.ea + "px;" : "") + "text-decoration: none;}.invisible {display: none;}.adStd.oneLine .descText {margin: 0 4px;}.adStd.twoLine .domainLink {margin-" + d + ": 8px;}.textLink {color: " + (a.oa ? a.oa : "black") +
            "; text-decoration: none;}.individualLabel {background-color: " + a.xb + ";" + (a.ea ? "font-size: " + a.ea + "px;" : "") + "color: " + a.Xf + "; border-radius: 2px; padding: 0 2px; margin-" + d + ": 3px; vertical-align: baseline;}.sl-table, .sl-column {visibility: hidden; margin-top: " + (a.j.isHighendMobile ? "0px" : "4px") + ";}.sl-table-ol a, .sl-table a, .sl-column a {text-decoration: none;}.sl-table-ol td {vertical-align: top; padding: 0px;}.sl-table a:hover, .sl-column a:hover, .sl-table-ol a:hover {text-decoration: underline;}.sl-table td {vertical-align: top; padding: 0px;}.sl-right {" +
            (a.j.isHighendMobile ? "margin: 4px 0 4px; margin-" + n + ": 8px;" : "margin-" + n + ": 13px;") + "}.sl-left {" + (a.j.isHighendMobile ? "margin: 4px 0 4px; margin-" + d + ": 8px;" : "margin-" + n + ": 12px;") + "}" + (a.j.isTablet ? "" : ".sl-table, .sl-column {line-height: 1.5;}") + (a.j.isHighendMobile || a.j.isTablet ? ".sl.l {margin-" + d + ": 5px;}.sl.r {margin-" + n + ": 5px;}" : "") + ".sitelinks {margin: 0; padding: 0; list-style-type: none; overflow: hidden;}.twoColSitelink {float: " + n + "; width: 49%;}.sitelink-spacer {padding-" + d + ": 10px;}.sitelink-nowrap {white-space: nowrap; overflow: hidden; text-overflow: ellipsis; text-align: " +
            n + ";}.plus-ones, .plus-ones a {text-decoration: none; color: " + (a.Ab ? a.Ab : a.I ? a.I : "#666666") + ";" + (a.Db ? "font-size: " + a.Db + "px;" : a.M ? "font-size: " + a.M + "px;" : "") + "}.plus-ones a:hover {text-decoration: underline;}.apareview {" + (a.M ? "font-size: " + a.M + "px;" : "") + "color: " + (null != a.I ? a.I : "#676767") + ";}.reviewlink {text-decoration: none; color: " + a.Bb + ";}.reviewlink:hover {text-decoration: underline;}.sr-div, .sr-rl {color: " + (a.I ? a.I : a.oa ? a.oa : "#666666") + ";}.sr-rl {text-decoration: none;}.sr-rl:hover {text-decoration: underline;}.sr-gl {text-decoration: none; color: " +
            (null != a.I ? a.I : "#777777") + ";}.sr-gl:hover {text-decoration: underline;}.sr-p {padding-right: 62px;}.sr-nsc {display: inline; position: relative;}.sr-star {position: absolute;}.sr-number {color: #F99B00;}a:hover {" + (a.$f ? "font-weight: bold;" : "") + (a.we ? "color: " + a.we + ";" : "") + (a.ve ? "background-color: " + a.ve + ";" : "") + "}.ctcLD {color: #676767; font-size: 80%;}.ctcI {width: 10px; height: 10px; margin-" + d + ": 1px;}.ctcCOI {width: 16px; height:16px;" + (a.j.isRtl ? '-moz-transform: scaleX(-1); -o-transform: scaleX(-1); -webkit-transform: scaleX(-1); transform: scaleX(-1); filter: FlipH; -ms-filter: "FlipH";' :
                "") + "}.ctcT {margin: 4px 0px 2px;}.ctcT a {" + (a.j.isHighendMobile && !a.te ? "text-decoration: underline;" : "text-decoration: none;") + "}.ctcCO {font-weight: bold;}" + (a.vb && a.nc && (a.j.customAdIcons || a.j.customAdIconsUnique) ? ".adIcon {visibility: visible; width: " + a.vb + "px; height: " + a.nc + "px; border: none;" + ("title-right" == a.oc ? "padding-left: 2px; padding-right: 2px;" : "float: " + n + ";" + (a.sc ? "padding-" + n + ":" + a.sc + "px;" : "") + "padding-" + d + ": " + (null != a.rc ? a.rc : 4) + "px; padding-top: " + (null != a.qc ? a.qc : 4) + "px; padding-bottom: " +
                (null != a.je ? a.je : 0) + "px;") + "}" + ("ad-left" == a.oc ? (a.uc ? ".adD, " : "") + ".adC {display: block; overflow: hidden;" + (a.uc ? "" : "margin-" + n + ": " + a.vb + "px;") + "}" : "") : "") + ".location {color: " + (a.yb ? a.yb : a.I ? a.I : "#666666") + ";" + (a.Cb ? "font-size: " + a.Cb + "px;" : a.M ? "font-size: " + a.M + "px;" : "") + "}" + (a.j.isHighendMobile || a.j.isTablet ? ".adStd {margin-bottom: " + (a.j.isTablet ? "5" : "10") + "px;}.sr-div, .sl-table-ol, .sl-left, .sl-right {margin-bottom: 12px;}.location, .plus-ones {margin-bottom: 10px;}" : "") + ".ohTbl {border-collapse: collapse; visibility: hidden;}.ohWrapper {margin-" +
            n + ": 20px;}.ohWrapper.foh {margin: 0;}.ohImg {float: " + n + "; background: url(//www.google.com/images/afs/offer_highlight_4.png) no-repeat;}.ohTxt {margin-" + n + ": 3px; color: " + (a.I ? a.I : "#666666") + ";" + (a.M ? "font-size: " + a.M + "px;" : "") + "}" + (a.Zf ? ".plaTbl {border-collapse: collapse; width: 100%;}ul.hpla {list-style: none; padding: 0; margin: 0; clear: both;}.plaTbl td {padding: 0;}.plaTbl td.imgEntry {width: 80px;}.plaTbl td.txtEntry {padding: 0 4px;" + (a.xe ? "padding-" + n + ": " + a.xe + "px;" : "") + (a.ye ? "padding-" +
                d + ": " + a.ye + "px;" : "") + "}.plaTbl td.priceEntry {text-align: " + d + ";}" + (a.Y ? "" : ".adC.pla {padding: 0;}") + (a.na ? ".adStd.pla, .adStd.hpla {cursor: auto;}" : "") + "li.ad.hpla {display: -moz-inline-stack; display: inline-block; zoom: 1; *display: inline; padding: 0; padding-" + d + ": 2px; margin: 2px 0 2px; margin-" + d + ": 2px;" + (a.ca ? "border-" + d + ": 1px solid " + a.ca + "; border-bottom: none;" : "") + (a.wc.ba ? "padding-" + d + ": " + a.wc.ub + "px; margin-" + d + ": " + a.wc.tb + "px;" : "") + (a.U.ba ? "margin-top: " + a.U.ub + "px; margin-bottom: " +
                a.U.tb + "px;" : "") + "}li.ad.hpla.l {padding-" + d + ": 0; margin-" + d + ": 0;" + (a.ca ? "border-" + d + ": none;" : "") + "}" + (a.U.ba ? "li.ad.hpla.t {margin-top: 2px;}li.ad.hpla.b {margin-bottom: 2px;}" : "") + ".titleLink.hpla {display: block;}.imgLink {line-height: 0; display: block;}.plaImgWrapper {" + (a.zb && "transparent" == a.zb ? "border: none;" : a.zb ? "border: 1px solid " + a.zb + ";" : "border: 1px solid #EBEBEB;") + "background-repeat: no-repeat; background-position: center; background-size: contain; cursor: pointer;}" + (a.Y ? ".hplaImgWrapper {margin-left: auto; margin-right: auto;}" :
                "") + ".price {color: " + (a.pe ? a.pe : "black") + ";" + (a.cb ? "font-size: " + a.cb + "px;" : "") + "}" + (a.cb && a.ea ? ".priceMerchantHyphen {font-size: " + (a.cb <= a.ea ? a.cb : a.ea) + "px;}" : "") : "") + ("relatedsearch" == a.type ? ".radlinkC {" + (a.xc && a.ra < a.Pa ? "padding: " + (1 + (a.Pa - a.ra)) + "px 4px;" : "padding: 1px 4px;") + "}.col {" + (a.Eb ? "text-align:" + ("right" == n && "left" == a.Eb ? "right" : "right" == n && "right" == a.Eb ? "left" : a.Eb) + ";" : "") + (a.xc ? "border-right: 1px solid " + a.ca + ";" : "") + "vertical-align: top;" + (a.qe ? "padding-right: " + a.qe + "px;" :
                "") + "}" + (a.xc ? "#adBlock h2 {float: " + n + "; line-height: 1.4em; vertical-align: top;" + (a.ra >= a.Pa ? "padding: " + (3 + (a.ra - a.Pa)) + "px 4px;" : "padding: 3px 4px;") + "}.ad {border-bottom: none;}.col.l {border-right: none;}" : "#adBlock h2 {text-align: " + n + ";}") : "") + ".raiDiv {margin-bottom: 20px;}.raiImg {margin-right: 5px; margin-top: 10px; margin-bottom: 0px; border: 1px solid #CCCCCC;}.nowrap {white-space: nowrap;}" + ("" + (".buttonsWrapper {margin: 10px 0 13px; white-space: nowrap;}.inlineButton {display: inline-block; box-sizing: border-box; text-align: center; border-" +
                f + ": 1px solid #DDDDDD; vertical-align: top;}.inlineButton.firstButton {border-" + f + ": none;}.button {text-align: center;}.buttonImageWrapper {margin-top: 10px; line-height: 0;}.buttonTextWrapper {margin-top: 7px;}.buttonText {text-decoration: none; color: #5897F1; font-size: 12px;}" + (e ? '.buttonImage {-moz-transform: scaleX(-1); -o-transform: scaleX(-1); -webkit-transform: scaleX(-1); transform: scaleX(-1); filter: FlipH; -ms-filter: "FlipH";}' : "")));
        a = a.j.sellerFirstBoxLeft ? ".sfblAd {padding-top: 17px;}.sfblAd.notLast {padding-bottom: 17px; border-bottom: 1px solid " +
            L(null != a.ca ? a.ca : "#E1E1E1") + ";}.sfblNarrowPadder {padding-top: 4px;}.sfblFavicon {vertical-align: top; width: 16px; height: 16px;}.sfblSellerNameWrapper {overflow: hidden; text-overflow: ellipsis; color: " + L(a.xb) + "; font-size: " + L(null != a.ea ? a.ea : "13") + "px;}.sfblSellerNameLink {text-decoration: none; color: " + L(a.xb) + ";}.sfblSellerNameLink:hover {text-decoration: underline;}.sfblSellerRatingsWrapper {padding-top: 3px;}.sfblTitleLink {font-size: " + L(null != a.ra ? a.ra : "15") + "px; font-weight: bold; text-decoration: none; color: " +
            L(a.Bb) + ";}.sfblTitleLink:hover {text-decoration: underline;}.sfblDescriptionWrapper {padding-top: 3px; color: " + L(null != a.oa ? a.oa : "#333333") + "; font-size: " + L(null != a.qa ? a.qa : "13") + "px;}.sfblSitelinksWrapper {padding-top: 4px; max-width: 450px; font-size: " + L(null != a.qa ? a.qa : "13") + "px;}.sfblSitelink {text-decoration: none; line-height: 17px; color: " + L(a.Bb) + ";}.sfblSitelink:hover {text-decoration: underline;}.plus-ones, .plus-ones a {color: " + (a.Ab ? L(a.Ab) : a.I ? L(a.I) : "#777777") + "; font-size: " +
            (a.Db ? L(a.Db) : a.M ? L(a.M) : "13") + "px; line-height: 1.3;}.location {color: " + (a.yb ? L(a.yb) : a.I ? L(a.I) : "#777777") + "; font-size: " + (a.Cb ? L(a.Cb) : a.M ? L(a.M) : "13") + "px; line-height: 1.3;}.ohTxt {color: " + L(null != a.I ? a.I : "#777777") + ";}.adC {padding: 0;}" : "";
        jf(g + (n + a + "</style>"), b, c)
    }, lf = function (a, b, c, d, e, f, g, k, n) {
        a = "<h2 " + (n ? ' class="' + L(n) + '" ' : "") + " id='attrHeader'>" + (f ? a ? td({text: a, N: "rhHeader"}) + "<br />" : de({Id: c, ec: b, N: "rhHeader"}) + (e ? ee({pb: e, N: "rhHeader", id: "megaLabel"}) : ee({pb: d, N: "lhHeader", id: "adsLabel"})) :
            a ? td({text: a, N: "lhHeader"}) : (e ? ee({pb: e, N: "lhHeader", id: "megaLabel"}) : ee({pb: d, N: "rhHeader", id: "adsLabel"})) + de({Id: c, ec: b, N: "lhHeader"})) + "</h2>";
        jf(a, g, k)
    }, jf = function (a, b, c) {
        oa() ? b.populate(a) : c.appendChild(vc(uc(), a))
    };
    var mf = function (a) {
        return'<div class="card adC" id="' + a.Ke + '"><div class="cardPadder">' + Yc({Dc: "<div>" + ff({href: a.sa, content: '<div class="image" style="background-image:url(' + a.Fb + ');"><div class="attribution">' + a.Ge + "</div></div>", k: a.Sa, Ia: "imageLink", Ja: a.He}) + "</div>", Ec: '<div class="contentWrapper"><div style="position: absolute;" class="titleParent">' + ff({href: a.sa, content: a.title, k: a.Sa, Ia: "title", Ja: a.Hb}) + '</div><div id="' + a.Le + '" style="position: absolute; bottom: 0;"><div class="priceParent"><span class="price" title="' +
            a.Me + '">' + a.Gb + '</span></div><div class="merchantParent">' + ff({href: a.sa, content: a.Je, k: a.Sa, Ia: "merchant", Ja: a.Ie}) + "</div></div></div>", Ib: a.lc, Fc: a.bb}) + '<div style="position: absolute; bottom: -8px; right: -6px;">' + a.Ne + "</div></div></div>"
    };
    mf.D = "csa.soy.pla.flagCard.flagCard";
    var nf = function (a) {
        return".card {background: white; margin-right: " + L(a.ib) + "px; margin-bottom: " + L(a.ib) + "px;" + (a.of ? "box-shadow: 1px 2px 1px rgba(0, 0, 0, 0.1); border: 1px solid #E0E0E0; box-sizing: border-box; border-radius: 3px;" : "box-shadow: 0 2px 1px rgba(0, 0, 0, 0.1), 0 0   1px rgba(0, 0, 0, 0.1); border-radius: 2px;") + "width: " + L(a.Xg) + "px; height: " + L(a.Wg) + "px; display: inline-block;}.cardPadder {" + (a.of ? "padding: " + L(a.bb - 1) + "px;" : "padding: " + L(a.bb) + "px;") + "position: relative;}.imageLink {text-decoration: none;}.image {width: " +
            L(a.lc) + "px; height: " + L(a.Zg) + "px; background-repeat: no-repeat; background-position: center; background-size: contain; cursor: pointer; position: relative;}.contentWrapper {position: relative; height: " + L(a.Yg) + "px;}.title {color: " + L(a.bh) + "; font-size: " + L(a.dh) + "px; text-decoration: none;}.titleParent {width: " + L(a.jd) + "px; word-wrap: break-word;}.price {font-size: " + L(a.ah) + "px; font-weight: bold; color: " + L(a.qf) + ";}.priceParent {color: " + L(a.qf) + "; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: " +
            L(a.jd - a.Rb) + "px; padding-bottom: 4px;}.merchant {color: " + L(a.pf) + "; text-decoration: none;}.merchantParent {font-size: " + L(a.$g) + "px; padding-bottom: 2px; color: " + L(a.pf) + "; overflow: hidden; text-overflow: ellipsis; white-space: nowrap; width: " + L(a.jd - a.Rb) + "px;}.attribution {font-size: 13px; display: inline-block; text-decoration: none; background-color: #555555; position: absolute; bottom: 1px; left: 1px; padding: 0 3px; color: white; border-radius: 2px;}"
    };
    nf.D = "csa.soy.pla.flagCard.style";
    var of = function (a) {
        return'<div class="card adC" id="' + a.Ke + '"><div class="cardPadder"><div>' + ff({href: a.sa, content: '<div class="image" style="background-image:url(' + a.Fb + ');"><div class="attribution">' + a.Ge + "</div></div>", k: a.Sa, Ia: "imageLink", Ja: a.He}) + '</div><div class="contentWrapper"><div style="position: absolute;" class="titleParent">' + ff({href: a.sa, content: a.title, k: a.Sa, Ia: "title", Ja: a.Hb}) + '</div><div id="' + a.Le + '" style="position: absolute; bottom: 0;"><div class="priceParent"><span class="price" title="' +
            a.Me + '">' + a.Gb + '</span></div><div class="merchantParent">' + ff({href: a.sa, content: a.Je, k: a.Sa, Ia: "merchant", Ja: a.Ie}) + '</div></div><div style="position: absolute; bottom: -14px; right: -14px;">' + a.Ne + "</div></div></div></div>"
    };
    of.D = "csa.soy.pla.stampCard.stampCard";
    var pf = function (a) {
        return nf(a) + ".image {margin-bottom: " + L(a.bb) + "px;}"
    };
    pf.D = "csa.soy.pla.stampCard.style";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var qf = function (a, b, c, d, e, f, g, k, n, p, r, s, D) {
            this.eg = c;
            this.Ac = d;
            this.aa = a.t;
            this.fg = a.m;
            this.Cc = a.pr;
            this.zc = a.i;
            this.Kc = a.s;
            this.Lc = a.ppu;
            this.mg = b.h;
            this.ug = b.w;
            this.Ic = e;
            this.Fe = f;
            this.ng = b.ih;
            this.Ee = b.iw;
            this.Ve = g;
            this.kg = k;
            this.tg = b.ts;
            this.pg = b.ms;
            this.rg = b.ps;
            this.sg = b.tc;
            this.og = b.mc;
            this.qg = b.pc;
            this.Bc = n;
            this.lg = p;
            this.V = r;
            this.Jc = s;
            this.B = D;
            this.Se = E();
            this.Pe = E();
            this.Ca = E();
            this.Qe = E();
            this.Re = E()
        };
        h = qf.prototype;
        h.o = function () {
            var a = this.V ? this.V.o() :
                "";
            return this.B({Ke: this.Se, Ge: this.eg, sa: this.Ac, Fb: this.zc, He: this.Pe, title: this.aa, Hb: this.Ca, Gb: this.Cc, Je: this.fg, Ie: this.Qe, Le: this.Re, lc: this.Ee, bb: this.Fe, Me: this.Dg(), Sa: this.Bc, Ne: a})
        };
        h.cd = function () {
            return(this.V ? this.V.cd() : "") + this.Jc({Xg: this.ug, Wg: this.mg, ib: this.Ic, bb: this.Fe, Zg: this.ng, lc: this.Ee, Yg: this.Ve, jd: this.kg, dh: this.tg, $g: this.pg, ah: this.rg, bh: this.sg, pf: this.og, qf: this.qg, of: this.lg, Rb: this.V ? 20 : 0})
        };
        h.Dg = function () {
            return dc([this.Lc, this.Kc], ca).join("\n")
        };
        h.ob = function (a) {
            var b =
                a.document.getElementById(this.Re);
            b && cf(a.document.getElementById(this.Ca), this.Ve - (b.offsetHeight + 4));
            this.V && this.V.ob(a)
        };
        h.Kd = function (a) {
            this.V && this.V.Kd(a)
        };
        h.Bf = function (a) {
            return he(a, this.Se)
        };
        h.lb = function (a) {
            var b = this.V ? this.V.lb(a) : [];
            return[new Fe(he(a, this.Ca), "&nb=0"), new Fe(he(a, this.Qe), "&nb=1"), new Fe(he(a, this.Pe), "&nb=9")].concat(b)
        };
        var rf = function (a, b, c, d, e, f, g) {
            var k = Sa(a.u), n = new H(b.w, b.h), p = new H(b.iw, b.ih), r = Math.floor((n.height - p.height) / 2), s = p.height, p = n.width - (3 * r +
                p.width);
            g = g ? ef(a, n.width - 90, n.height - 20, k, e, -22, !0) : null;
            return new qf(a, b, c, k, d, r, s, p, e, f, g, nf, mf)
        }, sf = function (a, b, c, d, e, f, g) {
            var k = Sa(a.u), n = new H(b.w, b.h), p = new H(b.iw, b.ih), r = Math.floor((n.width - p.width) / 2), s = n.height - (3 * r + p.height), p = p.width;
            g = g ? ef(a, n.width, n.height - 50, k, e, -19, !1) : null;
            return new qf(a, b, c, k, d, r, s, p, e, f, g, pf, of)
        }
    }
    ;
    var tf = function (a) {
        var b = "<style>#adBlock {width: " + a.width + "px; font-size: 0;}.blockWrapper {background-color: " + a.backgroundColor + "; font-family: " + a.fontFamily + ";}.plasWrapper {padding-top: " + a.ib + "px; padding-left: " + a.ib + "px;}" + a.kh + '</style><div class="blockWrapper"><div class="plasWrapper">';
        a = a.mh;
        for (var c = a.length, d = 0; d < c; d++)b += a[d];
        return b + "</div></div>"
    };
    tf.D = "csa.soy.pla.block.gridBlock";
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var uf = function (a, b, c, d, e, f, g) {
            this.Wa = a;
            this.rf = b;
            this.Ic = c;
            this.gh = d;
            this.hh = e;
            this.jh = f;
            this.B = g
        };
        uf.prototype.o = function () {
            for (var a = [], b = 0; b < this.Wa.length; b++)a.push(this.Wa[b].o());
            return this.B({mh: a, width: this.rf.width, kh: this.jh, ib: this.Ic, backgroundColor: this.gh, fontFamily: this.hh})
        };
        uf.prototype.Ih = function () {
            return this.rf
        };
        uf.prototype.Hh = function () {
            return this.Wa
        };
        uf.prototype.Gh = function (a) {
            for (var b = 0; b < this.Wa.length; b++)this.Wa[b].ob(a), this.Wa[b].Kd(a.document)
        }
    }
    ;
    var vf = function (a) {
        var b, c = 0;
        b = '<div class="SponsoredLinksBoxNoBorder"><div style="margin-left:2px"><div class="SponsoredLinksContentWrapper" id="A9AdsWidgetAdsWrapper"><div class="SponsoredLinksAdBox"><table id="SponsoredLinksTable" class="SponsoredLinkColumnAds"><tbody>';
        for (var d = a.ads, e = d.length, f = 0; f < e; f++) {
            var g = d[f];
            b += '<tr class="adUnit_js adC"><td valign="top"><span style="white-space:nowrap; padding-right:18px">' + (1 == a.ads.length ? '<span class="SponsoredLinkYellowBlockEnclosure"><span class="SponsoredLinkYellowBlock">&nbsp;</span>&nbsp;</span>' :
                '<span class="SponsoredLinkNumberItem">' + ++c + ".&nbsp;</span>") + '<span class="SponsoredLinkTitle"> <a target="_blank" href="' + g.u + '" rel="nofollow" class="titleLink"><b>' + g.cleanTitle + '</b></a> <a rel="nofollow" href="' + g.u + '" target="_blank" class="amazonExternalLinkImage_js"><img width="23" height="20" border="0" align="absbottom" style="padding-bottom:0px; margin-bottom:0px; display:inline;" alt="opens new browser window" src="//www.google.com/images/afs/amazon/external_link_icon.png"></a></span></span></td><td><span class="SponsoredLinkDescription" style="white-space:normal; padding-left:0px"><span style="padding-right:10px;" class="SponsoredLinkDescriptionText">' +
                g.l1 + "&nbsp;" + g.l2 + '</span></span> <span class="SponsoredLinkDescription" style="padding-left:0px"><a class="SponsoredLinkDescriptionUrlLink" rel="nofollow" href="' + g.u + '" target="_blank" class="domainLink">' + g.v + "</a></span></td></tr>"
        }
        return b + '</tbody></table></div></div></div></div><style type="text/css">#adBlock {font-size: 13px;}#adBlock a:hover {text-decoration: none;}#sponsoredLinks {font-family: verdana,arial,helvetica,sans-serif;}.SponsoredLinksBoxNoBorder td, .SponsoredLinksBoxNoBorder th{font-family: verdana,arial,helvetica,sans-serif;}.SponsoredLinksBoxNoBorder a {color: #004B91; font-family: verdana, arial,helvetica,sans-serif;}.SponsoredLinksBox td, .SponsoredLinksBox th{font-family: verdana,arial,helvetica,sans-serif;}.SponsoredLinksBox a {color: #004B91; font-family: verdana, arial,helvetica,sans-serif;}.SponsoredFeedbackDiv{display: block; font-size: 90%; padding-left: 2px; padding-top: 5px;}.SponsoredLinkDescriptionUrlLink:link, #sponsoredLinks .SponsoredLinkDescriptionUrlLink:link {color: black; font-weight: normal; text-decoration: none;}.SponsoredLinkDescriptionUrlLink:visited, #sponsoredLinks .SponsoredLinkDescriptionUrlLink:visited {color: black; font-weight: normal; text-decoration: none;}.SponsoredLinkDescriptionUrlLink:hover,  #sponsoredLinks .SponsoredLinkDescriptionUrlLink:hover {color: black; font-weight: normal; text-decoration: none;}.SponsoredLinksBox{height: auto; padding-left: 5px; padding-right: 5px; padding-top: 3px; padding-bottom: 10px; margin-top: 0px; margin-bottom: 10px; border: 1px solid #D0EAF8;}.SponsoredLinksBoxNoBorder{height: auto; padding-left: 0px; padding-right: 0px; padding-top: 0px; margin-top: 0px; border: none;}.SponsoredLinkYellowBlock {position: absolute; background-color: #db9234; width: 4px; height: 4px; margin-right: 2px; margin-left: 2px; margin-top: 9px; left: 0px; line-height: 1px;}#sponsoredLinks {width: 100%; padding-top: 4px;}.SponsoredLinkYellowBlockEnclosure {position: relative; margin-right: 2px;}.SponsoredLinkContentDeclaration {text-align: right; padding-right: 20px; color: #C2C2C2}.SponsoredLinksBottomBox {padding-top: 5px; padding-right: 20px;}.SponsoredLinksAdvertiseYourServices {font-size: 90%; float: right;}#sponsoredLinks a:link, #sponsoredLinks a:visited {text-decoration: underline;}.SponsoredLinksSearchSeperator {margin-top: 6px; border-bottom: 1px dotted gray;}.SponsoredLinkDescriptionUrlLink {white-space: nowrap;}.SponsoredLinkNumberItem {font-family: verdana; color: #666666; font-size: 100%;}.SponsoredLinkNumberItemEnclose {padding-top: 3px;}.SponsoredLinksAdBox{padding: 0px; margin: 0px;}.SponsoredLinksAdBox ul {list-style-type: none; padding-left: 0px; margin-left: 0px;}.SponsoredLinksAdBox ul li {clear: both; margin-top: 10px; padding-left: 5px; border: 0px solid #ffcc00;}.SponsoredLinksAdBox ul li span{float: left; padding: 0 0 0 0}.SponsoredLinksAdBox ul li div{float: left; padding: 0 10px 0 0}.SponsoredLinksAdBox .SponsoredLinkTitle {font-size: 125%; white-space: nowrap; min-width: 250px; padding-left: 0px; padding-bottom: 5px}.SponsoredLinksAdBox .SponsoredLinkTitle a:hover {color: #CC6600;}.SponsoredLinksAdBox .SponsoredLinkTitle a {font-family: arial;}.SponsoredLinksAdBox .SponsoredLinkDescription{font-size: 115%; color: #000; min-width: 240px; white-space: nowrap; padding-left: 18px; padding-top: 3px; font-family: arial;}.SponsoredLinksAdBox .SponsoredLinkDescription a:link {color: black; text-decoration: none; font-family: arial;}table.SponsoredLinkColumnAds td {padding-bottom: 10px;}</style>'
    };
    vf.D = "csa.soy.amazon.Numbered";
    var wf = function (a) {
        for (var b = '<div id="AUI_A9AdsWidgetAdsWrapper"><table class="AUI_SponsoredLinkColumnAds" style="width:auto; margin-right:40px;"><tbody>', c = a.ads, d = c.length, e = 0; e < d; e++)var f = c[e], b = b + ('<tr class="adUnit_js adC"><td><ul><li><div class="AUI_SponsoredLinkTitle"><a class="a-size-medium" style="font-size:15px; padding-top:3px; display:inline-block;" target="_blank" href="' + f.u + '" rel="nofollow">' + (a.options.amazonGrayBullets ? "<b>" + f.t + "</b>" : "<b>" + f.cleanTitle + "</b>") + '</a> <a target="_blank" href="' +
            f.u + '" rel="nofollow"><img src="//www.google.com/images/afs/amazon/external_link_icon.png" width="23" alt="opens new browser window" align="absbottom" style="padding-bottom:0px; margin-bottom:0px;" height="20" border="0"></a></div></li></ul></td><td><div class="AUI_SponsoredLinkDescriptionDIV"><span style="padding-top:2px; display:inline-block;">&nbsp;&nbsp;-&nbsp;&nbsp;</span></div></td><td><div class="AUI_SponsoredLinkDescriptionDIV"><span class="a-size-base" style="padding-top:2px; display:inline-block;">' +
            f.l1 + "&nbsp;" + f.l2 + '</span></div></td><td style="padding-left: 10px;"><div class="AUI_SponsoredLinkDescriptionDIV"><a class="a-size-base" style="padding-top:2px; display:inline-block;" target="_blank" href="' + f.u + '" rel="nofollow"><span class="a-color-secondary">' + f.v + "</span></a></div></td></tr>");
        return b += "</tbody></table></div><style>#adBlock {margin-top: 10px;}* {-moz-box-sizing: border-box; -webkit-box-sizing: border-box; box-sizing: border-box;}body {font-size: 13px; line-height: 19px; color: #333; font-family: Arial,sans-serif;}" +
            (a.options.amazonGrayBullets ? "" : "#AUI_A9AdsWidgetAdsWrapper table {margin-left: 27px; font-family: verdana,arial,helvetica,sans-serif;}") + "table:last-child {margin-bottom: 0!important;}table {margin-bottom: 18px; border-collapse: collapse; width: 100%;}tr:first-child td, tr:first-child th {padding-top: 0;}td:first-child, th:first-child {padding-left: 0;}td, th {padding: 3px;}td, th {vertical-align: top;}td:last-child, th:last-child {padding-right: 0;}ul:last-child, ol:last-child {margin-bottom: 0!important;}ul, ol {padding: 0;}ul {margin: 0 0 18px 18px; color: #aaa;}ul li {" +
            (a.options.amazonGrayBullets ? "" : "color: #db9234;") + "}ul li, ol li {word-wrap: break-word; margin: 0;}ul li {list-style: disc;}a, a:visited, a:active, a:link {text-decoration: none; color: #0066c0;}.a-size-medium {font-size: 17px!important; line-height: 1.255!important; font-family: Arial,sans-serif; text-rendering: optimizeLegibility;}a:hover {text-decoration: underline; cursor: pointer; color: #e47911;}.a-size-base {font-size: 13px!important; line-height: 19px!important;}.a-color-secondary {color: #888!important;}img {vertical-align: top;}img {max-width: 100%; border: 0; -ms-interpolation-mode: bicubic;}</style>"
    };
    wf.D = "csa.soy.amazon.Bulleted";
    var xf = function (a) {
        for (var b = '<ul class="hpla">', c = a.ads, d = c.length, e = 0; e < d; e++)var f = c[e], b = b + ('<li class="ad hpla' + (0 == e ? " f t" : "") + (e == d - 1 ? " l b" : "") + '" align="' + (a.j.isRtl ? "right" : "left") + '"><div class="adC hpla adUnit_js"><div class="adStd hpla" style="width: 110px;"><a href="' + f.u + '" style="text-decoration: none;"' + M(a) + '><div class="plaImgWrapper hplaImgWrapper" style="background-image:url(' + f.i.u + "); width:" + f.i.w + "px; height:" + f.i.h + 'px; position: relative;"></div></a><div class="titleLink hpla limitTwoLines" title="' +
            L(f.cleanTitle) + '"><a href="' + f.u + '" class="titleLink" ' + M(a) + 'style="width: 110px;">' + f.t + "</a></div><span>" + (a.j.clickableText ? '<a href="' + f.u + '" class="textLink" ' + M(a) + ">" : "") + '<b class="price">' + f.p + "</b>" + (a.j.clickableText ? "</a>" : "") + '</span><br/><div class="domainLink hpla" title="' + L(f.m) + '"><a href="' + f.u + '" class="domainLink" ' + M(a) + ">" + f.m + "</a></div></div></div></li>");
        return b + "</ul>"
    };
    xf.D = "csa.soy.horizontalPlas.ads";
    var yf = function (a) {
        for (var b = "", c = a.ads, d = c.length, e = 0; e < d; e++)var f = c[e], b = b + ('<div class="ad' + (0 == e ? " f" : "") + (e == d - 1 ? " l" : "") + ' adUnit_js"><div class="adC pla"><div class="adStd pla"><table class="plaTbl"><tr><td class="imgEntry"><a href="' + f.u + '" style="text-decoration: none;" class="imgLink" ' + M(a) + '><div class="plaImgWrapper" style="background-image:url(' + f.i.u + "); width:" + f.i.w + "px; height:" + f.i.h + 'px; position: relative;"></div></a></td><td class="txtEntry"><div class="limitTwoLines"><a href="' +
            f.u + '" class="titleLink" ' + M(a) + ">" + f.t + "</a></div>" + (a.j.clickableText ? '<a href="' + f.u + '" class="textLink" ' + M(a) + ">" : "") + '<a href="' + f.u + '" class="domainLink"' + M(a) + ">" + f.m + "</a>" + (a.j.clickableText ? "</a>" : "") + "<br />" + (a.j.clickableText ? '<a href="' + f.u + '" class="textLink" ' + M(a) + ">" : "") + '<span class="descText">' + f.pt + "</span>" + (a.j.clickableText ? "</a>" : "") + '</td><td class="priceEntry"><b class="price">' + f.p + "</b></td></tr></table></div></div></div>");
        return b
    };
    yf.D = "csa.soy.threeColumnPlas.ads";
    var zf = function (a) {
        for (var b = "", c = a.ads, d = c.length, e = 0; e < d; e++)var f = c[e], b = b + ('<div class="ad' + (0 == e ? " f" : "") + (e == d - 1 ? " l" : "") + ' adUnit_js"><div class="adC pla"><div class="adStd pla"><table class="plaTbl"><tr><td class="imgEntry"><a href="' + f.u + '" style="text-decoration: none;" class="imgLink" ' + M(a) + '><div class="plaImgWrapper" style="background-image:url(' + f.i.u + "); width:" + f.i.w + "px; height:" + f.i.h + 'px; position: relative;"></div></a></td><td class="txtEntry"><div class="limitTwoLines"><a href="' +
            f.u + '" class="titleLink" ' + M(a) + ">" + f.t + "</a></div>" + (a.j.clickableText ? '<a href="' + f.u + '" class="textLink" ' + M(a) + ">" : "") + '<b class="price">' + f.p + '</b><span class="priceMerchantHyphen"> - </span><a href="' + f.u + '" class="domainLink"' + M(a) + ">" + f.m + "</a>" + (a.j.clickableText ? "</a>" : "") + "<br />" + (a.j.clickableText ? '<a href="' + f.u + '" class="textLink" ' + M(a) + ">" : "") + '<span class="descText">' + f.pt + "</span>" + (a.j.clickableText ? "</a>" : "") + "</td></tr></table></div></div></div>");
        return b
    };
    zf.D = "csa.soy.twoColumnPlas.ads";
    var Cf = function (a) {
        for (var b = '<div id="wideSfbl">', c = a.ads, d = c.length, e = 0; e < d; e++)var f = c[e], b = b + ('<div class="adC adUnit_js"><div class="sfblAd' + (e != d - 1 ? " notLast" : "") + '">' + Yc({Dc: "" + Af(Nc(a, {A: f})), Ec: "" + Bf(Nc(a, {A: f})), Ib: 129, Fc: 10, Ue: a.j.isRtl}) + "</div></div>");
        b += '</div><div id="narrowSfbl" style="display: none;">';
        c = a.ads;
        d = c.length;
        for (e = 0; e < d; e++)f = c[e], b += '<div class="adC adUnit_js"><div class="sfblAd' + (e != d - 1 ? " notLast" : "") + '">' + Af(Nc(a, {A: f})) + '<div class="sfblNarrowPadder">' + Bf(Nc(a, {A: f,
            ai: !0})) + "</div></div></div>";
        return b + "</div>"
    };
    Cf.D = "csa.soy.sellerFirst.boxLeft.ads";
    var Af = function (a) {
        var b = Yc({Dc: '<img src="http://s2.googleusercontent.com/s2/favicons?domain_url=' + L(a.A.visDomain) + '" class="sfblFavicon"/>', Ec: '<div class="sfblSellerNameWrapper" title="' + L(a.A.visDomain) + '"><a class="sfblSellerNameLink" href="' + L(a.A.u) + '"' + M(a) + ">" + Pc({text: a.A.nonBreakingVisDomain, Ta: !1, f: a.j.isRtl}) + "</a></div>", Ib: 16, Fc: 5, Ue: a.j.isRtl}) + '<div class="sfblSellerRatingsWrapper">', c;
        c = a.A.sr;
        var d = a.k;
        a = a.j.isRtl;
        c = "" + (c ? ld({Ce: c.nt, k: d, Be: c.r, De: c.u, f: a, Ze: !0, jg: !0}) : "");
        return b +
            c + "</div>"
    }, Bf = function (a) {
        var b = '<div class="sfblTitleWrapper"><a href="' + a.A.u + '" class="sfblTitleLink" ' + M(a) + ">" + Qc({text: a.A.tr, f: a.j.isRtl}) + '</a></div><div class="sfblDescriptionWrapper">' + Sc({Lb: a.A.l1r, hb: a.A.l2r, f: a.j.isRtl}) + "</div>" + id({Gc: a.A.plus_ones, k: a.k}) + ad({Hc: a.A.location, f: a.j.isRtl}), c = a.A.oh, d = "";
        if (c && 0 < c.length) {
            for (var d = d + '<table class="ohTbl"><tbody><tr>', e = c.length, f = 0; f < e; f++)var g = c[f], d = d + ('<td class="ohTd">' + ed({Oe: g.p, text: g.t}) + "</td>");
            d += "</tr></tbody></table>"
        }
        return b +
            d + (a.A.sls && 0 < a.A.sls.length ? '<div class="sfblSitelinksWrapper"><div class="sfblWideSitelinksWrapper">' + qd({Ra: a.A.sls, k: a.k, df: 2, ad: "sfblSitelink"}) + '</div><div class="sfblNarrowSitelinksWrapper" style="display: none;">' + qd({Ra: a.A.sls.slice(0, 3), k: a.k, df: 1, ad: "sfblSitelink"}) + "</div></div>" : "")
    };
    if (window.IS_GOOGLE_AFS_IFRAME_)var Df = function (a, b) {
        var c = a.document.getElementById("wideSfbl"), d = a.document.getElementById("narrowSfbl");
        b.sellerFirstBoxLeftCutoffWidth && c && d && (R(a.document.body, !1) < b.sellerFirstBoxLeftCutoffWidth ? (c.style.display = "none", d.style.display = "block") : (c.style.display = "block", d.style.display = "none"));
        for (var c = P(a.document, "div", "sfblWideSitelinksWrapper"), d = P(a.document, "div", "sfblNarrowSitelinksWrapper"), e = P(a.document, "div", "sfblSitelinksWrapper"), f = null, g = 0, k; k = e[g]; g++)if (0 <
            k.offsetWidth) {
            f = k;
            break
        }
        if (f && 260 > R(f, !1)) {
            for (g = 0; k = c[g]; g++)k.style.display = "none";
            for (g = 0; k = d[g]; g++)k.style.display = "block"
        } else {
            for (g = 0; k = c[g]; g++)k.style.display = "block";
            for (g = 0; k = d[g]; g++)k.style.display = "none"
        }
    };
    var Ef = window;
    var Ff = function (a, b) {
        var c = b || Ef;
        a && c.top != c && (c = c.top);
        try {
            var d;
            if (c.document && !c.document.body)d = new H(-1, -1); else {
                var e = (c || window).document, f = "CSS1Compat" == e.compatMode ? e.documentElement : e.body;
                d = new H(f.clientWidth, f.clientHeight)
            }
            return d
        } catch (g) {
            return new H(-12245933, -12245933)
        }
    };
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var Gf = new Xa("ijsp"), Hf = {}, If = null, Jf = new x("iframe"), Kf = {Ff: 0, td: 1, Xh: 2, fc: 3}, Lf = {ads: Kf.Ff, plas: Kf.td, rss: Kf.Xh, pbs: Kf.fc}, Mf = {4: "horizontal", 5: "twoColumn", 6: "threeColumn"}, Nf = {bulleted: wf, numbered: vf}, Of = {0: "ad-left", 1: "title-right"}, Pf = {0: "off", 1: "low", 2: "med", 3: "high"}, S = {}, Qf = {}, Rf = {}, Sf = function (a, b) {
                this.Th = a;
                this.Uh = b
            }, Sf = q(Sf, "hWI"), Tf = function (a) {
                !If && a.name && (If = (a = a.name.match(/master-(\d+)/)) && a[1] ? a[1] : null);
                If || (If = -1);
                return If
            }, Tf = q(Tf, "gMN"), Uf =
                function (a, b) {
                    try {
                        return R(a.document.getElementById(b), !0)
                    } catch (c) {
                        return null
                    }
                }, Uf = q(Uf, "gBH"), Vf = function (a, b) {
                try {
                    return R(a.document.getElementById(b), !1)
                } catch (c) {
                    return null
                }
            }, Vf = q(Vf, "gBW"), Xf = function (a, b) {
                var c = [], d = [], e;
                for (e in a) {
                    var f = Wf(e, b);
                    null == f ? delete a[e] : (c.push(e), d.push(f))
                }
                return{frames: d, names: c}
            }, Xf = q(Xf, "cFr"), $f = function (a, b) {
                var c = Xf(Hf, a), d = c.names, c = c.frames, e;
                for (e in d)Yf(Wf(d[e], a), d[e]), Df(Wf(d[e], a), b), Rf[d[e]] && Zf(Wf(d[e], a), d[e], b), Te(c[e])
            }, $f = q($f, "aPE"),
            bg = function (a) {
                var b = Xf(Hf, a), c = b.names;
                a = ag(b.frames, ea(bg, a));
                for (b = 0; b < a.length; b++)null != a[b] && Jf.mb(c[b] + ".h", a[b]);
                sb(Jf)
            }, bg = q(bg, "sPH"), cg = function (a, b) {
                $f(a, b);
                bg(a)
            }, cg = q(cg, "oR"), dg = function (a, b) {
                var c = document.defaultView || {};
                return c && c.getComputedStyle ? (c = c.getComputedStyle(a, !1)) ? c.getPropertyValue(b) : null : (c = a.currentStyle) ? c[b] : null
            }, dg = q(dg, "gS"), eg = function (a) {
                try {
                    var b = dg(a, "display");
                    return null != b && "none" != b
                } catch (c) {
                    return!1
                }
            }, eg = q(eg, "iV"), fg = {titleLink: "&nb=0", sfblTitleLink: "&nb=0",
                domainLink: "&nb=1", sfblSellerNameLink: "&nb=1", sl: "&nb=6", sfblSitelink: "&nb=6", textLink: "&nb=7", nArr: "&nb=8", ctcBtnLink: "&nb=14", amazonExternalLinkImage_js: "&nb=9"}, gg = function (a) {
                var b = [];
                a = a.getElementsByTagName("a");
                for (var c = 0, d; d = a[c]; c++)if (eg(d))for (var e in fg)if (fe(d, e)) {
                    b.push(new Fe(d, fg[e]));
                    break
                }
                return b
            }, gg = q(gg, "gTASSL"), hg = function (a, b, c, d) {
                for (var e = 0; e < a.length; e++) {
                    var f = a[e], g = f;
                    Q(g.element, "mouseover", Ae([g]));
                    var k = g;
                    Q(k.element, "mousedown", Ce(k));
                    Q(k.element, "mouseup", Be(k));
                    k = g.element.href;
                    k = k.replace(we, "");
                    k += g.Rh;
                    ze(g, k);
                    Ee(f, c);
                    void 0 != d.resultUrl && (g = d.resultUrl, g = void 0 == g ? document.location.href : g, "" != g && (k = f.element.href, k = De(k, "&res_url=", g), ze(f, k)));
                    void 0 != d.refererUrl && (g = d.refererUrl, g = void 0 == g ? document.referrer : g, "" != g && (k = f.element.href, k = De(k, "&rurl=", g), ze(f, k)))
                }
                0 < a.length && Q(b, "mouseover", Ae(a))
            }, hg = q(hg, "aSSTA"), Yf = function (a, b) {
                var c = a.document.getElementById("attribution"), d = a.document.getElementById("adsLabel"), e = a.document.getElementById("megaLabel");
                if (d || e) {
                    var f;
                    Qf[b] ? f = Qf[b] : (f = 20, e ? f += U(e).width : (f += U(d).width, c && (f += U(c).width, f += 20)), Qf[b] = f);
                    var g = he(a.document, "adBlock"), g = oe(g);
                    f > g ? e ? (e.style.display = "none", c ? c.style.display = "" : e.parentNode.style.display = "none") : (d.style.display = "none", c || (d.parentNode.style.display = "none")) : e ? (e.style.display = "", e.parentNode.style.display = "", c && (c.style.display = "none")) : (d.style.display = "", d.parentNode.style.display = "")
                }
            }, Yf = q(Yf, "aH"), jg = function (a, b, c) {
                a = a.document.getElementsByTagName("table");
                for (var d =
                    a.length, e = 0; e < d; e++) {
                    var f = a[e];
                    fe(f, "sl-table") && !fe(f.parentNode, "invisible") && ig(f, b, c)
                }
            }, jg = q(jg, "aSL"), kg = function (a) {
                if (a instanceof Array) {
                    for (var b = 0; b < a.length; b++)if (kg(a[b]))return!0;
                    return!1
                }
                return a.offsetHeight > U(a).height
            }, kg = q(kg, "iW"), U = function (a) {
                if (!a)return null;
                var b = a.ownerDocument.createElement("div");
                V(b, "visibility", "hidden");
                b.innerHTML = a.innerHTML;
                V(b, "position", "absolute");
                b.className = a.className;
                if (oa()) {
                    var c = a.ownerDocument.createElement("div");
                    V(c, "visibility", "hidden");
                    V(c, "position", "relative");
                    V(c, "width", "9999px");
                    c.appendChild(b);
                    a.parentNode.appendChild(c)
                } else V(b, "left", "-9999px"), V(b, "top", "0px"), a.parentNode.appendChild(b);
                a = {width: b.offsetWidth, height: b.offsetHeight, ei: a, innerHTML: a.innerHTML};
                oa() ? c.parentNode.removeChild(c) : b.parentNode.removeChild(b);
                return a
            }, U = q(U, "gTDAN"), lg = function (a) {
                for (; 0 < a.length;) {
                    var b = a.pop();
                    b && b.parentNode.removeChild(b)
                }
            }, lg = q(lg, "rLON"), ig = function (a, b, c) {
                for (var d = a.getElementsByTagName("div"), e = [], f = [], g = 0, k; k = d[g]; g++)"sl-left" ==
                k.className && 3 > e.length ? e.push(k) : "sl-right" == k.className && 3 > f.length && f.push(k);
                for (d = []; 0 < e.length;)0 < f.length ? d.push([e.shift(), f.shift()]) : d.push([e.shift()]);
                b ? mg(a, d) : ng(a, d, c);
                V(a, "visibility", "visible")
            }, ig = q(ig, "aSL"), ng = function (a, b) {
                for (var c = a.getElementsByTagName("a").length; 1 < b.length && kg(b);)lg(b.pop());
                1 == b.length && mg(a, b);
                var d = P(a.parentNode, "div", "sl-column");
                if (1 == d.length) {
                    var d = d[0], e = a.getElementsByTagName("a").length;
                    if (e < c && 3 > e) {
                        c = oe(d) - 15;
                        125 > c && (c = 125);
                        for (var f = d.getElementsByTagName("div"),
                                 g = 0, k = 0, n; n = f[k]; k++)U(n).width <= c && 3 > g ? g++ : n.style.display = "none";
                        g > e ? (V(d, "visibility", "visible"), a.style.display = "none") : d.style.display = "none"
                    } else d.style.display = "none"
                }
            }, ng = q(ng, "uS"), mg = function (a, b) {
                for (var c = b.shift(); 0 < b.length;)lg(b.pop());
                c[1] && (kg(c) || (O(c[0].firstChild, "l"), O(c[1].firstChild, "r"), c[0].innerHTML += " - " + c[1].innerHTML), c[1].parentNode.removeChild(c[1]), c.pop());
                a.className = "sl-table-ol";
                c[0].className = "sl-left-ol";
                kg(c[0]) && lg(c)
            }, mg = q(mg, "hSLS"), og = function (a) {
                var b =
                    R(a[0], !1);
                a = R(a[a.length - 1], !1);
                return new Sf(b, a)
            }, og = q(og, "cHW"), Zf = function (a, b, c) {
                a = a.document.getElementsByTagName("li");
                if (!(1 >= a.length)) {
                    Rf[b] || (Rf[b] = og(a));
                    var d = Rf[b].Th, e = Rf[b].Uh;
                    if (d && e) {
                        var f = R(a[0].parentNode, !1);
                        b = Math.floor((f - e) / d) + 1;
                        b = Math.max(1, b);
                        b = Math.min(a.length, b);
                        var g = 0 == a.length % b ? b : a.length % b, d = Math.max(f - ((b - 1) * d + e) - 20, 0);
                        pg(a, b, g, d, c);
                        qg(a, b)
                    }
                }
            }, Zf = q(Zf, "aHCC"), qg = function (a, b) {
                for (var c = !0, d = [], e = 0; e < a.length; e += b) {
                    for (var f = 0; f < b && e + f < a.length; f++) {
                        var g = P(a[e +
                            f], "div", "titleLink hpla");
                        if (1 == g.length) {
                            if (!fe(g[0], "ot")) {
                                c = !1;
                                break
                            }
                            d.push(g[0])
                        }
                    }
                    if (!0 == c)for (c = 0; c < d.length; c++)V(d[c], "height", "auto");
                    c = !0;
                    d = []
                }
            }, qg = q(qg, "aHTH"), pg = function (a, b, c, d, e) {
                for (var f = 0; f < a.length; f++)f < b ? O(a[f], "t") : ge(a[f], "t"), 0 == f % b ? O(a[f], "f") : ge(a[f], "f"), 0 == (f + 1) % b ? (O(a[f], "l"), rg(a[f], d, e)) : (ge(a[f], "l"), sg(a[f], e)), f > a.length - 1 - c ? O(a[f], "b") : ge(a[f], "b");
                O(a[a.length - 1], "l");
                sg(a[a.length - 1], e)
            }, pg = q(pg, "apHCC"), rg = function (a, b, c) {
                c.isRtl ? a.style.marginLeft = b + "px" : a.style.marginRight =
                    b + "px"
            }, rg = q(rg, "fRSWM"), sg = function (a, b) {
                b.isRtl ? a.style.marginLeft = "" : a.style.marginRight = ""
            }, sg = q(sg, "rAM"), ug = function (a) {
                a = P(a.document, "div", "domainLink hpla");
                for (var b = 0, c; c = a[b]; b++)tg(c, c.firstChild.firstChild, 110)
            }, ug = q(ug, "aHTE"), wg = function (a, b) {
                for (var c = P(a.document, "div", "limitTwoLines"), d = 0, e; e = c[d]; d++)vg(e, e.firstChild.firstChild, 2, b)
            }, wg = q(wg, "tPTTTL"), tg = function (a, b, c) {
                var d = U(a).width;
                if (b && b.nodeValue && "string" == typeof b.nodeValue)for (var e = b.nodeValue; d > c && e;)e = xg(e), b.nodeValue =
                    e + "...", d = U(a).width
            }, tg = q(tg, "tTW"), vg = function (a, b, c, d) {
                var e = U(a.firstChild).height;
                if (b && b.nodeValue && "string" == typeof b.nodeValue) {
                    var f = Math.round(R(a, !0) / e);
                    d && f < c && (V(a, "height", c * e + "px"), O(a, "ot"));
                    for (d = b.nodeValue; f > c && d;)d = xg(d), b.nodeValue = d + "...", f = Math.round(R(a, !0) / e)
                }
            }, vg = q(vg, "aTL"), xg = function (a) {
                return a.substring(0, a.length - 1)
            }, xg = q(xg, "tS"), yg = function (a, b) {
                return oe(a) < b
            }, yg = q(yg, "sHNE"), zg = function (a) {
                return oa() && !a
            }, zg = q(zg, "rCS"), Ag = function (a) {
                var b = [], c = a.indexOf("<a");
                -1 != c ? b = b.concat([a.substring(0, c + 3), "TARGET", a.substring(c + 2)]) : b.push(a);
                return b
            }, Ag = q(Ag, "pPSTA"), Bg = function (a) {
                for (var b = 0, c; c = a[b]; b++)c.plus_ones && (c.plus_ones = Ag(c.plus_ones))
            }, Bg = q(Bg, "aPOT"), Dg = function (a) {
                a = P(a.document, "table", "ohTbl");
                for (var b = 0, c; c = a[b]; b++)Cg(c), V(c, "visibility", "visible")
            }, Dg = q(Dg, "aOH"), Cg = function (a) {
                a = a.getElementsByTagName("tr");
                for (a = 1 == a.length ? a[0] : null; a;) {
                    var b = P(a, "td", "ohTd");
                    for (1 <= b.length && O(b[0].childNodes[0], "foh"); 1 < b.length;) {
                        var c = U(b[0].getElementsByTagName("span")[0]).height;
                        if (a.offsetHeight >= 2 * c) {
                            c = a.nextSibling;
                            c || (c = a.parentNode.ownerDocument.createElement("tr"), a.parentNode.appendChild(c));
                            var d = b[b.length - 1];
                            if (oa()) {
                                var e = d.cloneNode(!0);
                                c.appendChild(e);
                                a.removeChild(d)
                            } else c.appendChild(d);
                            b.pop()
                        } else break
                    }
                    a = a.nextSibling
                }
            }, Cg = q(Cg, "arOH"), Eg = function (a, b) {
                var c = b[a];
                c || (l.log({message: "frameOptions is undefined for " + a}, "fAU"), c = {});
                return c
            }, Eg = q(Eg, "gFO"), Fg = function (a, b, c, d, e, f) {
                var g = window.ad_json;
                e = Eg(b, e);
                var k = Ab(e);
                if (d.hasOwnProperty("gbrs"))t:{
                    var n =
                        g.ipa, p = f.fillEuData, r = null, s = null, g = d.gbrs;
                    if (g.hasOwnProperty("scrs"))r = sf, s = g.scrs; else if (g.hasOwnProperty("fcrs"))r = rf, s = g.fcrs; else {
                        l.log({message: "PLA grid render spec failed to provide a valid format."}, "crpGc");
                        d = F;
                        break t
                    }
                    for (var D = s.bc, la = D && "#ffffff" == D.toLowerCase(), eb = s.ff, G = g.i, T = [], ma = 0; ma < d.plas.length; ma++)T.push(r(d.plas[ma], s, n, G, k, la, p));
                    d = new H(s.w, s.h);
                    d = 0 == T.length ? F : new uf(T, new H(G + g.c * (d.width + G), G + g.r * (d.height + G)), G, D, eb, T[0].cd(), tf)
                } else l.log({message: "PLA block json failed to provide a known render spec."},
                    "crpBc"), d = F;
                jf(d.o(), a, c);
                d.Gh(a);
                Jf.mb(b + ".w", d.Ih().width);
                d = d.Hh();
                for (k = 0; k < d.length; k++)hg(d[k].lb(a.document), d[k].Bf(a.document), c, f);
                a = jb(b);
                Ie(e, c, a, f)
            }, Fg = q(Fg, "fP"), Hg = function (a, b, c, d, e, f) {
                if (!f.uiExp1)return!1;
                e = Eg(b, e);
                var g = e.amazonTheme;
                if (!Nf.hasOwnProperty(g))return!1;
                jf((0, Nf[g])({ads: d, options: e}), a, c);
                Gg(c, f);
                a = jb(b);
                Ie(e, c, a, f);
                return!0
            }, Hg = q(Hg, "fAA"), Kg = function (a, b, c, d, e, f) {
                var g = window.ad_json;
                e = Eg(b, e);
                var k = g.attr, n = d && d[0] && d[0].type == Kf.td;
                e.isPla = n;
                var p = null, r = null,
                    s = null, D = f.rhsAttribution && e.rightHandAttribution || f.isHighendMobile && !1 !== e.rightHandAttribution, la = D, eb = !1 != e.domainLinkAboveDescription, G = e.type || "ads", T = !1, ma = g.iaa, qa = null, fb = null, hd = g.vw;
                null != ma && (qa = ma.t, fb = ma.b, la = !1);
                e.adsLabel && (s = g.ads_label || null);
                if ("relatedsearch" == G) {
                    if (k)if ("ads" == G)var p = k.u, Oa = e.attributionText, r = k.alt_t && k.alt_t[Oa] ? k.alt_t[Oa] : "Ads" == e.attributionText ? "Ads" : k.t; else"relatedsearch" == G && (r = g.rs_attr.t, p = g.rs_attr.u, e.horizontalFlow && (r += ":"));
                    r || s ? (lf(null, p, r,
                        s, null, D, a, c), T = !0) : (void 0)(a)
                } else {
                    g = null;
                    f && f.suppliedAttribution && e.attributionText ? (G = {t: e.attributionText}, e.attributionHref && (G.u = e.attributionHref)) : G = null;
                    null != G ? k = G : Oa = e.position ? "ad-block-position-" + e.position : void 0;
                    if (null != k) {
                        if (e.detailedAttribution || !1 != e.detailedAttribution && f.megaLabelExp)g = k.t2;
                        p = k.u;
                        r = k.t
                    }
                    if (fb || r || s || g)lf(fb, p, r, s, g, D, a, c, Oa), T = !0
                }
                Bg(d);
                (k = zg(T)) || kf(f, a, c, e, n, la);
                p = yg(c, 300);
                qa = qa && !p ? new ud(qa) : F;
                Ig(d, a, c, e, zb(e, f), !!f.clickableText, eb, qa, hd, f);
                k && kf(f, a, c,
                    e, n, la);
                (la = a.document.getElementById("attrHeader")) && qa != F && V(la, "display", "none");
                Yf(a, b);
                d && d[0] && d[0].sls && jg(a, Bb(e, f), f);
                n && (d = "horizontal" == e.plaFormat, wg(a, d), d && (ug(a), Zf(a, b, f), -1 == ia.indexOf("Opera") && /firefox.2\./i.test(ia) && Jg(a)));
                b = jb(b);
                Ie(e, c, b, f);
                zb(e, f) && Re(c, Ge(e, f), b);
                Gg(c, f);
                Dg(a);
                Df(a, f)
            }, Kg = q(Kg, "fA"), Gg = function (a, b) {
                for (var c = P(a, "div", "adUnit_js"), c = c.concat(P(a, "tr", "adUnit_js")), d = 0, e; e = c[d]; d++)hg(gg(e), e, a, b)
            }, Gg = q(Gg, "aSSTATU"), Mg = function (a, b) {
                var c = window.ad_json,
                    d = {};
                if (c.bs)for (var e = 0, f; f = c.bs[e]; e++)if (f.container == a.container) {
                    d = f;
                    break
                }
                if (c = c.ps)for (var g in c)c.hasOwnProperty(g) && (d[g] = c[g]);
                for (g in d)d.hasOwnProperty(g) && "" !== d[g] && (c = g.replace(/_(.)/g, function (a, b) {
                    return b.toUpperCase()
                }), !b[c] || "clicktrackUrl" == c && a[c] || (a[c] = d[g]));
                "boolean" == typeof a.linkTarget && (a.linkTarget = a.linkTarget ? "_blank" : "_top");
                "number" == typeof a.plaFormat && (a.plaFormat = Mf[a.plaFormat]);
                "number" == typeof a.adIconLocation && (a.adIconLocation = Of[a.adIconLocation]);
                "number" == typeof a.adsafe && (a.adsafe = Pf[a.adsafe]);
                Lg(a, "adBorderSelections");
                Lg(a, "borderSelections");
                Lg(a, "fontFamily");
                Lg(a, "fontFamilyAttribution")
            }, Mg = q(Mg, "fSSS"), Lg = function (a, b) {
                a[b]instanceof Array && (0 == a[b].length ? delete a[b] : a[b] = a[b].join(","))
            }, Lg = q(Lg, "cSLSTS"), Jg = function (a) {
                a = a.document.getElementsByTagName("li");
                for (var b = 0, c; c = a[b]; b++)c.style.display = "-moz-inline-box"
            }, Jg = q(Jg, "fF2TR"), Wf = function (a, b) {
                if (a == b.name)return window;
                var c = null;
                try {
                    if (c = window.parent.frames[a + "|" + window.name])return c
                } catch (d) {
                }
                try {
                    if (c =
                        window.parent.frames[a])return c
                } catch (e) {
                }
                return null
            }, Wf = q(Wf, "gFBN"), Ng = function (a, b) {
                for (var c in S) {
                    var d = S[c];
                    if (0 == d.length)l.log({message: c}, "mPAASH2"); else {
                        var e = Wf(c, a);
                        if (null != e) {
                            var f = null;
                            try {
                                f = e.document.getElementById("adBlock")
                            } catch (g) {
                            }
                            null != f && (d[0].type == Kf.fc ? Fg(e, c, f, d[0], a, b) : Hg(e, c, f, d, a, b) || Kg(e, c, f, d, a, b), Hf[c] = !0, delete S[c])
                        }
                    }
                }
                cg(a, b)
            }, Ng = q(Ng, "mPAASH"), Og = function (a, b, c) {
                return("number" == typeof b && 16 > b || "number" == typeof c && 16 > c) && (a = a.document.getElementById("adBlock")) &&
                    "" != a.innerHTML ? !0 : !1
            }, Og = q(Og, "iCSI"), ag = function (a, b) {
                for (var c = !1, d = [], e = 0; e < a.length; e++) {
                    var f = a[e], g = Uf(f, "adBlock"), k = Vf(f, "adBlock");
                    Og(f, g, k) && (g = null, c = !0);
                    d.push(g)
                }
                c && window.setTimeout(b, 10);
                return d
            }, ag = q(ag, "gFH"), Pg = function (a, b, c) {
                var d;
                d = Math.max.apply(Math, a);
                a = Math.min.apply(Math, a);
                if (d - a > bb)for (a = 0; a < b.length; a++)d = b[a], c[d] = null;
                return c
            }, Pg = q(Pg, "pBDF"), Qg = function (a, b) {
                var c = {}, d = !1, e = [], f = [], g;
                for (g in b)if (g in a) {
                    var k = b[g], n = a[g];
                    "undefined" != typeof n && (n = gb(k, n), null !=
                        n && (c[g] = n, k.a == db && (e.push(n), f.push(g)), d = !0))
                }
                0 < e.length && (c = Pg(e, f, c));
                return d ? c : null
            }, Qg = q(Qg, "vO"), Rg = function (a, b) {
                return a ? Qg(a, b) : null
            }, Rg = q(Rg, "vCO"), Sg = function (a, b) {
                for (var c in b)a[c] = b[c]
            }, Sg = q(Sg, "iCO"), Tg = function (a, b) {
                return(/^slave-\d+-\d+$/.test(a) || /^master-\d+$/.test(a)) && "object" == typeof b
            }, Tg = q(Tg, "iPABO"), Ug = function (a) {
                return ua(a) || {}
            }, Ug = q(Ug, "pNAO"), Vg = function (a, b) {
                var c = Rg(window.CSE_OPTIONS_, b), d = {}, e;
                for (e in a) {
                    var f = a[e];
                    "name" == e ? d[e] = /^slave-\d+-\d+$/.test(f) ||
                        /^master-\d+$/.test(f) ? f : null : Tg(e, f) && (f.adPageId && Mg(f, b), f = Qg(f, b), c && Sg(f, c), d[e] = f, S[e] = [])
                }
                return d
            }, Vg = q(Vg, "vNAO"), V = function (a, b, c) {
                a.style[b] = c
            }, V = q(V, "sS"), hf = function (a) {
                return a.titleLetterSpacing || ""
            }, hf = q(hf, "gTLS"), Wg = function (a, b) {
                for (var c = a.resultsPageBaseUrl, d = a.resultsPageQueryParam, e = 0; e < b.length; e++) {
                    var f = b[e].t, g = b[e].afdt;
                    if (null != f && null != g) {
                        if (!c)throw m("resultsPageBaseUrl resultsPageBaseUrl needs to be set.");
                        var k = new Pa(c);
                        t(k, d, f);
                        t(k, "rsToken", g);
                        b[e].l = Qa(k)
                    }
                }
            },
            Wg = q(Wg, "fRSCL"), Xg = function (a, b, c) {
                var d = b.horizontalFlow ? -1 : b.columns;
                if (2 <= d && !(0 >= d)) {
                    for (var e = [], f = 0, g = 0; g < d; g++)for (var k = Math.ceil((a.length - f) / (d - g)), n = 0; n < k; n++)e[n * d + g] = a[f++];
                    a = e
                }
                b = !b.horizontalFlow;
                b = "" + ('<table cellspacing="0" cellpadding="0"' + (2 <= d || b ? ' width="100%"' : "") + "><tbody><tr>");
                e = a.length;
                for (f = 0; f < e; f++)g = a[f], k = 0 > d || 2 <= d && f < d, b += (0 != f && 0 < d && 0 == f % d ? "</tr><tr>" : "") + '<td class="col' + (f == e - 1 ? " l" : "") + '"' + (2 <= d ? ' width="' + 100 / d + '%"' : "") + ">", n = a.length % d || d, b += '<div class="ad' +
                    (0 == f ? " f" : "") + (k ? " fr" : "") + (f == e - 1 ? " l" : "") + (!k && 2 <= d && f >= a.length - n ? " lr" : "") + '">' + ce({A: g, Mb: !1, Lh: "_top"}) + '<div class="adC radlinkC">' + be({A: g, Mb: !1, Lh: "_top"}) + '<div class="adD"><div class="adStd" ' + (c ? 'data-click-s="' + g.l + '" data-click-trg="_top"' : "") + '><a href="' + g.l + '" class="titleLink" target="_top">' + g.t + "</a></div></div></div></div></td>";
                return b + "</tr></tbody></table>"
            }, Xg = q(Xg, "cRSN"), Ig = function (a, b, c, d, e, f, g, k, n, p) {
                if (!(0 >= a.length)) {
                    var r = Ab(d), s = "";
                    if (p.customAdIconsUnique || p.customAdIcons) {
                        var D =
                            !!p.customAdIconsUnique;
                        null != d.adIconUrl && 0 < d.adIconHeight && 0 < d.adIconWidth ? re(a, d.adIconUrl, d.adIconLocation, D, !0) : null != d.adIconPageUrl && 0 < d.adIconPageHeight && 0 < d.adIconPageWidth && re(a, d.adIconPageUrl, d.adIconPageLocation, D, !1)
                    }
                    Wg(d, a);
                    D = d.type || "ads";
                    if ("ads" == D)if (a && a[0] && a[0].type == Kf.td) {
                        switch (d.plaFormat) {
                            case "horizontal":
                                d = xf;
                                break;
                            case "twoColumn":
                                d = zf;
                                break;
                            case "threeColumn":
                                d = yf;
                                break;
                            default:
                                throw m("No PLA format specified");
                        }
                        s = d({ads: a, j: p, k: r})
                    } else {
                        if (p.sellerFirstBoxLeft)a = Cf({ads: a,
                            j: p, k: r}); else {
                            r = new Nd(d.lines, e, f, g, !Bb(d, p), k, n, !!p.isRtl, r);
                            d = [];
                            for (e = 0; e < a.length; ++e)d.push(gf(a[e], p, r));
                            a = ae({uh: d})
                        }
                        s = a
                    } else"relatedsearch" == D && (s = Xg(a, d, e));
                    jf(s, b, c)
                }
            }, Ig = q(Ig, "cAN"), Yg = function (a) {
                var b = [
                    {index: a.indexOf("{{NUM_START}}"), ab: 13},
                    {index: a.indexOf("{{NUM_END}}"), ab: 11},
                    {index: a.indexOf("{{LINK_START}}"), ab: 14},
                    {index: a.indexOf("{{LINK_END}}"), ab: 12},
                    {index: a.indexOf("{{RATING}}"), ab: 10}
                ];
                b.sort(function (a, b) {
                    return a.index - b.index
                });
                for (var c = [], d = 0, e = 0; -1 == b[e].index;)e++;
                for (; e < b.length; e++)d < b[e].index && c.push(a.substring(d, b[e].index)), d = a.substring(b[e].index, b[e].index + b[e].ab), d = d.replace("{{", "").replace("}}", ""), c.push(d), d = b[e].index + b[e].ab;
                d < a.length && c.push(a.substring(d));
                return c
            }, Yg = q(Yg, "pSSTA"), Zg = function (a) {
                if (a.u && (a.u = Sa(a.u), a.ctc && (a.ctc.u = Sa(a.ctc.u)), a.sls))for (var b = 0; b < a.sls.length; b++)a.sls[b].u = Sa(a.sls[b].u)
            }, Zg = q(Zg, "aDTU"), $g = function (a) {
                a.sr && (a.sr.wt = Yg(a.sr.wt), a.sr.nt = Yg(a.sr.nt))
            }, $g = q($g, "fSRD"), ah = function (a, b) {
                if (!b.isHighendMobile || !ta())return null;
                var c = "100%";
                return q(function () {
                    var b = Ff(!1, window).width, e = window.screen.width, b = b > e && b < 2 * e ? e + "px" : "100%";
                    if (b != c) {
                        c = b;
                        for (var f in Hf)e = Wf(f, a), null == e ? delete Hf[f] : V(e.document.body, "width", b);
                        setTimeout(ea(bg, a), 10)
                    }
                }, "mWS")
            }, ah = q(ah, "gMWS"), bh = function (a, b, c) {
                var d = !1;
                b = Tf(b);
                c.isRtl && Jf.$a("rtl", !0);
                for (var e = {}, f = 0; f < a.length; f++) {
                    var g = a[f], k = g.fn;
                    "slave-0" == k && (d = !0);
                    k = k + "-" + b;
                    if (!S[k]) {
                        var n = {message: k};
                        l.log(n, "pAJ2");
                        S[k] = []
                    }
                    S[k].push(g);
                    g.type != Kf.fc && (g.ctc && g.ctc.coa && !g.u && (g.u = g.ctc.u), Zg(g), g.t && (g.cleanTitle = ne(g.t)), g.v && (g.visDomain = ne(g.v).replace(/\/.*$/, "").replace(/^www\./, ""), g.nonBreakingVisDomain = g.visDomain.replace(/-/g, "&#8209;")), g.type == Kf.Ff && $g(g), c.getVisUrls && g && g.v && (e[ne(g.v)] = 1))
                }
                if (c.getVisUrls) {
                    a = [];
                    for (var p in e)a.push(p);
                    Jf.Qd("v." + b, a.sort().join("|"))
                }
                for (var r in S)p = S[r].length, 0 < p && S[r][0].type == Kf.fc && (p = S[r][0].plas.length), d && /^master/.test(r) ? (0 < p && (n = {message: S[r].length}, l.log(n, "pAJ3")), delete S[r]) : (Jf.$a(r + ".hA", 0 < p),
                    c.getNumAds && Jf.mb(r + ".aC", p), 1 > p && delete S[r]);
                c.getNumAds && Jf.$a("aD." + b, !0);
                Jf.$a("r." + b, !!c.isRejected);
                sb(Jf)
            }, bh = q(bh, "pAJ"), ch = function () {
                var a = [], b;
                for (b in Lf) {
                    var c = window.ad_json[b];
                    if (c) {
                        for (var d = Lf[b], e = 0; e < c.length; e++)c[e].type = d;
                        a = a.concat(c)
                    }
                }
                return a
            }, ch = q(ch, "cAA"), eh = function (a, b, c) {
                var d = null;
                window.XMLHttpRequest ? d = new XMLHttpRequest : window.ActiveXObject && (d = new ActiveXObject("Microsoft.XMLHTTP"));
                if (d)d.open("GET", "/uds/afs?" + c, !0), d.setRequestHeader("Duplicate", "1"), d.onreadystatechange =
                    function () {
                        if (4 == d.readyState) {
                            var c = ua(d.responseText.substr(d.responseText.indexOf("//") + 2));
                            if (!c)throw Error("Unable to use waitForAds");
                            window.ad_json = c;
                            dh(a, b)
                        }
                    }, d.send(); else throw Error("Unable to create the HTTP request object.");
            }, eh = q(eh, "rCAAC"), fh = function (a) {
                var b = window.caps_ || {};
                if (a && a.hasOwnProperty("caps"))for (var c = 0; c < a.caps.length; c++) {
                    var d = a.caps[c], e = d.n, d = d.v;
                    "t" == d ? b[e] = !0 : "f" != d && (b[e] = d)
                }
                window.relay && (b.relay = window.relay);
                window.resultUrl && (b.resultUrl = window.resultUrl);
                window.refererUrl && (b.refererUrl = window.refererUrl);
                return b
            }, fh = q(fh, "pCFJPD"), gh = function (a, b) {
                window.cMF_ = function (a) {
                    /Opera/i.test(ia) ? setTimeout(function () {
                        a()
                    }, 0) : a()
                };
                window.sPH = function () {
                    window.cMF_(ea(bg, a))
                };
                window.mPAASH = function () {
                    window.cMF_(ea(Ng, a, b))
                };
                Ng(a, b);
                var c = ah(a, b);
                c && setInterval(c, 500)
            }, gh = q(gh, "sCFC"), dh = function (a, b) {
                var c = fh(window.ad_json), d = Vg(b, a);
                bh(ch(), d, c);
                gh(d, c);
                window.onresize = ea(cg, d, c)
            }, dh = q(dh, "raa"), hh = function (a) {
                var b = Ug(window.name), c = b ? b.name : null;
                b &&
                b[c] && ib(b[c]) ? eh(a, b, b[c].adRequestUrlParams) : dh(a, b)
            }, hh = q(hh, "init"), ih = function () {
                return function () {
                    window.startTime && Ya(new Xa("ipl", window.startTime), "ol")
                }
            }, ih = q(ih, "onload");
        Q(window, "load", ih());
        var jh = function () {
            Za()
        }, jh = q(jh, "istats");
        u && (Q(window, "unload", jh), setTimeout(jh, 15E3), Ya(u.clone("ipl"), "jlt"));
        Ya(Gf, "pt")
    }
    ;
    var kh = function (a) {
        this.La = a
    };
    kh.prototype.R = function () {
        return this.La.R() + " (one by itself, or multiple in an Array)"
    };
    kh.prototype.K = function (a) {
        a = "array" == ba(a) ? a : [a];
        for (var b = [], c = 0; c < a.length; c++) {
            var d = this.La.K(a[c]);
            if (null == d)return null;
            b.push(d)
        }
        return 0 == b.length ? null : b
    };
    kh.prototype.Q = function (a) {
        a = this.K(a);
        return null == a || 1 > a.length ? null : this.La.Q(a[0])
    };
    var lh = function () {
    };
    lh.prototype.R = function () {
        return"true, false"
    };
    lh.prototype.K = function (a) {
        return"true" == a || !0 == a ? !0 : "false" == a || !1 === a ? !1 : null
    };
    lh.prototype.Q = function (a) {
        a = this.K(a);
        return null == a ? null : a ? 1 : 0
    };
    var v = new lh;
    var W = function (a, b) {
        this.rb = Math.ceil(a);
        this.qb = Math.floor(b)
    };
    W.prototype.R = function () {
        return this.rb + " - " + this.qb
    };
    W.prototype.K = function (a) {
        a = parseInt(a, 10);
        return a >= this.rb && a <= this.qb ? a : null
    };
    W.prototype.Q = function (a) {
        return this.K(a)
    };
    var mh = function (a) {
        this.La = a
    };
    mh.prototype.R = function () {
        return this.La.R() + " (one or more, comma separated)"
    };
    mh.prototype.K = function (a) {
        a = nh(a);
        for (var b = [], c = 0; c < a.length; c++) {
            var d = this.La.K(a[c]);
            null != d && b.push(d)
        }
        return 0 == b.length ? null : b.join(",")
    };
    mh.prototype.Q = function (a) {
        a = nh(a);
        for (var b = 0; b < a.length; b++) {
            var c = this.La.Q(a[b]);
            if (null != c)return c
        }
        return null
    };
    var nh = function (a) {
        if (!da(a))return[];
        a = a.split(",");
        for (var b = [], c = 0; c < a.length; c++)b.push(Kb(a[c]));
        return b
    };
    var X = function (a, b) {
        this.$d = a;
        var c = b || 0;
        this.ae = {};
        for (var d = 0; d < this.$d.length; d++) {
            var e = this.$d[d];
            this.ae[e.toLowerCase()] = new oh(e, c + d)
        }
    }, oh = function (a, b) {
        this.Zh = a;
        this.id = b
    }, ph = new oh(null, null);
    X.prototype.R = function () {
        return this.$d.join(", ") + " (case insensitive)"
    };
    var qh = function (a, b) {
        if (!da(b))return ph;
        b = b.toLowerCase();
        return a.ae.hasOwnProperty(b) ? a.ae[b] : ph
    };
    X.prototype.K = function (a) {
        return qh(this, a).Zh
    };
    X.prototype.Q = function (a) {
        return qh(this, a).id
    };
    var rh = function () {
    }, sh = /^\d+px$/i, th = /^\d+%$/;
    rh.prototype.R = function () {
        return"Width in px (e.g. '500px') or 'auto'"
    };
    rh.prototype.K = function (a) {
        var b = uh(a);
        return null != b ? b + "px" : da(a) && ("auto" == a || th.test(a)) ? a : null
    };
    rh.prototype.Q = function (a) {
        return uh(a)
    };
    var uh = function (a) {
        return"number" == typeof a || da(a) && (!/[^0-9]/.test(a) || sh.test(a)) ? (a = parseInt(a, 10), isNaN(a) ? null : a) : null
    }, vh = new rh;
    var wh = function () {
    };
    wh.prototype.R = function () {
        return"A string"
    };
    wh.prototype.K = function (a) {
        return da(a) ? a : null
    };
    wh.prototype.Q = ec;
    var xh = new wh;
    var yh = function () {
    }, zh = /^(https?):\/\/([a-zA-Z0-9\~\!\@\#\$\&\*\(\)_\+\-\=\:\;\'\,\.\?\/\%]*)$/;
    yh.prototype.R = function () {
        return"An http(s) url"
    };
    yh.prototype.K = function (a) {
        return da(a) && zh.test(a) ? a : null
    };
    yh.prototype.Q = ec;
    var Ah = new yh;
    var Bh = new W(0, 500), Ch = new W(2, 400), Dh = new W(0, 400), Eh = new X(["title-right", "ad-left"]), Fh = new W(8, 50), Gh = new mh(new X("verdana;arial;tahoma;times new roman;georgia;trebuchet ms".split(";"), 1)), Hh = new mh(new X(["right", "left", "top", "bottom"])), Ih = new X(["off", "low", "med", "high"]), Jh = new X(["_top", "_blank"]), Kh = {key: "container", a: xh}, Lh = {key: "adtest", a: v, C: "at", $: !0}, Mh = {key: "adsafe", a: Ih, C: "as", $: !0}, Nh = {key: "clicktrackUrl", a: new kh(Ah)}, Oh = {key: "linkTarget", a: Jh, Ha: "_top", G: !0}, Ph = function (a, b) {
        for (var c in b)b.hasOwnProperty(c) && !a.hasOwnProperty(c) && (a[c] = b[c])
    }, Qh = {role: 2, slaveNumber: 1, masterNumber: 1, cx: 1, cref: 1, bgresponse: 1, sbsignals: 1, gcsc: 1, fexp: 1, forceEx: 1, expflags: 1, userAgent: 1, domainName: 1, adRequestUrlParams: 1, debug: 1, adsRejectedCallback: 1}, Rh = {pubId: 1, propertyCode: 1, container: 2, channel: 1, hl: 1, adtest: 1, adsafe: 1, clicktrackUrl: 1, adLoadedCallback: 1, adsResponseCallback: 1, linkTarget: 1}, Sh = function () {
        var a = {};
        hb(a, [Mh, Lh, Nh, Kh, Oh, {key: "verticalSpacing", a: new W(2, 30)}, {key: "horizontalSpacing", a: new W(4, 12)}, {key: "spacingPlaImageText",
            a: Bh}, {key: "spacingPlaTextPrice", a: Bh}, {key: "lines", a: new W(1, 3), C: "af", Ha: 3}, {key: "colorAdBackground", a: N}, {key: "colorAdBorder", a: N}, {key: "colorAdSeparator", a: N}, {key: "colorText", a: N, G: !0}, {key: "colorTitleLink", a: N, G: !0}, {key: "colorDomainLink", a: N, G: !0}, {key: "colorBackground", a: N, G: !0}, {key: "colorBorder", a: N, G: !0}, {key: "colorAttribution", a: N}, {key: "colorPlusOnes", a: N}, {key: "colorPlaImageBorder", a: $d}, {key: "colorPrice", a: N}, {key: "colorKeyword", a: N}, {key: "colorLocation", a: N}, {key: "colorAnnotation",
            a: N}, {key: "fontFamily", a: Gh, C: "ff", G: !0}, {key: "fontFamilyAttribution", a: Gh, C: "fa"}, {key: "fontSizeTitle", a: db, C: "st", G: !0}, {key: "fontSizeDescription", a: db, C: "sd", G: !0}, {key: "fontSizeDomainLink", a: db, C: "sv", G: !0}, {key: "fontSizeAttribution", a: db, C: "sa", G: !0}, {key: "fontSizePlusOnes", a: db, C: "so", G: !0}, {key: "fontSizePrice", a: db, C: "sp", G: !0}, {key: "fontSizeLocation", a: db, C: "sc", G: !0}, {key: "fontSizeAnnotation", a: db, C: "sn", G: !0}, {key: "titleBold", a: v, G: !0}, {key: "rolloverLinkBold", a: v, G: !0}, {key: "rolloverLinkColor",
            a: N, G: !0}, {key: "rolloverLinkBackgroundColor", a: N, G: !0}, {key: "rolloverLinkUnderline", a: v, G: !0}, {key: "rolloverAdBackgroundColor", a: N, G: !0}, {key: "noTitleUnderline", a: v}, {key: "rightHandAttribution", a: v}, {key: "clickableBackgrounds", a: v}, {key: "attributionText", a: xh}, {key: "attributionHref", a: Ah}, {key: "adsLabel", a: v}, {key: "adBorderSelections", a: Hh}, {key: "borderSelections", a: Hh}, {key: "position", a: new X(["top", "right", "bottom"])}, {key: "cseGoogleHosting", a: new X(["full", "iframe", "partner"])}, {key: "adIconPageUrl",
            a: Ah}, {key: "adIconPageWidth", a: Ch}, {key: "adIconPageHeight", a: Ch}, {key: "adIconPageLocation", a: Eh}, {key: "adIconPageSpacingAbove", a: Dh}, {key: "adIconPageSpacingBefore", a: Dh}, {key: "adIconPageSpacingAfter", a: Dh}, {key: "adIconUrl", a: Ah}, {key: "adIconWidth", a: Ch}, {key: "adIconHeight", a: Ch}, {key: "adIconLocation", a: Eh, Ha: "ad-left"}, {key: "adIconSpacingAbove", a: Dh, G: !0}, {key: "adIconSpacingBefore", a: Dh}, {key: "adIconSpacingAfter", a: Dh}, {key: "adIconSpacingBelow", a: Dh}, {key: "lineHeightTitle", a: Fh, C: "lt"}, {key: "lineHeightDescription",
            a: Fh, C: "ld"}, {key: "lineHeightDomainLink", a: Fh, C: "lv"}, {key: "domainLinkAboveDescription", a: v, C: "va"}, {key: "plaFormat", a: new X(["horizontal", "twoColumn", "threeColumn"], 4), C: "af", Ha: "twoColumn"}, {key: "adRequestUrlParams", a: xh}, {key: "waitForAds", a: v, C: "wa"}, {key: "heightConstrained", a: v, C: "hc"}, {key: "width", a: vh, C: "wi", G: !0}, {key: "detailedAttribution", a: v, C: "da"}, {key: "attributionSpacingBelow", a: new W(0, 40)}, {key: "siteLinks", a: v, C: "sl", $: !0}, {key: "sellerRatings", a: v, C: "sr", $: !0}, {key: "location", a: v, C: "lo",
            $: !0}, {key: "clickToCall", a: v, C: "cc", $: !0}, {key: "longerHeadlines", a: v, C: "lh", $: !0}, {key: "plusOnes", a: v, C: "po", $: !0}, {key: "resultsPageBaseUrl", a: Ah}, {key: "offerHighlight", a: v, C: "oh", $: !0}, {key: "type", a: new X(["ads", "relatedsearch"])}, {key: "columns", a: new W(1, 20), Ha: 1}, {key: "columnSpacing", a: new W(2, 100)}, {key: "horizontalFlow", a: v}, {key: "horizontalAlignment", a: new X(["center", "left", "right"]), Ha: "left"}, {key: "resultsPageQueryParam", a: xh, Ha: "query"}, {key: "adPageId", a: new W(0, 4294967295)}, {key: "imageExtension",
            a: v, C: "ri", $: !0}, {key: "amazonTheme", a: new X(["numbered", "bulleted"])}, {key: "amazonGrayBullets", a: v}]);
        return a
    };
    if (window.IS_GOOGLE_AFS_IFRAME_) {
        var Th = function () {
            hh(Sh())
        };
        0 == ia.indexOf("Opera") || -1 == ia.indexOf("MSIE") && -1 == ia.indexOf("Trident") ? Th() : window.onload = Th
    }
    ;
    if (!window.IS_GOOGLE_AFS_IFRAME_) {
        var Uh = function () {
        };
        h = Uh.prototype;
        h.Gd = function () {
            return this.Of(!1)
        };
        h.md = function () {
            return this.Of(!0)
        };
        h.Wc = function () {
            return null
        };
        h.gd = function () {
            return"uds_ads_only"
        };
        h.hd = function () {
            return!1
        };
        h.Of = function (a) {
            var b = window.google && window.google.loader && window.google.loader.ServiceBase ? window.google.loader.ServiceBase : serviceBase_;
            a = "/afs" + (a ? "/i" : "");
            1 == window.googleSynd && "//afs.googlesyndication.com/uds" == b && (b = "//ads.google.com/uds");
            return new Pa(b ? b + a :
                "//www.google.com/uds" + a)
        };
        var Vh = function () {
        };
        h = Vh.prototype;
        h.Gd = function () {
            return new Pa((window.dafeBase_ || "//domains.googlesyndication.com") + "/apps/domainpark/domainpark.cgi?")
        };
        h.md = function () {
            return null
        };
        h.Wc = function () {
            return null
        };
        h.gd = function () {
            return"caf"
        };
        h.hd = function () {
            return!0
        };
        var Wh = function () {
        };
        h = Wh.prototype;
        h.Gd = function () {
            return new Pa("//" + (window.google && window.google.loader && window.google.loader.GoogleLocale ? window.google.loader.GoogleLocale : "www.google.com") + "/cse")
        };
        h.md =
            function () {
                return null
            };
        h.Wc = function () {
            return null
        };
        h.gd = function () {
            return"uds_ads_only"
        };
        h.hd = function () {
            return!1
        }
    }
    ;
    var Xh = function (a) {
        var b = Math.random;
        this.wh = a;
        this.xh = Wb;
        this.zh = Ba;
        this.yh = b
    };
    if (!window.IS_GOOGLE_AFS_IFRAME_) {
        var Y = function (a, b, c, d, e, f, g, k) {
            this.ga = a;
            this.Pb = b;
            this.Td(c, d, e, f, g, k)
        }, Y = q(Y, "ab");
        Y.$h = new Xa("pjsp");
        Y.Kg = "gcsc";
        Y.Gg = "21404";
        Y.Jg = "20606";
        Y.ef = ["", "7000105", "7000106", "7000107", "7000108"];
        Y.Fa = "longerHeadlines";
        Y.qd = "n";
        Y.xf = "w";
        Y.uf = "p";
        Y.Dh = "a";
        Y.vf = "pn";
        Y.wf = "pt";
        Y.Sh = 6E4;
        Y.Lg = "on";
        Y.prototype.Vb = !1;
        Y.Te = "";
        Y.gf = Math.floor(100 * Math.random());
        Y.Ng = "7000126";
        Y.Og = "7000127";
        Y.Qg = "7000128";
        Y.Pg = /(^|,|\+)csa_(use|no)_rs(_aa)?($|,|\+)/;
        Y.Zb = {query: "q", type: "type",
            format: "format", ads: "ad", pubId: "client", channel: "channel", adtest: "adtest", hl: "hl", adsafe: "adsafe", adPage: "adpage", adpage: "adpage", oe: "oe", ie: "ie", output: "output", role: "r", referer: "referer", rurl: "rurl", res_url: "res_url", v: "v", source: "source", safe: "safe", num: "num", fexp: "fexp", jsei: "jsei", nocache: "nocache", cx: "cx", cref: "cref", bgresponse: "bgresponse", sbsignals: "sbsignals", gcse_nc: "gcse_nc", queryLink: "qry_lnk", queryContext: "qry_ctxt", adExtensions: {arg: "adext", siteLinks: "as1", location: "l1", sellerRatings: "sr1",
                clickToCall: "ctc1"}, allwcallad: "allwcallad", adstyle: "adstyle", adlh: "adlh", numRepeated: "adrep", gl: "gl", gcs: "gcs", gr: "gr", gm: "gm", preload: "preload", forceEx: "expid", e: "e", expflags: "expflags", userAgent: "useragent", afdToken: "afdt", plusOnes: "po", colorKeyword: "clkwd", debug: "debug", location: "lo", domainName: "domain_name", maxTermLength: "max_radlink_len", adPageId: "apid", theme: "theme", gtin: "gtin", brand: "brand", mpn: "mpn"};
        Y.Ig = "UTF-8";
        Y.Hg = "UTF-8";
        Y.zf = 2;
        Y.di = 2;
        Y.nf = "googleSynd";
        Y.af = {};
        Y.Mg = 80;
        h = Y.prototype;
        h.ed = function (a) {
            if (this.P)return Y.qd + "0";
            var b = a.minTop + this.ua, c = a.maxTop + this.ta, d = a.narrow + this.wa, e = a.wide + this.ya, f = a.plas + this.va, g = a.topPlas + this.xa;
            a = 0 < b ? Y.Dh + b : "";
            var k = 0 < c ? Y.uf + c : "", d = 0 < d ? Y.qd + d : "", e = 0 < e ? Y.xf + e : "", f = 0 < f ? Y.vf + f : "", g = 0 < g ? Y.wf + g : "";
            if (c && b > c)throw m("Cannot request more minTop ads than maxTop.");
            return e + d + k + a + f + g
        };
        h.ed = q(Y.prototype.ed, "cAA");
        h.fd = function (a, b) {
            var c = this.O(a);
            b && 0 < b.length && (b.splice(0, 0, c), c = b.join("|"));
            return c
        };
        h.fd = q(Y.prototype.fd, "cFAM");
        h.O = function (a) {
            this.wa =
                    a.number && !a[Y.Fa] ? a.number : 0;
            this.ya = a.number && a[Y.Fa] ? a.number : 0;
            this.ua = a.minTop;
            this.ta = a.maxTop;
            this.va = a.plas;
            this.xa = a.topPlas;
            this.wa || this.ua || this.ta || this.ya || this.va || this.xa || (a[Y.Fa] ? this.ya = Y.zf : this.wa = Y.zf);
            var b = this.wa || this.ya, c = this.ta || this.ua, d = this.va || this.xa;
            if (b && c)throw m("Cannot request standard and top ads in the same ad block.");
            if (b && d)throw m("Cannot request standard and PLA ads in the same ad block.");
            if (c && d)throw m("Cannot request top and PLA ads in the same ad block.");
            if (this.va && this.xa)throw m("Cannot request top PLAs and standard PLAs in the same ad block.");
            if (this.P && 0 != a.slaveNumber && !a.firstAdBlock && (this.ta || this.ua))throw m("Only the first ad block can have top ads.");
            var e;
            this.ta || this.ua ? e = Y.uf : this.wa ? e = Y.qd : this.ya ? e = Y.xf : this.va ? e = Y.vf : this.xa && (e = Y.wf);
            return e + (this.ta || this.ua || this.wa || this.ya || this.va || this.xa || 0)
        };
        h.O = q(Y.prototype.O, "cFA");
        h.yd = function () {
            return this.Rg
        };
        h.yd = q(Y.prototype.yd, "gFA");
        h.Qb = function (a) {
            mb(a) && (a.siteLinks = !1 !=
                a.siteLinks, a.sellerRatings = !1 != a.sellerRatings, a.clickToCall = !1 != a.clickToCall);
            return a = Y.ge(a)
        };
        h.Qb = q(Y.prototype.Qb, "sDIUP");
        h.Va = function () {
        };
        h.Va = q(Y.prototype.Va, "vRSO");
        h.$c = function (a, b, c, d) {
            var e = {}, f;
            for (f in this.Pb)if (this.Pb.hasOwnProperty(f))if (2 != this.Pb[f] || a[f])"undefined" != typeof a[f] && null != a[f] && (e[f] = a[f]); else throw m("Missing option '" + f + "'.");
            this.P = "m" != a.role;
            if (!this.P) {
                var g;
                i:{
                    var k = window.location.href.match(/[?&]rsToken=([^&]*)/);
                    if (k && k[1])try {
                        g = decodeURIComponent(k[1]);
                        break i
                    } catch (n) {
                    }
                    g = null
                }
                g && (e.afdToken = g)
            }
            e.adLoadedCallback = a.adLoadedCallback || a.callback || null;
            e.adsRejectedCallback = a.adsRejectedCallback || null;
            e.oe = e.oe || Y.Ig;
            e.ie = e.ie || Y.Hg;
            e.number = Y.Ga(e.number, 0);
            e.minTop = Y.Ga(e.minTop, 0);
            e.maxTop = Y.Ga(e.maxTop, 0);
            e.plas = Y.Ga(e.plas, 0);
            e.topPlas = Y.Ga(e.topPlas, 0);
            1 == e.slaveNumber && e.numRepeated && e.longerHeadlines && (e.longerHeadlines = !1);
            e.fexp = (e.fexp ? e.fexp + "," : "") + (e.gcsc ? Y.Jg : Y.Gg);
            (g = window.googlev3ex) && !isNaN(parseInt(g, 10)) && (e.fexp += "," + g);
            g = parseInt(window._googCsaX,
                10) || 0;
            0 < g && g < Y.ef.length && (e.jsei = g, e.fexp += "," + Y.ef[g]);
            g = parseInt(window._googCsaExp, 10) || 0;
            0 < g && (e.fexp += "," + g);
            e.channel && "string" == typeof e.channel && (g = e.channel.match(Y.Pg)) && (e.fexp += "," + ("use" == g[2] ? Y.Qg : "_aa" == g[3] ? Y.Og : Y.Ng));
            e.forceEx ? e.e = "ForceExperiment" : 0 === e.forceEx && (e.e = "0");
            e.gcsc && (5 > Y.gf ? e.fexp += ",37108" : 10 > Y.gf && (e.fexp += ",37109"), "top" == a.position && (e.maxTop = a.number, e.longerHeadlines = !1, e.number = null));
            e.format = this.P ? this.O(e) : this.fd(e, b);
            this.Rg = e.format;
            e.ads = this.ed(c);
            e.nocache = [Math.floor(1E3 * Math.random()), (new Date).getTime()].join("");
            e.num = "0";
            e.output = this.eb.gd();
            this.eb.hd() ? (e.domainName || (e.domainName = window.document.domain), e.domainName = e.domainName.substring(0, Y.Mg)) : e.domainName = "";
            e.gcsc && (e.source = Y.Kg);
            e.v = ib(e) ? "4" : "3";
            e.adPageId && (e.pubId = e.propertyCode, e.adPageId = gb(this.ga.adPageId, e.adPageId));
            0 == e.pubId.indexOf("partner-") && (this.Qa("Do not add 'partner-' to the pubId."), e.pubId = e.pubId.substring(8));
            e = this.Qb(e);
            !e.titleBold || !0 !== e.titleBold &&
                1 != e.titleBold ? e.titleBold && delete e.titleBold : e.titleBold = 1;
            mb(e) && (!e.maxTop && !e.minTop || e.hasOwnProperty(Y.Fa) || (e[Y.Fa] = !0));
            if (!this.P) {
                b = e[Y.Fa] || !1;
                for (f in d)d.hasOwnProperty(f) && (b = b || d[f].g[Y.Fa]);
                b && (e.adlh = Y.Lg)
            }
            e.clickToCall && (e.allwcallad = 1);
            this.Va(a);
            return e
        };
        h.$c = q(Y.prototype.$c, "vASDO");
        Y.Ga = function (a, b) {
            var c = parseInt(a, 10);
            return isNaN(c) ? b : c
        };
        Y.Ga = q(Y.Ga, "tIOD");
        Y.Nb = function (a) {
            a = parseInt(a, 10);
            return!isNaN(a) && 0 <= a
        };
        Y.Nb = q(Y.Nb, "iNNN");
        Y.Ug = {hc: 1, lh: 1, oh: 1, pa: 1};
        Y.Yb = function (a, b) {
            var c = b.C, d = b.a.Q(a);
            return null != d && Y.Nb(d) ? Y.Ug.hasOwnProperty(c) ? d ? c.charAt(0) + c.charAt(1).toUpperCase() : c : c + d : ""
        };
        Y.Yb = q(Y.Yb, "gPFO");
        h = Y.prototype;
        h.Ad = function (a) {
            var b = [], c;
            for (c in a)a.hasOwnProperty(c) && c in this.ga && this.ga[c].C && b.push(Y.Yb(a[c], this.ga[c]));
            return b.join("")
        };
        h.Ad = q(Y.prototype.Ad, "oTPP");
        h.nb = function (a, b) {
            var c = [], d;
            for (d in a)!(a.hasOwnProperty(d) && d in this.ga && this.ga[d].C) || d in b && b[d] == a[d] || c.push(Y.Yb(a[d], this.ga[d]));
            return c.join("")
        };
        h.nb = q(Y.prototype.nb,
            "oTBP");
        h.Tc = function (a, b, c) {
            var d = a.v ? a.v : "3", e = this.zd(a, b, c);
            if (0 == b.length)return["uv", d, e, this.nb(a, {}), "-"].join("");
            c.pubId = a.pubId;
            c = this.Qb(c);
            var f = this.Ad(c), f = ["uv", d, e, f].join(""), d = [];
            d.push(this.nb(a, c));
            for (a = 0; e = b[a]; a++)e.g.slaveNumber && 0 != e.g.slaveNumber && d.push(this.nb(e.g, c));
            return[f, d.join("-")].join("-")
        };
        h.Tc = q(Y.prototype.Tc, "cUIP");
        h.zd = function (a, b, c) {
            if (a.colorTitleLink || a.colorDomainLink || c.colorTitleLink || c.colorDomainLink)return"cs1";
            for (a = 0; c = b[a]; a++)if (c.g.colorTitleLink ||
                c.g.colorDomainLink)return"cs1";
            return""
        };
        h.zd = q(Y.prototype.zd, "cCTPP");
        Y.ge = function (a) {
            for (var b = ["fontSizeTitle", "fontSizeDescription", "fontSizeDomainLink", "fontSizeAttribution"], c = 0; c < b.length; c++) {
                var d = b[c];
                if (a[d]) {
                    var e = "string" == typeof a[d] ? parseInt(a[d].replace("px", ""), 10) : a[d], e = e > cb ? cb : e, e = 8 > e ? 8 : e;
                    a[d] = e + "px"
                }
            }
            return a
        };
        Y.ge = q(Y.ge, "vFS");
        h = Y.prototype;
        h.Uc = function (a, b) {
            var c, d, e = this.eb.Gd();
            if (e) {
                this.Fd(a, e);
                1 == window[Y.nf] ? t(e, "bsl", 3) : 15 == b.googleAltLoader && t(e, "bsl", 2);
                if (!this.P) {
                    var f =
                        window;
                    d = document;
                    c = new Date;
                    var g;
                    var k = f || window;
                    try {
                        g = k.history.length
                    } catch (n) {
                        g = 0
                    }
                    t(e, "u_his", g);
                    t(e, "u_tz", -c.getTimezoneOffset());
                    t(e, "dt", c.getTime());
                    t(e, "u_w", f.screen.width);
                    t(e, "u_h", f.screen.height);
                    c = Ff(!0, f);
                    t(e, "biw", c.width);
                    t(e, "bih", c.height);
                    f.top != f && (c = Ff(!1, f), t(e, "isw", c.width), t(e, "ish", c.height));
                    d.body ? (c = (g = !f.scrollY && "CSS1Compat" != d.compatMode) ? d.body.scrollWidth : d.body.offsetWidth, d = g ? d.body.scrollHeight : d.body.offsetHeight) : d = c = -1;
                    t(e, "psw", c);
                    t(e, "psh", d);
                    var p;
                    if (f.top ==
                        f)p = 0; else {
                        f = f.top;
                        try {
                            var r;
                            if (r = !!f && null != f.location.href)t:{
                                try {
                                    We(f.foo);
                                    r = !0;
                                    break t
                                } catch (s) {
                                }
                                r = !1
                            }
                            p = r
                        } catch (D) {
                            p = !1
                        }
                        p = p ? 1 : 2
                    }
                    t(e, "frm", p)
                }
                t(e, "uio", this.Te);
                t(e, "rurl", b.location.href, !0);
                t(e, Y.Zb.referer, b.document.referrer, !0);
                a.referrer && t(e, "optref", a.referrer, !0)
            }
            return e
        };
        h.Uc = q(Y.prototype.Uc, "cU");
        h.Xd = function (a, b, c) {
            var d = a.arg, e = [], f;
            for (f in a)"arg" != f && a.hasOwnProperty(f) && b.hasOwnProperty(f) && b[f] && e.push(a[f]);
            0 < e.length && t(c, d, e.join(","))
        };
        h.Xd = q(Y.prototype.Xd, "aSCSA");
        h.Fd =
            function (a, b) {
                for (var c in a)if (a.hasOwnProperty(c) && Y.Zb.hasOwnProperty(c)) {
                    var d = Y.Zb[c], e = a[c];
                    "clkwd" == d && (e = "t");
                    if ("mvtb" != d || "low" == e || "medium" == e || "high" == e)"type" == d && (e = Ua[a[c]]), t(b, d, e)
                }
                this.Xd(Y.Zb.adExtensions, a, b)
            };
        h.Fd = q(Y.prototype.Fd, "aOTU");
        h.fa = function () {
            return"s" == this.g.role ? ["slave", this.g.slaveNumber, this.g.masterNumber].join("-") : ["master", this.g.masterNumber].join("-")
        };
        h.fa = q(Y.prototype.fa, "gFN");
        h.Vc = function (a, b, c, d) {
            var e = {};
            e.name = b;
            a = c.concat([a]);
            b = d.concat([b]);
            for (d = 0; d < a.length; d++) {
                c = a[d];
                var f = this.ga, g = {}, k = void 0;
                for (k in f)if (f.hasOwnProperty(k) && !f[k].$) {
                    var n = c[k], p = f[k].Ha;
                    "undefined" == typeof n || "container" == k && "object" == typeof n ? "undefined" != typeof p && (g[k] = p) : g[k] = n
                }
                e[b[d]] = g
            }
            a = [];
            xa(new va, e, a);
            return a.join("")
        };
        h.Vc = q(Y.prototype.Vc, "gFNAOAJ");
        h.Ld = function (a, b, c) {
            document.getElementById(a) && l.log({message: a}, "dI");
            var d = document.createElement("iframe");
            d.frameBorder = 0;
            d.marginWidth = 0;
            d.marginHeight = 0;
            d.vspace = 0;
            d.hspace = 0;
            d.setAttribute("allowTransparency",
                "true");
            d.scrolling = "no";
            d.style.visibility = "hidden";
            d.width = "100%";
            d.style.height = "0px";
            d.name = b;
            d.id = a;
            oa() ? (d.style.display = "none", this.jc(d), d.src = c, d.style.display = "") : (d.src = c, this.jc(d));
            try {
                d.contentWindow.name = b
            } catch (e) {
            }
            return d
        };
        h.Ld = q(Y.prototype.Ld, "gAI");
        h.jb = function (a, b, c) {
            a = this.Ld(a, b, c);
            this.Ef = new Xa(this.P ? "sipl" : "mipl");
            Q(a, "load", this.Md());
            this.P || this.Nd(a)
        };
        h.jb = q(Y.prototype.jb, "iAI");
        h.nd = function (a) {
            document.write('<script src="' + a + '" type="text/javascript">\x3c/script>')
        };
        h.nd = q(Y.prototype.nd, "sAP");
        h.Zc = function () {
            var a = this.g;
            this.Qa("Selected Options:");
            for (var b in a)a.hasOwnProperty(b) && this.Qa(b + ": " + a[b])
        };
        h.Zc = q(Y.prototype.Zc, "pO");
        h.jc = function (a) {
            this.Aa.style.fontWeight = "normal";
            this.Aa.style.textAlign = "center";
            this.Aa.innerHTML = "";
            this.Aa.appendChild(a)
        };
        h.jc = q(Y.prototype.jc, "aI");
        h.Yc = function () {
            var a = {}, b;
            for (b in this.g)this.g.hasOwnProperty(b) && (a[b] = this.g[b]);
            a.ads = "n0";
            a[""] = "";
            a.slaveNumber = "0";
            a.role = "s";
            a = Yh(this.ga, this.Pb, a);
            Z[a.fa()] = a;
            this.za.splice(0, 0, a);
            a = document.createElement("div");
            document.body.appendChild(a);
            a.style.height = "0px";
            a.style.visibility = "hidden";
            this.g.container = a;
            this.mf = this.g.preload = !0
        };
        h.Yc = q(Y.prototype.Yc, "pM");
        h.ud = function () {
            self.Lf = self.Lf || (new Date).getTime();
            return(new Date).getTime() - self.Lf > Y.Sh ? !0 : !1
        };
        h.ud = q(Y.prototype.ud, "iTU");
        h.Td = function (a, b, c, d, e, f) {
            this.xa = this.va = this.ya = this.ua = this.ta = this.wa = 0;
            this.eb = b;
            if ("function" == typeof a.logHandler || "function" == typeof a.dbg)this.Xc = "function" == typeof a.logHandler ? a.logHandler : a.dbg;
            this.za = f || null;
            this.$e = c || null;
            this.g = this.$c(a, d, e, f);
            this.gg = new Xh(this.g.pubId);
            this.Kb() || this.P || !document.body || Zh() || this.Yc();
            this.Xc && this.Zc();
            this.Te = null == this.$e ? "" : this.Tc(this.g, this.za, this.$e);
            if (this.fb = this.P && this.eb.Wc() || this.Uc(this.g, window))if (this.Qa("New url: " + Qa(this.fb)), this.Ea = this.id = this.gb = this.fa(), this.fb.Jb = this.gb, this.Z = Qa(this.fb), !this.P) {
                a = [];
                b = [];
                for (c = 0; c < this.za.length; c++)a.push(this.za[c].fa()), b.push(this.za[c].g);
                ib(this.g) && (this.g.adRequestUrlParams = this.Z.substr(this.Z.indexOf("?") + 1));
                this.Ea = this.Vc(this.g, this.gb, b, a);
                Y.af[this.Z] ? l.log({message: this.Z}, "dAU") : Y.af[this.Z] = !0
            }
        };
        h.Td = q(Y.prototype.Td, "i");
        h.Wb = function () {
            var a = this;
            a.Sb = new Xa("plabl");
            var b = q(function () {
                if (!a.Kb())return!1;
                a.Sb = a.Sb.clone("iabl");
                a.wd(a.g.container);
                a.g.width && !a.mf && ("auto" == a.g.width ? a.Aa.style.width = "100%" : Y.Nb(a.g.width) && (a.Aa.style.width = a.g.width));
                a.vd();
                return!0
            }, "mA");
            b() || (this.Af = window.setInterval(function () {
                if (b())clearInterval(a.Af);
                else if (a.ud())throw clearInterval(a.Af), m('container "' + a.g.container + '" does not exist.');
            }, 5))
        };
        h.Wb = q(Y.prototype.Wb, "cI");
        h.vd = function () {
            if (this.fb) {
                var a = this.eb.md();
                if (a && Qa(a) && ib(this.g)) {
                    !0 === this.g.debug && t(a, "debug", !0);
                    "1" == window[Y.nf] && t(a, "bsl", "3");
                    a.Jb = this.gb;
                    var b = Qa(a);
                    if (this.P)this.jb(this.id, this.Ea, b); else {
                        var c = this;
                        window.google.renderCsaAds = function () {
                            c.jb(c.id, c.Ea, b)
                        };
                        this.nd(this.Z)
                    }
                } else this.jb(this.id, this.Ea, this.Z)
            }
        };
        h.vd = q(Y.prototype.vd, "mA");
        h.Md = function () {
            var a =
                this;
            return q(function () {
                a.Ef && Ya(a.Ef, "ol")
            }, "iLC")
        };
        h.Md = q(Y.prototype.Md, "gILC");
        h.Nd = function (a) {
            var b = "" + this.g.masterNumber, c = new x(b);
            c.S("aD." + b, z, $h);
            var d = null;
            this.mf || (d = this.fa(), c.S(d + ".hA", z, ai), c.S(d + ".h", y, bi), c.S(d + ".w", y, ci), c.S(d + ".aC", y));
            c.S("v." + b, ob, di);
            this.g.hasOwnProperty("gcsc") && this.g.gcsc && c.S("r." + b, z, ei);
            if (this.za)for (b = 0; b < this.za.length; b++)d = this.za[b].fa(), c.S(d + ".hA", z, ai), c.S(d + ".h", y, bi), c.S(d + ".aC", y);
            ub(c, a)
        };
        h.Nd = q(Y.prototype.Nd, "iFS");
        h.ee = function () {
            if (!this.Vb) {
                this.Vb = !0;
                var a = this.g.container, b = this.g.noAdLoadedCallback;
                b && fi(b, a, !1);
                (b = this.g.adLoadedCallback) && fi(b, a, !1)
            }
        };
        h.ee = q(Y.prototype.ee, "nNA");
        h.xd = function (a, b) {
            a.width = "100%";
            a.style.visibility = 0 < b ? "visible" : "hidden";
            a.style.height = b + "px";
            this.Aa.style.height = b + "px"
        };
        h.xd = q(Y.prototype.xd, "sIH");
        h.fe = function (a) {
            this.Aa.style.width = a + "px"
        };
        h.fe = q(Y.prototype.fe, "sCW");
        h.Cd = function (a) {
            var b = gi(this.fa(), !0);
            b && (this.xd(b, a), !this.Vb && 0 < a && (this.Vb = !0, this.Sb && Ya(this.Sb, "alt"), window.googleNDT_ && !hi &&
                u && (hi = !0, Ya(u, "palt")), a = this.gg, .01 < a.yh() || (b = new Pa("https://www.google.com/afs/gen_204"), t(b, "client", a.wh), t(b, "output", "uds_ads_only"), t(b, "zx", a.xh()), a.zh(Qa(b))), (a = this.g.adLoadedCallback) && fi(a, this.g.container, !0)))
        };
        h.Cd = q(Y.prototype.Cd, "rIS");
        h.Kb = function () {
            var a = this.g.container;
            return"string" == typeof a ? (a = document.getElementById(a), !!a) : "string" == typeof a.innerHTML ? !0 : !1
        };
        h.Kb = q(Y.prototype.Kb, "dCE");
        h.wd = function (a) {
            "string" == typeof a && (a = document.getElementById(a));
            this.Aa = a
        };
        h.wd = q(Y.prototype.wd, "sC");
        h.Qa = function (a) {
            this.Xc && this.Xc(a)
        };
        h.Qa = q(Y.prototype.Qa, "m")
    }
    ;
    if (!window.IS_GOOGLE_AFS_IFRAME_) {
        var ii = function (a, b, c, d, e, f, g, k) {
            Y.call(this, a, b, c, d, e, f, g, k)
        }, ii = q(ii, "JB");
        ga(ii, Y);
        ii.prototype.O = function () {
            return""
        };
        ii.prototype.O = q(ii.prototype.O, "cFA_cJB");
        ii.prototype.Va = function (a) {
            if (!a.brand && a.mpn || a.brand && !a.mpn)throw m("Both brand and mpn should be present in the request.");
        };
        ii.prototype.Va = q(ii.prototype.Va, "vRSO_cJB")
    }
    ;
    if (!window.IS_GOOGLE_AFS_IFRAME_) {
        var ji = function (a, b, c, d, e, f, g, k) {
            Y.call(this, a, b, c, d, e, f, g, k)
        }, ji = q(ji, "pb");
        ga(ji, Y);
        ji.prototype.O = function () {
            return""
        };
        ji.prototype.O = q(ji.prototype.O, "cFA_PB")
    }
    ;
    if (!window.IS_GOOGLE_AFS_IFRAME_) {
        var $ = function (a, b, c, d, e, f, g, k) {
            Y.call(this, a, b, c, d, e, f, g, k)
        }, $ = q($, "rsb");
        ga($, Y);
        $.Vh = "r";
        $.Wh = 10;
        $.prototype.O = function (a) {
            var b = a.relatedSearches;
            b || 0 === b || (b = a.number, b || 0 === b || (b = $.Wh));
            return $.Vh + b
        };
        $.prototype.O = q($.prototype.O, "cFA_RS")
    }
    ;
    if (!window.IS_GOOGLE_AFS_IFRAME_)var Yh = function (a, b, c, d, e, f, g) {
        c.relatedSearches ? c.type = "relatedsearch" : c.type || (c.type = "ads");
        if ("relatedsearch" == c.type)return new $(a, b, c, new Vh, d, e, f, g);
        if ("ads" == c.type)return new Y(a, b, c, c.gcsc ? new Wh : new Uh, d, e, f, g);
        if ("plas" == c.type)return new ji(a, b, c, new Uh, d, e, f, g);
        if ("singleProduct" == c.type)return new ii(a, b, c, new Uh, d, e, f, g);
        throw m("invalid block type: " + c.type);
    }, Yh = q(Yh, "nAB");
    var ki = function () {
        this.options = {}
    }, li = function () {
        this.Vd = {};
        this.If = [];
        this.Jf = []
    };
    if (!window.IS_GOOGLE_AFS_IFRAME_)var mi = function (a) {
        if (2 > a.length)throw m("No options specified.");
        return 1 < a.length && a[1]instanceof Array ? [a[0]].concat(a[1]) : Array.prototype.slice.call(a, 0)
    }, mi = q(mi, "ppata"), oi = function (a, b, c, d) {
        c = mi(c);
        var e = ia.toLowerCase();
        if (-1 == e.indexOf("series60") && -1 == e.indexOf("series 60")) {
            d && (c[0].type = d);
            d = new li;
            for (var e = c[0], f = null, g = 1; g < c.length; g++) {
                var k = f = new ki, n = e, p = c[g], r = void 0;
                for (r in p)p.hasOwnProperty(r) && (k.options[r] = p[r]);
                for (r in n)n.hasOwnProperty(r) &&
                ("longerHeadlines" != r || k.options.maxTop || k.options.minTop) && (k.options[r] = n[r]);
                f.options.relatedSearches ? d.Jf.push(f) : d.If.push(f)
            }
            for (var s in e)e.hasOwnProperty(s) && (d.Vd[s] = e[s]);
            ni(a, b, d.Vd, d.If, {});
            ni(a, b, d.Vd, d.Jf)
        }
    }, oi = q(oi, "aasi"), ni = function (a, b, c, d) {
        if (0 != d.length) {
            var e = [], f = [], g = {maxTop: 0, narrow: 0, minTop: 0, wide: 0, plas: 0, topPlas: 0}, k = Zh();
            k || pi++;
            for (var n = d.length - 1; 0 <= n; n--) {
                var p = d[n].options;
                0 == n || k ? (k && (e = [], g = {maxTop: 0, narrow: 0, minTop: 0, wide: 0, plas: 0, topPlas: 0}, pi++), p.role = "m",
                    p.masterNumber = pi, p.fexp = xi.join(","), p = Yh(a, b, p, c, e, g, f)) : (p.role = "s", p.slaveNumber = n, p.masterNumber = pi, p = Yh(a, b, p), e.splice(0, 0, p.yd()), f.splice(0, 0, p), g.narrow += p.wa, g.maxTop += p.ta, g.minTop += p.ua, g.wide += p.ya, g.plas += p.va, g.topPlas += p.xa);
                Z[p.fa()] = p
            }
            a = "master-" + pi;
            var n = new RegExp("slave-[0-9]+-" + pi), r;
            for (r in Z)n.test(r) && (Z[r].Ea += "|" + Z[a].Ea);
            for (n = d.length - 1; 0 <= n; n--)d = ["slave", n, pi].join("-"), Z.hasOwnProperty(d) && Z[d].Wb();
            Z.hasOwnProperty(a) ? Z[a].Wb() : l.log({message: "Missing ad block for " +
                a}, "cAFOMM")
        }
    }, ni = q(ni, "cAFO"), gi = function (a, b) {
        var c = document.getElementById(a);
        if (!c && b) {
            var d = [];
            try {
                for (var e = document.getElementsByTagName("iframe"), f = 0; f < e.length; f++) {
                    var g = e[f];
                    try {
                        d.push(["N=" + g.name + "ID=" + g.id])
                    } catch (k) {
                    }
                }
            } catch (n) {
            }
            l.log({message: "iframe name: " + a + ". existing frames: " + d.join(",") + ". num masters: " + pi}, "gAFBN2")
        }
        return c
    }, gi = q(gi, "gAFBN"), ai = function (a, b, c, d) {
        d || Z[c.split(".")[0]].ee()
    }, ai = q(ai, "hAC"), ei = function (a, b, c, d) {
        (a = Z["master-" + b]) && a.g && (a = a.g.adsRejectedCallback) &&
        yi(a, d)
    }, ei = q(ei, "aRC"), bi = function (a, b, c, d) {
        a = Z[c.split(".")[0]];
        a.Cd(d);
        a && a.g && a.g.iframeHeightCallback && zi(a.g.iframeHeightCallback, 0 < d ? d : 0)
    }, bi = q(bi, "hC"), ci = function (a, b, c, d) {
        Z[c.split(".")[0]].fe(d)
    }, ci = q(ci, "wC"), Ai = function (a, b) {
        var c = {}, d;
        for (d in Z)if (Z.hasOwnProperty(d)) {
            var e = Z[d];
            e.g && e.g.masterNumber == b && "string" == typeof e.g.container && (c[e.g.container] = a.Bd(d + ".aC"))
        }
        return c
    }, Ai = q(Ai, "gAC"), $h = function (a, b) {
        var c = Z["master-" + b];
        if (c && c.g && c.g.adsResponseCallback) {
            var d = Ai(a, b);
            Bi(c.g.adsResponseCallback,
                d)
        }
    }, $h = q($h, "aCC"), di = function (a, b, c, d) {
        (a = Z["master-" + b]) && a.g && a.g.visibleUrlsCallback && Ci(a.g.visibleUrlsCallback, d ? d.split("|") : [])
    }, di = q(di, "vUC"), Di = null, Zh = function () {
        if (null != Di)return Di;
        if (6 != ja(ka))return Di = !1;
        var a;
        if (2 < window.location.host.split(".").length)a = window.location.host.split(".").slice(1).join("."), a = a.replace(/:\d*/, ""); else return Di = !0;
        window.google.disallowedSameDomain_ = !1;
        var b = document.createElement("iframe"), c = document.createElement("iframe");
        b.style.display = "none";
        c.style.display = "none";
        var d = document.getElementsByTagName("head")[0];
        d.appendChild(b);
        d.appendChild(c);
        try {
            var e = b.contentWindow.document, f = c.contentWindow.document
        } catch (g) {
            e = b.document, f = c.document
        }
        if (e.domain == a)return Di = !0;
        e.open();
        e.domain = a;
        e.write("<script>function test() {}\x3c/script>");
        e.close();
        f.open();
        f.write("<script>var theParent = window.parent;\x3c/script>");
        f.domain = a;
        f.write("<script>try{window.parent.frames[" + (window.frames.length - 2) + "].location} catch(e){theParent.google.disallowedSameDomain_ = true;}\x3c/script>");
        f.close();
        Di = window.google.disallowedSameDomain_;
        b.parentNode.removeChild(b);
        c.parentNode.removeChild(c);
        return Di
    }, Zh = q(Zh, "dBDSDIC"), pi = 0, Z = {}, hi = !1, Ei = function (a, b, c) {
        c = 1 - (c || Math.random)();
        if (c < b * a.length) {
            try {
                var d = new Uint16Array(1);
                window.crypto.getRandomValues(d);
                c = d[0] / 65536
            } catch (e) {
                c = Math.random()
            }
            return a[Math.floor(c * a.length)]
        }
        return null
    }, Ei = q(Ei, "pE"), xi = dc([Ei([2631601, 2631602], .05)], ca), fi = function (a, b, c) {
        a(b, c)
    }, fi = q(fi), yi = function (a, b) {
        a(b)
    }, yi = q(yi), Bi = function (a, b) {
        a(b)
    }, Bi =
        q(Bi), Ci = function (a, b) {
        a(b)
    }, Ci = q(Ci), zi = function (a, b) {
        a(b)
    }, zi = q(zi), Fi = function () {
        u && Ya(u, "ol")
    }, Fi = q(Fi, "rCPL"), Hi = function () {
        u && !u.Yh && (u.Yh = !0, Q(window, "load", Fi), setTimeout(Gi, 15E3));
        Q(window, "unload", Gi)
    }, Hi = q(Hi, "sCEL"), Gi = function () {
        Za()
    }, Gi = q(Gi, "sCS"), Ii = function (a) {
        a && a()
    }, Ii = q(Ii), Ji = function () {
        u && (Hi(), Ya(Y.$h, "pt"), Ya(u, "jlt"))
    }, Ji = q(Ji, "sCOLT");
    var Ki = function (a) {
        var b;
        b = {};
        hb(b, [Mh, Lh, Nh, Kh, Oh, {key: "width", a: new W(0, 1E4), C: "wi"}, {key: "height", a: new W(0, 1E4), C: "he"}, {key: "promoted", a: v, C: "pa"}]);
        var c = {query: 2, width: 2, height: 2, promoted: 1, theme: 1};
        Ph(c, Qh);
        Ph(c, Rh);
        oi(b, c, arguments, "plas")
    }, Ki = q(Ki, "cmpp");
    if (!window.IS_GOOGLE_AFS_IFRAME_) {
        var Li = function (a) {
            var b = Sh(), c = {query: 2, number: 1, oe: 1, ie: 1, maxTop: 1, minTop: 1, plas: 1, topPlas: 1, gcse_nc: 1, queryLink: 1, queryContext: 1, siteLinks: 1, location: 1, sellerRatings: 1, adPage: 1, adpage: 1, clickToCall: 1, adstyle: 1, numRepeated: 1, gl: 1, gcs: 1, gr: 1, gm: 1, longerHeadlines: 1, afdToken: 1, plusOnes: 1, colorKeyword: 1, relatedSearches: 1, offerHighlight: 1, adPageId: 1, heightConstrained: 1, imageExtension: 1, referrer: 1, lines: 1, width: 1, noAdLoadedCallback: 1, iframeHeightCallback: 1, visibleUrlsCallback: 1,
                verticalSpacing: 1, horizontalSpacing: 1, spacingPlaImageText: 1, spacingPlaTextPrice: 1, colorAdBackground: 1, colorAdBorder: 1, colorAdSeparator: 1, colorText: 1, colorTitleLink: 1, colorDomainLink: 1, colorBackground: 1, colorBorder: 1, colorAttribution: 1, colorPlusOnes: 1, colorPlaImageBorder: 1, colorPrice: 1, colorLocation: 1, colorAnnotation: 1, fontFamily: 1, fontFamilyAttribution: 1, fontSizeTitle: 1, fontSizeDescription: 1, fontSizeDomainLink: 1, fontSizeAttribution: 1, fontSizePlusOnes: 1, fontSizePrice: 1, fontSizeLocation: 1, fontSizeAnnotation: 1,
                titleBold: 1, rolloverLinkBold: 1, rolloverLinkColor: 1, rolloverLinkBackgroundColor: 1, rolloverLinkUnderline: 1, rolloverAdBackgroundColor: 1, noTitleUnderline: 1, attributionSpacingBelow: 1, clickableBackgrounds: 1, rightHandAttribution: 1, attributionText: 1, attributionHref: 1, adsLabel: 1, adBorderSelections: 1, borderSelections: 1, position: 1, cseGoogleHosting: 1, adIconPageUrl: 1, adIconPageWidth: 1, adIconPageHeight: 1, adIconPageLocation: 1, adIconPageSpacingAbove: 1, adIconPageSpacingBefore: 1, adIconPageSpacingAfter: 1, adIconUrl: 1,
                adIconWidth: 1, adIconHeight: 1, adIconLocation: 1, adIconSpacingAbove: 1, adIconSpacingBefore: 1, adIconSpacingAfter: 1, adIconSpacingBelow: 1, lineHeightTitle: 1, lineHeightDescription: 1, lineHeightDomainLink: 1, domainLinkAboveDescription: 1, plaFormat: 1, detailedAttribution: 1, waitForAds: 1, type: 1, resultsPageBaseUrl: 1, columns: 1, columnSpacing: 1, horizontalFlow: 1, horizontalAlignment: 1, resultsPageQueryParam: 1, maxTermLength: 1, amazonTheme: 1, amazonGrayBullets: 1};
            Ph(c, Qh);
            Ph(c, Rh);
            oi(b, c, arguments)
        }, Li = q(Li, "cmpc"), Ni = function () {
            var a =
                window._googCsa, b = null, c = null;
            a && (b = a.q, c = a.t);
            window._googCsa = function () {
                Mi(arguments)
            };
            c && (window._googCsa.t = c);
            if (b && 0 < b.length)for (a = 0; a < b.length; a++)Mi(b[a])
        }, Ni = q(Ni, "cmps"), Mi = function (a) {
            if (a && 1 < a.length)if ("ads" == a[0] || "plas" == a[0]) {
                var b = "plas" == a[0] ? Ki : Li;
                3 == a.length ? new b(a[1], a[2]) : new b(a[1], Array.prototype.slice.call(a, 2))
            } else"jsLoadedCallback" == a[0] && Ii(a[1])
        }, Mi = q(Mi, "cmpe");
        window.google = window.google || {};
        window.google.ads = window.google.ads || {};
        window.google.ads.search = window.google.ads.search ||
        {};
        window.google.ads.search.Ads || (window.google.ads.search.Ads = Li, Ji(), Ni())
    }
    ;
    google.loader.loaded({"module": "ads", "version": "3.0", "components": ["search"]});
    google.loader.eval.ads = function () {
        eval(arguments[0]);
    };
    if (google.loader.eval.scripts && google.loader.eval.scripts['ads']) {
        (function () {
            var scripts = google.loader.eval.scripts['ads'];
            for (var i = 0; i < scripts.length; i++) {
                google.loader.eval.ads(scripts[i]);
            }
        })();
        google.loader.eval.scripts['ads'] = null;
    }
})();