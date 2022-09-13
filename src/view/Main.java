package view;

import Storage.ReadWriteFile;
import controller.ProductController;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductController boss=new ProductController();
        List<Product> producList =ProductController.productList;
        ReadWriteFile tuan=new ReadWriteFile();
        Scanner scanner =new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        Scanner scanner2=new Scanner(System.in);
        int choice=0;
        do {
            System.out.println(" Chương trình quản lí sản phẩm");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhập");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp" );
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.print(" Chọn chức năng");
            choice =scanner2.nextInt();
            switch (choice){
                case 1:
                    boss.showProductList();
                    break;
                    case 2:
                        System.out.println("Lựa chọn thêm mới");
                        System.out.println("Mời bạn nhập mã sản phẩm");
                        String idProduct=scanner.nextLine();
                        System.out.println("Mời bạn nhập tên");
                        String name=scanner.nextLine();

                        System.out.println("Mời bạn nhập giá");
                        double price=scanner1.nextDouble();

                        System.out.println("Mời bạn nhập số lượng");
                        int quantity =scanner2.nextInt();

                        System.out.println("Mời bạn nhập mô tả");
                        String description=scanner.nextLine();

                        Product product=new Product(idProduct,name,price,quantity,description);
                        boss.addNewProduct(product);

                    break;
                    case 3:
                        System.out.println("Mời bạn nhập mã sản phẩm cần cập nhập");
                        String id=scanner.nextLine();
                        int index=boss.findProductById(id);
                        if(index==-1){
                            System.out.println("Không tìm thấy sản phẩm");
                        }else{
                            System.out.println("Mời bạn nhập id");
                            id=scanner.nextLine();

                            System.out.println("Mời bạn nhập tên");
                             name=scanner.nextLine();

                            System.out.println("Mời bạn nhập giá");
                             price=scanner1.nextDouble();

                            System.out.println("Mời bạn nhập số lượng");
                             quantity =scanner2.nextInt();

                            System.out.println("Mời bạn nhập mô tả");
                            description=scanner.nextLine();

                            boss.changeProductInformation(index,id,name,price,quantity,description);
                            System.out.println("Sửa thông tin thành công");
                        }

                    break;
                    case 4:
                        System.out.println("Mời bạn nhập mã sản phẩm cần xóa");
                        id=scanner.nextLine();
                        index = boss.findProductById(id);
                        if(index==-1){
                            System.out.println("Không tìm thấy sản phẩm cần xóa");
                        } else {
                            System.out.println("Nhập Y để xác nhận");
                            String confirm=scanner.nextLine();
                            if(confirm.equals("Y")){
                                boss.deleteProduct(index);
                                System.out.println("Đã xóa");
                            }
                        }
                    break;
                    case 5:
                        System.out.println("1. Sắp xếp theo giá tăng dần");
                        System.out.println("2. Sắp xếp theo giá giảm dần");
                        System.out.println("3. Quay lại");
                        int choice1 =0;
                                do{
                                    choice1=scanner2.nextInt();
                                    switch (choice1){
                                        case 1:
                                            boss.sortIncre();
                                            break;
                                        case 2:
                                            boss.sortDecre();
                                            break;
                                        default:
                                    }
                                }while (choice1!=3);
                    break;
                    case 6:
                       boss.findMaxValue();

                    break;
                    case 7:
                        tuan.readData();
                    break;
                    case 8:
                        tuan.writeData(producList);

                    break;
                    case 9:
                        System.exit(0);
                default:


            }
        } while (choice!=9);
    }


}
