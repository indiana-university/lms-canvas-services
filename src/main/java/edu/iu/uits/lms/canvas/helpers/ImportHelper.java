package edu.iu.uits.lms.canvas.helpers;

/*-
 * #%L
 * LMS Canvas Services
 * %%
 * Copyright (C) 2015 - 2021 Indiana University
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the Indiana University nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ImportHelper {

   public static final String PENDING_TYPE = "pending";
   public static final String IN_PROGRESS_TYPE = "in-progress";
   public static final String DONE_TYPE = "done";

   @AllArgsConstructor
   @Getter
   public enum CANVAS_UPLOAD_STATE {
      initializing(PENDING_TYPE), created(PENDING_TYPE),
      importing(IN_PROGRESS_TYPE), cleanup_batch(IN_PROGRESS_TYPE), restoring(IN_PROGRESS_TYPE),
      imported(DONE_TYPE), imported_with_messages(DONE_TYPE), aborted(DONE_TYPE), failed(DONE_TYPE),
      failed_with_messages(DONE_TYPE), partially_restored(DONE_TYPE), restored(DONE_TYPE);

      private String type;
   }

   public static String getTypeFromState(String state) {
      String result = null;
      switch (state) {
         case "initializing":
         case "created":
            result = PENDING_TYPE;
            break;
         case "importing":
         case "cleanup_batch":
         case "restoring":
            result = IN_PROGRESS_TYPE;
            break;
         case "imported":
         case "imported_with_messages":
         case "aborted":
         case "failed":
         case "failed_with_messages":
         case "partially_restored":
         case "restored":
            result = DONE_TYPE;
            break;
      }
      return result;
   }
}
