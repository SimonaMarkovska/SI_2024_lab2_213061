import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){
        if (allItems == null){ //1
            throw new RuntimeException("allItems list can't be null!"); //2
        } //3

        float sum = 0; //4

        for (int i = 0; i < allItems.size(); i++){ //5.1 , 5.2
            Item item = allItems.get(i); //6
            if (item.getName() == null || item.getName().length() == 0){ //7
                item.setName("unknown"); //8
            } //9
            if (item.getBarcode() != null){ //10
                String allowed = "0123456789"; //11
                char chars[] = item.getBarcode().toCharArray(); //12
                for (int j = 0; j < item.getBarcode().length(); j++){ //13.1 , 13.2
                    char c = item.getBarcode().charAt(j); //14
                    if (allowed.indexOf(c) == -1){ //15
                        throw new RuntimeException("Invalid character in item barcode!"); //16
                    } //17
                } //13.3
                if (item.getDiscount() > 0){ //18
                    sum += item.getPrice()*item.getDiscount(); //19
                }
                else {
                    sum += item.getPrice(); //20
                } //21
            }
            else {
                throw new RuntimeException("No barcode!"); //22
            } //23
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){ //24
                sum -= 30; //25
            } //26
        } //5.3
        if (sum <= payment){ //27
            return true; //28
        }
        else {
            return false; //29
        } //30
    }
}