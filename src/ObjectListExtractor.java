import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjectListExtractor {

    public static void main(String[] args) {
        YourObject yourObject = new YourObject();

        String filePath = "/Users/vshar04/Downloads/266830.0000257506.230625.d.A022.dfr_resp"; // Replace with the actual path to your file
        List<YourObject> objects = readObjectsFromFile(filePath);

        // Do something with the extracted objects
        for (YourObject obj : objects) {
            System.out.println(obj);
        }
        System.out.println("Size   ="+objects.size());
    }

    private static List<YourObject> readObjectsFromFile(String filePath) {
        List<YourObject> objects = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields using the pipe "|" as the delimiter
                String[] fields = line.split("\\|");

                // Create an object and set its fields
                YourObject obj = new YourObject();
                if(fields[0].equals("RPDE0017D")){
                    obj.setRecord_Type(fields[0].trim());
                    obj.setEntity_Type(fields[1].trim());
                    obj.setEntity(fields[2].trim());
                    obj.setConsumer_Bank_Country_Code(fields[3].trim());
                    obj.setMop(fields[4].trim());
                    obj.setCurrency(fields[5].trim());
                    obj.setCategory(fields[6].trim());
                    obj.setStatus_flag(fields[7].trim());
                    obj.setSequence(fields[8].trim());
                    obj.setMerchant_Order(fields[9].trim());
                    obj.setAccount(fields[10].trim());
                    obj.setReason_Code(fields[11].trim());
                    obj.setTransaction_Date(fields[12].trim());
                    obj.setEcp_Return_Date(fields[13].trim());
                    obj.setActivity_Date(fields[14].trim());
                    obj.setEcp_Return_Amt(fields[15].trim());
                    obj.setUsage_Code(fields[16].trim());
                    obj.setUsage_Code(fields[17].trim());
                    obj.setConsumer_Name(fields[18].trim());
                    obj.setRdfi(fields[19].trim());
                    obj.setReason_Code_Classification(fields[20].trim());
                    obj.setAccountholder_Authorization_Method(fields[21].trim());
                    // Add the object to the list
                    objects.add(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
