package Storage;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadWriteFile {
    public List<Product> readData() {
        List<Product> productList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("data/product.CSV");
            ObjectInputStream ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;

    }

    public void writeData(List<Product> productList) {
        try {
            FileOutputStream fos = new FileOutputStream("data/product.CSV");
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(productList);
            ois.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
