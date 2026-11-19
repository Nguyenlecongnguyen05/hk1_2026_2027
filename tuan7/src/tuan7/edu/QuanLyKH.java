package tuan7.edu;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class QuanLyKH {


List<KhachHang> ls;

public QuanLyKH() {
    ls = new ArrayList<KhachHang>(2);
}


public boolean themKH(KhachHang kh) {
    if (ls.contains(kh)) {
        return false;
    } else {
        return ls.add(kh);
    }
}


public boolean capnhat(String ma, double gia) {
    for (KhachHang kh : ls) {
        if (kh.getMaKH().equalsIgnoreCase(ma)) {
            kh.setGia(gia);
            return true;
        }
    }
    return false;
}


public boolean xoama(String ma) {
    for (int i = 0; i < ls.size(); i++) {
        if (ls.get(i).getMaKH().equalsIgnoreCase(ma)) {
            ls.remove(i);
            return true;
        }
    }
    return false;
}


public void sapxep() {
    Collections.sort(ls, new Comparator<KhachHang>() {
        @Override
        public int compare(KhachHang o1, KhachHang o2) {
            String x = o1.getMaKH();
            String y = o2.getMaKH();
            return x.compareToIgnoreCase(y);
        }
    });
}


public void themNhieu(KhachHang... ds) {
    for (KhachHang kh : ds) {
        themKH(kh);
    }
}


public void duyet(Consumer<KhachHang> hanhDong) {
    for (KhachHang kh : ls) {
        hanhDong.accept(kh);
    }
}


public long dem(Predicate<KhachHang> dieuKien) {
    long dem = 0;

    for (KhachHang kh : ls) {
        if (dieuKien.test(kh)) {
            dem++;
        }
    }

    return dem;
}


}