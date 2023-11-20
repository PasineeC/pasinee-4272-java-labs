package chantapinich.pasinee.lab2;

public class CamelCaseNaming {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: Please provide exactly two arguments.");
        }
        else {
            String f_name = args[0];
            String l_name = args[1];
            
            String upper_f_name = f_name.substring(0,1).toUpperCase();
            String lower_f_name = f_name.substring(1).toLowerCase();
            String mix_f_name = upper_f_name + lower_f_name;

            String upper_l_name = l_name.substring(0, 1).toUpperCase();
            String lower_l_name = l_name.substring(1).toLowerCase();
            String mix_l_name = upper_l_name + lower_l_name;

            String mix_all = mix_f_name + mix_l_name;

            System.out.println(mix_all);
        }
    }
}

