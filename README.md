# EventScheduler
An event scheduler which helps you to execute jobs on the scheduled time.

The implemented methods are as follows:

1. ZoomScheduler

2. ...

---

## ZoomScheduler
Automatically participate and quit a zoom meeting at the scheduled time for you.

### How to use
1. Zoom settings
Choose always use zoom.app when click a zoom meeting link, and set directly quit zoom app when click the 'leave' button

2. Clone the repository
```
git clone git@github.com:MashiroCl/EventScheduler.git
./gradlew build
```

3. Fill the `lecture.csv` with your scheduled zoom meetings

The `lecture.csv` is under the path `src/main/resources`

The csv file contains 4 columns, where the 1st column is the zoom meeting link(remember to include the pwd for the meeting in the URL), the 2nd column is the start time, the 3rd column is the end time, and the 4th column is for memo.

|  |   |  |   |
| ---- | ---- | ---- | ---- |
|  zoom url 1  |  start time  |  end time  | memo/ lecture name  |
|  zoom url 2  |  start time  |  end time  | memo/ lecture name  |



4. Run the tool
```
./gradlew run
```
