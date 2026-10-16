package vn.edu.vhu.ltdd.a8fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "A8_231A010308";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.tab_home) {
                doiTab(new HomeFragment());
            } else if (id == R.id.tab_news) {
                doiTab(new NewsListFragment());
            } else if (id == R.id.tab_profile) {
                doiTab(ProfileFragment.newInstance("Nguyễn Phạm Chí Thành", "231A010308"));
            }
            return true; // true = tô sáng tab được chọn
        });

        // Chỉ nạp Fragment mặc định ở lần tạo đầu tiên (ngừa nạp chồng khi xoay màn hình)
        if (savedInstanceState == null) {
            bottomNav.setSelectedItemId(R.id.tab_home);
        }
    }

    /** Thay Fragment đang hiển thị trong khung chứa (Tích hợp NC4 Animation) */
    private void doiTab(Fragment f) {
        Log.d(TAG, "Chuyển tab sang: " + f.getClass().getSimpleName());
        getSupportFragmentManager()
                .beginTransaction()
                // NC4: Thêm hiệu ứng mờ dần (fade in / fade out) khi đổi tab
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragmentContainer, f)
                // LƯU Ý: KHÔNG dùng .addToBackStack() cho tab để khi bấm Back sẽ thoát app ngay
                .setReorderingAllowed(true)
                .commit();
    }
}