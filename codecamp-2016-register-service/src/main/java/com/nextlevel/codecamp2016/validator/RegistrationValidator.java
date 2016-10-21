/**
 * Fast Lane Platform - Open Source License:
 *
 * "Copyright (C) 2009-2015 Next Level Integration GmbH http://www.next-level-integration.com
 *
 * This file is part of the Fast Lane Platform solution. The Fast Lane Platform is free software;
 * you can redistribute it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * The Fast Lane Platform is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with the Fast Lane Platform;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Linking the Fast Lane Platform statically or dynamically with other modules is making a
 * combined work based on the Fast Lane Platform. Thus, the terms and conditions of the
 * GNU General Public License cover the whole combination.
 *
 * In addition, as a special exception, the copyright holders of the Fast Lane Platform give you
 * permission to combine the Fast Lane Platform with code included in the (binary) release of
 * Next Level Integration GmbH Next Level Software under Next Level Integration GmbHs commercial license
 * (or modified versions of such code, with unchanged license). You may copy and distribute such a system
 * following the terms of the GNU GPL for the Fast Lane Platform and the licenses of Next Level Integration GmbH."
 */
package com.nextlevel.codecamp2016.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nextlevel.codecamp.model.register.Register;

@Component
public class RegistrationValidator implements Validator{
	
    @Override
    public boolean supports(Class<?> aClass) {
        return Register.class.equals(aClass);
    }

    // file validation.properties needed
    @Override
    public void validate(Object o, Errors errors) {
        Register reg = (Register) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (reg.getUsername().length() < 6 || reg.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (reg.getPassword().length() < 8 || reg.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

    }

}
