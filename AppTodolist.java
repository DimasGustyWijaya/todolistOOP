
import java.util.Scanner;

public class AppTodolist {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       viewShowTodolist();
    }

    public static void showTodolist(){
        System.out.println("Todolist");
        for(var i = 0; i < model.length; i++){
            var todo = model[i];
            int no = i + 1;

            if(todo != null){
                System.out.println(no + "." + todo );
            }

        }
    }

    public static void testShowTodolist(){
        model[0] = "Baca Buku";
        model[1] = "Belajar Java";
        showTodolist();
    }



    public static void addTodolist(String todo){
//        cek apakah penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null){
                isFull = false;
                break;
            }
        }

//        jika penuh gedein 2kali lipat
        if(isFull){
            var temp = model;
            model = new String[2 * model.length];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

//        masukan data ke yang kosong di model
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static boolean removeTodolist(int number){
        if((number - 1) >= model.length){
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else  {
            for (int i = (number - 1); i < model.length; i++) {
                if( i == (model.length - 1)){
                    model[i] = null;
                }else{
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("name");
        System.out.println("hi " + name);
    }

    public static void testRemoveTodolist(){
        addTodolist("belajar java");
        addTodolist("baca buku");
        addTodolist("playing games");
        addTodolist("workout");

        removeTodolist(2);

    }

    public static void viewShowTodolist(){
        showTodolist();

        while(true){
            System.out.println("Menu : ");
            System.out.println("1.Tambah");
            System.out.println("2.Hapus");
            System.out.println("x.exit");

            var input = input("pilih");
            if(input.equals("1")){
                viewAddTodolist();
                showTodolist();
            } else if (input.equals("2")) {
                viewRemoveTodolist();
                showTodolist();
            }else if (input.equals("x")){
                break;
            }else{
                System.out.println("perintah tidak ditemukan");
            }
        }
    }

    public static void testViewTodolist(){
        addTodolist("Belajar Java");
        addTodolist("Read a Book");
        addTodolist("Games");


        viewShowTodolist();
    }

    public static void viewAddTodolist(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("todo (x jika batal");

        if(todo.equals("x")){
//            if nya di kosongin biar dia batal dan ga manggil function addTodolist
        }else{
            addTodolist(todo);
        }

    }

    public static void testViewAddTodolist(){
        addTodolist("learn java");
        addTodolist("games");

        viewAddTodolist();
        showTodolist();
    }

    public static void viewRemoveTodolist(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor Yg Dihapus (x jika batal)");
        if(number.equals("x")){

        }else{
            removeTodolist(Integer.valueOf(number));
        }


    }

    public static void testViewRemoveTodolist(){
        addTodolist("learn java basic");
        addTodolist("playing genshin impact");
        addTodolist("workout");

        viewRemoveTodolist();
        showTodolist();
    }
}
