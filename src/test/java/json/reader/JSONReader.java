package json.reader;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class JSONReader {

    public <T> List<T> readMultipleType(String fileName, Class clazz) throws IOException, ClassNotFoundException {
        JsonFactory factory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper(factory);
        JsonNode rootNode = mapper.readTree(readJson(fileName));
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.getFields();
        Map<String, JsonNode> map = new HashMap<String, JsonNode>();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            map.put(field.getKey(), field.getValue());
        }
        String response = map.get(clazz.getSimpleName()).toString();
        return convertJsonToList(response, clazz);
    }

    private  <T> List<T> convertJsonToList(String json, Class clazz) {

        Gson gson = new Gson();
        JSONArray jsonarray = new JSONArray(json);
        ArrayList<T> list = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            Object obj = gson.fromJson(jsonobject.toString(), clazz);
            list.add((T) obj);
        }
        return list;

    }

    public  <T>List<T> read(String fileName, Class clazz){
        return convertJsonToList(readJson(fileName),clazz);
    }

    private String readJson(String fileName){
        JsonParser parser = new JsonParser();
        String result = "";
        try {
            result =  parser.parse(IOUtils.toString(getClass().getClassLoader().getResource(fileName))).toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}