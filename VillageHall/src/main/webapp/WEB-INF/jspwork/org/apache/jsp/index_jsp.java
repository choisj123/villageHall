/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-03-29 03:22:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1679974654467L));
    _jspx_dependants.put("jar:file:/C:/workspace/villageHall/VillageHall/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>마을회관</title>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"http://code.jquery.com/jquery-1.7.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"resources/css/main.css\"\r\n");
      out.write("    />\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"resources/css/mainPage.css\"\r\n");
      out.write("    />\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"resources/css/weather.css\"\r\n");
      out.write("    />\r\n");
      out.write("\r\n");
      out.write("    <!-- 정훈씨꺼 지도 api key -->\r\n");
      out.write("    <script\r\n");
      out.write("      type=\"text/javascript\"\r\n");
      out.write("      src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=196b8c346b121bd08b2a475bfa001dd0\"\r\n");
      out.write("    ></script>\r\n");
      out.write("    <script\r\n");
      out.write("      type=\"text/javascript\"\r\n");
      out.write("      src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=196b8c346b121bd08b2a475bfa001dd0&libraries=LIBRARY\"\r\n");
      out.write("    ></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- fontawesome -->\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"https://kit.fontawesome.com/2f1bf0eac7.js\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    ></script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <main>\r\n");
      out.write("      <!-- header include -->\r\n");
      out.write("\r\n");
      out.write("      <!-- 내부 접근 절대 경로 -->\r\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <!-- 바디 부분 시작 -->\r\n");
      out.write("      <section class=\"body\">\r\n");
      out.write("        \r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/leftBody.jsp", out, false);
      out.write(" \r\n");
      out.write("\r\n");
      out.write("        <!-- 메인 콘텐츠 -->\r\n");
      out.write("        <section class=\"right-body\"> 메인게시판확인\r\n");
      out.write("          <!-- 지도 부분 -->\r\n");
      out.write("          <section>\r\n");
      out.write("            <div>\r\n");
      out.write("              <label for=\"category\" class=\"category\">카테고리:</label>\r\n");
      out.write("              <select onchange=\"showMarkersByCategory(this.value)\">\r\n");
      out.write("                <option value=\"전체\">전체글</option>\r\n");
      out.write("                <option value=\"이슈\">이슈</option>\r\n");
      out.write("                <option value=\"맛집\">맛집</option>\r\n");
      out.write("                <option value=\"취미\">취미</option>\r\n");
      out.write("                <option value=\"친목\">친목</option>\r\n");
      out.write("                <option value=\"추천\">추천</option>\r\n");
      out.write("                <option value=\"기타\">기타</option>\r\n");
      out.write("              </select>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div\r\n");
      out.write("              id=\"map\"\r\n");
      out.write("              style=\"width: auto; height: 500px; margin-left: 15px\"\r\n");
      out.write("            ></div>\r\n");
      out.write("          </section>\r\n");
      out.write("\r\n");
      out.write("          <!-- 공지+인기글 -->\r\n");
      out.write("          <section class=\"notice-fave\">\r\n");
      out.write("            <!-- 공지사항 -->\r\n");
      out.write("            <div class=\"notice-box\">\r\n");
      out.write("              <div><p>공지사항</p></div>\r\n");
      out.write("              <div>\r\n");
      out.write("                <table class=\"notice-content\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>제목</th>\r\n");
      out.write("                      <th>조회수</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          개인정보처리방침 개정 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 66 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          개인정보처리방침 개정 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 66 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          위치기반서비스방침 개정 내용 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 53 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          서비스 점검 시간 사전 안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 39 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          인터넷 익스플로러(IE) 지원 종료 안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 27 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          5년 이상 미사용 계정 휴면처리 안내 공지\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 11 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          개인정보처리방침 개정 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 66 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          개인정보처리방침 개정 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 66 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          위치기반서비스방침 개정 내용 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 53 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          서비스 점검 시간 사전 안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 39 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          인터넷 익스플로러(IE) 지원 종료 안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 27 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- 인기글 -->\r\n");
      out.write("            <div class=\"fave-box\">\r\n");
      out.write("              <div><p>인기글</p></div>\r\n");
      out.write("              <div>\r\n");
      out.write("                <table class=\"fave-content\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <th>제목</th>\r\n");
      out.write("                      <th>조회수</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          개인정보처리방침 개정 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 66 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          개인정보처리방침 개정 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 66 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          위치기반서비스방침 개정 내용 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 53 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          서비스 점검 시간 사전 안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 39 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          인터넷 익스플로러(IE) 지원 종료 안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 27 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          5년 이상 미사용 계정 휴면처리 안내 공지\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 11 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          개인정보처리방침 개정 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 66 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          개인정보처리방침 개정 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 66 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          위치기반서비스방침 개정 내용 사전안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 53 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          서비스 점검 시간 사전 안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 39 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td>\r\n");
      out.write("                        <a href=\"#\" title=\"사용꿀팁\">\r\n");
      out.write("                          인터넷 익스플로러(IE) 지원 종료 안내\r\n");
      out.write("                        </a>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      <td><a href=\"#\" title=\"사용꿀팁\"> 27 </a></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </section>\r\n");
      out.write("\r\n");
      out.write("          <!-- 날씨 -->\r\n");
      out.write("          <section class=\"weather\">\r\n");
      out.write("            <div class=\"box\">\r\n");
      out.write("              <!-- 날짜 -->\r\n");
      out.write("              <div class=\"FirstBox\">\r\n");
      out.write("                <h1 class=\"date\">오늘의날씨..</h1>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- 날씨 입력 -->\r\n");
      out.write("              <div class=\"SecondBox\">\r\n");
      out.write("                <div class=\"Sbox1\">\r\n");
      out.write("                  <div class=\"cicon\"></div>\r\n");
      out.write("                  <div class=\"main\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"ctemp\"><h4>현재온도</h4></div>\r\n");
      out.write("                <div class=\"clowtemp\"><h4>최저온도</h4></div>\r\n");
      out.write("                <div class=\"humidity\"><h4>습도</h4></div>\r\n");
      out.write("                <div class=\"mi\">\r\n");
      out.write("                  <h4>미세먼지</h4>\r\n");
      out.write("                  <div class=\"aqi\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </section>\r\n");
      out.write("        </section>\r\n");
      out.write("      </section>\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("    <!-- footer include -->\r\n");
      out.write("    <!-- 내부 접근 절대 경로 -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery 라이브러리 추가 -->\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"https://code.jquery.com/jquery-3.6.0.js\"\r\n");
      out.write("      integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    ></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- main.js 연결 -->\r\n");
      out.write("    <!-- <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/main.js\"></script> -->\r\n");
      out.write("\r\n");
      out.write("    <script src=\"/js/main-page.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/weather.js\"></script>\r\n");
      out.write("    <script src=\"/js/mainPage.js\"></script>\r\n");
      out.write("    <script src=\"/js/weather.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/mainPage-MapAPI.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
