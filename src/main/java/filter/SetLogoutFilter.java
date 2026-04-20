package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ブラウザのキャッシュを無効化し、ログアウト後の「戻る」を防止するフィルタ
 */
@WebFilter("/*") // すべてのページ（JSPやサーブレット）に適用
public class SetLogoutFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初期化処理（必要なければ空でOK）
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // HTTP 1.1: キャッシュを保存させず、毎回サーバーに確認させる
        httpResponse.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        
        // HTTP 1.0 互換用
        httpResponse.setHeader("Pragma", "no-cache");
        
        // プロキシサーバー等でのキャッシュ防止（過去の時間を設定）
        httpResponse.setDateHeader("Expires", 0);

        // 次の処理（実際のJSPやサーブレット）へ渡す
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 終了処理（必要なければ空でOK）
    }
}


