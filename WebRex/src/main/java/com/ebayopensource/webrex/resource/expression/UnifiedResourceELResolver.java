/*
    Copyright [2015-2016] eBay Software Foundation

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.ebayopensource.webrex.resource.expression;

import java.beans.FeatureDescriptor;
import java.util.Iterator;

import javax.el.ELContext;
import javax.el.ELResolver;

/**
 * EL resolver support EL method call with parameters
 *
 */
public class UnifiedResourceELResolver extends ELResolver {

   public Object invoke(ELContext context, Object base, Object method, Class<?>[] paramTypes, Object[] params) {
      if (base instanceof ResourceExpression) {
         context.setPropertyResolved(true);

         if (params == null) {
            params = new Object[] {};
         }

         return ((ResourceExpression) base).call(method, params);
      }

      return null;
   }

   @Override
   public Class<?> getCommonPropertyType(ELContext context, Object base) {
      return null;
   }

   @Override
   public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
      return null;
   }

   @Override
   public Class<?> getType(ELContext context, Object base, Object property) {
      return null;
   }

   @Override
   public Object getValue(ELContext context, Object base, Object property) {
      return null;
   }

   @Override
   public boolean isReadOnly(ELContext context, Object base, Object property) {
      return false;
   }

   @Override
   public void setValue(ELContext context, Object base, Object property, Object value) {
      //do nothing
   }

}
