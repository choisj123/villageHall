/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-03-28 00:38:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1679893946172L));
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

      out.write(" \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>마을회관</title>\r\n");
      out.write("\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/main.css\"\r\n");
      out.write("    />\r\n");
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
      out.write("      <!--콘텐츠 작성 영역-->\r\n");
      out.write("      <section class=\"content\">\r\n");
      out.write("        <h1 class=\"sign-up-text\">회원가입</h1>\r\n");
      out.write("      </section>\r\n");
      out.write("\r\n");
      out.write("      <section class=\"content-2\">\r\n");
      out.write("        <!--회원가입시 필요한 정보 기입 영역-->\r\n");
      out.write("        <form action=\"#\" name=\"sign-up-form\">\r\n");
      out.write("          <fieldset id=\"sign-up-area\">\r\n");
      out.write("            <section class=\"sign-up-1\">\r\n");
      out.write("              <!--이메일-->\r\n");
      out.write("              이메일<br /><input\r\n");
      out.write("                type=\"text\"\r\n");
      out.write("                name=\"userEmail\"\r\n");
      out.write("                class=\"input-text\"\r\n");
      out.write("                id=\"userEmail\"\r\n");
      out.write("                placeholder=\"아이디(이메일)\"\r\n");
      out.write("                maxlength=\"30\"\r\n");
      out.write("                autocomplete=\"off\"\r\n");
      out.write("                required\r\n");
      out.write("                autofocus\r\n");
      out.write("              />\r\n");
      out.write("              <button id=\"email-check-btn\">인증</button><br />\r\n");
      out.write("              <span class=\"signUp-message\" id=\"emailMessage\"\r\n");
      out.write("                >메일을 받을 수 있는 이메일을 입력해주세요.</span\r\n");
      out.write("              >\r\n");
      out.write("\r\n");
      out.write("              <!--이메일 인증번호 확인-->\r\n");
      out.write("              이메일 인증<br /><input\r\n");
      out.write("                type=\"text\"\r\n");
      out.write("                name=\"auth_number\"\r\n");
      out.write("                class=\"input-text\"\r\n");
      out.write("              />\r\n");
      out.write("              <button id=\"email-check-btn\">확인</button><br /><br />\r\n");
      out.write("\r\n");
      out.write("              <!--비밀번호-->\r\n");
      out.write("              비밀번호<br /><input\r\n");
      out.write("                type=\"password\"\r\n");
      out.write("                input\r\n");
      out.write("                name=\"password\"\r\n");
      out.write("                id=\"pw1\"\r\n");
      out.write("                class=\"input-text\"\r\n");
      out.write("              /><br />\r\n");
      out.write("              <span id=\"result1\" class=\"confirm\"></span><br />\r\n");
      out.write("              비밀번호 확인<br /><input\r\n");
      out.write("                type=\"password\"\r\n");
      out.write("                input\r\n");
      out.write("                name=\"password-check\"\r\n");
      out.write("                id=\"pw2\"\r\n");
      out.write("                class=\"input-text\"\r\n");
      out.write("              /><br />\r\n");
      out.write("              <span id=\"result2\" class=\"confirm\"></span><br />\r\n");
      out.write("              <!--닉네임-->\r\n");
      out.write("              닉네임<br /><input\r\n");
      out.write("                type=\"text\"\r\n");
      out.write("                name=\"Nickname\"\r\n");
      out.write("                class=\"input-text\"\r\n");
      out.write("              />\r\n");
      out.write("              <br /><br /><br />\r\n");
      out.write("\r\n");
      out.write("              <!--프로필사진-->\r\n");
      out.write("              프로필사진<br />\r\n");
      out.write("              <input type=\"file\" name=\"profile-pic\" />\r\n");
      out.write("            </section>\r\n");
      out.write("          </fieldset>\r\n");
      out.write("\r\n");
      out.write("          <!--회원가입/카카오로 시작하기-->\r\n");
      out.write("          <br />\r\n");
      out.write("          <section>\r\n");
      out.write("            <article class=\"sign-up-article-1\">\r\n");
      out.write("              <button type=\"submit\" id=\"signup-btn\">회원가입</button><br />\r\n");
      out.write("            </article>\r\n");
      out.write("\r\n");
      out.write("            <article class=\"sign-up-article-2\">\r\n");
      out.write("              <a href=\"javascript:void(0)\" onclick=\"kakaoLogin();\">\r\n");
      out.write("                <img src=\"/src/kakao_login_medium_wide.png\" />\r\n");
      out.write("              </a>\r\n");
      out.write("            </article>\r\n");
      out.write("          </section>\r\n");
      out.write("        </form>\r\n");
      out.write("      </section>\r\n");
      out.write("\r\n");
      out.write("      <script src=\"/js/sign-up-page.js\"></script>\r\n");
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
