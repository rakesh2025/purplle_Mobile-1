package utils;

import org.testng.annotations.Test;

public class JavaUtils
{


    @Test
    public String convertCartPageProductPrice(String productPriceAtCart)
    {
//        String str = "₹3000  4600  35% off";
        String str = productPriceAtCart;
        String price = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == ' ')
            {
                break;
            }
            else
            {
                price = price + str.charAt(i);
            }
        }

        System.out.println(price);

        return price;

    }
}
