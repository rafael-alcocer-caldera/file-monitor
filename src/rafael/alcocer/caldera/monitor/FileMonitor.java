/**
 * Copyright [2025] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rafael.alcocer.caldera.monitor;

import java.io.IOException;
import java.util.Timer;

/**
 * A singleton class that monitors file changes using Timer and TimerTask.
 *
 * @author Rafael Alcocer Caldera
 */
public final class FileMonitor {

    private static final FileMonitor instance = new FileMonitor();
    private Timer timer = new Timer(true);

    private FileMonitor() {
    }
    
    public static FileMonitor getInstance() {
	return instance;
    }

    public void monitorFiles(long period, String... fileNames) throws IOException {
	for (String fileName : fileNames) {
	    FileMonitorTask task = new FileMonitorTask(fileName);
	    
	    if (task.getMonitoredFile() == null) {
		System.out.println("##### File Not Found: " + fileName);
		continue;
	    }
	    
	    timer.schedule(task, 0, period);
	    System.out.println("##### task: " + task);
	    System.out.println("##### task.scheduledExecutionTime(): " + task.scheduledExecutionTime());
	    System.out.println("");
	}

	// Keep the program running
	System.out.println("");
	System.out.println("##### Monitoring file changes. Press Enter to exit.");
	System.in.read();
    }
}
