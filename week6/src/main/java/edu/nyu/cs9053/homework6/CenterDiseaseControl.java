package edu.nyu.cs9053.homework6;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.InvocationTargetException;
/**
 * User: blangel
 * Date: 10/5/14
 * Time: 6:21 PM
 */
public class CenterDiseaseControl {

    public static void main(String[] args) {
        if ((args == null) || (args.length != 1)) {
            throw new AssertionError("Please specify your NetID");
        }
        String netId = args[0];
        CenterDiseaseControl centerDiseaseControl = new CenterDiseaseControl(netId);
        Population population = new Population();
        if (centerDiseaseControl.areDiseasesCured(population)) {
            System.out.printf("Congrats! You cured the epidemic!");
        } else {
            System.out.printf("Sadly, the epidemic still spreads...");
        }
    }

    private final long id;

    public CenterDiseaseControl(String id) {
        this.id = CRC32s.crc32(id);
    }

    public boolean areDiseasesCured(Population population) {
        Map<Disease, String> infections = getInfections(population);
        Map<Disease, String> cures = getCures();

        if (infections.isEmpty() || cures.isEmpty()) {
            throw new IllegalStateException("Not properly setup");
        }
        for (String value : infections.values()) {
            if ("".equals(value)) {
                throw new IllegalStateException("Not properly setup");
            }
        }
        for (Disease disease : Disease.values()) {
            String infection = infections.get(disease);
            String cure = cures.get(disease);
            if ((infection == null) || (cure == null)) {
                throw new IllegalStateException("Infection or cure not found.");
            }
            Pattern pattern = Pattern.compile(String.format(".*%s.*", cure));
            Matcher matcher = pattern.matcher(infection);
            if (!matcher.find()) {
                return false;
            }
        }
        return true;
    }

    @Vaccine(cures = Disease.SmallPox, seed=1021261699L, antidote="1111") public String getSmallPoxCure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(0, 4);
    }

    @Vaccine(cures = Disease.Ebola, seed=1021261699L,antidote="0011") public String getEbolaCure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(4, 8);
    }

    @Vaccine(cures = Disease.Sars, seed=1021261699L, antidote="0111") public String getSarsCure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(8, 12);
    }

    @Vaccine(cures = Disease.H1N1, seed=1021261699L, antidote="110011011110000011") public String getH1N1Cure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(12);
    }

    private Map<Disease, String> getInfections(Population population) {
        Method[] methods = Population.class.getDeclaredMethods();
        Map<Disease, String> diseases = new HashMap<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Infection.class)) {
                Infection infection = method.getAnnotation(Infection.class);
                Disease disease = infection.cause();
                try {
                    String result = (String) method.invoke(population);
                    if (!"".equals(result)) {
                        diseases.put(disease, result);
                    } } catch (IllegalAccessException | InvocationTargetException ise){
                    System.out.println(ise);
                }
            }
        }
        return diseases;
    }

    private Map<Disease, String> getCures() {
        Method[] centerDiseaseControlMethods = CenterDiseaseControl.class.getDeclaredMethods();
        Map<Disease, String> cures = new HashMap<>(Disease.values().length);
        for (Method method : centerDiseaseControlMethods) {
            if (method.isAnnotationPresent(Vaccine.class)) {
                Vaccine vaccine = method.getAnnotation(Vaccine.class);
                Disease disease = vaccine.cures();
                try {
                    String result = (String) method.invoke(this);
                    if (!"".equals(result) && (vaccine.seed() == id) && (vaccine.antidote().equals(result))) {
                        cures.put(disease, result);
                    } } catch (IllegalAccessException | InvocationTargetException ie){
                    System.out.println(ie.getMessage());
                }
            }
        }
        return cures;
    }

    private String getIdAsBinary() {
        return String.format("%16s", Long.toBinaryString(id)).replace(' ', '0');
    }

}
