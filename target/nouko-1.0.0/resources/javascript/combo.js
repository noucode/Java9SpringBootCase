Effect.OpenUp = function(element) {
     element = $(element);
     new Effect.BlindDown(element, arguments[1] || {});
 }

 Effect.CloseDown = function(element) {
     element = $(element);
     new Effect.BlindUp(element, arguments[1] || {});
 }

 Effect.Combo = function(element) {
     element = $(element);
     if(element.style.display == 'none') { 
          new Effect.OpenUp(element, arguments[1] || {}); 
     }else { 
          new Effect.CloseDown(element, arguments[1] || {}); 
     }
 }
 
 /*
 Currently, this code uses the BlindUp and BlindDown code, which I personally like, but 
 there’s nothing wrong with you changing the effect-type into one of the other effects 
 available
 */
 
 