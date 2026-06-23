package model;

public class Node {
   private String host;
   private int port;

   public Node(String var1, int var2) {
      this.host = var1;
      this.port = var2;
   }

   public String getId() {
      return this.host + ":" + this.port;
   }

   public String getHost() {
      return this.host;
   }

   public int getPort() {
      return this.port;
   }
}
