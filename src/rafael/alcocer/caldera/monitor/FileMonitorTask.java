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

import java.io.File;
import java.net.URL;
import java.util.TimerTask;

/**
 * A TimerTask that monitors a file for changes.
 *
 * @author Rafael Alcocer Caldera
 */
public class FileMonitorTask extends TimerTask {

    private File monitoredFile;
    private long lastModified;

    public FileMonitorTask(String fileName) {
	URL fileURL = getClass().getClassLoader().getResource(fileName);

	if (fileURL != null) {
	    monitoredFile = new File(fileURL.getFile());
	    System.out.println("##### File to be monitored: " + monitoredFile);

	    lastModified = monitoredFile.lastModified();
	}
    }

    @Override
    public void run() {
	if (monitoredFile == null || !monitoredFile.exists()) {
	    return;
	}

	long currentModified = monitoredFile.lastModified();

	if (currentModified != lastModified) {
	    lastModified = currentModified;
	    System.out.println("##### File changed: " + monitoredFile.getName());
	}
    }
    
    public File getMonitoredFile() {
        return monitoredFile;
    }

    public long getLastModified() {
        return lastModified;
    }
}
