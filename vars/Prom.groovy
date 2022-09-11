def send_message(String url, String msg) {
    def pushGateway = new URL(url).openConnection()
    pushGateway.setRequestMethod("POST")
    pushGateway.setDoOutput(true);
    pushGateway.getOutputStream().write(msg.getBytes("UTF-8"))
    def postRC = pushGateway.getResponseCode()
    if (!postRC.equals(200)) {
        println("Unable to send metrics")
        println(postRC.toString())
        println(pushGateway.getResponseMessage())
    }
}

def loki() {
    def msg = "        \"streams\": [\n" +
            "            {\n" +
            "                \"stream\": {\n" +
            "                    \"job\": \"test\",\n" +
            "                    \"instance\": \"test\"\n" +
            "                },\n" +
            "                \"values\": [\n" +
            "                    [\"${System.nanoTime()}\", \"test\"]\n" +
            "                ]\n" +
            "            }\n" +
            "        ]\n" +
            "    }"

    sh ("curl -v -H -XPOST -s \"Content-Type: application/json\" -d ${HOSTNAME} --data-raw ${msg}")

}