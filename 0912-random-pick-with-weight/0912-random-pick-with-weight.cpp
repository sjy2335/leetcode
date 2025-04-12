#include <cstdlib>
#include <iostream>

class Solution {
public:
    vector<float> borders;

    int getSum(vector<int>& w) {
        int sum = 0;
        for (int number: w) {
            sum += number;
        }
        return sum;
    }

    Solution(vector<int>& w) {
        int sum = getSum(w);
        
        float prev = 0.;
        for (int number: w) {
            prev += (float) number / sum;
            borders.push_back(prev);
        }
    }
    
    int pickIndex() {
        float prob = (float) rand() / RAND_MAX;
        float prev = 0.;
        for (int i = 0; i < borders.size(); i++) {
            float border = borders[i];
            if (prob >= prev && prob < border) return i;
            prev = border;

        }

        return 0;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(w);
 * int param_1 = obj->pickIndex();
 */