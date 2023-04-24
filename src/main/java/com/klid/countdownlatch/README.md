#### CountDownLatch

Get list of students with list of note, we have to compute en display student avg note and order DESC. Time to calculate
one student note is 5s.

| #  | Student   | Note 1 | Note 2 | Note 3 | Note 4 | Note 5 |
|----|-----------|--------|--------|--------|--------|--------|
| 1  | Harry     | 12     | 02     | 15     | 04     | 18     |
| 2  | Jean      | 03     | 17     | 08     | 04     | 16     |
| 3  | Emmy      | 17     | 14     | 12     | 02     | 09     |
| 4  | Azikiwe   | 04     | 06     | 19     | 07     | 12     |
| 5  | Nigesa    | 03     | 14     | 05     | 13     | 18     |
| 6  | Babangida | 12     | 10     | 11     | 14     | 17     |
| 7  | Biobaku   | 08     | 14     | 14     | 17     | 11     |
| 8  | Bamgboshe | 10     | 01     | 18     | 16     | 09     |
| 9  | Akinjide  | 15     | 18     | 17     | 11     | 13     |
| 10 | Dashiki   | 17     | 13     | 07     | 09     | 10     |

#### Single thread

| Execution time | 50s |
|----------------|-----|

#### Multi thread: 3

| Execution time | 20s |
|----------------|-----|

#### Multi thread: 5

| Execution time | 10s |
|----------------|-----|
