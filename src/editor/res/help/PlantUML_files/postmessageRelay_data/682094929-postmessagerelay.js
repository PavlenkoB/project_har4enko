var f = this, g = function (a) {
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
};
Math.random();
var h = function (a, b) {
    var c = a.split("."), d = f;
    c[0]in d || !d.execScript || d.execScript("var " + c[0]);
    for (var e; c.length && (e = c.shift());)c.length || void 0 === b ? d = d[e] ? d[e] : d[e] = {} : d[e] = b
};
Math.random();
var l;
i:{
    var m = f.navigator;
    if (m) {
        var n = m.userAgent;
        if (n) {
            l = n;
            break i
        }
    }
    l = ""
}
;
var p = -1 != l.indexOf("Opera") || -1 != l.indexOf("OPR"), r = -1 != l.indexOf("Trident") || -1 != l.indexOf("MSIE"), s = -1 != l.indexOf("Gecko") && -1 == l.toLowerCase().indexOf("webkit") && !(-1 != l.indexOf("Trident") || -1 != l.indexOf("MSIE")), t = -1 != l.toLowerCase().indexOf("webkit"), u = t && -1 != l.indexOf("Mobile");
(function () {
    var a = "", b;
    if (p && f.opera)return a = f.opera.version, "function" == g(a) ? a() : a;
    s ? b = /rv\:([^\);]+)(\)|;)/ : r ? b = /\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/ : t && (b = /WebKit\/(\S+)/);
    b && (a = (a = b.exec(l)) ? a[1] : "");
    return r && (b = (b = f.document) ? b.documentMode : void 0, b > parseFloat(a)) ? String(b) : a
})();
var v;
v = !1;
var x = l;
x && (-1 != x.indexOf("Firefox") || -1 != x.indexOf("Camino") || -1 != x.indexOf("iPhone") || -1 != x.indexOf("iPod") || -1 != x.indexOf("iPad") || -1 != x.indexOf("Chrome") || -1 != x.indexOf("Android") || -1 != x.indexOf("Safari") && (v = !0));
var y = v;
var z = function (a) {
    var b = window;
    if (u && y && b) {
        b.focus();
        var c = 0, d = null, d = b.setInterval(function () {
            a.closed || 5 == c ? b.clearInterval(d) : (a.close(), c++)
        }, 150)
    } else a.close()
};
var B, C = function (a) {
    a = a || [];
    for (var b = [], c = 0, d = a.length; c < d; ++c) {
        var e = String(a[c] || "");
        e && b.push(e)
    }
    if (!b.length)return null;
    B ? B.reset.call(B) : B = shindig.sha1();
    B.update.call(B, b.join(" "));
    return B.digestString.call(B).toLowerCase()
}, D = function (a, b, c) {
    this.i = String(a || "");
    this.e = String(b || "");
    this.a = String(c || "");
    this.d = {};
    this.g = this.k = this.f = this.h = "";
    this.c = null
};
D.prototype.evaluate = function () {
    var a = {}, b = "";
    try {
        b = String(document.cookie || "")
    } catch (c) {
    }
    for (var b = b.split("; ").join(";").split(";"), d = 0, e = b.length; d < e; ++d) {
        var k = b[d], w = k.indexOf("=");
        -1 != w ? a[k.substr(0, w)] = k.substr(w + 1) : a[k] = null
    }
    this.d = a;
    if (this.d.SID)if (this.e = this.e.split(".")[0].split("@")[0], a = "", a = 0 == this.i.indexOf("https://") ? "SAPISID" : "APISID", this.f = String(this.d[a] || ""))if (a = "", a = 0 == gadgets.rpc.getOrigin(String(window.location.href)).indexOf("https://") ? "SAPISID" : "APISID", this.h = String(this.d[a] ||
        "")) {
        b = String(this.d.LSOLH || "").split(":");
        d = b.length;
        if (1 == d || 4 == d)this.k = b[0];
        if (3 == d || 4 == d)a = String(b[d - 3] || ""), b = String(b[d - 1] || ""), (d = C([a, this.h]).substr(0, 4)) && d == b && (this.g = a);
        this.a && (a = this.a.indexOf("."), -1 != a && (a = this.a.substr(0, a) || "", this.a = a + "." + C([this.f, this.i, this.e, this.k, this.g, a]).substr(0, 4)));
        a = C([this.f, this.i, this.e, this.a]);
        this.a && (a = a + "." + this.a);
        this.c = a
    } else this.c = ""; else this.c = ""
};
var E = function (a, b, c) {
    a = new D(a, b, c);
    a.evaluate();
    return a
}, G = function (a, b, c) {
    c = c || F(this);
    var d = null;
    if (a) {
        a = String(a);
        var e = a.indexOf(".");
        -1 != e && (d = a.substr(e + 1))
    }
    b = E(c, b, d).c;
    if (null == a || "" == a)a = b == a; else if (null == b || b.length != a.length)a = !1; else {
        d = c = 0;
        for (e = a.length; d < e; ++d)c |= a.charCodeAt(d) ^ b.charCodeAt(d);
        a = 0 == c
    }
    return a
}, H = function (a, b, c) {
    c = c || F(this);
    c = E(c);
    if (String(a) != c.c)throw Error("Unauthorized request");
    b = String(b);
    a = parseInt(b, 10);
    String(a) == b && 0 <= a ? (b = c.g) ? (b = b.split("|"), a = b.length <=
        a ? null : b[a] || null) : a = null : a = null;
    return a
}, F = function (a) {
    a = String(a.origin || "");
    if (!a)throw Error("RPC has no origin.");
    return a
};
h("checkSessionState", G);
h("getVersionInfo", H);
var I, J, K, L, M, N, O = window, P = (window.location.href || O.location.href).match(/.*(\?|#|&)usegapi=([^&#]+)/) || [];
"1" === decodeURIComponent(P[P.length - 1] || "") ? (K = function (a, b, c, d, e, k) {
    I.send(b, e, d, k || gapi.iframes.CROSS_ORIGIN_IFRAMES_FILTER)
}, L = function (a, b) {
    I.register(a, b, gapi.iframes.CROSS_ORIGIN_IFRAMES_FILTER)
}, M = function (a) {
    var b = gapi.iframes.makeWhiteListIframesFilter([a.substr(0, a.indexOf("?"))]);
    K("..", "oauth2callback", gadgets.rpc.getAuthToken(".."), void 0, a, b)
}, J = function () {
    Q()
}, N = function () {
    K("..", "oauth2relayReady", gadgets.rpc.getAuthToken(".."));
    L("check_session_state", R);
    L("get_versioninfo", S)
}) :
    (K = function (a, b, c, d, e) {
        gadgets.rpc.call(a, b + ":" + c, d, e)
    }, L = function (a, b) {
        gadgets.rpc.register(a, b)
    }, M = function (a) {
        gadgets.rpc.getTargetOrigin("..") == gadgets.rpc.getOrigin(a) && K("..", "oauth2callback", gadgets.rpc.getAuthToken(".."), void 0, a)
    }, J = function () {
        N()
    }, N = function () {
        K("..", "oauth2relayReady", gadgets.rpc.getAuthToken(".."));
        L("check_session_state", G);
        L("get_versioninfo", H)
    });
var Q = function () {
    var a = N;
    window.gapi.load("gapi.iframes", function () {
        I = gapi.iframes.getContext().getParentIframe();
        a()
    })
}, T = function (a) {
    window.setTimeout(function () {
        M(a)
    }, 1)
}, R = function (a) {
    var b, c;
    a && (b = a.session_state, c = a.client_id);
    return G(b, c, I.getOrigin())
}, S = function (a) {
    return H(a.xapisidHash, a.sessionIndex, I.getOrigin())
};
h("oauth2callback", T);
h("oauth2verify", function (a, b) {
    var c = window.open("javascript:void(0);", a), d;
    if (c && !c.closed && (d = c.oauth2callbackUrl))return window.b = window.b || {}, window.j = window.j || window.setTimeout, window.setTimeout = function (a, b) {
        try {
            var d = a, A = !1, q;
            a = function () {
                if (!A) {
                    A = !0;
                    try {
                        window.b[String(q)] = void 0, delete window.b[String(q)]
                    } catch (a) {
                    }
                    return d.call(this)
                }
            };
            var U = c.setTimeout(a, b);
            q = window.j(a, b);
            window.b[String(q)] = U;
            return q
        } catch (V) {
        }
        return window.j(a, b)
    }, window.l = window.l || window.clearTimeout, window.clearTimeout =
        function (a) {
            try {
                var b = window.b[String(a)];
                b && c.clearTimeout(b)
            } catch (d) {
            }
            try {
                window.b[String(a)] = void 0, delete window.b[String(a)]
            } catch (A) {
            }
            window.l(a)
        }, T(String(d)), "keep_open" != b && z(c), !0;
    c && !c.closed && z(c);
    return!1
});
window.addEventListener ? window.addEventListener("load", J, !1) : window.attachEvent("onload", J);
