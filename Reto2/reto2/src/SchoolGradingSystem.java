import java.util.Scanner;
public class SchoolGradingSystem{
    //Atributos
    private Scanner leer;
    private int registro, excelente, sobresaliente, regular, insuficiente, deficiente;
    private int biologia, geografia, matematicas, max=0, posicion = 0, pos = 0;
    private String vector_nombre[]= {"armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    private String vector_materia[]= {"biologia", "geografia", "matematicas"};
    private String [][]datos;
    private String []entrada;
    private float aprobados, mejor_nota = 0; 


    public void readData (){
        leer = new Scanner(System.in);
        registro = Integer.parseInt(leer.nextLine());
        datos = new String[registro][4];
        for (int i=0; i<datos.length; i++){
            entrada = leer.nextLine().split(" ");//lee el str de datos y los convierte en vector
            datos[i] = entrada;//agrega los datos ya separados antes, siguen en forma de str en una datos
        }  
    }

    public float question1 (){
        for(int i=0; i < datos.length; i++){ 
            //Rango de notas
            if (90<Float.parseFloat(datos[i][3]) && Float.parseFloat(datos[i][3])<=100){
                excelente +=1;
            }else if (80<Float.parseFloat(datos[i][3]) && Float.parseFloat(datos[i][3])<=90){
                sobresaliente +=1;
            }else if (60<Float.parseFloat(datos[i][3]) && Float.parseFloat(datos[i][3])<=80){
                regular +=1;
            }else if (30<Float.parseFloat(datos[i][3]) && Float.parseFloat(datos[i][3])<=60){
                insuficiente +=1;
            }else if (0<=Float.parseFloat(datos[i][3]) && Float.parseFloat(datos[i][3])<=30){
                deficiente +=1;
            }
        }    
        aprobados = (excelente + sobresaliente + regular)/(float)registro;
        return aprobados;
    }

    public int question2 (){
       return regular;
    }

    public String question3 (){
        for(int i=0; i < datos.length; i++){
            if (Float.parseFloat(datos[i][1]) == 1.0 && 60<Float.parseFloat(datos[i][3]) && Float.parseFloat(datos[i][3])<=100){//Materia con mejor desempeño entre 
                                                                                                                            //genero f
                if (Float.parseFloat(datos[i][2]) == 1.0){
                    biologia +=1;
                }else if(Float.parseFloat(datos[i][2]) == 2.0){
                    geografia +=1;
                }else if (Float.parseFloat(datos[i][2]) == 3.0){
                    matematicas +=1;
                }
                int []materia = {biologia, geografia, matematicas};//agreaga los valores anteriores a un vector 
                for (int index=0; index<materia.length; index++){//recore vector anterior
                    if(materia[index]>max){//compara cual de esos valores es el mayor
                        max = materia[index];
                        posicion = index;//sabiendo la poscion se usa para buscar el str de la materia en el 
                                         //vector_materia
                    }
                }
            }
        }
        return vector_materia[posicion];
    }    

    public String question4 (){
        for(int i=0; i < datos.length; i++){
            if (Float.parseFloat(datos[i][2]) == 1.0){//Busca de la materia biologia correspondiente a el numero 1
                if (Float.parseFloat(datos[i][3])>mejor_nota){//la mejor nota 
                    mejor_nota = Float.parseFloat(datos[i][3]);
                    pos = (int)(Float.parseFloat(datos[i][0]));//y el indicador del estudiante de esa mejor nota 
                } 
            }      
        }
        return vector_nombre[pos-1];
    }
}