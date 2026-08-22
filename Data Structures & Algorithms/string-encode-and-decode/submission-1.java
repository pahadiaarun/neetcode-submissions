class Solution {
    public String encode(List<String> strs) {
        if (strs.isEmpty())
            return "";
        StringBuilder encode = new StringBuilder();
        for (String str : strs) {
            encode.append(str).append(";A;");
        }
        return encode.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty())
            return new ArrayList<>();
        List<String> decode = new ArrayList<>(Arrays.asList(str.split(";A;", -1)));
        decode.remove(decode.size() - 1);
        return decode;
    }
}
