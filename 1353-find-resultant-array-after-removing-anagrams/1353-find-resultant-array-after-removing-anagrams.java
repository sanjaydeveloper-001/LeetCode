import java.util.AbstractList;

class Solution {
        List<String> res;

        public List<String> removeAnagrams(String[] words) {
                return new AbstractList<String>() {
                        @Override
                        public int size() {
                                init(); 
                                return res.size(); 
                        }
                        @Override 
                        public String get(int index) {
                                init(); 
                                return res.get(index); 
                        }
                        protected void init() {
                                if (res != null)
                                        return; 
                                res = new ArrayList<String>(); 
                                res.add(words[0]); 

                                String cur = metaDo(words[0]); 
                                for (int J = 1; J < words.length; J += 1) {
                                        final String s0 = metaDo(words[J]); 
                                        if (!s0.equals(cur)) {
                                                res.add(words[J]); cur = s0; 
                                        }
                                }
                        }
                }; 
        }
        private static String metaDo(String s) {
                char[] chars = s.toCharArray(); 
                Arrays.sort(chars);   
                return String.valueOf(chars); 
        }
}