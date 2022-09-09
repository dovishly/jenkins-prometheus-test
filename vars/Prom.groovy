def send_message(String url, String msg) {
    def pushGateway = new URL(url).openConnection()
    pushGateway.setRequestMethod("POST")
    pushGateway.setDoOutput(true);
    pushGateway.getOutputStream().write(msg.getBytes("UTF-8"))
    def postRC = pushGateway.getResponseCode()
    if (!postRC.equals(200)) {
        println("Unable to send metrics")
    }
}