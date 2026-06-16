class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        double hour = getHourPosition(h1, m1, s1);
        double minute = getMinutePosition(m1, s1);
        double second = getSecondPosition(s1);

        int diff = (h2 - h1) * 60 * 60;
        diff += (m2 - m1) * 60;
        diff += (s2 - s1);

        Time time = new Time(h1, m1, s1);
        int answer = 0;

        if (hour == second) {
            answer++;
        } else if (minute == second) {
            answer++;
        }

        for (int i = 0; i < diff; i++) {
            boolean minuteBefore = isBefore(minute, second);
            boolean hourBefore = isBefore(hour, second);

            time.addSecond();

            double nextHour = getHourPosition(time.h, time.m, time.s);
            double nextMinute = getMinutePosition(time.m, time.s);
            double nextSecond = getSecondPosition(time.s);

            if (time.isAllSame()) {
                answer++;
            } else {
                if (minuteBefore && !isBefore(nextMinute, nextSecond)) {
                    answer++;
                }

                if (hourBefore && !isBefore(nextHour, nextSecond)) {
                    answer++;
                }
            }

            hour = nextHour;
            minute = nextMinute;
            second = nextSecond;
        }

        return answer;
    }

    boolean isBefore(double a, double b) {
        if (a <= 180) {
            return b < a || a + 180 < b;
        } else {
            return a - 180 < b && b < a;
        }
    }

    double getHourPosition(int h, int m, int s) {
        return (h % 12) * 30 + m * 0.5 + (double) s / 120;
    }

    double getMinutePosition(int m, int s) {
        return m * 6 + s * 0.1;
    }

    double getSecondPosition(int s) {
        return s * 6;
    }

    class Time {
        int h, m, s;

        Time(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
        }

        void addSecond() {
            s++;

            if (s == 60) {
                s = 0;
                m++;
            }

            if (m == 60) {
                m = 0;
                h++;
            }
        }

        boolean isAllSame() {
            if (h == 0 && m == 0 && s == 0) {
                return true;
            }

            if (h == 12 && m == 0 && s == 0) {
                return true;
            }

            return false;
        }
    }
}