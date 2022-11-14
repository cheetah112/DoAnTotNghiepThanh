package constants;
// loại hình nhân viên
public enum Type {
    NHANVIENLETAN ("Nhân viên lễ tân"),
    NHANVIENWIP ("Nhân viên WIP"),
    NHANVIENSUAPCB ("Nhân Viên sửa chữa phần bản mạch"),
    NHANVIENSUAFONT("Nhân Viên sửa font"),
    NHANVIENSUAPHANMEM ("Nhân Viên sửa phần mềm"),
    NHANVIENKHO ("Nhân Viên Kho"),
    QUANLY ("Quản Lý"),

    ADMIN ("Ông chủ");
    Type(String s) {
    }
}
