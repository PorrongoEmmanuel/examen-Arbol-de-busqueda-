public class ArbolAVL {

    private NodoArbolAVL raiz;

    public ArbolAVL() {
        raiz = null;
    }
    public NodoArbolAVL obtenerRaiz(){
        return   raiz;
    }
    //buscar

    public NodoArbolAVL buscar(int d, NodoArbolAVL r) {

        if (raiz==null){
            return null;
        }else if(r.dato==d){
            return r;
        }else if(r.dato<d){
            return  buscar(d,r.hijoderecho);
        }else{
            return buscar(d,r.hijoIzquierdo);
        }
    }
    // obtener factor de equilibrio
    public  int obtenerFE(NodoArbolAVL x){
        if(x==null){
            return -1;
        }else{
            return x.fe;
        }
    }
    //rotacion simple  a la izquierda

    public NodoArbolAVL rotacionizquierda(NodoArbolAVL c) {
        NodoArbolAVL auxiliar=c.hijoIzquierdo;
        c.hijoderecho=auxiliar.hijoderecho;
        auxiliar.hijoderecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoderecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoderecho))+1;
        return auxiliar;

    }
    //rotacion simple  a la derecha

    public NodoArbolAVL rotacionderecha(NodoArbolAVL c) {
        NodoArbolAVL auxiliar=c.hijoderecho;
        c.hijoderecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoderecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoderecho))+1;
        return auxiliar;



    }
    //rotacion doble  a la derecha

    public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c){
        NodoArbolAVL temporal;
        c.hijoIzquierdo=rotacionderecha(c.hijoIzquierdo);
        temporal=rotacionizquierda(c);
        return temporal;
    }

    //rotacion doble a la izquierda


    public NodoArbolAVL  rotaciondoblederecha(NodoArbolAVL c) {
        NodoArbolAVL temporal;
        c.hijoderecho=rotacionizquierda(c.hijoderecho);
        temporal=rotacionderecha(c);
        return temporal;

    }
    //metodo para insertar AVL


    public NodoArbolAVL InsertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr) {
        NodoArbolAVL nuevopadre = subAr;
        if (nuevo.dato < subAr.dato) {
            if (subAr.hijoIzquierdo == null) {
                subAr.hijoIzquierdo = nuevo;

            } else {
                subAr.hijoIzquierdo = InsertarAVL(nuevo, subAr.hijoIzquierdo);
                if ((obtenerFE(subAr.hijoIzquierdo) - obtenerFE(subAr.hijoderecho) == 2)) {
                    if (nuevo.dato < subAr.hijoIzquierdo.dato) {
                        nuevopadre = rotacionizquierda(subAr);
                    } else {
                        nuevopadre = rotacionDobleIzquierda(subAr);

                    }
                }
            }
        } else if (nuevo.dato > subAr.dato) {
            if (subAr.hijoderecho == null) {
                subAr.hijoderecho = nuevo;

            } else {
                subAr.hijoderecho = InsertarAVL(nuevo, subAr.hijoderecho);

                if ((obtenerFE(subAr.hijoderecho) - obtenerFE(subAr.hijoIzquierdo) == 2)) {
                    if (nuevo.dato > subAr.hijoderecho.dato) {
                        nuevopadre = rotacionderecha(subAr);
                    } else {
                        nuevopadre = rotaciondoblederecha(subAr);
                    }

                }
            }

        }else {
            System.out.println("nodo duplicado");
        }
        //actualizando la altura
        if((subAr.hijoIzquierdo==null)&&(subAr.hijoderecho!=null)){
            subAr.fe=subAr.hijoderecho.fe+1;
        }else if ((subAr.hijoderecho==null)&&(subAr.hijoIzquierdo!=null)){
            subAr.fe=subAr.hijoIzquierdo.fe+1;

        }else{
            subAr.fe=Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoderecho))+1;

        }
        return nuevopadre;
    }
//metodo para insertar

    public  void insertar(int d){
        NodoArbolAVL nuevo=new NodoArbolAVL(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=InsertarAVL(nuevo, raiz);
        }
    }
    //recorrido inorden
    public  void inorden(NodoArbolAVL r){
        if (r!=null){
            inorden(r.hijoIzquierdo);
            System.out.print(r.dato+", ");
            inorden(r.hijoderecho);
        }
    }
    //recorrido en preorden
    public  void preorden(NodoArbolAVL r){
        if(r!=null){
            System.out.print(r.dato+", ");
            preorden(r.hijoIzquierdo);
            preorden(r.hijoderecho);
        }
    }
//recorrido en postorden

    public void postorden(NodoArbolAVL r) {
        if (r != null) {
            postorden(r.hijoIzquierdo);
            postorden(r.hijoderecho);
            System.out.print(r.dato + ", ");
        }
    }}
