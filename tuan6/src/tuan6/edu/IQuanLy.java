package tuan6.edu;


import java.util.List;
import java.util.Map;

public interface IQuanLy<T> {


    boolean them(T t);
    boolean xoa(String ma);
    boolean sua(String ma, T tMoi);


    List<T> timKiemTheoTen(String ten);
    List<T> timKiemTheoMa(String prefix);


    List<T> sapXepTheoLuong();
    List<T> sapXepTheoTen();

    Map<String, Double> thongKeLuongTheoLoai();
    Map<String, List<T>> groupByLoai();
    Map<String, List<T>> groupByPhongBan();

    List<T> locLuongTren(double mucLuong);
    List<T> timTheoChucVu(ChucVu chucVu);
}