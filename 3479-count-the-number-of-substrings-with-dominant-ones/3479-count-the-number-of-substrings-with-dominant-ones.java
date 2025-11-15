class Solution {
  public int numberOfSubstrings(String s) {
    return prefixEnumeration(s);
  }

  private int prefixEnumeration(String s) {
    int n = s.length();

    int[] zerosIdx = new int[n + 1];
    int nextZeroIdx = 1;
    zerosIdx[0] = -1;

    int totalOnes = 0;

    int res = 0;

    for(int right = 0; right < n; right++) {
      if(s.charAt(right) == '0') {
        zerosIdx[nextZeroIdx++] = right;
      } else {
        res += right - zerosIdx[nextZeroIdx - 1];
        totalOnes++;
      }

      for(int zeroPos = nextZeroIdx - 1; zeroPos > 0 && (nextZeroIdx - zeroPos) * (nextZeroIdx - zeroPos) <= totalOnes; zeroPos--) {
        int zerosCount = nextZeroIdx - zeroPos; //nextZeroIdx - 1 (zeros at right pos) - zeroes at earlier pos + 1

        int onesCount = right - zerosIdx[zeroPos] + 1 - zerosCount; //totalLength - zerosCount

        int onesDeficit = zerosCount * zerosCount - onesCount; //how many ones we're missing within [zeroIdx[z - 1]+1, zeroIdx[z]] range to satisfy
                                                                //the condition - therefore, how many substrings starting farther to the right
                                                                //(closer to zPos) would not satisfy it

        int extendable = zerosIdx[zeroPos] - zerosIdx[zeroPos - 1]; //how far back are we looking now - essentially, how many positions can we 
                                                                    //start our substring from

        res += Math.max(extendable - Math.max(onesDeficit, 0), 0); //all the possible substrings (extendable) decreased by the number of 
                                                                    //invalid substrings (those starting further to the right, and therefore
                                                                    // having less ones)

      }
    }

    return res;
  }
}