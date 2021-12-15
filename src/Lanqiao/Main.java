package Lanqiao;

class TopVotedCandidate {
    public int[] persons;
    public int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = new int[persons.length];
        this.times = new int[times.length];
        for (int i = 0; i < persons.length; i++) {
            this.persons[i] = persons[i];
        }
        for (int i = 0; i < times.length; i++) {
            this.times[i] = times[i];
        }
    }

    public int q(int t) {
        int j = 0;
        while (times[j] <= t) {

            if (j < times.length - 1) {
                j++;
            } else {
                j++;
                break;
            }
        }
        int max = 0;
        int index = 0;
        int[] count = new int[times.length];
        for (int k = 0; k < j; k++) {

            count[persons[k]]++;
            if (max <= count[persons[k]]) {
                max = count[persons[k]];
                index = persons[k];
            }

        }
        for (int i = 0; i < j; i++) {
            System.out.printf("%d", persons[i]);

        }
        System.out.println("***********");
        return index;
    }
}
/*
  Your TopVotedCandidate object will be instantiated and called as such:
  TopVotedCandidate obj = new TopVotedCandidate(persons, times);
  int param_1 = obj.q(t);
 */

