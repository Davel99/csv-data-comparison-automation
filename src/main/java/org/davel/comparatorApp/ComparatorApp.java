package org.davel.comparatorApp;
import java.util.*;

public class ComparatorApp {
    Map<Integer, Double> originalValues;
    Map<Integer, Double> copyValues;
    Map<Integer, String> comparison;
    public enum DataCase{
        EQUAL,
        MISSING,
        DIFFERENCE
    }

    public ComparatorApp(){
        this.originalValues = new HashMap<>();
        this.copyValues = new HashMap<>();
        this.comparison = new HashMap<>();
    }

    public void compare(){
        for(Map.Entry<Integer, Double> entry : this.originalValues.entrySet()){
            Integer id = entry.getKey();
            Double amount = entry.getValue();
            checkData(id,amount);
        }
        sortComparison();
    }

    private void checkData(Integer id, Double amount){
        String message = "";
        if(this.copyValues.containsKey(id)){
            Double copyAmount = this.copyValues.get(id);
            if(Objects.equals(copyAmount, amount))
                this.comparison.put(id, "A. EQUAL");
            else
                this.comparison.put(id, "B. DIFFERENT - Original: " + amount + " vs " + copyAmount );
        } else {
            this.comparison.put(id, "C. MISSING");
        }
    }

    private void sortComparison(){
        List<Map.Entry<Integer,String>> entryList = new ArrayList<>(this.comparison.entrySet());
        entryList.sort(Comparator.comparing(Map.Entry::getKey));
        Map<Integer,String> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer,String> entry : entryList){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        this.comparison = sortedMap;
    }

    public Map<Integer, Double> getOriginalValues() {
        return originalValues;
    }

    public void setOriginalValues(Map<Integer, Double> originalValues) {
        this.originalValues = originalValues;
    }

    public Map<Integer, Double> getCopyValues() {
        return copyValues;
    }

    public void setCopyValues(Map<Integer, Double> copyValues) {
        this.copyValues = copyValues;
    }

    public Map<Integer, String> getComparison() {
        return comparison;
    }

    public void setComparison(Map<Integer, String> comparison) {
        this.comparison = comparison;
    }

}
