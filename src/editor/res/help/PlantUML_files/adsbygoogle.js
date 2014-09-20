(function () {
    var p = this, aa = function (a) {
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
    }, ba = function (a, b, c) {
        return a.call.apply(a.bind, arguments)
    }, ca = function (a, b, c) {
        if (!a)throw Error();
        if (2 < arguments.length) {
            var d = Array.prototype.slice.call(arguments, 2);
            return function () {
                var c = Array.prototype.slice.call(arguments);
                Array.prototype.unshift.apply(c, d);
                return a.apply(b, c)
            }
        }
        return function () {
            return a.apply(b, arguments)
        }
    }, r = function (a, b, c) {
        r = Function.prototype.bind && -1 != Function.prototype.bind.toString().indexOf("native code") ?
            ba : ca;
        return r.apply(null, arguments)
    };
    var v = (new Date).getTime();
    var da = function () {
    }, y = function (a, b, c) {
        switch (typeof b) {
            case "string":
                ea(b, c);
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
                if (b instanceof Array) {
                    var d = b.length;
                    c.push("[");
                    for (var e = "", f = 0; f < d; f++)c.push(e), y(a, b[f], c), e = ",";
                    c.push("]");
                    break
                }
                c.push("{");
                d = "";
                for (e in b)b.hasOwnProperty(e) && (f = b[e], "function" != typeof f && (c.push(d), ea(e, c), c.push(":"), y(a, f, c), d =
                    ","));
                c.push("}");
                break;
            case "function":
                break;
            default:
                throw Error("Unknown type: " + typeof b);
        }
    }, z = {'"': '\\"', "\\": "\\\\", "/": "\\/", "\b": "\\b", "\f": "\\f", "\n": "\\n", "\r": "\\r", "\t": "\\t", "\x0B": "\\u000b"}, fa = /\uffff/.test("\uffff") ? /[\\\"\x00-\x1f\x7f-\uffff]/g : /[\\\"\x00-\x1f\x7f-\xff]/g, ea = function (a, b) {
        b.push('"');
        b.push(a.replace(fa, function (a) {
            if (a in z)return z[a];
            var b = a.charCodeAt(0), e = "\\u";
            16 > b ? e += "000" : 256 > b ? e += "00" : 4096 > b && (e += "0");
            return z[a] = e + b.toString(16)
        }));
        b.push('"')
    };
    var ga = /&/g, ha = /</g, ia = />/g, ja = /"/g, ka = /'/g, la = /\x00/g, A = {"\x00": "\\0", "\b": "\\b", "\f": "\\f", "\n": "\\n", "\r": "\\r", "\t": "\\t", "\x0B": "\\x0B", '"': '\\"', "\\": "\\\\"}, D = {"'": "\\'"}, F = function (a, b) {
        return a < b ? -1 : a > b ? 1 : 0
    };
    var G = function (a) {
        G[" "](a);
        return a
    };
    G[" "] = function () {
    };
    var H = function (a) {
        try {
            var b;
            if (b = !!a && null != a.location.href)t:{
                try {
                    G(a.foo);
                    b = !0;
                    break t
                } catch (c) {
                }
                b = !1
            }
            return b
        } catch (d) {
            return!1
        }
    };
    var I = document, J = window;
    var K = function (a, b) {
        for (var c in a)Object.prototype.hasOwnProperty.call(a, c) && b.call(null, a[c], c, a)
    }, L = function (a) {
        return!!a && "function" == typeof a && !!a.call
    }, ma = function (a, b) {
        if (!(2 > arguments.length))for (var c = 1, d = arguments.length; c < d; ++c)a.push(arguments[c])
    }, M = function (a, b) {
        if (!(1E-4 > Math.random())) {
            var c = Math.random();
            if (c < b) {
                try {
                    var d = new Uint16Array(1);
                    window.crypto.getRandomValues(d);
                    c = d[0] / 65536
                } catch (e) {
                    c = Math.random()
                }
                return a[Math.floor(c * a.length)]
            }
        }
        return null
    }, na = function (a) {
        a.google_unique_id ?
            ++a.google_unique_id : a.google_unique_id = 1
    }, N = function (a) {
        a = a.google_unique_id;
        return"number" == typeof a ? a : 0
    }, oa = function (a) {
        var b = a.length;
        if (0 == b)return 0;
        for (var c = 305419896, d = 0; d < b; d++)c ^= (c << 5) + (c >> 2) + a.charCodeAt(d) & 4294967295;
        return 0 < c ? c : 4294967296 + c
    }, O = function (a, b) {
        return b.getComputedStyle ? b.getComputedStyle(a, null) : a.currentStyle
    };
    var pa = {google_analytics_domain_name: !0, google_analytics_uacct: !0}, qa = function (a) {
        a.google_page_url && (a.google_page_url = String(a.google_page_url));
        var b = [];
        K(a, function (a, d) {
            if (null != a) {
                var e;
                try {
                    var f = [];
                    y(new da, a, f);
                    e = f.join("")
                } catch (g) {
                }
                e && ma(b, d, "=", e, ";")
            }
        });
        return b.join("")
    };
    var P = function (a) {
        a = parseFloat(a);
        return isNaN(a) || 1 < a || 0 > a ? 0 : a
    }, Q = function (a, b) {
        return/^true$/.test(a) ? !0 : /^false$/.test(a) ? !1 : b
    }, ra = /^([\w-]+\.)*([\w-]{2,})(\:[0-9]+)?$/, sa = function (a, b) {
        if (!a)return b;
        var c = a.match(ra);
        return c ? c[0] : b
    };
    var ta = P("0.15"), ua = P("0.0"), va = P("0.01"), wa = P("0.001"), xa = P("0.001"), ya = P("0.001"), za = P("0.001"), Aa = P("0.2"), Ba = Q("true", !0);
    var Ca = Q("false", !1);
    var Da = {"120x90": !0, "160x90": !0, "180x90": !0, "200x90": !0, "468x15": !0, "728x15": !0};
    var Ea = {rectangle: 1, horizontal: 2, vertical: 4}, Fa = /^([0-9.]+)px$/, Ga = /^([0-9.]+)$/, Ha = [
        {width: 970, height: 90, format: 2, i: 9},
        {width: 728, height: 90, format: 2, i: 4},
        {width: 468, height: 60, format: 2, i: 7},
        {width: 336, height: 280, format: 1, i: 1},
        {width: 320, height: 50, format: 2, i: 3},
        {width: 300, height: 600, format: 4, i: 2},
        {width: 300, height: 250, format: 1, i: 5},
        {width: 250, height: 250, format: 1, i: 11},
        {width: 234, height: 60, format: 2, i: 8},
        {width: 200, height: 200, format: 1, i: 13},
        {width: 180, height: 150, format: 1, i: 10},
        {width: 160, height: 600,
            format: 4, i: 6},
        {width: 125, height: 125, format: 1, i: 15},
        {width: 120, height: 600, format: 4, i: 12},
        {width: 120, height: 240, format: 4, i: 14}
    ], Ia = function (a) {
        return(a = Fa.exec(a)) ? Number(a[1]) : null
    }, Ja = function (a) {
        return(a = Ia(a)) ? Math.round(a) : null
    }, R = function (a, b, c) {
        for (var d = 0; d < c.length; d++) {
            var e = "google_ad_" + c[d];
            if (!b.hasOwnProperty(e)) {
                var f = Ja(a[c[d]]);
                null != f && (b[e] = f)
            }
        }
    }, Ka = function (a) {
        var b = a.style.width;
        a.style.width = "100%";
        var c = a.offsetWidth;
        a.style.width = b;
        return c
    }, La = function (a, b) {
        return a <= b
    }, Na =
        function (a, b, c) {
            if ("auto" == c)return c = Ma(a), c = Math.min(1200, c), .25 >= b / c ? 4 : 3;
            b = 0;
            for (var d in Ea)-1 != c.indexOf(d) && (b |= Ea[d]);
            return b
        }, Oa = function (a, b, c, d) {
        c = Ha.sort(c);
        for (var e = 0; e < c.length; e++)if (b(c[e].width, a) && c[e].format & d)return c[e];
        return null
    }, Pa = function (a, b) {
        return b.width - a.width || b.height - a.height
    }, Qa = function (a, b, c, d) {
        b = Na(c, a, b);
        d && (d.google_responsive_formats = b);
        return Oa(a, La, Pa, b)
    }, Ra = function (a, b) {
        return a.i - b.i
    }, Sa = function (a, b) {
        var c = a / b;
        return.66 <= c && 1 >= c
    }, Ta = function (a, b, c, d) {
        b = Na(c, a, b);
        d && (d.google_responsive_formats = b);
        d = Oa(a, Sa, Ra, b);
        return null == d ? Oa(a, La, Pa, b) : d
    }, Ma = function (a) {
        a = a.document;
        return a.documentElement.clientWidth || a.body.clientWidth
    }, Ua = {B: "E1", v: "C", u: "C320", A: "E320"}, Va = {w: "SE", t: "SC"};
    var Wa = {M: 1, N: 8, O: 16, L: 24};
    var Xa = !!window.google_async_iframe_id, S = Xa && window.parent || window, Ya = function (a, b, c) {
        var d = ["<iframe"], e;
        for (e in a)a.hasOwnProperty(e) && ma(d, e + "=" + a[e]);
        d.push('style="left:0;position:absolute;top:0;"');
        d.push("></iframe>");
        b = "border:none;height:" + c + "px;margin:0;padding:0;position:relative;visibility:visible;width:" + b + "px;background-color:transparent";
        return['<ins style="display:inline-table;', b, '"><ins id="', a.id + "_anchor", '" style="display:block;', b, '">', d.join(" "), "</ins></ins>"].join("")
    };
    var Za = !0, $a = {}, ab = function (a) {
        var b = a.toString();
        a.name && -1 == b.indexOf(a.name) && (b += ": " + a.name);
        a.message && -1 == b.indexOf(a.message) && (b += ": " + a.message);
        if (a.stack) {
            a = a.stack;
            var c = b;
            try {
                -1 == a.indexOf(c) && (a = c + "\n" + a);
                for (var d; a != d;)d = a, a = a.replace(/((https?:\/..*\/)[^\/:]*:\d+(?:.|\n)*)\2/, "$1");
                b = a.replace(/\n */g, "\n")
            } catch (e) {
                b = c
            }
        }
        return b
    }, db = function (a, b, c, d) {
        var e = bb, f, g = Za;
        try {
            f = b()
        } catch (h) {
            try {
                var n = ab(h);
                b = "";
                h.fileName && (b = h.fileName);
                var m = -1;
                h.lineNumber && (m = h.lineNumber);
                g = e(a,
                    n, b, m, c)
            } catch (k) {
                try {
                    var s = ab(k);
                    a = "";
                    k.fileName && (a = k.fileName);
                    c = -1;
                    k.lineNumber && (c = k.lineNumber);
                    bb("pAR", s, a, c, void 0, void 0)
                } catch (E) {
                    cb({context: "mRE", msg: E.toString() + "\n" + (E.stack || "")}, void 0)
                }
            }
            if (!g)throw h;
        } finally {
            if (d)try {
                d()
            } catch (B) {
            }
        }
        return f
    }, bb = function (a, b, c, d, e, f) {
        var g = {};
        if (e)try {
            e(g)
        } catch (h) {
        }
        g.context = a;
        g.msg = b.substring(0, 512);
        c && (g.file = c);
        0 < d && (g.line = d.toString());
        g.url = I.URL.substring(0, 512);
        g.ref = I.referrer.substring(0, 512);
        eb(g);
        cb(g, f);
        return Za
    }, cb = function (a, b) {
        try {
            if (Math.random() <
                (b || .01)) {
                var c = "/pagead/gen_204?id=jserror" + fb(a), d = "http" + ("https:" == J.location.protocol ? "s" : "") + "://pagead2.googlesyndication.com" + c, c = d = d.substring(0, 2E3);
                J.google_image_requests || (J.google_image_requests = []);
                var e = J.document.createElement("img");
                e.src = c;
                J.google_image_requests.push(e)
            }
        } catch (f) {
        }
    }, eb = function (a) {
        var b = a || {};
        K($a, function (a, d) {
            b[d] = J[a]
        })
    }, gb = function (a, b) {
        return function () {
            var c = arguments;
            return db(a, function () {
                return b.apply(void 0, c)
            }, void 0, void 0)
        }
    }, hb = function (a, b) {
        return gb(a,
            b)
    }, fb = function (a) {
        var b = "";
        K(a, function (a, d) {
            if (0 === a || a)b += "&" + d + "=" + ("function" == typeof encodeURIComponent ? encodeURIComponent(a) : escape(a))
        });
        return b
    };
    var ib = null, jb = function () {
        if (!ib) {
            for (var a = window, b = a, c = 0; a != a.parent;)if (a = a.parent, c++, H(a))b = a; else break;
            ib = b
        }
        return ib
    };
    Za = !Q("false", !1);
    $a = {client: "google_ad_client", format: "google_ad_format", slotname: "google_ad_slot", output: "google_ad_output", ad_type: "google_ad_type", async_oa: "google_async_for_oa_experiment", dimpr: "google_always_use_delayed_impressions_experiment", peri: "google_top_experiment", pse: "google_pstate_expt"};
    var kb = function (a, b, c) {
        c || (c = Ca ? "https" : "http");
        return[c, "://", a, b].join("")
    };
    var T = null;
    var U;
    t:{
        var lb = p.navigator;
        if (lb) {
            var mb = lb.userAgent;
            if (mb) {
                U = mb;
                break t
            }
        }
        U = ""
    }
    var V = function (a) {
        return-1 != U.indexOf(a)
    };
    var nb = V("Opera") || V("OPR"), W = V("Trident") || V("MSIE"), ob = V("Gecko") && -1 == U.toLowerCase().indexOf("webkit") && !(V("Trident") || V("MSIE")), pb = -1 != U.toLowerCase().indexOf("webkit"), qb = function () {
            var a = p.document;
            return a ? a.documentMode : void 0
        }, rb = function () {
            var a = "", b;
            if (nb && p.opera)return a = p.opera.version, "function" == aa(a) ? a() : a;
            ob ? b = /rv\:([^\);]+)(\)|;)/ : W ? b = /\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/ : pb && (b = /WebKit\/(\S+)/);
            b && (a = (a = b.exec(U)) ? a[1] : "");
            return W && (b = qb(), b > parseFloat(a)) ? String(b) : a
        }(), sb = {},
        tb = function (a) {
            if (!sb[a]) {
                for (var b = 0, c = String(rb).replace(/^[\s\xa0]+|[\s\xa0]+$/g, "").split("."), d = String(a).replace(/^[\s\xa0]+|[\s\xa0]+$/g, "").split("."), e = Math.max(c.length, d.length), f = 0; 0 == b && f < e; f++) {
                    var g = c[f] || "", h = d[f] || "", n = RegExp("(\\d*)(\\D*)", "g"), m = RegExp("(\\d*)(\\D*)", "g");
                    do {
                        var k = n.exec(g) || ["", "", ""], s = m.exec(h) || ["", "", ""];
                        if (0 == k[0].length && 0 == s[0].length)break;
                        b = F(0 == k[1].length ? 0 : parseInt(k[1], 10), 0 == s[1].length ? 0 : parseInt(s[1], 10)) || F(0 == k[2].length, 0 == s[2].length) || F(k[2],
                            s[2])
                    } while (0 == b)
                }
                sb[a] = 0 <= b
            }
        }, ub = p.document, vb = ub && W ? qb() || ("CSS1Compat" == ub.compatMode ? parseInt(rb, 10) : 5) : void 0;
    var wb;
    if (!(wb = !ob && !W)) {
        var xb;
        if (xb = W)xb = W && 9 <= vb;
        wb = xb
    }
    wb || ob && tb("1.9.1");
    W && tb("9");
    var yb = function (a, b, c) {
        if (!a || !b || !c)return"XS";
        var d;
        if (Xa && !H(S)) {
            for (d = "." + I.domain; 2 < d.split(".").length && !H(S);)I.domain = d = d.substr(d.indexOf(".") + 1), S = window.parent;
            H(S) || (S = window)
        }
        d = S;
        for (a = a.parentElement; a;) {
            try {
                var e = a.style
            } catch (f) {
            }
            var g = a.parentElement;
            if (e) {
                var h = Ia(e.width), n = Ia(e.height), m = g && 1 == g.childNodes.length;
                if (n && (m || h && b >= h) && c < n)return"NS";
                if (h && (m || n && c >= n)) {
                    if (b < h)return"NS"
                } else if (h || n)return"NS"
            }
            if ((a = O(a, d)) && ("absolute" == a.position || "fixed" == a.position))return"absolute" ==
                a.position ? "CA" : "CF";
            a = g;
            if (!a)try {
                a = d.frameElement;
                var k = d.parent;
                k && k != d && (d = k)
            } catch (s) {
                return"XS"
            }
        }
        return"CS"
    };
    var X = function (a) {
        this.k = a;
        a.google_iframe_oncopy || (a.google_iframe_oncopy = {handlers: {}, upd: r(this.F, this)});
        this.s = a.google_iframe_oncopy
    }, zb;
    var Y = "var i=this.id,s=window.google_iframe_oncopy,H=s&&s.handlers,h=H&&H[i],w=this.contentWindow,d;try{d=w.document}catch(e){}if(h&&d&&(!d.body||!d.body.firstChild)){if(h.call){setTimeout(h,0)}else if(h.match){try{h=s.upd(h,i)}catch(e){}w.location.replace(h)}}";
    /[\x00&<>"']/.test(Y) && (-1 != Y.indexOf("&") && (Y = Y.replace(ga, "&amp;")), -1 != Y.indexOf("<") && (Y = Y.replace(ha, "&lt;")), -1 != Y.indexOf(">") && (Y = Y.replace(ia, "&gt;")), -1 != Y.indexOf('"') && (Y = Y.replace(ja, "&quot;")), -1 != Y.indexOf("'") && (Y = Y.replace(ka, "&#39;")), -1 != Y.indexOf("\x00") && (Y = Y.replace(la, "&#0;")));
    zb = Y;
    X.prototype.set = function (a, b) {
        this.s.handlers[a] = b;
        this.k.addEventListener && this.k.addEventListener("load", r(this.C, this, a), !1)
    };
    X.prototype.C = function (a) {
        a = this.k.document.getElementById(a);
        try {
            var b = a.contentWindow.document;
            if (a.onload && b && (!b.body || !b.body.firstChild))a.onload()
        } catch (c) {
        }
    };
    X.prototype.F = function (a, b) {
        var c = Ab("rx", a), d;
        t:{
            if (a && (d = a.match("dt=([^&]+)")) && 2 == d.length) {
                d = d[1];
                break t
            }
            d = ""
        }
        d = (new Date).getTime() - d;
        c = c.replace(/&dtd=(\d+|M)/, "&dtd=" + (1E4 > d ? d + "" : "M"));
        this.set(b, c);
        return c
    };
    var Ab = function (a, b) {
        var c = new RegExp("\\b" + a + "=(\\d+)"), d = c.exec(b);
        d && (b = b.replace(c, a + "=" + (+d[1] + 1 || 1)));
        return b
    };
    var Z, $ = function (a) {
        this.l = [];
        this.k = a || window;
        this.j = 0;
        this.m = null;
        this.n = 0
    }, Bb = function (a, b) {
        this.D = a;
        this.r = b
    };
    $.prototype.H = function (a, b) {
        0 != this.j || 0 != this.l.length || b && b != window ? this.q(a, b) : (this.j = 2, this.p(new Bb(a, window)))
    };
    $.prototype.q = function (a, b) {
        this.l.push(new Bb(a, b || this.k));
        Cb(this)
    };
    $.prototype.I = function (a) {
        this.j = 1;
        if (a) {
            var b = hb("sjr::timeout", r(this.o, this, !0));
            this.m = this.k.setTimeout(b, a)
        }
    };
    $.prototype.o = function (a) {
        a && ++this.n;
        1 == this.j && (null != this.m && (this.k.clearTimeout(this.m), this.m = null), this.j = 0);
        Cb(this)
    };
    $.prototype.J = function () {
        return!(!window || !Array)
    };
    $.prototype.K = function () {
        return this.n
    };
    $.prototype.nq = $.prototype.H;
    $.prototype.nqa = $.prototype.q;
    $.prototype.al = $.prototype.I;
    $.prototype.rl = $.prototype.o;
    $.prototype.sz = $.prototype.J;
    $.prototype.tc = $.prototype.K;
    var Cb = function (a) {
        var b = hb("sjr::tryrun", r(a.G, a));
        a.k.setTimeout(b, 0)
    };
    $.prototype.G = function () {
        if (0 == this.j && this.l.length) {
            var a = this.l.shift();
            this.j = 2;
            var b = hb("sjr::run", r(this.p, this, a));
            a.r.setTimeout(b, 0);
            Cb(this)
        }
    };
    $.prototype.p = function (a) {
        this.j = 0;
        a.D()
    };
    var Db = function (a) {
        try {
            return a.sz()
        } catch (b) {
            return!1
        }
    }, Eb = function (a) {
        return!!a && ("object" == typeof a || "function" == typeof a) && Db(a) && L(a.nq) && L(a.nqa) && L(a.al) && L(a.rl)
    }, Fb = function () {
        if (Z && Db(Z))return Z;
        var a = jb(), b = a.google_jobrunner;
        return Eb(b) ? Z = b : a.google_jobrunner = Z = new $(a)
    }, Gb = function (a, b) {
        Fb().nq(a, b)
    }, Hb = function (a, b) {
        Fb().nqa(a, b)
    };
    var Ib = Xa ? 1 == N(J) : !N(J), Jb = function () {
        var a = G("script"), b;
        b = sa("", "pagead2.googlesyndication.com");
        return["<", a, ' src="', kb(b, "/pagead/js/r20140715/r20140417/show_ads_impl.js", ""), '"></', a, ">"].join("")
    }, Kb = function (a, b, c, d) {
        return function () {
            var e = !1;
            d && Fb().al(3E4);
            var f = a.document.getElementById(b);
            f && !H(f.contentWindow) && 3 ==
                a.google_top_js_status && (a.google_top_js_status = 6);
            try {
                if (H(a.document.getElementById(b).contentWindow)) {
                    var g = a.document.getElementById(b).contentWindow, h = g.document;
                    h.body && h.body.firstChild || (h.open(), g.google_async_iframe_close = !0, h.write(c))
                } else {
                    var n = a.document.getElementById(b).contentWindow, m;
                    f = c;
                    f = String(f);
                    if (f.quote)m = f.quote(); else {
                        g = ['"'];
                        for (h = 0; h < f.length; h++) {
                            var k = f.charAt(h), s = k.charCodeAt(0), E = h + 1, B;
                            if (!(B = A[k])) {
                                var x;
                                if (31 < s && 127 > s)x = k; else {
                                    var l = k;
                                    if (l in D)x = D[l]; else if (l in
                                        A)x = D[l] = A[l]; else {
                                        var q = l, C = l.charCodeAt(0);
                                        if (31 < C && 127 > C)q = l; else {
                                            if (256 > C) {
                                                if (q = "\\x", 16 > C || 256 < C)q += "0"
                                            } else q = "\\u", 4096 > C && (q += "0");
                                            q += C.toString(16).toUpperCase()
                                        }
                                        x = D[l] = q
                                    }
                                }
                                B = x
                            }
                            g[E] = B
                        }
                        g.push('"');
                        m = g.join("")
                    }
                    n.location.replace("javascript:" + m)
                }
                e = !0
            } catch (t) {
                n = jb().google_jobrunner, Eb(n) && n.rl()
            }
            e && (e = Ab("google_async_rrc", c), (new X(a)).set(b, Kb(a, b, e, !1)))
        }
    }, Lb = function (a) {
        var b = ["<iframe"];
        K(a, function (a, d) {
            null != a && b.push(" " + d + '="' + a + '"')
        });
        b.push("></iframe>");
        return b.join("")
    }, Mb = function (a, b, c, d) {
        d = d ? '"' : "";
        var e = d + "0" + d;
        a.width = d + b + d;
        a.height = d + c + d;
        a.frameborder = e;
        a.marginwidth = e;
        a.marginheight = e;
        a.vspace = e;
        a.hspace = e;
        a.allowtransparency = d + "true" + d;
        a.scrolling = d + "no" + d;
        a.allowfullscreen = d + "true" + d
    }, Ob = function (a, b, c) {
        Nb(a, b, c, function (a, b, f) {
            a = a.document;
            for (var g = b.id, h = 0; !g || a.getElementById(g);)g = "aswift_" + h++;
            b.id = g;
            b.name = g;
            g = Number(f.google_ad_width);
            h = Number(f.google_ad_height);
            16 == f.google_reactive_ad_format ? (f = a.createElement("div"), f.innerHTML = Ya(b, g, h), c.appendChild(f.firstChild)) :
                c.innerHTML = Ya(b, g, h);
            return b.id
        })
    }, Nb = function (a, b, c, d) {
        var e = G("script"), f = {};
        Mb(f, b.google_ad_width, b.google_ad_height, !0);
        f.onload = '"' + zb + '"';
        d = d(a, f, b);
        var f = b.google_override_format || !Da[b.google_ad_width + "x" + b.google_ad_height] && "aa" == b.google_loader_used ? M(["c", "e"], Aa) : null, g = b.google_ad_output, h = b.google_ad_format;
        h || "html" != g && null != g || (h = b.google_ad_width + "x" + b.google_ad_height, "e" == f && (h += "_as"));
        g = !b.google_ad_slot || b.google_override_format || !Da[b.google_ad_width + "x" + b.google_ad_height] &&
            "aa" == b.google_loader_used;
        h = h && g ? h.toLowerCase() : "";
        b.google_ad_format = h;
        for (var h = [b.google_ad_slot, b.google_ad_format, b.google_ad_type, b.google_ad_width, b.google_ad_height], g = [], n = 0, m = c; m && 25 > n; m = m.parentNode, ++n)g.push(9 != m.nodeType && m.id || "");
        (g = g.join()) && h.push(g);
        b.google_ad_unit_key = oa(h.join(":")).toString();
        h = a.google_adk2_experiment = a.google_adk2_experiment || M(["C", "E"], za) || "N";
        if ("E" == h) {
            h = c;
            g = [];
            for (n = 0; h && 25 > n; ++n) {
                var m = (m = 9 != h.nodeType && h.id) ? "/" + m : "", k;
                t:{
                    var s = h.parentElement;
                    k = h.nodeName.toLowerCase();
                    if (s)for (var s = s.childNodes, E = 0, B = 0; B < s.length; ++B) {
                        var x = s[B];
                        if (x.nodeName && x.nodeName.toLowerCase() == k) {
                            if (h == x) {
                                k = "." + E;
                                break t
                            }
                            ++E
                        }
                    }
                    k = ""
                }
                g.push((h.nodeName && h.nodeName.toLowerCase()) + m + k);
                h = h.parentElement
            }
            h = g.join() + ":";
            g = a;
            n = [];
            if (g)try {
                for (var l = g.parent, m = 0; l && l != g && 25 > m; ++m) {
                    var q = l.frames;
                    for (k = 0; k < q.length; ++k)if (g == q[k]) {
                        n.push(k);
                        break
                    }
                    g = l;
                    l = g.parent
                }
            } catch (C) {
            }
            b.google_ad_unit_key_2 = oa(h + n.join()).toString()
        } else"C" == h && (b.google_ad_unit_key_2 = "ctrl");
        if (l =
            a)l = H(a.top) ? a.top : null;
        if (l) {
            var l = b.google_reactive_ad_format, t;
            t:{
                for (t in Wa)if (Wa[t] == l) {
                    t = !0;
                    break t
                }
                t = !1
            }
            l = !(t && "" + l)
        }
        c = l ? yb(c, b.google_ad_width, b.google_ad_height) : "XS";
        b.google_ablation_signals = c;
        b = qa(b);
        var u;
        if (c = Ib) {
            if (!T)r:{
                t = [J.top];
                c = [];
                for (l = 0; q = t[l++];) {
                    c.push(q);
                    try {
                        if (q.frames)for (var w = q.frames.length, h = 0; h < w && 1024 > t.length; ++h)t.push(q.frames[h])
                    } catch (Yb) {
                    }
                }
                for (w = 0; w < c.length; w++)try {
                    if (u = c[w].frames.google_esf) {
                        T = u;
                        break r
                    }
                } catch (Zb) {
                }
                T = null
            }
            c = !T
        }
        c ? (u = {}, Mb(u, 0, 0, !1), u.style =
            "display:none", u.id = "google_esf", u.name = "google_esf", w = kb(sa("", "googleads.g.doubleclick.net"), "/pagead/html/r20140715/r20140417/zrt_lookup.html"), u.src = w, u = Lb(u)) : u = "";
        w = (new Date).getTime();
        c = a.google_top_experiment;
        t = a.google_async_for_oa_experiment;
        l = a.google_always_use_delayed_impressions_experiment;
        q = a.google_available_width_experiment;
        h = a.google_auto_width_experiment;
        g = a.google_responsive_optimization_experiment;
        f = ["<!doctype html><html><body>", u, "<", e, ">", b, "google_show_ads_impl=true;google_unique_id=", a.google_unique_id, ';google_async_iframe_id="', d, '";google_start_time=', v, ";", c ? 'google_top_experiment="' + c + '";' : "", t ? 'google_async_for_oa_experiment="' + t + '";' : "", l ? 'google_always_use_delayed_impressions_experiment="' + l + '";' : "", f ? 'google_append_as_for_format_override="' + f + '";' : "", q ? 'google_available_width_experiment="' + q + '";' : "", h ? 'google_auto_width_experiment="' + h + '";' : "", g ? 'google_responsive_optimization_experiment="' +
            g + '";' : "", "google_bpp=", w > v ? w - v : 1, ";google_async_rrc=0;</", e, ">", Jb(), "</body></html>"].join("");
        (a.document.getElementById(d) ? Gb : Hb)(Kb(a, d, f, !0))
    }, Pb = Math.floor(1E6 * Math.random()), Qb = function (a) {
        for (var b = a.data.split("\n"), c = {}, d = 0; d < b.length; d++) {
            var e = b[d].indexOf("=");
            -1 != e && (c[b[d].substr(0, e)] = b[d].substr(e + 1))
        }
        b = c[3];
        if (c[1] == Pb && (window.google_top_js_status = 4, a.source == top && 0 == b.indexOf(a.origin) && (window.google_top_values = c, window.google_top_js_status = 5), window.google_top_js_callbacks)) {
            for (a =
                     0; a < window.google_top_js_callbacks.length; a++)window.google_top_js_callbacks[a]();
            window.google_top_js_callbacks.length = 0
        }
    }, Rb = function (a, b) {
        var c = navigator;
        if (Ba && a && b && c) {
            var d = a.document, c = d.createElement("script"), e;
            (e = b) ? (e = e.toLowerCase()) && "ca-" != e.substring(0, 3) && (e = "ca-" + e) : e = "";
            c.async = !0;
            c.type = "text/javascript";
            c.src = kb("www.gstatic.com", "/pub-config/" + e + ".js");
            d = d.getElementsByTagName("script")[0];
            d.parentNode.insertBefore(c, d)
        }
    };
    var Sb = function (a) {
            return/(^| )adsbygoogle($| )/.test(a.className) && "done" != a.getAttribute("data-adsbygoogle-status")
        }, Ub = function (a, b, c) {
            na(c);
            Tb(a, b, c);
            var d = O(a, c);
            if (!d || "none" != d.display || "on" == b.google_adtest || 0 < b.google_reactive_ad_format) {
                1 == N(c) && Rb(c, b.google_ad_client);
                K(pa, function (a, d) {
                    b[d] = b[d] || c[d]
                });
                b.google_loader_used = "aa";
                if ((d = b.google_ad_output) && "html" != d)throw Error("No support for google_ad_output=" + d);
                db("aa::main", function () {
                    Ob(c, b, a)
                })
            } else c.document.createComment && a.appendChild(c.document.createComment("No ad requested because of display:none on the adsbygoogle tag"))
        },
        Tb = function (a, b, c) {
            for (var d = a.attributes, e = d.length, f = 0; f < e; f++) {
                var g = d[f];
                if (/data-/.test(g.nodeName)) {
                    var h = g.nodeName.replace("data", "google").replace(/-/g, "_");
                    b.hasOwnProperty(h) || (g = g.nodeValue, "google_reactive_ad_format" == h && (g = +g, g = isNaN(g) ? null : g), null === g || (b[h] = g))
                }
            }
            if (b.google_enable_content_recommendations && 1 == b.google_reactive_ad_format)b.google_ad_width = Ma(c), b.google_ad_height = 50, a.style.display = "none"; else if (1 == b.google_reactive_ad_format)b.google_ad_width = 320, b.google_ad_height =
                50, a.style.display = "none"; else if (8 == b.google_reactive_ad_format)d = c.document, b.google_ad_width = ("CSS1Compat" == d.compatMode ? d.documentElement : d.body).clientWidth, c = c.document, b.google_ad_height = Math.max(("CSS1Compat" == c.compatMode ? c.documentElement : c.body).clientHeight - 200, 200), a.style.display = "none"; else if (d = b.google_ad_format, "auto" == d || /^((^|,) *(horizontal|vertical|rectangle) *)+$/.test(d)) {
                void 0 === window.google_responsive_optimization_experiment && (d = Ua, e = [d.v, d.B], f = wa, window.google_responsive_optimization_experiment =
                    M(e, f), window.google_responsive_optimization_experiment || (e = [d.u, d.A], f = xa, window.google_responsive_optimization_experiment = M(e, f), window.google_responsive_optimization_experiment || (d = Va, e = [d.t, d.w], f = ya, window.google_responsive_optimization_experiment = M(e, f))));
                d = a.offsetWidth;
                e = b.google_ad_format;
                f = Qa;
                "E1" == c.google_responsive_optimization_experiment && (f = Ta);
                f = f(d, e, c, b);
                if (!f)throw Error("Cannot find a responsive size for a container of width=" + d + "px and data-ad-format=" + e);
                d = "SE" == c.google_responsive_optimization_experiment ?
                    f.width : 300 < d && 300 < f.height ? f.width : 1200 < d ? 1200 : Math.round(d);
                b.google_ad_height = "E320" == c.google_responsive_optimization_experiment && 320 == f.width && 50 == f.height ? 100 : f.height;
                b.google_ad_width = d;
                a.style.height = b.google_ad_height + "px";
                b.google_ad_resizable = !0;
                delete b.google_ad_format;
                b.google_loader_features_used = 128
            } else!Ga.test(b.google_ad_width) && !Fa.test(a.style.width) || !Ga.test(b.google_ad_height) && !Fa.test(a.style.height) ? (c = O(a, c), a.style.width = c.width, a.style.height = c.height, R(c, b, ["width",
                "height"]), b.google_loader_features_used = 256) : (void 0 !== window.google_auto_width_experiment ? c = "" : (window.google_auto_width_experiment = M(["C", "E"], va), c = window.google_auto_width_experiment), "E" == c ? (c = a.style, R(c, b, ["height"]), d = Ka(a), e = Ja(c.width), f = Ja(c.height), !f || !e || 50 > f || 120 > d || Da[e + "x" + f] ? R(c, b, ["width"]) : (d = Math.min(1200, d), 300 < f && (d = Math.min(300, d)), d <= e ? R(c, b, ["width"]) : (b.google_ad_width = d, b.google_original_width = e, a.style.width = d + "px"))) : (void 0 !== window.google_available_width_experiment ?
                c = "" : (window.google_available_width_experiment = M(["C", "E"], ua), c = window.google_available_width_experiment), "E" == c && (b.google_available_width = Ka(a)), R(a.style, b, ["width", "height"])))
        }, Vb = function (a) {
            for (var b = document.getElementsByTagName("ins"), c = 0, d = b[c]; c < b.length; d = b[++c])if (Sb(d) && (!a || d.id == a))return d;
            return null
        }, Wb = function (a) {
            var b = a.element;
            a = a.params || {};
            if (b) {
                if (!Sb(b) && (b = b.id && Vb(b.id), !b))throw Error("adsbygoogle: 'element' has already been filled.");
                if (!("innerHTML"in b))throw Error("adsbygoogle.push(): 'element' is not a good DOM element.");
            } else if (b = Vb(), !b)throw Error("adsbygoogle.push(): All ins elements in the DOM with class=adsbygoogle already have ads in them.");
            var c = window;
            b.setAttribute("data-adsbygoogle-status", "done");
            Ub(b, a, c)
        }, Xb = function () {
            if (!window.google_top_experiment && !window.google_top_js_status) {
                var a = window;
                if (2 !== (a.top == a ? 0 : H(a.top) ? 1 : 2))window.google_top_js_status = 0; else if (top.postMessage) {
                    var b;
                    try {
                        b = J.top.frames.google_top_static_frame ? !0 : !1
                    } catch (c) {
                        b = !1
                    }
                    if (b) {
                        if (window.google_top_experiment = M(["jp_c", "jp_zl",
                            "jp_wfpmr", "jp_zlt", "jp_wnt"], ta), "jp_c" !== window.google_top_experiment) {
                            a = window;
                            a.addEventListener ? a.addEventListener("message", Qb, !1) : a.attachEvent && a.attachEvent("onmessage", Qb);
                            window.google_top_js_status = 3;
                            a = {0: "google_loc_request", 1: Pb};
                            b = [];
                            for (var d in a)b.push(d + "=" + a[d]);
                            top.postMessage(b.join("\n"), "*")
                        }
                    } else window.google_top_js_status = 2
                } else window.google_top_js_status = 1
            }
            if ((d = window.adsbygoogle) && d.shift)for (b = 20; (a = d.shift()) && 0 < b--;)try {
                Wb(a)
            } catch (e) {
                throw window.setTimeout(Xb, 0),
                    e;
            }
            window.adsbygoogle = {push: Wb}
        };
    Xb();
})();
