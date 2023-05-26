import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Đường dẫn tệp tin nguồn và tệp tin đích.
            String sourceFilePath = "source.txt";
            String targetFilePath = "target.txt";

            // Khởi tạo luồng đầu vào từ tệp tin nguồn.
            reader = new BufferedReader(new FileReader(sourceFilePath));

            // Kiểm tra xem tệp tin đích đã tồn tại hay chưa.
            File targetFile = new File(targetFilePath);
            if (targetFile.exists()){
                System.out.println("Tệp tin đích đã tồn tại");
                return;
            }

            // Khởi tạo luồng đầu ra đến tệp tin đích.
            writer = new BufferedWriter(new FileWriter(targetFilePath));

            int charCount = 0;
            int charValue;
            while ((charValue = reader.read()) != -1){
                writer.write(charValue);
                charCount++;
            }

            System.out.println("Sao chép tệp tin thành công.");
            System.out.println("Số ký tự trong tệp tin là: " + charCount);
        } catch (FileNotFoundException e){
            System.out.println("Tệp tin nguồn không tồn tại.");
        } catch (IOException e){
            System.out.println("Lỗi khi đọc/ghi tệp tin.");
        }finally {
            try {
                // Đóng luồng đầu vào và đầu ra.
                if (reader != null){
                    reader.close();
                }
                if (writer != null){
                    writer.close();
                }
            } catch (IOException e){
                System.out.println("Lỗi khi đóng luồng.");
            }
        }
    }
}
