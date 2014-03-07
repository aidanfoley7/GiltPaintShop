package GiltPaintShop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: aidanfoley7
 * Date: 06/03/2014
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
public class PaintShop {

    List<String> orderList = new ArrayList<String>();
    List<Customer> customerList = new ArrayList<Customer>();
    Map<Integer,Paint> uniquePaintList = new HashMap<Integer,Paint>();
    Map<Integer,Paint> initialOrderGuess = new HashMap<Integer,Paint>();
    int numberOfPaints = 0;
    int numberOfCustomers = 0;
    String orderResponse = null;

    public PaintShop() {}

    public PaintShop(File file) throws IOException {
        int count = 0;
        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                if(count < 1) {
                    numberOfPaints = Integer.parseInt(line);
                } else {
                    orderList.add(line.replaceAll("\\s", ""));
                }
                count ++;
            }

            numberOfCustomers = count-1;

            //Ordering the list as when we read in the order it will be easier to fill the final order
            Collections.sort(orderList, new LineComparator());

        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

        retrieveOrder(orderList);
    }

    public String retrieveOrder(List<String> orderList) {
        int customerId = 1;
        String key = null;
        String finish = null;
        for(String s: orderList) {
            boolean isAMust = false;
            if(s.length()==2) {
                isAMust = true;
            }
            Map<Integer, Paint> paintMapForCustomer = new HashMap<Integer, Paint>();
            for (int i = 0; i < s.length(); i++){
                key = Character.toString(s.charAt(i));
                finish = Character.toString(s.charAt(++i));
                Paint paint =  new Paint(key,finish,isAMust);
                if(isAMust) {
                    uniquePaintList.put(Integer.parseInt(key),paint);
                }
                paintMapForCustomer.put(Integer.parseInt(key), paint);
            }
            customerList.add(new Customer(paintMapForCustomer,customerId,isAMust));
            customerId++;
        }

        initialOrderGuess = initialGuess();
        orderResponse = finalizeOrder(initialOrderGuess, customerList);
        return  orderResponse;
    }

    public Map<Integer, Paint> initialGuess() {
        Map<Integer,Paint> initialOrderGuess = new HashMap<Integer,Paint>();

        for(int i=1; i<=numberOfPaints; i++) {
            initialOrderGuess.put(i, new Paint(null, "G", false));
        }

        for(Integer i: uniquePaintList.keySet()){
            initialOrderGuess.put(i, uniquePaintList.get(i));
        }
        return initialOrderGuess;
    }

    public String finalizeOrder(Map<Integer,Paint> initialOrderGuess, List<Customer> customerList) {

        for(int i=0; i<numberOfCustomers; i++) {
            Customer customer = customerList.get(i);
            while(!customer.isOrderApproved()) {
                for(int j=1; j<=customer.getPaints().size(); j++) {
                    if(!initialOrderGuess.get(j).isCannotBeAltered()){
                        if(customer.getPaints().get(j) != null && !initialOrderGuess.get(j).getFinish().equals(customer.getPaints().get(j).getFinish())){
                            initialOrderGuess.get(j).setFinish(customer.getPaints().get(j).getFinish());
                            customer.setOrderApproved(true);
                            break;
                        }
                    }
                    customer.setOrderApproved(true);
                }
            }
        }
        System.out.println(initialOrderGuess);
        return null;
    }
}
