/*
 *
 *  Copyright 2015 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */

package springfox.documentation.spring.web.paths;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.service.PathDecorator;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spi.service.contexts.PathContext;

import java.util.function.Function;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE + 40)
class PathMappingDecorator implements PathDecorator {

  @Override
  public Function<String, String> decorator(final PathContext context) {
    return input -> new PathMappingAdjuster(context.documentationContext())
        .adjustedPath(input);
  }

  @Override
  public boolean supports(DocumentationContext delimiter) {
    return true;
  }
}
