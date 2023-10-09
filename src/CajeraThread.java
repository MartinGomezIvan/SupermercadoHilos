public class CajeraThread extends Thread {
    private String nombre;
    Cliente cliente;
    long initialTime;

    public CajeraThread(){

    }

    public CajeraThread(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente=cliente;
        this.initialTime=initialTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run(){
        System.out.println("La cajera "+this.nombre +" comienza a procesar la compra del cliente "+this.cliente.getNombre()+" en el tiempo "+
                (System.currentTimeMillis()-this.initialTime)/1000+" segundos");
        for(int i=0; i<this.cliente.getCarroCompra().length; i++){
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            /*System.out.println("Procesado el producto "+(i+1)+" del cliente "+this.cliente.getNombre()+" en el tiempo "+
                    (System.currentTimeMillis()-this.initialTime)/1000+" segundos");*/
        }

        System.out.println("La cajera "+this.nombre +" ha terminado de procesar a "+this.cliente.getNombre()+" en el tiempo "+
                (System.currentTimeMillis()-this.initialTime)/1000+" segundos");
    }

    private void esperarXsegundos(int segundos){
        try{
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
