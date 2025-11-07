# FILES MONITOR

## Synopsis

You can monitor several files so that they can be monitored by changes.

## Motivation

I wanted to create a file monitoring project.

## PRE REQUIERMENTS

- Java SE Development Kit 17.

## FLOW

- Put the number of files you want, and they will be monitored by changes.

## OUTPUT

```log
##### File to be monitored: /Users/rac/RAC/GitHub/file-monitor/classes/timer.properties
##### task: rafael.alcocer.caldera.monitor.FileMonitorTask@659e0bfd
##### task.scheduledExecutionTime(): 1762550569130

##### File to be monitored: /Users/rac/RAC/GitHub/file-monitor/classes/timer.xml
##### task: rafael.alcocer.caldera.monitor.FileMonitorTask@5c647e05
##### task.scheduledExecutionTime(): 1762550568134

##### File Not Found: rec.txt

##### Monitoring file changes. Press Enter to exit.
##### File changed: timer.xml
##### File changed: timer.properties
```

## License

All work is under Apache 2.0 license