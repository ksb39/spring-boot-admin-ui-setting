package com.example.demo;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.domain.values.Info;
import de.codecentric.boot.admin.server.notify.AbstractEventNotifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomEventNotifier extends AbstractEventNotifier {

    public CustomEventNotifier(InstanceRepository repository) {
        super(repository);
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        return Mono.fromRunnable(() -> {
            if (event instanceof InstanceStatusChangedEvent) {
                // agent stop
                if(((InstanceStatusChangedEvent) event).getStatusInfo().getStatus().equals("OFFLINE")) {
                    Info info = instance.getInfo();
                    Map<String, String> infoMap = info.getValues().entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getKey, e -> (String)e.getValue()));

//                    .stop(infoMap);
                }
//                log.info("Instance {} ({}) is {}", instance.getRegistration().getName(), event.getInstance(),
//                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());
            } else {
                // agent start
                if(event.getType().equals("INFO_CHANGED")) {
                    Info info = instance.getInfo();
                    Map<String, String> infoMap = info.getValues().entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getKey, e -> (String)e.getValue()));

//                    .start(infoMap);
                }
//                log.info("Instance {} ({}) {}", instance.getRegistration().getName(), event.getInstance(),
//                        event.getType());
            }
        });
    }
}