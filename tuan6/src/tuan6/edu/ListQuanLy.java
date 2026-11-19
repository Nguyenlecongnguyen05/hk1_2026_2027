package tuan6.edu;


import java.util.*;
import java.util.stream.Collectors;

public class ListQuanLy implements IQuanLy<NhanVien> {


    private final List<NhanVien> danhSach = new ArrayList<>();


    private NhanVien timTheoMa(String ma) {
        return danhSach.stream()
                .filter(nv -> nv.getMaNV().equalsIgnoreCase(ma))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean them(NhanVien nv) {
        if (timTheoMa(nv.getMaNV()) != null) {
            return false;           
        }
        return danhSach.add(nv);
    }

    @Override
    public boolean xoa(String ma) {
        return danhSach.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(ma));
    }

    @Override
    public boolean sua(String ma, NhanVien nvMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaNV().equalsIgnoreCase(ma)) {
                danhSach.set(i, nvMoi);
                return true;
            }
        }
        return false;
    }


    @Override
    public List<NhanVien> timKiemTheoTen(String ten) {
        String keyword = ten.toLowerCase();
        return danhSach.stream()
                .filter(nv -> nv.getHoTen().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<NhanVien> timKiemTheoMa(String prefix) {
        return danhSach.stream()
                .filter(nv -> nv.getMaNV().toLowerCase().startsWith(prefix.toLowerCase()))
                .collect(Collectors.toList());
    }


    @Override
    public List<NhanVien> sapXepTheoLuong() {
        return danhSach.stream()
                .sorted(Comparator.comparingDouble(NhanVien::tinhLuong))
                .collect(Collectors.toList());
    }

    @Override
    public List<NhanVien> sapXepTheoTen() {
        return danhSach.stream()
                .sorted(Comparator.comparing(NhanVien::getHoTen))
                .collect(Collectors.toList());
    }


    @Override
    public Map<String, Double> thongKeLuongTheoLoai() {
        return danhSach.stream()
                .collect(Collectors.groupingBy(
                        nv -> nv.getLoai().getMa(),                 
                        Collectors.summingDouble(NhanVien::tinhLuong) 
                ));
    }

    @Override
    public Map<String, List<NhanVien>> groupByLoai() {
        return danhSach.stream()
                .collect(Collectors.groupingBy(nv -> nv.getLoai().getMa()));
    }

    @Override
    public Map<String, List<NhanVien>> groupByPhongBan() {
        return danhSach.stream()
                .collect(Collectors.groupingBy(nv -> nv.getPhongBan().getTen()));
    }


    @Override
    public List<NhanVien> locLuongTren(double mucLuong) {
        return danhSach.stream()
                .filter(nv -> nv.tinhLuong() > mucLuong)
                .collect(Collectors.toList());
    }

    @Override
    public List<NhanVien> timTheoChucVu(ChucVu chucVu) {
        return danhSach.stream()
                .filter(nv -> nv.getChucVu() == chucVu)  
                .collect(Collectors.toList());
    }


    public List<NhanVien> getDanhSach() {
        return Collections.unmodifiableList(danhSach);
    }
}