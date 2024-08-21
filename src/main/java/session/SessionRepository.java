package session;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class SessionRepository {
	private static final Map<String, HttpSession> repository = new ConcurrentHashMap<>();
	private static final String COOKIE_NAME = "JSESSION_ID";
	
	
	public static HttpSession getSession(String sessionId) {
		return repository.get(sessionId);
	}
	
	public static void addSession(String sessionId, HttpSession session) {
		repository.put(sessionId, session);
	}
	
	public static boolean containsSession(String sessionId) {
		return repository.containsKey(sessionId);
	}
	
	public static String getSessionId(Cookie[] cookies) {
		return getCookieValue(cookies, COOKIE_NAME);
	}
	
	public static Cookie getSessionCookie(String sessionId) {
		Cookie cookie = new Cookie(COOKIE_NAME, sessionId);
		cookie.setMaxAge(60 * 60);
		
		return cookie;
	}
	
	private static String getCookieValue(Cookie[] cookies, String cookieName) {
		if (Objects.isNull(cookies)) return null;
		for (Cookie cookie: cookies) {
			if (cookie.getName().equals(cookieName)) {
				return cookie.getValue();
			}
		}
		return null;
		
	}

	public static void removeSession(String sessionId) {
		repository.get(sessionId).invalidate();
		repository.remove(sessionId);
	}
	

}
