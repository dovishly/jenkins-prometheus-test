def send_message(String url, String message) {
    def pushGateway = new URL(url).openConnection()
    pushGateway.setRequestMethod("POST")
    pushGateway.getOutputStream().write(msg.getBytes("UTF-8"))
    def postRC = pushGateway.getResponseCode()
    if (!postRC.equals(200)) {
        println("Unable to send metrics")
    }
}