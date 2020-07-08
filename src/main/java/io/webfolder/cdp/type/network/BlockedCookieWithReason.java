/**
 * cdp4j Commercial License
 *
 * Copyright 2017, 2020 WebFolder OÜ
 *
 * Permission  is hereby  granted,  to "____" obtaining  a  copy of  this software  and
 * associated  documentation files  (the "Software"), to deal in  the Software  without
 * restriction, including without limitation  the rights  to use, copy, modify,  merge,
 * publish, distribute  and sublicense  of the Software,  and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  IMPLIED,
 * INCLUDING  BUT NOT  LIMITED  TO THE  WARRANTIES  OF  MERCHANTABILITY, FITNESS  FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL  THE AUTHORS  OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.webfolder.cdp.type.network;

import io.webfolder.cdp.annotation.Experimental;

/**
 * A cookie with was not sent with a request with the corresponding reason
 */
@Experimental
public class BlockedCookieWithReason {
    private CookieBlockedReason blockedReasons;

    private Cookie cookie;

    /**
     * The reason(s) the cookie was blocked.
     */
    public CookieBlockedReason getBlockedReasons() {
        return blockedReasons;
    }

    /**
     * The reason(s) the cookie was blocked.
     */
    public void setBlockedReasons(CookieBlockedReason blockedReasons) {
        this.blockedReasons = blockedReasons;
    }

    /**
     * The cookie object representing the cookie which was not sent.
     */
    public Cookie getCookie() {
        return cookie;
    }

    /**
     * The cookie object representing the cookie which was not sent.
     */
    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }
}
