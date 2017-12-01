public class programa {

    public static void main(String[]args){
        ArbolAVL ARBOLITOAVL= new ArbolAVL();
        //insertando nodos
        ARBOLITOAVL.insertar(50);
        ARBOLITOAVL.insertar(25);
        ARBOLITOAVL.insertar(75);
        ARBOLITOAVL.insertar(10);
        ARBOLITOAVL.insertar(40);
        ARBOLITOAVL.insertar(60);
        ARBOLITOAVL.insertar(90);
        ARBOLITOAVL.insertar(35);
        ARBOLITOAVL.insertar(45);
        ARBOLITOAVL.insertar(70);
        ARBOLITOAVL.insertar(42);


        ARBOLITOAVL.preorden(ARBOLITOAVL.obtenerRaiz());
    }
}
