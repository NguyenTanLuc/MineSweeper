package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogAbout implements Dialog{
	public DialogAbout() {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Infomation");
		a.setHeaderText("Developer:" + "\n" + " Nguyễn Tấn Lực " + "\n" + " Lê Anh Minh \n" + "Project TKHDT");
		a.setContentText("Hướng dẫn : \n" + "Người chơi khởi đầu với một bảng ô vuông trống thể hiện \"bãi mìn\".\r\n"
				+ "Click chuột vào một ô vuông trong bảng. Nếu không may trúng phải ô có mìn (điều này ít xảy ra hơn) thì người chơi trò chơi kết thúc. Trường hợp thường xảy ra hơn là ô đó không có mìn và một vùng các ô sẽ được mở ra cùng với những con số. Số trên một ô là chỉ số ô có mìn trong cả thảy 8 ô nằm lân cận với ô đó.\r\n"
				+ "Nếu chắc chắn một ô có mìn, người chơi đánh dấu vào ô đó bằng hình lá cờ (click chuột phải).\r\n"
				+ "Khi 8 ô lân cận trong một số đã có đủ số mìn mà vẫn còn các ô khác thì những ô đó không có mìn\r\n"
				+ "Trò chơi kết thúc với phần thắng dành cho người chơi nếu tìm được tất cả các ô có mìn và mở được tất cả các ô không có mìn.	");
		a.showAndWait();
	}

}
